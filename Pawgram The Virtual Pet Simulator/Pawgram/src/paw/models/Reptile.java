package paw.models;

public abstract class Reptile extends Pets{
    public Reptile(String name, String species, String accessories, boolean sick) {
        super(name, species, accessories, sick);
    }
    public void shedSkin() {
        System.out.println(getPetName() + " is starting to shed its skin!");
        checkHealth();
    }
    public void layEggs() {
        System.out.println(getPetName() + " laid its eggs!");
        petExperience(10);
        checkHealth();
    }

    public void makeSound() {
        if(getEnergy() > 20) {
            System.out.println(getPetName() + " makes a soft hissing noise.");
            petExperience(2);
            petMood(5);
        }else {
            System.out.println(getPetName() + " is too tired...");
            petMood(-3);
        }
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        if(getMoodLevel() <= 20) {
            System.out.println(getPetName() + " is scared. It doesn't want to be touched.");
            petMood(-10);
        }else {
            System.out.println(getPetName() + " loves being touched!");
            petMood(10);
            petExperience(10);
        }
        checkHealth();
    }
}
