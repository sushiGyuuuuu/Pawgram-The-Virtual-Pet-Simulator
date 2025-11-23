package paw.models;

public class Cat extends Mammal{
    public Cat(String name, String accs, boolean sick) {
        super(name, "Cat", accs, sick);
    }

    @Override
    public void makeSound() {
        if(isSick) {
            System.out.println(getPetName() + " meows weakly...");
            petMood(-3);
        }else {
            System.out.println(getPetName() + " purrs softly.");
            petMood(5);
            petExperience(3);
        }
        checkHealth();
    }
    
    @Override
    public void move() {
        if(getEnergy() > 20) {
            System.out.println(getPetName() + " prowls gracefully.");
            petEnergy(-8);
        } else {
            System.out.println(getPetName() + " pads slowly.");
            petEnergy(-4);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if (isSick) {
            System.out.println(getPetName() + " sniffs food but won't eat.");
            petMood(-4);
        } else {
            System.out.println(getPetName() + " nibbles cat food happily.");
            petEnergy(12);
            petMood(6);
            petExperience(6);
        }
        checkHealth();
    }

    @Override
    public void reactToTouch() {
        if (isSick) {
            System.out.println(getPetName() + " tolerates a stroke.");
            petMood(-1);
        } else {
            System.out.println(getPetName() + " rubs its head happily.");
            petMood(8);
            petExperience(3);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if (!isSick) {
            System.out.println(getPetName() + " seems unwell.");
            setIsSick(true);
            petMood(-10);
        } else {
            System.out.println(getPetName() + " is already sick.");
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(getPetName() + " curls up and dozes.");
            petEnergy(20);
        }else {
            System.out.println(getPetName() + " is not sleepy right now.");
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 20) {
            System.out.println(getPetName() + " chases a toy mouse!");
            petExperience(7);
            petEnergy(-9);
            petMood(10);
        } else {
            System.out.println(getPetName() + " yawns and ignores the toy.");
            petMood(-2);
        }
        checkHealth();
    }
}   
