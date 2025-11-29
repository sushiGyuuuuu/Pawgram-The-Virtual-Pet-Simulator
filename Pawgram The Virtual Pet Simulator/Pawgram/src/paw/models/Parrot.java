package paw.models;

import paw.utils.PetUtils;

public class Parrot extends Bird{
    public Parrot(String name, String accs, String gender, boolean sick) {
        super(name, "Parrot", accs, gender, "Bird", "Social", "Pellets", "Aviary", sick);
    }

    @Override 
    public void makeSound() {
        if(isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " weakly squawks...");
            petMood(-4);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " squawks and mimics you!");
            petExperience(5);
            petMood(4);
        }
        checkHealth();
    }
    @Override 
    public void move() {
        if(getEnergy() > 20) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " flutters around its cage.");
            petEnergy(-6);
            petExperience(3);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " perches quietly.");
            petEnergy(-2);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() < 15) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is not in the mood for food right now.");
            petMood(-4);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " ate the pellets!");
            petEnergy(8);
            petMood(5);
            petExperience(4);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if(isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " seems unwell and fluffs feathers...");
            setIsSick(true);
            petMood(-10);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " continues to be sick, but a lot better now.");
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " does not seem to be sleepy yet.");
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " tuck its head under a wing and sleeps.");
            petEnergy(12);
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 25) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " plays with a bell toy!");
            petExperience(8);
            petMood(10);
            petEnergy(-6);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is too tired to play...");
        }
        checkHealth();
    }
}
