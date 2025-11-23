package paw.models;

public class Goldfish extends Fish{
    public Goldfish(String name, String accs, boolean sick) {
        super(name, "Goldfish", accs, sick);
    }

    @Override
    public void move() {
        if(getEnergy() > 30) {
            System.out.println(getPetName() + " swims around the aquarium!");
            petEnergy(-5);
            petExperience(5);
            petMood(5);
        }else {
            System.out.println(getPetName() + " floats lazily in its aquarium...");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getEnergy() < 100) {
            System.out.println(getPetName() + " is happily eating its pellets!");
            petEnergy(10);
            petMood(5);
            petExperience(5);
        }else {
            System.out.println(getPetName() + " if full. It doesn't want to eat right now.");
            petMood(-5);
        }
        checkHealth();
    }

    @Override
    public void getsSick() {
        if(getMoodLevel() <= 20 || getEnergy() <= 25) {
            System.out.println(getPetName() + " looks pale and less active than usual. It might be sick...");
            setIsSick(true);
            petMood(-10);
            petEnergy(-10);
        }else {
            System.out.println(getPetName() + " still looks sluggish, but it should be fine now.");
            petMood(-3);
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 95) {
            System.out.println(getPetName() + " rests near the bottom of the tank...");
            petEnergy(10);
            petExperience(5);
        }else {
            System.out.println(getPetName() + " isn't sleepy yet and swims around the tank.");
            petMood(-2);
        }
        checkHealth();
    }

    @Override
    public void play() {
        if(getEnergy() > 20 && getMoodLevel() > 30) {
            System.out.println(getPetName() + " plays with bubbles and decorations inside the tank!");
            petEnergy(-8);
            petMood(8);
            petExperience(10);
        }else {
            System.out.println(getPetName() + " is too stressed to play.");
        }
        checkHealth();
    }
}
