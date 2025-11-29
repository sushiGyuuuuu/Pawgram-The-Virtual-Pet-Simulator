package paw.models;

import paw.utils.PetUtils;

public class Turtle extends Reptile {
    public Turtle(String name, String accs, String gender, boolean sick) {
        super(name, "Turtle", accs, gender, "Reptile", "Calm", "Vegetables", "Terrarium", sick);
    }

    @Override
    public void move() {
        if(getEnergy() > 30) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " slowly moving around.");
            petEnergy(-4);
            petMood(7);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " it looks too tired to move...");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() < 10) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " does not want to eat right now.");
            petMood(-5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " munches on vegetables.");
            petEnergy(10);
            petExperience(10);
            petMood(10);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if(isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " looks sick and unable to move.");
            setIsSick(true);
            petEnergy(-10);
            petMood(-15);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "looks a lot more better now!");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "naps inside its shell.");
            petEnergy(8);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "isn't sleepy.");
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() >= 25) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "plays with a floating toy!");
            petExperience(15);
            petMood(10);
            petEnergy(-8);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "is too tired to play right now.");
        }
        checkHealth();
    }
}
