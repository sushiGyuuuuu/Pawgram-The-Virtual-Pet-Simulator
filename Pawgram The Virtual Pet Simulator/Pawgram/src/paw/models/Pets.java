package paw.models;

public abstract class Pets {
    private String petName;
    private String mood;
    private String accessories;
    private int moodLevel;
    private int hungerLevel;
    private int happinessLevel;
    private int energy;

    //Pet Constructor
    public Pets(String petName, String mood, String accessories, int moodLevel, int hungerLevel, int happinessLevel, int energy) {
        this.petName = petName;
        this.mood = mood;
        this.accessories = accessories;
        this.moodLevel = 100;
        this.hungerLevel = 100;
        this.happinessLevel = 100;
        this.energy = 100;
    }

    //Getters and Setters
    public String getPetName() {return petName;}
    public String getMoodIndicator() {return mood;}
    public String getAccessories() {return accessories;}
    public int getMoodLevel() {return moodLevel;}
    public int getHungerLevel() {return hungerLevel;}
    public int getHappinesLevel() {return happinessLevel;}
    public int getEnergy() {return energy;}

    public void setPetName(String petName) {this.petName = petName;}
    public void setMoodIndicator(String moodIndicator) {this.mood = moodIndicator;}
    public void setAccessories(String accessories) {this.accessories = accessories;}
    public void setMoodLevel(int moodLevel) {this.moodLevel = moodLevel;}
    public void setHungerLevel(int hungerLevel) {this.hungerLevel = hungerLevel;}
    public void setHappinessLevel(int happinessLevel) {this.happinessLevel = happinessLevel;}
    public void setEnergy(int energy) {this.energy = energy;}

    //Abstract Methods 
    public abstract void makeSound();
    public abstract void move();
    public abstract void eatFood();
    public abstract void expressMood();
    public abstract void reactToTouch();
    public abstract void getsSick();

    //Common Behaviors
    public void feed() {
        moodLevel += 5;
        hungerLevel += 10;
        happinessLevel += 10;
        energy += 10;

        System.out.println(petName + " has been fed!");
    }

    public void play() {
        moodLevel += 10;
        hungerLevel -= 5;
        happinessLevel += 15;
        energy -= 10;

        System.out.println(petName + " has played!");
    }

    public void sleep() {
        hungerLevel -= 5;
        energy += 20;
    }
}
