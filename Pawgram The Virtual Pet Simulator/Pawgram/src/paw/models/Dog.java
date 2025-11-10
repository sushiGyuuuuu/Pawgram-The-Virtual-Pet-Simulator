package paw.models;

public class Dog extends Mammal {
    public Dog(String name, String species, String accs) {
        super(name, species, accs);
    }

    @Override
    public void makeSound() {
        if(getEnergy() > 20) {
            System.out.println(getPetName() + " barks happily: woof woof!!");
            petMood(5);
            petExperience(5);
        }else {
            System.out.println(getPetName() + " is too tired to bark...");
            petMood(-5);
        }
    }
    
    @Override
    public void move() {
        if(getEnergy() > 30) {
            System.out.println(getPetName() + " runs around the backyard!");
            petEnergy(-10);
            petExperience(5);
            petMood(5);
        }else {
            System.out.println(getPetName() + " is very tired. Feed it or let it rest.");
            petMood(-5);
        }
        
    }

    @Override
    public void eatFood() {
        if(getMoodLevel() < 10) {
            System.out.println(getPetName() + " does not want to eat right now.");
            petMood(-5);
        }else {
            System.out.println(getPetName() + " is happily munching on dog food!");
            petEnergy(10);
            petExperience(10);
            petMood(10);
        }
    }

    @Override
    public void reactToTouch() {
        if(getMoodLevel() >= 30) {
            System.out.println(getPetName() + " enjoys being petted!");
            petExperience(10);
            petMood(10);
        }else {
            System.out.println(getPetName() + " feels scared and backed away...");
            petMood(-5);
        }
    }

    @Override 
    public void getsSick() {
        if(getMoodLevel() <= 20 || getEnergy() <= 20) {
            System.out.println(getPetName() + " looks very tired and refuses to move...");
            petEnergy(-10);
            petMood(-15);
        }else {
            System.out.println(getPetName() + " seems a little better now, but still not feeling well...");
            petMood(-5);
        }
    }

    @Override
    public void sleep() {
        if(getEnergy() < 100) {
            System.out.println(getPetName() + " snores softly...");
            petEnergy(15);
            petExperience(5);
            petMood(2);
        }else {
            System.out.println(getPetName() + " is already full of energy!");
            petMood(-3);
        }
    }

    @Override
    public void play() {
        if(getEnergy() > 25) {
            System.out.println(getPetName() + " enjoys playing fetch with you!");
            petEnergy(-8);
            petExperience(15);
            petMood(9);
        }else {
            System.out.println(getPetName() + " feels too tired to play with you right now...");
            petMood(-5);
        }
    }
}