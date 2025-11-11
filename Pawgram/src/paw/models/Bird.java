package paw.models;

public abstract class Bird extends Pets{
    public Bird(String name, String species, String accs) {
        super(name, species, accs);
    }

    public void flapWings() {
        System.out.println(getPetName() + " flaps its wings gracefully.");
        petMood(4);
        petEnergy(-3);
    }

    public void layEggs() {
        System.out.println(getPetName() + " laid its eggs!");
        petExperience(8);
    }

    public abstract void makeSound();
    public abstract void move();
    public abstract void eatFood();
    public abstract void reactToTouch();
    public abstract void getsSick();
    public abstract void sleep();
    public abstract void play();
}
