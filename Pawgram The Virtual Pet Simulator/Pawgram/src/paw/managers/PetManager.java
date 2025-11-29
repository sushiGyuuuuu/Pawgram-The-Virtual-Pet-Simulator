package paw.managers;

import paw.models.*;
import paw.utils.PetUtils;
import paw.utils.UIUtils;

import java.util.Scanner;
import java.util.Random;

public class PetManager {
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public Pets createPet(int choice, String name) {
        System.out.print("Name your pet: ");
        name = input.nextLine();
        name = PetUtils.capitalizeFirstLetter(name);

        String gender = random.nextBoolean() ? "Male" : "Female";

        return switch (choice) {
            case 1 -> new Dog(name,"Collar", gender, false); 
            case 2 -> new Cat(name,"Bell", gender, false);
            case 3 -> new Goldfish(name, "Decor", gender, false); 
            case 4 -> new Turtle(name , "Shell Polish", gender, false); 
            case 5 ->new Lizard(name, "Rock", gender, false); 
            case 6 -> new Parrot(name, "Bell", gender, false); 
            default -> null;
        };
    }

     public Pets createPetWithGender(int choice, String name, String gender) {
        return switch (choice) {
            case 1 -> new Dog(name, "Collar", gender, false);
            case 2 -> new Cat(name, "Bell", gender, false);
            case 3 -> new Goldfish(name, "Decor", gender, false);
            case 4 -> new Turtle(name, "Shell Polish", gender, false);
            case 5 -> new Lizard(name, "Rock", gender, false);
            case 6 -> new Parrot(name, "Bell", gender, false);
            default -> null;
        };
    }

    public void switchPet(paw.models.Player player) {
        if (player.getOwnedPets().size() <= 1) {
            System.out.println("You only have one pet.");
            return;
        }
        System.out.println("\n=== Choose Pet ===");
        for (int i = 0; i < player.getOwnedPets().size(); i++) {
            System.out.println((i + 1) + ". " + player.getOwnedPets().get(i).getPetName());
        }
        System.out.print("Select: ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice > 0 && choice <= player.getOwnedPets().size()) {
            player.setActivePet(player.getOwnedPets().get(choice - 1));
            System.out.println("Switched active pet to " + player.getActivePet().getPetName());
        }
    }

    // In PetManager.java, fix the breedPets method
    public void breedPets(Player player) {
        if (player.getOwnedPets().size() < 2) {
            System.out.println("You need at least two pets to breed!");
            return;
        }

        System.out.println(UIUtils.createTitleBox("PET BREEDING"));
        System.out.println("Select two pets to breed:\n");
    
    // Display available pets with breeding info
        for (int i = 0; i < player.getOwnedPets().size(); i++) {
            Pets pet = player.getOwnedPets().get(i);
            String status = pet.isReadyToBreed() ? "Ready" : "Not Ready";
            String pregnant = pet.getIsPregnant() ? "Yes" : "No";
            System.out.printf("%2d. %s %s (%s, %s)%s\n", i + 1, pet.getGender(), pet.getPetName(), pet.getPetSpecies(), status, pregnant);
        
        // Show why not ready if applicable
            if (!pet.isReadyToBreed()) {
                if (pet.getLevel() < 3) System.out.println("     - Needs level 3+");
                if (pet.getIsSick()) System.out.println("     - Is sick");
                if (pet.getEnergy() <= 50) System.out.println("     - Needs energy > 50");
                if (pet.getMoodLevel() <= 60) System.out.println("     - Needs mood > 60");
                if (pet.getBreedCooldown() > 0) System.out.println("     - On cooldown: " + pet.getBreedCooldown() + " actions left");
                if (pet.getIsPregnant()) System.out.println("     - Already pregnant");
            }
        }
    
        System.out.print("\nSelect first parent: ");
        int firstChoice = input.nextInt() - 1;
        input.nextLine();

        if (firstChoice < 0 || firstChoice >= player.getOwnedPets().size()) {
            System.out.println("Invalid selection!");
            return;
        }

        System.out.println("\n=== Select Second Parent ===");
        for (int i = 0; i < player.getOwnedPets().size(); i++) {
            if (i == firstChoice) continue;
            Pets pet = player.getOwnedPets().get(i);
            String status = pet.isReadyToBreed() ? "Ready" : "Not Ready";
            String pregnant = pet.getIsPregnant() ? "Yes" : "No";
            System.out.printf("%2d. %s %s (%s, %s)%s\n", i + 1, pet.getGender(), pet.getPetName(), pet.getPetSpecies(), status, pregnant);
        }
        System.out.print("Select second parent: ");
        int secondChoice = input.nextInt() - 1;
        input.nextLine();

        if (secondChoice < 0 || secondChoice >= player.getOwnedPets().size() || secondChoice == firstChoice) {
            System.out.println("Invalid selection!");
            return;
        }

        Pets parent1 = player.getOwnedPets().get(firstChoice);
        Pets parent2 = player.getOwnedPets().get(secondChoice);

    // Enhanced compatibility check with detailed feedback
        if (!checkBreedingCompatibility(parent1, parent2)) {
            return;
        }

    // Calculate compatibility score
        int compatibility = parent1.calculateCompatibility(parent2);
        String compatibilityDesc = parent1.getCompatibilityDescription(compatibility);
    
        System.out.println("\n" + UIUtils.createTitleBox("BREEDING COMPATIBILITY"));
        System.out.println("Compatibility Score: " + compatibility + "/100 - " + compatibilityDesc);
        System.out.println("Factors:");
        System.out.println("- Same Species: " + (parent1.getPetSpecies().equals(parent2.getPetSpecies()) ? "Yes +40" : "No +0"));
        System.out.println("- Same Breed Group: " + (parent1.getBreedGroup().equals(parent2.getBreedGroup()) ? "Yes +20" : "No +0"));
        System.out.println("- Compatible Natures: " + (parent1.areNaturesCompatible(parent1.getNature(), parent2.getNature()) ? "Yes +10" : "No +0"));
        System.out.println("- Same Environment: " + (parent1.getPreferredEnvironment().equals(parent2.getPreferredEnvironment()) ? "Yes +15" : "No +0"));
        System.out.println("- Level Similarity: " + getLevelCompatibilityBonus(parent1, parent2));
        System.out.println("- Mood Bonus: " + (parent1.getMoodLevel() > 80 && parent2.getMoodLevel() > 80 ? "Yes +15" : "No +0"));

    // Breeding success chance based on compatibility
        double successChance = compatibility / 100.0;
        System.out.println("\nSuccess Chance: " + (int)(successChance * 100) + "%");
    
        if (Math.random() > successChance) {
            System.out.println("\nBreeding attempt failed! The pets weren't compatible enough.");
            parent1.petEnergy(-10);
            parent2.petEnergy(-10);
            parent1.petMood(-5);
            parent2.petMood(-5);
            UIUtils.pause();
            return;
        }

    // PREGNANCY SYSTEM FIX: Always set pregnancy for female
        Pets mother = parent1.getGender().equals("Female") ? parent1 : parent2;
        // FIX: Actually set the pregnancy
        if (mother.getGender().equals("Female")) {
            mother.setIsPregnant(true);
            mother.setPregnancyProgress(0);
            System.out.println("\nBreeding successful! " + mother.getPetName() + " is now pregnant!");
            System.out.println("Pregnancy progress: 0%");
            System.out.println("Visit 'Manage Offspring' to care for " + mother.getPetName() + " and progress the pregnancy!");
        } else {
        // This should never happen due to gender check, but just in case
            System.out.println("Error: No female parent found for pregnancy.");
            return;
        }

    // Set cooldown and energy costs
        parent1.setBreedCooldown(5);
        parent2.setBreedCooldown(5);
        parent1.petEnergy(-25);
        parent2.petEnergy(-25);
        parent1.petMood(10); // Happy from successful breeding
        parent2.petMood(10);
    
        UIUtils.pause();
    }

// NEW: Helper method for level compatibility
    private String getLevelCompatibilityBonus(Pets pet1, Pets pet2) {
        int levelDiff = Math.abs(pet1.getLevel() - pet2.getLevel());
        if (levelDiff <= 2) return "Yes +10";
        if (levelDiff <= 5) return "Yes +5";
        return "No + 0";
    }

// FIXED: Enhanced breeding compatibility check
    private boolean checkBreedingCompatibility(Pets parent1, Pets parent2) {
    // Basic conditions
        if (!parent1.isReadyToBreed()) {
            System.out.println(parent1.getPetName() + " is not ready to breed!");
            showBreedingRequirements(parent1);
            return false;
        }
    
        if (!parent2.isReadyToBreed()) {
            System.out.println(parent2.getPetName() + " is not ready to breed!");
            showBreedingRequirements(parent2);
            return false;
        }

        if (parent1.getGender().equals(parent2.getGender())) {
            System.out.println("Pets must be of opposite genders to breed!");
            return false;
        }

    // Species and group compatibility
        if (!parent1.getBreedGroup().equals(parent2.getBreedGroup())) {
            System.out.println("Pets must be from the same breed group to breed!");
            System.out.println(parent1.getPetName() + " is a " + parent1.getBreedGroup());
            System.out.println(parent2.getPetName() + " is a " + parent2.getBreedGroup());
            return false;
        }

        return true;
    }

// NEW: Show detailed breeding requirements
    private void showBreedingRequirements(Pets pet) {
        System.out.println("Breeding Requirements for " + pet.getPetName() + ":");
        if (pet.getLevel() < 3) System.out.println("  - Level 3+ (Current: " + pet.getLevel() + ")");
        if (pet.getIsSick()) System.out.println("  - Must be healthy");
        if (pet.getEnergy() <= 50) System.out.println("  - Energy > 50 (Current: " + pet.getEnergy() + ")");
        if (pet.getMoodLevel() <= 60) System.out.println("  - Mood > 60 (Current: " + pet.getMoodLevel() + ")");
        if (pet.getBreedCooldown() > 0) System.out.println("  - No breeding cooldown (Current: " + pet.getBreedCooldown() + ")");
        if (pet.getIsPregnant()) System.out.println("  - Not already pregnant");
    }

        public void manageOffspring(Player player) {
        if (player.getOffsprings().isEmpty()) {
            System.out.println("You have no offspring to manage.");
            return;
        }

        System.out.println("\n=== Manage Offspring ===");
        for (int i = 0; i < player.getOffsprings().size(); i++) {
            Offspring offspring = player.getOffsprings().get(i);
            System.out.println((i + 1) + ". " + offspring.getName() + 
                " (" + offspring.getSpecies() + ", " + offspring.getGender() + 
                ", " + offspring.getGrowthStageName() + ")");
        }

        System.out.println("1. Care for Offspring (Progress Growth)");
        System.out.println("2. Promote to Full Pet (if adult)");
        System.out.println("0. Back");
        System.out.print("Select: ");
        
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                player.careForOffspring();
                System.out.println("You cared for all offspring! They're growing well.");
                break;
            case 2:
                System.out.print("Select offspring to promote: ");
                int offspringChoice = input.nextInt() - 1;
                input.nextLine();
                
                if (offspringChoice >= 0 && offspringChoice < player.getOffsprings().size()) {
                    Offspring selected = player.getOffsprings().get(offspringChoice);
                    player.promoteOffspringToPet(selected);
                } else {
                    System.out.println("Invalid selection!");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
