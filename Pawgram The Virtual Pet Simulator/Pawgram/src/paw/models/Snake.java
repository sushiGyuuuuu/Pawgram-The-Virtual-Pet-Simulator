package paw.models;

public class Snake extends Reptile{
    public Snake(String name, String accessories, boolean isSick) {
        super(name, "Snake", accessories, isSick);
    }

    @Override
    public void move() {
        if(getEnergy() > 25) {
            System.out.println(getPetName() + " slither smoothly across the tank.");
        } else {
            System.out.println(getPetName() + " sluggishly drags along.");
        }
        petExperience(5);
        petEnergy(-5);
        checkHealth();
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() > 50) {
            System.out.println(getPetName() + " quickly swallows its food!");
        }else {
            System.out.println(getPetName() + " slowly eats, seemingly unsure...");
        }
        petEnergy(20);
        checkHealth();
    }

    @Override 
    public void getsSick() {
        if(!isSick) {
            System.out.println(getPetName() + " looks like it's not feeling well. Let it rest.");
            setIsSick(true);
            petMood(-10);
            petEnergy(-12);
        }else{
            System.out.println(getPetName() + " looks a little better now, but you should still let it rest.");
        }
        checkHealth();
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(getPetName() + " coils and dozes.");
            petEnergy(12);
        }else {
            System.out.println(getPetName() + " is not sleepy yet!");
        }
        checkHealth();
    }

    @Override 
    public void play() {
        if(getEnergy() > 40) {
            System.out.println(getPetName() +  " explore a new log.");
            petExperience(7);
            petEnergy(-5);
            petMood(4);
        }else {
            System.out.println(getPetName() + " prefers to rest instead.");
        }
        checkHealth();
    }
}
