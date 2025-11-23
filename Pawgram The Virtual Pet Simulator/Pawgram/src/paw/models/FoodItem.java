package paw.models;

public class FoodItem extends Item{
    private int energyBoost;

    public FoodItem(String itemName, int itemCost, int energyBoost) {
        super(itemName, itemCost);
        this.energyBoost = energyBoost;
    }

    @Override
    public void useItem(Pets pet) {
        System.out.println(pet.getPetName() + " eats " + getItemName() + ".");
        pet.petEnergy(energyBoost);
        pet.petMood(5);
        pet.petExperience(4);
        pet.checkHealth();
    }
}
