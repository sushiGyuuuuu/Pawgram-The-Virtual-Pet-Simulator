package paw.models;

public class Bird extends Pets{
    public Bird(String name, String moodIndic, String accs, int moodLvl, int hungerLvl, int happinessLvl, int energyLvl, int lvl, int exp) {
        super(name, moodIndic, accs, moodLvl, hungerLvl, happinessLvl, energyLvl, lvl, exp);
    }

    @Override
    public void makeSound() {
        System.out.println(getPetName() + " chirps: tweet tweet!!");
    }
    
    @Override
    public void move() {
        System.out.println(getPetName() + " flies around.");
    }
}
