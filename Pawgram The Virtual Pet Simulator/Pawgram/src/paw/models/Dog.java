package paw.models;

import paw.utils.PetUtils;

public class Dog extends Mammal {
    public Dog(String name, String accs, boolean sick) {
        super(name, "Dog", accs, sick);
    }

    @Override
    public void makeSound() {
        if(getEnergy() > 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "barks happily: woof woof!!");
            petMood(5);
            petExperience(5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "is too tired to bark...");
            petMood(-5);
        }
        checkHealth();
    }
    
    @Override
    public void move() {
        if(getEnergy() > 30) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "runs around the backyard!");
            petEnergy(-10);
            petExperience(5);
            petMood(5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "is very tired. Feed it or let it rest.");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() < 10) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "does not want to eat right now.");
            petMood(-5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "is happily munching on dog food!");
            petEnergy(10);
            petExperience(10);
            petMood(10);
        }
        checkHealth();
    }

    @Override 
    public void getsSick() {
        if(!isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "looks very tired and refuses to move...");
            setIsSick(true);
            petEnergy(-10);
            petMood(-15);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "seems a little better now, but still not feeling well...");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "snores softly...");
            petEnergy(15);
            petExperience(5);
            petMood(2);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "is already full of energy!");
            petMood(-3);
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 25) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "enjoys playing fetch with you!");
            petEnergy(-8);
            petExperience(15);
            petMood(9);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + "feels too tired to play with you right now...");
            petMood(-5);
        }
        checkHealth();
    }
}