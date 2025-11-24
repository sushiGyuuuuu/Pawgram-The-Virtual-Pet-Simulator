package paw.models;

import java.io.Serializable;
import paw.utils.PetUtils;

public abstract class Pets implements Serializable{
    protected String petName;
    protected String petSpecies;
    protected String accessories;
    protected int moodLevel;
    protected int energy;
    protected int level;
    protected int experience;
    protected boolean isSick;

    //Pet Constructor
    public Pets(String petName, String petSpecies, String accessories, boolean isSick) {
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.accessories = accessories;
        this.moodLevel = 100;
        this.energy = 100;
        this.level = 1;
        this.experience = 0;
        this.isSick = false; // healthy
    }

    //Getters and Setters
    public String getPetName() {return petName;}
    public String getPetSpecies() {return petSpecies;}
    public String getAccessories() {return accessories;}
    public int getMoodLevel() {return moodLevel;}
    public int getEnergy() {return energy;}
    public int getLevel() {return level;}
    public int getExperience() {return experience;}
    public boolean getIsSick() {return isSick;}

    public void setPetName(String petName) {this.petName = petName;}
    public void setPetSpecies(String petSpecies) {this.petSpecies = petSpecies;}
    public void setAccessories(String accessories) {this.accessories = accessories;}
    public void setMoodLevel(int moodLevel) {this.moodLevel = moodLevel;}
    public void setEnergy(int energy) {this.energy = energy;}
    public void setLevel(int level) {this.level = level;}
    public void setExperience(int experience) {this.experience = experience;}
    public void setIsSick(boolean isSick) {this.isSick = isSick;}

    //Abstract Methods 
    public abstract void makeSound();
    public abstract void move();
    public abstract void eatFood();
    public abstract void reactToTouch();
    public abstract void getsSick();
    public abstract void sleep();
    public abstract void play();

    //Pet Stats Modifiers
    public void petExperience(int amount) {
        this.experience += amount;

        if(this.experience >= 100) {
            this.level++;
            this.experience -= 100;
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " has now leveled up to lvl " + this.level + "!" );
        }
    }

    public void petMood(int amount) {
        this.moodLevel += amount;

        if(this.moodLevel > 100) this.moodLevel = 100;
        if(this.moodLevel < 0) this.moodLevel = 0;

        if(this.moodLevel >= 80 && this.moodLevel <= 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is very happy.");
        }else if(this.moodLevel >= 20 && this.moodLevel <= 79) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is happy.");
        }else{
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is sad.");
        }
    }

    public void petEnergy(int amount) {
        this.energy += amount;

        if(this.energy > 100) this.energy = 100;
        if(this.energy < 0) this.energy = 0;

        if(this.energy < 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is low on energy.");
            System.out.println("Feed your pet to increase its energy.");
            this.moodLevel -= 10;
        }
    }

    public void checkHealth() {
        if(this.energy < 10 || this.moodLevel < 10) {
            isSick = true;
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " became sick!");
        }
    } 
}