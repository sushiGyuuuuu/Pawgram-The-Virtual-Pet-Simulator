package paw.models;

import paw.utils.PetUtils;

public abstract class Fish extends Pets{
    public Fish(String name, String species, String accs, String gender, String breedGroup, String nature, String favFood, String prefEnv, 
        boolean sick) {
        super(name, species, accs, gender, breedGroup, nature, favFood, prefEnv, sick);
    }

    public void spawnEggs() {
        System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " spawned its eggs!");
        petExperience(10);
        checkHealth();
    }

    @Override
    public void makeSound() {
        System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " happily goes: glub glub!!");
        petExperience(1);
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        System.out.println(PetUtils.capitalizeFirstLetter(getPetName()) + " does not want to be touched, and swam away!");
        petMood(-3);
        checkHealth();
    }
}
