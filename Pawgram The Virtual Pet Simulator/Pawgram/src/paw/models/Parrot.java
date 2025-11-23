package paw.models;

public class Parrot extends Bird{
    public Parrot(String name, String accs, boolean sick) {
        super(name, "Parrot", accs, sick);
    }


    @Override 
    public void makeSound() {
        if(!isSick) {
            System.out.println(getPetName() + " weakly squawks...");
            petMood(-4);
        }else {
            System.out.println(getPetName() + " squawks and mimics you!");
            petExperience(5);
            petMood(4);
        }
        checkHealth();
    }
    @Override 
    public void move() {
        if(getEnergy() > 20) {
            System.out.println(getPetName() + " flutters around its cage.");
            petEnergy(-6);
            petExperience(3);
        }else {
            System.out.println(getPetName() + " perches quietly.");
            petEnergy(-2);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() < 15) {
            System.out.println(getPetName() + " is not in the mood for food right now.");
            petMood(-4);
        }else {
            System.out.println(getPetName() + " eats the seeds and nuts!");
            petEnergy(8);
            petMood(5);
            petExperience(4);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if(!isSick) {
            System.out.println(getPetName() + " seems unwell and fluffs feathers...");
            setIsSick(true);
            petMood(-10);
        }else {
            System.out.println(getPetName() + " continues to be sick, but a lot better now.");
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(getPetName() + " does not seem to be sleepy yet.");
        }else {
            System.out.println(getPetName() + " tuck its head under a wing and sleeps.");
            petEnergy(12);
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 25) {
            System.out.println(getPetName() + " plays with a bell toy!");
            petExperience(8);
            petMood(10);
            petEnergy(-6);
        }else {
            System.out.println(getPetName() + " is too tired to play...");
        }
        checkHealth();
    }
}
