package paw.models;

import paw.utils.PetUtils;

public abstract class Bird extends Pets{
    public Bird(String name, String species, String accs, boolean sick) {
        super(name, species, accs, sick);
    }

    public void flapWings() {
        System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " flaps its wings gracefully.");
        petMood(4);
        petEnergy(-3);
        checkHealth();
    }

    public void layEggs() {
        System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " laid its eggs!");
        petExperience(10);
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        if(isSick) {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " is fragile and flutters away...");
            petMood(-3);
        }else {
            System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " chirps happily when gently touched.");
            petMood(8);
            petExperience(3);
        }
        checkHealth();
    }
}
