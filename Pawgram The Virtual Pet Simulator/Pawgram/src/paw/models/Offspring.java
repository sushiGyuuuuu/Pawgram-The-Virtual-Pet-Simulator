package paw.models;

import java.io.Serializable;

public class Offspring implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String species;
    private String gender;
    
    private int growthStage;     // 0 = Baby, 1 = Juvenile, 2 = Adult
    private int growthProgress;  // Actions completed toward next stage
    private int requiredGrowth;  // How many actions needed to grow

    private Pets parent1;
    private Pets parent2;

    // Inherited traits
    private String nature;
    private String favoriteFood;
    private String preferredEnvironment;

    public Offspring(String name, String species, String gender, Pets parent1, Pets parent2) {
        this.name = name;
        this.species = species; 
        this.gender = gender;
        this.parent1 = parent1;
        this.parent2 = parent2;

        this.growthStage = 0;
        this.growthProgress = 0;
        this.requiredGrowth = 3;   // 3 actions per growth stage
        
        //Inherit traits from parents
        this.nature = inheritNature(parent1, parent2);
        this.favoriteFood = inheritFavoriteFood(parent1, parent2);
        this.preferredEnvironment = inheritEnvironment(parent1, parent2);
    }

    // Getters
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public String getGender() { return gender; }
    public int getGrowthStage() { return growthStage; }
    public int getGrowthProgress() { return growthProgress; }
    public int getRequiredGrowth() { return requiredGrowth; } 
    public Pets getParent1() { return parent1; }
    public Pets getParent2() { return parent2; }

    public String getNature() { return nature; }
    public String getFavoriteFood() { return favoriteFood; }
    public String getPreferredEnvironment() { return preferredEnvironment; }

    // Setters
    public void setGrowthStage(int s) { growthStage = s; }
    public void setGrowthProgress(int p) { growthProgress = p; }

    private String inheritNature(Pets parent1, Pets parent2) {
        if (Math.random() < 0.5) {
            return parent1.getNature();
        } else {
            return parent2.getNature();
        }
    }

    // Inherit favorite food
    private String inheritFavoriteFood(Pets parent1, Pets parent2) {
        if (parent1.getFavoriteFood().equals(parent2.getFavoriteFood())) {
            return parent1.getFavoriteFood();
        }
        return Math.random() < 0.5 ? parent1.getFavoriteFood() : parent2.getFavoriteFood();
    }

    //Inherit environment preference
    private String inheritEnvironment(Pets parent1, Pets parent2) {
        if (parent1.getPreferredEnvironment().equals(parent2.getPreferredEnvironment())) {
            return parent1.getPreferredEnvironment();
        }
        return Math.random() < 0.5 ? parent1.getPreferredEnvironment() : parent2.getPreferredEnvironment();
    }

    public boolean progressGrowth() {
        growthProgress++;

        if (growthProgress >= requiredGrowth) {
            growthStage++;
            growthProgress = 0;
            return true; // Grew
        }
        return false;
    }

    //Check if offspring has reached adult stage. 
    public boolean isReadyForAdulthood() {
        return growthStage >= 2;
    }

    public Pets toAdultPet() {
        // Determine default accessory based on species
        String accessory = getDefaultAccessory(species);
        
        // Create the appropriate pet based on species
        Pets adultPet = createPetBySpecies(name, accessory, gender);
        
        // Set inherited traits
        if (adultPet != null) {
            adultPet.setNature(this.nature);
            adultPet.setFavoriteFood(this.favoriteFood);
            adultPet.setPreferredEnvironment(this.preferredEnvironment);
        }
        
        return adultPet;
    }

    // Helper method to create pet by species
    private Pets createPetBySpecies(String name, String accessory, String gender) {
        switch (species.toLowerCase()) {
            case "dog":
                return new Dog(name, accessory, gender, false);
            case "cat":
                return new Cat(name, accessory, gender, false);
            case "goldfish":
                return new Goldfish(name, accessory, gender, false);
            case "turtle":
                return new Turtle(name, accessory, gender, false);
            case "lizard":
                return new Lizard(name, accessory, gender, false);
            case "parrot":
                return new Parrot(name, accessory, gender, false);
            default:
                // Handle hybrid species or unknown species
                return createFallbackPet(name, accessory, gender);
        }
    }

    //Handle hybrid species or fallback
    private Pets createFallbackPet(String name, String accessory, String gender) {
        // If it's a hybrid, try to determine base species
        if (species.contains("-") && species.contains("Hybrid")) {
            String baseSpecies = species.split("-")[0].trim();
            switch (baseSpecies.toLowerCase()) {
                case "dog":
                case "cat":
                    return new Dog(name, accessory, gender, false); // Default to Dog for mammal hybrids
                case "goldfish":
                    return new Goldfish(name, accessory, gender, false);
                case "turtle":
                case "lizard":
                    return new Turtle(name, accessory, gender, false);
                case "parrot":
                    return new Parrot(name, accessory, gender, false);
                default:
                    return new Dog(name, accessory, gender, false); // Ultimate fallback
            }
        }
        
        // If unknown species, try to determine from parents
        if (parent1 != null) {
            return createPetBySpecies(name, accessory, parent1.getPetSpecies());
        }
        
        // Fallback
        return new Dog(name, accessory, gender, false);
    }

    //Get default accessory based on species
    private String getDefaultAccessory(String species) {
        switch (species.toLowerCase()) {
            case "dog": return "Collar";
            case "cat": return "Bell";
            case "goldfish": return "Decor";
            case "turtle": return "Shell Polish";
            case "lizard": return "Rock";
            case "parrot": return "Bell";
            default: return "Accessory";
        }
    }

    public String getGrowthStageName() {
        switch (growthStage) {
            case 0: return "Baby";
            case 1: return "Juvenile";
            case 2: return "Adult";
            default: return "Unknown";
        }
    }

    // toString for debugging
    @Override
    public String toString() {
        return String.format("Offspring{name='%s', species='%s', gender='%s', stage=%d, progress=%d/%d}", 
            name, species, gender, growthStage, growthProgress, requiredGrowth);
    }
}