package paw.models;

public class ToyItem extends Item{
    private int moodBoost;
    public ToyItem(String itemName, int itemCost, int moodBoost) {
        super(itemName, itemCost);
        this.moodBoost = moodBoost;
    }

    @Override
    public void useItem(Pets pet) {
        System.out.println(pet.getPetName() + " plays with " + getItemName() + ".");
        pet.petMood(moodBoost);
        pet.petExperience(3);
        pet.checkHealth();
    }
}
