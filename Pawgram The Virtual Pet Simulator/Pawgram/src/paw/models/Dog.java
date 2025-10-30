package paw.models;

public class Dog extends Pets {
    public Dog(String name, String moodIndic, String accs, int moodLvl, int hungerLvl, int happinessLvl, int energyLvl) {
        super(name, moodIndic, accs, moodLvl, hungerLvl, happinessLvl, energyLvl);
    }

    @Override
    public void makeSound() {
        System.out.println(getPetName() + " barks: woof woof!!");
    }
    
    @Override
    public void move() {
        System.out.println(getPetName() + " moves around.");
    }

    @Override
    public void eatFood() {
        System.out.println(getPetName() + " is eating dog food.");
    }

    @Override
    public void expressMood() {
        System.out.println(getPetName() + " wag its tail around.");
    }

    @Override
    public void reactToTouch() {
        System.out.println(getPetName() + " loves to be petted.");
    }

    @Override 
    public void getsSick() {
        System.out.println(getPetName() + " looks very tired and refuses to eat food.");
    }
}
