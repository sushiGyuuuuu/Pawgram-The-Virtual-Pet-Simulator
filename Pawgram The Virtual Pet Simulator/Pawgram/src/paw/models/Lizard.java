package paw.models;

public class Lizard extends Reptile{
    public Lizard(String name, String accessories, boolean sick) {
        super(name, "Lizard", accessories, sick);
    }

    @Override
    public void move() {
        if(getEnergy() > 30) {
            System.out.println(getPetName() + " scurries along the rocks in its cage.");
            petExperience(5);
            petEnergy(-7);
        }else {
            System.out.println(getPetName() + " is too tired to move...");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() > 15) {
            System.out.println(getPetName() + " happily munches on eats food!");
            petEnergy(7);
            petExperience(10);
            petMood(8);
        }else {
            System.out.println(getPetName() + " does not want to eat right now...");
            petMood(-3);
        }
        checkHealth();
    }

    @Override 
    public void getsSick() {
        if(!isSick) {
            System.out.println(getPetName() + " looks weakened. It may be sick...");
            setIsSick(true);
            petMood(-15);
            petEnergy(-10);
        }else {
            System.out.println(getPetName() + " look a little better now, let it rest for a while...");
            petMood(-8);
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(getPetName() + " is gonna take a quick nap...");
            petEnergy(8);
        }else {
            System.out.println(getPetName() + " is still full of energy. It does not want to sleep yet.");
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() >= 20) {
            System.out.println(getPetName() + " is full of energy and loves playing with you!");
            petEnergy(-6);
            petMood(8);
            petExperience(10);
        }else {
            System.out.println(getPetName() + " does not have the energy to play right now...");
        }
        checkHealth();
    }
}
