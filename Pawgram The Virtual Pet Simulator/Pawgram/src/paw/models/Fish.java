package paw.models;

public class Fish extends Pets{
    public Fish(String name, String moodIndic, String accs, int moodLvl, int hungerLvl, int happinessLvl, int energyLvl) {
        super(name, moodIndic, accs, moodLvl, hungerLvl, happinessLvl, energyLvl);
    }

    @Override
    public void makeSound() {
        System.out.println(getPetName() + " goes: glub glub!!");
    }
    
    @Override
    public void move() {
        System.out.println(getPetName() + " swims around.");
    }
}
