package paw.models;

public abstract class Mammal extends Pets{
    public Mammal(String name, String species, String accs) {
        super(name, species, accs);
    }

    public void groomFur() {
        System.out.println(getPetName() + " is getting its fur groomed.");
        petMood(5);
        petExperience(8);
    }

    public void giveBirth() {
        System.out.println(getPetName() + " gave birth!");
        petExperience(9);
    }

    public abstract void makeSound();
    public abstract void move();
    public abstract void eatFood();
    public abstract void reactToTouch();
    public abstract void getsSick();
    public abstract void sleep();
    public abstract void play();
}
