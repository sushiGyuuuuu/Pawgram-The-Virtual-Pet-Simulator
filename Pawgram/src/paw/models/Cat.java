package paw.models;

public class Cat extends Mammal{
    public Cat(String name, String species, String accs) {
        super(name, species, accs);
    }

    @Override
    public void makeSound() {
        if(getEnergy() > 30) {
            System.out.println(getPetName() + " meows: meow meow!!");
        }else {
            System.out.println(getPetName() + " is too tired...");
        }
    }
    
    @Override
    public void move() {
        
    }

    @Override
    public void eatFood() {

    }

    @Override
    public void reactToTouch() {

    }

    @Override
    public void getsSick() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void play() {

    }
}   
