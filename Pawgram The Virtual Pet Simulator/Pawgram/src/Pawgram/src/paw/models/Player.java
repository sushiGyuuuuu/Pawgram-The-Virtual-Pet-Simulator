package paw.models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Player implements Serializable{
    private static final long serialVersionUID = 1L;

    private String playerName;
    private int level;
    private int coins;
    private int experience;
    private List<Pets> ownedPets;
    private List<Item> inventory;
    private List<Player> accessories;
    private List<Offspring> offsprings;
    private Pets activePet;

    //Player Constructor
    public Player(String playerName) {
        this.playerName = playerName;
        this.level = 1;
        this.coins = 9999999;
        this.experience = 0;
        this.ownedPets = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.accessories = new ArrayList<>();
        this.offsprings = new ArrayList<>();
        this.activePet = null;
    }

    //Getters and Setters
    public String getPlayerName() {return playerName;}
    public int getLevel() {return level;}
    public int getCoins() {return coins;}
    public int experience() {return experience;}
    public List<Pets> getOwnedPets() {return ownedPets;}
    public List<Item> getInventory() {return inventory;}
    public List<Player> getAccessories() {return accessories;}
    public List<Offspring> getOffsprings() {return offsprings;}
    public Pets getActivePet() {return activePet;}

    public void setPlayerName(String playerName) {this.playerName = playerName;}
    public void setLevel(int level) {this.level = level;}
    public void setCoins(int coins) {this.coins = coins;}
    public void setExperience(int experience) {this.experience = experience;}
    public void setOwnedPets(List<Pets> ownedPets) {this.ownedPets = ownedPets;}
    public void setInventory(List<Item> inventory) {this.inventory = inventory;}
    public void setAccessories(List<Player> accessories) {this.accessories = accessories;}
    public void setOffsprings(List<Offspring> offsprings) {this.offsprings = offsprings;}
    public void setActivePet(Pets activepet) {this.activePet = activepet;}
    public void addItem(Item item) {inventory.add(item);}
    public void addCoins(int amount) {this.coins += amount;}
    public void addPet(Pets pet) {ownedPets.add(pet);}
    public void addOffspring(Offspring offspring) {offsprings.add(offspring);}
    public void removeOffspring(Offspring offspring) {offsprings.remove(offspring);}
    
    //Actions that can be made by the Player
    public void useItem(int index, Pets pet) {
        if(index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            item.useItem(pet);
            inventory.remove(index);
        }
    }

    public void careForOffspring() {
        for (Offspring offspring : offsprings) {
            if (offspring.progressGrowth()) {
                System.out.println(offspring.getName() + " has grown to " + offspring.getGrowthStageName() + " stage!");
                
                if (offspring.isReadyForAdulthood()) {
                    System.out.println(offspring.getName() + " is now ready to become a full pet!");
                }
            }
        }
    }

    public void promoteOffspringToPet(Offspring offspring) {
        if (offspring.isReadyForAdulthood()) {
            Pets newPet = offspring.toAdultPet();
            if (newPet != null) {
                ownedPets.add(newPet);
                offsprings.remove(offspring);
                System.out.println("Congratulations! " + newPet.getPetName() + " is now a full-grown pet!");
            }
        }
    }
}