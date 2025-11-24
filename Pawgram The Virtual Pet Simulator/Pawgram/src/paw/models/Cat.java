package paw.models;

import paw.utils.PetUtils;

public class Cat extends Mammal{
    public Cat(String name, String accs, boolean sick) {
        super(name, "Cat", accs, sick);
    }

    @Override
    public void makeSound() {
        if(isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " meows weakly...");
            petMood(-3);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " purrs softly.");
            petMood(5);
            petExperience(3);
        }
        checkHealth();
    }
    
    @Override
    public void move() {
        if(getEnergy() > 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " prowls gracefully.");
            petEnergy(-8);
        } else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " pads slowly.");
            petEnergy(-4);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if (isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " sniffs food but won't eat.");
            petMood(-4);
        } else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " nibbles cat food happily.");
            petEnergy(12);
            petMood(6);
            petExperience(6);
        }
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        if (isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " tolerates a stroke.");
            petMood(-1);
        } else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " rubs its head happily.");
            petMood(8);
            petExperience(3);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if (!isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " seems unwell.");
            setIsSick(true);
            petMood(-10);
        } else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is already sick.");
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " curls up and dozes.");
            petEnergy(20);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is not sleepy right now.");
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " chases a toy mouse!");
            petExperience(7);
            petEnergy(-9);
            petMood(10);
        } else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " yawns and ignores the toy.");
            petMood(-2);
        }
        checkHealth();
    }
}   
