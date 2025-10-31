package paw.models;

public class Cat extends Pets{
    public Cat(String name, String moodIndic, String accs, int moodLvl, int hungerLvl, int happinessLvl, int energyLvl, int lvl, int exp) {
        super(name, moodIndic, accs, moodLvl, hungerLvl, happinessLvl, energyLvl, lvl, exp);
    }

    @Override
    public void makeSound() {
        System.out.println(getPetName() + " meows: meow meow!!");
    }
    
    @Override
    public void move() {
        System.out.println(getPetName() + " moves around.");
    }
}   
