package paw.models;

import java.io.Serializable;
import paw.utils.PetUtils;

public abstract class Pets implements Serializable {

    protected String petName;
    protected String petSpecies;
    protected String accessories;
    protected String gender;
    protected String breedGroup;
    protected String nature; 
    protected String favoriteFood;
    protected String preferredEnvironment;

    protected int compatibilityScore;
    protected int pregnancyProgress;
    protected int moodLevel;
    protected int energy;
    protected int level;
    protected int experience;
    protected int happiness;
    protected int breedCooldown;

    protected boolean isSick;
    protected boolean canBreed;
    protected boolean isPregnant;

    //CONSTRUCTOR
    public Pets(
        String petName, String petSpecies, String accessories,
        String gender, String breedGroup, String nature,
        String favoriteFood, String preferredEnvironment,
        boolean isSick
    ) {
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.accessories = accessories;
        this.gender = gender;
        this.breedGroup = breedGroup;
        this.nature = nature; 
        this.favoriteFood = favoriteFood;
        this.preferredEnvironment = preferredEnvironment;

        this.moodLevel = 100;
        this.energy = 100;
        this.level = 1;
        this.experience = 0;
        this.happiness = 100;

        this.isSick = isSick;
        this.canBreed = true;
        this.breedCooldown = 0;

        this.isPregnant = false;
        this.pregnancyProgress = 0;
    }

    //GETTERS & SETTERS
    public String getPetName() { return petName; }
    public String getPetSpecies() { return petSpecies; }
    public String getAccessories() { return accessories; }
    public String getGender() { return gender; }
    public String getBreedGroup() { return breedGroup; }
    public String getNature() { return nature; }
    public String getFavoriteFood() { return favoriteFood; }
    public String getPreferredEnvironment() { return preferredEnvironment; }

    public int getMoodLevel() { return moodLevel; }
    public int getEnergy() { return energy; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getHappiness() { return happiness; }
    public int getBreedCooldown() { return breedCooldown; }
    public int getCompatibilityScore() { return compatibilityScore; }
    public int getPregnancyProgress() { return pregnancyProgress; }

    public boolean getIsSick() { return isSick; }
    public boolean getIsPregnant() { return isPregnant; }
    public boolean getCanBreed() { return canBreed; }

    public void setPetName(String name) { petName = name; }
    public void setAccessories(String accs) { accessories = accs; } 
    public void setNature(String nature) { this.nature = nature; } 
    public void setFavoriteFood(String food) { favoriteFood = food; } 
    public void setPreferredEnvironment(String env) { preferredEnvironment = env; } 
    
    public void setMoodLevel(int value) { moodLevel = value; }
    public void setEnergy(int value) { energy = value; }
    public void setLevel(int value) { level = value; }
    public void setExperience(int value) { experience = value; }
    public void setHappiness(int value) { happiness = value; }
    public void setIsSick(boolean value) { isSick = value; }
    public void setBreedCooldown(int value) { breedCooldown = value; }
    public void setCompatibilityScore(int value) { compatibilityScore = value; }
    public void setIsPregnant(boolean value) { isPregnant = value; }
    public void setPregnancyProgress(int value) { pregnancyProgress = value; }
    public void setCanBreed(boolean value) { canBreed = value; }

    //ABSTRACT METHODS
    public abstract void makeSound();
    public abstract void move();
    public abstract void eatFood();
    public abstract void reactToTouch();
    public abstract void getsSick();
    public abstract void sleep();
    public abstract void play();

    //      STAT MODIFIERS
    public void petExperience(int amount) {
        experience += amount;
        if (experience >= 100) {
            level++;
            experience -= 100;
            System.out.println(PetUtils.capitalizeFirstLetter(petName)
                + " leveled up to lvl " + level + "!");
        }
    }

    public void petMood(int amount) {
        moodLevel = Math.max(0, Math.min(100, moodLevel + amount));

        if (moodLevel >= 80) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is very happy.");
        } else if (moodLevel >= 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is happy.");
        } else {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is sad.");
        }
    }

    public void petEnergy(int amount) {
        energy = Math.max(0, Math.min(100, energy + amount));

        if (energy < 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is low on energy.");
            moodLevel = Math.max(0, moodLevel - 10);
        }
    }

    public void checkHealth() {
        if (energy < 10 || moodLevel < 10) {
            isSick = true;
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " has become sick!");
        }
    }

    public void increaseHappiness(int amount) {
        happiness = Math.min(100, happiness + amount);
    }

    //      BREEDING SYSTEM
    public boolean isReadyToBreed() {
        return level >= 3 &&
               !isSick &&
               !isPregnant &&
               energy > 50 &&
               moodLevel > 60 &&
               breedCooldown <= 0 &&
               canBreed;
    }

    public int calculateCompatibility(Pets other) {
        int score = 0;

        // Species
        if (petSpecies.equals(other.petSpecies)) score += 40; //Same species
        else if (breedGroup.equals(other.breedGroup)) score += 20; //Diff Species

        if (nature.equals(other.nature)) score += 20; //Same Nature = more Compatible
        else if (areNaturesCompatible(nature, other.nature)) score += 10;

        // Environment
        if (preferredEnvironment.equals(other.preferredEnvironment))
            score += 15;

        // Levels
        int diff = Math.abs(level - other.level); // The lower lvl diff = more compatible
        if (diff <= 2) score += 10;
        else if (diff <= 5) score += 5;

        if (moodLevel > 80 && other.moodLevel > 80) score += 15;

        compatibilityScore = Math.min(100, score); //lesser value becomes score
        return compatibilityScore;
    }

    //Nature Compatibility Checker
    public boolean areNaturesCompatible(String temp1, String temp2) {
        switch (temp1) {
            case "Calm": return temp2.equals("Social") || temp2.equals("Shy");
            case "Energetic": return temp2.equals("Social") || temp2.equals("Playful");
            case "Shy": return temp2.equals("Calm") || temp2.equals("Gentle");
            case "Social": return temp2.equals("Energetic") || temp2.equals("Calm");
            case "Playful": return temp2.equals("Energetic") || temp2.equals("Social");
            case "Gentle": return temp2.equals("Calm") || temp2.equals("Shy");
            default: return false;
        }
    }

    //Compatibility description 
    public String getCompatibilityDescription(int score) {
        if (score >= 80) return "Perfect Match!";
        if (score >= 60) return "Very Compatible";
        if (score >= 40) return "Moderately Compatible";
        if (score >= 20) return "Slightly Compatible";
        return "Poor Match";
    }

    //      PREGNANCY + BIRTH
    public boolean progressPregnancy() {
        if (!isPregnant) return false;

        int oldProgress = pregnancyProgress;
        pregnancyProgress = Math.min(100, pregnancyProgress + 20);

        if (pregnancyProgress >= 100 && oldProgress < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is ready to give birth!");
            return true;
        }
        if (pregnancyProgress >= 80 && oldProgress < 80) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is getting close to giving birth!");
        } else if (pregnancyProgress >= 50 && oldProgress < 50) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + " is halfway through the pregnancy!");
        } else if (pregnancyProgress >= 20 && oldProgress < 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(petName) + "'s pregnancy is progressing well.");
        }

        checkHealth();
        return false;
    }

    public Offspring giveBirth(String offspringName, Pets father) {
        if (!isPregnant || pregnancyProgress < 100) {
            return null;
        }

        //Determine gender
        String offspringGender = Math.random() > 0.5 ? "Male" : "Female";
        
        //If hybrid
        String offspringSpecies = this.petSpecies;
        if (!this.petSpecies.equals(father.getPetSpecies()) && 
            this.breedGroup.equals(father.getBreedGroup()) &&
            Math.random() < 0.3) { // 30% chance for hybrid
            offspringSpecies = this.petSpecies + "-" + father.getPetSpecies() + " Hybrid";
        }

        // Create the offspring
        Offspring offspring = new Offspring(
            offspringName,
            offspringSpecies,
            offspringGender,
            this,  // mother
            father // father
        );

        System.out.println(PetUtils.capitalizeFirstLetter(petName) + " gave birth to " + offspringName + "!");

        // Reset
        isPregnant = false;
        pregnancyProgress = 0;
        breedCooldown = 5; // 5 actions before being able to breed
        petEnergy(-30);

        return offspring;
    }

    //Helper for debugging
    public String getStatus() {
        return String.format("%s (%s, %s) - Level: %d, Mood: %d, Energy: %d, Pregnant: %s", 
            petName, petSpecies, gender, level, moodLevel, energy, isPregnant);
    }
}