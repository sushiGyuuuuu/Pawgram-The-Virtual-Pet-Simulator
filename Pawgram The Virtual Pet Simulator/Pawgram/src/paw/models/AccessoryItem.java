package paw.models;

public class AccessoryItem extends Item {
    private int happinessBoost;

    public AccessoryItem(String itemName, int itemCost, int happinessBoost) {
        super(itemName, itemCost);
        this.happinessBoost = happinessBoost;
    }

    @Override
    public void useItem(Pets pet) {
        System.out.println("Using accessory on " + pet.getPetName() + "...");
        pet.increaseHappiness(happinessBoost);
        System.out.println(pet.getPetName() + " feels happier!");
    }
}
