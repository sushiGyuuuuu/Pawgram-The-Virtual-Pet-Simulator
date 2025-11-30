package paw.managers;

import java.util.Scanner;
import paw.models.*;
import paw.services.*;
import paw.utils.*;

public class GameManager {
    private Player player;
    private PetManager petManager;
    private ShopManager shop;
    private Scanner input = new Scanner(System.in);

    public GameManager() {
        this.petManager = new PetManager();
        this.shop = new ShopManager();
    }

    public void start() {
        UIUtils.clearScreen();
        displayWelcomeScreen();
        
        System.out.println(UIUtils.createTitleBox("PAWGRAM"));
        System.out.println("1) New Game");
        System.out.println("2) Load Game");
        System.out.print("\nSelect: ");
        
        int sel = UIUtils.getValidatedInt(input, 1, 2);
        
        if (sel == 2) {
            if (!loadGame()) {
                input.nextLine();
                newPlayerFlow();
            }
        } else {
            newPlayerFlow();
        }
        
        mainLoop();
    }

    private void displayWelcomeScreen() {
        System.out.println(
            "██████╗  █████╗ ██╗    ██╗ ██████╗ ██████╗  █████╗ ███╗   ███╗\n" +
            "██╔══██╗██╔══██╗██║    ██║██╔════╝ ██╔══██╗██╔══██╗████╗ ████║\n" +
            "██████╔╝███████║██║ █╗ ██║██║  ███╗██████╔╝███████║██╔████╔██║\n" +
            "██╔═══╝ ██╔══██║██║███╗██║██║   ██║██╔══██╗██╔══██║██║╚██╔╝██║\n" +
            "██║     ██║  ██║╚███╔███╔╝╚██████╔╝██║  ██║██║  ██║██║ ╚═╝ ██║\n" +
            "╚═╝     ╚═╝  ╚═╝ ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝\n"
        );
        System.out.println("\n" + UIUtils.centerText("Your Virtual Pet Adventure Awaits!", 60));
        System.out.println("\n" + UIUtils.createSeparator(60));
        UIUtils.pause();
        input.nextLine();
    }

    private boolean loadGame() {
        UIUtils.clearScreen();
        UIUtils.showLoading("Loading your adventure");
        
        Player loaded = SaveSystem.load();
        if (loaded != null) {
            this.player = loaded;
            System.out.println("\n" + UIUtils.createTitleBox("WELCOME BACK!"));
            System.out.println("Hello, " + PetUtils.capitalizeFirstLetter(player.getPlayerName()) + "!");
            System.out.println("Your pets missed you!");
            return true;
        } else {
            System.out.println("\nNo saved game found. Starting new adventure...");
            UIUtils.pause();
            return false;
        }
    }

    private void newPlayerFlow() {
        UIUtils.clearScreen();
        System.out.println(UIUtils.createTitleBox("NEW ADVENTURE"));
        
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        player = new Player(name);
        
        UIUtils.clearScreen();
        
        System.out.println(UIUtils.createTitleBox("WELCOME, " + name.toUpperCase() + "!"));
        System.out.println("Let's find your first pet companion!\n");
        
        System.out.println("Choose your starting pet:");
        System.out.println("┌──────────────────────────┐");
        System.out.println("│ 1. Dog                   │");
        System.out.println("│ 2. Cat                   │");
        System.out.println("│ 3. Goldfish              │");
        System.out.println("│ 4. Turtle                │");
        System.out.println("│ 5. Lizard                │");
        System.out.println("│ 6. Parrot                │");
        System.out.println("└──────────────────────────┘");
        System.out.print("\nSelect: ");

        int choice = UIUtils.getValidatedInt(input,1, 6);
        UIUtils.clearScreen();

        Pets p = petManager.createPet(choice, name);
        UIUtils.clearScreen();

        if (p != null) {
            player.addPet(p);
            player.setActivePet(p);
            System.out.println(UIUtils.createTitleBox("CONGRATULATIONS!"));
            System.out.println(PetUtils.formatPetStatus(
                p.getPetName(), 
                p.getPetSpecies(), 
                p.getMoodLevel(), 
                p.getEnergy(), 
                p.getLevel(), 
                p.getIsSick(), 
                p.getGender(), 
                p.getIsPregnant()
            ));
            System.out.println("Take good care of your new friend! ");
        }
        UIUtils.pause();
    }

    private void mainLoop() {
        int choice;
        do {
            UIUtils.clearScreen();
            displayMainMenu();
            
            System.out.print("\nSelect: ");
            choice = UIUtils.getValidatedInt(input, 0, 11);

            switch (choice) {
                case 1:
                    UIUtils.clearScreen(); 
                    feedPet();
                    input.nextLine();
                    break;
                case 2:
                    UIUtils.clearScreen();
                    playWithPet();
                    input.nextLine();
                    break;
                case 3:
                    UIUtils.clearScreen();
                    putPetToSleep();
                    input.nextLine();
                    break;
                case 4:
                    UIUtils.clearScreen();
                    showStats();
                    input.nextLine();
                    break;
                case 5:
                    UIUtils.clearScreen();
                    petManager.switchPet(player);
                    input.nextLine();
                    break;
                case 6:
                    UIUtils.clearScreen();
                    shop.openShop(player);
                    input.nextLine();
                    break;
                case 7:
                    UIUtils.clearScreen();
                    openInventory();
                    input.nextLine();
                    break;
                case 8:
                    UIUtils.clearScreen();
                    petManager.breedPets(player);
                    input.nextLine();
                    break;
                case 9:
                    UIUtils.clearScreen();
                    petManager.manageOffspring(player);
                    input.nextLine();
                    break;
                case 10:
                    UIUtils.clearScreen();
                    saveGame();
                    input.nextLine();
                    break;
                case 11:
                    UIUtils.clearScreen();
                    loadGame();
                    input.nextLine();
                    break;
                case 0:
                    UIUtils.clearScreen();
                    System.out.println(UIUtils.createTitleBox("GOODBYE!"));
                    System.out.println("Thanks for playing Pawgram! ");
                    input.nextLine();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
                    UIUtils.pause();
            }
        } while(choice != 0);
    }

    private void displayMainMenu() {
        Pets activePet = player.getActivePet();
        
        // Display active pet info
        if (activePet != null) {
            System.out.println(PetUtils.formatPetStatus(
                activePet.getPetName(), 
                activePet.getPetSpecies(), 
                activePet.getMoodLevel(), 
                activePet.getEnergy(), 
                activePet.getLevel(), 
                activePet.getIsSick(), 
                activePet.getGender(), 
                activePet.getIsPregnant()
            ));
        

        if (activePet.getIsPregnant()) {
            System.out.println(UIUtils.createTitleBox("PREGNANCY UPDATE"));
            System.out.println(activePet.getPetName() + " is pregnant!");
            System.out.println("Pregnancy Progress: " + activePet.getPregnancyProgress() + "%");
            if (activePet.getPregnancyProgress() >= 100) {
                System.out.println(activePet.getPetName() + " is ready to give birth!");
                System.out.println("Visit 'Manage Offspring' to deliver the baby!");
            } else {
                System.out.println("Care for " + activePet.getPetName() + " to progress the pregnancy!");
            }
            System.out.println();
        }
    }
    
    // PREGNANCY NOTIFICATION: Check for other pregnant pets
        int pregnantPetsCount = countPregnantPets();
        if (pregnantPetsCount > 0) {
            System.out.println(UIUtils.createTitleBox("PREGNANCY ALERT"));
            System.out.println("You have " + pregnantPetsCount + " pregnant pet(s)!");
            System.out.println("Visit 'Manage Offspring' to check on them!");
            System.out.println();
        }
        
        System.out.println(UIUtils.createTitleBox("MAIN MENU"));
        System.out.println(UIUtils.menuOption(1, "Feed Pet"));
        System.out.println(UIUtils.menuOption(2, "Play with Pet"));
        System.out.println(UIUtils.menuOption(3, "Put Pet to Sleep"));
        System.out.println(UIUtils.menuOption(4, "View Detailed Stats"));
        System.out.println(UIUtils.menuOption(5, "Switch Active Pet"));
        System.out.println(UIUtils.menuOption(6, "Visit Shop"));
        System.out.println(UIUtils.menuOption(7, "Open Inventory"));
        System.out.println(UIUtils.menuOption(8, "Breed Pets"));
        System.out.println(UIUtils.menuOption(9, "Manage Offspring"));
        System.out.println(UIUtils.menuOption(10, "Save Game"));
        System.out.println(UIUtils.menuOption(11, "Load Game"));
        System.out.println(UIUtils.menuOption(0, "Exit Game"));
        
        // Player info
        System.out.println("\n" + UIUtils.createSeparator(40));
        System.out.println("Player: " + PetUtils.capitalizeFirstLetter(player.getPlayerName()));
        System.out.println("Coins: " + player.getCoins());
        System.out.println("Pets: " + player.getOwnedPets().size());
        System.out.println("Offspring: " + player.getOffsprings().size());

        if (pregnantPetsCount > 0) {
        System.out.println("Pregnant: " + pregnantPetsCount);
        }
    }
    private int countPregnantPets() {
        int count = 0;
        for (Pets pet : player.getOwnedPets()) {
            if (pet.getIsPregnant()) {
                count++;
            }
        }
        return count;
    
    }
    private void feedPet() {
        System.out.println(UIUtils.createTitleBox("FEEDING TIME"));
        player.getActivePet().eatFood();
        UIUtils.pause();
    }

    private void playWithPet() {
        System.out.println(UIUtils.createTitleBox("PLAY TIME"));
        player.getActivePet().play();
        UIUtils.pause();
    }

    private void putPetToSleep() {
        System.out.println(UIUtils.createTitleBox("SLEEP TIME"));
        player.getActivePet().sleep();
        UIUtils.pause();
    }

    private void showStats() {
        Pets pet = player.getActivePet();
        System.out.println(UIUtils.createTitleBox("DETAILED STATS"));
        
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.printf ("│ %-15s: %-20s      │\n", "Name", pet.getPetName());
        System.out.printf ("│ %-15s: %-20s      │\n", "Species", pet.getPetSpecies());
        System.out.printf ("│ %-15s: %-20s      │\n", "Gender", pet.getGender());
        System.out.println("├────────────────────────────────────────────┤");
        System.out.printf ("│ %-15s: %-20s │\n", "Mood", UIUtils.createProgressBar(pet.getMoodLevel(), 100, 15));
        System.out.printf ("│ %-15s: %-20s │\n", "Energy", UIUtils.createProgressBar(pet.getEnergy(), 100, 15));
        System.out.printf ("│ %-15s: %-20s │\n", "Happiness", UIUtils.createProgressBar(pet.getHappiness(), 100, 15));
        System.out.println("├────────────────────────────────────────────┤");
        System.out.printf ("│ %-15s: %-20d      │\n", "Level", pet.getLevel());
        System.out.printf ("│ %-15s: %-20d      │\n", "Experience", pet.getExperience());
        System.out.printf ("│ %-15s: %-20s      │\n", "Health", pet.getIsSick() ? "Sick" : "Healthy");
        System.out.println("├────────────────────────────────────────────┤");
        
        // Breeding info
        if (pet.getLevel() >= 3) {
            System.out.printf ("│ %-15s: %-20s      │\n", "Breeding Ready", pet.isReadyToBreed() ? "Yes" : "No");
            if (pet.getIsPregnant()) {
                System.out.printf ("│ %-15s: %-20d%%      │\n", "Pregnancy", pet.getPregnancyProgress());
            }
        }
        
        // Compatibility traits
        System.out.printf ("│ %-15s: %-20s      │\n", "Nature", pet.getNature());
        System.out.printf ("│ %-15s: %-20s      │\n", "Favorite Food", pet.getFavoriteFood());
        System.out.printf ("│ %-15s: %-20s      │\n", "Environment", pet.getPreferredEnvironment());
        System.out.println("└────────────────────────────────────────────┘");
        
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }

    private void saveGame() {
        System.out.println(UIUtils.createTitleBox("SAVE GAME"));
        SaveSystem.save(player);
        System.out.println("Game saved successfully!");
        UIUtils.pause();
    }

    private void openInventory() {
        System.out.println(UIUtils.createTitleBox("INVENTORY"));
        
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
            System.out.println("Visit the shop to buy some items!");
        } else {
            System.out.println("Items in your inventory:");
            System.out.println("┌─────────────────────────────────────┐");
            for (int i = 0; i < player.getInventory().size(); i++) {
                System.out.printf("│ %2d. %-30s  │\n", i + 1, player.getInventory().get(i).getItemName());
            }
            System.out.println("└─────────────────────────────────────┘");
            
            System.out.println("\n0. Back to Menu");
            System.out.print("Select item to use: ");
            int sel = UIUtils.getValidatedInt(input, 0, player.getInventory().size());
            
            if (sel > 0 && sel <= player.getInventory().size()) {
                player.useItem(sel - 1, player.getActivePet());
            } else if (sel != 0) {
                System.out.println("Invalid selection.");
            }
        }
        UIUtils.pause();
    }
}