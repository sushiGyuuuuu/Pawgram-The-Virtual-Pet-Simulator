package paw.models;

import paw.utils.PetUtils;

public class Goldfish extends Fish{
    public Goldfish(String name, String accs, String gender, boolean sick) {
        super(name, "Goldfish", accs, gender, "Fish", "Calm", "Fish Flakes", "Aquarium", sick);
    }

    @Override
    public void move() {
        if(getEnergy() > 30) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " swims around the aquarium!");
            petEnergy(-5);
            petExperience(5);
            petMood(5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " floats lazily in its aquarium...");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getEnergy() < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is happily eating its pellets!");
            petEnergy(10);
            petMood(5);
            petExperience(5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " if full. It doesn't want to eat right now.");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if(getMoodLevel() <= 20 || getEnergy() <= 25) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " looks pale and less active than usual. It might be sick...");
            setIsSick(true);
            petMood(-10);
            petEnergy(-10);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " still looks sluggish, but it should be fine now.");
            petMood(-3);
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " rests near the bottom of the tank...");
            petEnergy(10);
            petExperience(5);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " isn't sleepy yet and swims around the tank.");
            petMood(-2);
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 20 && getMoodLevel() > 30) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " plays with bubbles and decorations inside the tank!");
            petEnergy(-8);
            petMood(8);
            petExperience(10);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is too stressed to play.");
        }
        checkHealth();
    }
}
