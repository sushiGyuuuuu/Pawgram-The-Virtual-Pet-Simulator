package paw.models;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private int level;
    private int coins;
    private int experience;
    private List<Pets> ownedPets;
    private List<Player> inventory;
    private List<Player> accessories;
    private Pets activePet;

    //Player Constructor
    public Player(String playerName) {
        this.playerName = playerName;
        this.level = 1;
        this.coins = 100;
        this.experience = 0;
        this.ownedPets = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.accessories = new ArrayList<>();
        this.activePet = null;
    }

    //Getters and Setters
    public String getPlayerName() {return playerName;}
    public int getLevel() {return level;}
    public int getCoins() {return coins;}
    public int experience() {return experience;}
    public List<Pets> getOwnedPets() {return ownedPets;}
    public List<Player> getInventory() {return inventory;}
    public List<Player> getAccessories() {return accessories;}
    public Pets getActivePet() {return activePet;}

    public void setPlayerName(String playerName) {this.playerName = playerName;}
    public void setLevel(int level) {this.level = level;}
    public void setCoins(int coins) {this.coins = coins;}
    public void setExperience(int experience) {this.experience = experience;}
    public void setOwnedPets(List<Pets> ownedPets) {this.ownedPets = ownedPets;}
    public void setInventory(List<Player> inventory) {this.inventory = inventory;}
    public void setAccessories(List<Player> accessories) {this.accessories = accessories;}
    public void setActivePet(Pets activepet) {this.activePet = activepet;}
    
    //Actions that can be made by the Player
    public void buyPet(Pets pet, int price) {
        if(coins > price) {
            coins -= price;
            ownedPets.add(pet);
            System.out.printf("%s has bought a %s!%n", getPlayerName(), pet.getPetSpecies());
            experience += 5;
        }else {
            System.out.printf("You don't have enough coins to buy a %s.%n", pet.getPetSpecies());
        }
    }

    public void feedPets(Pets pet) {
        pet.eatFood();
        experience += 10;
    }

    public void playPets(Pets pet) {
        pet.play();
        experience += 15;
    }

    public void activePet(Pets pet) {
        if(ownedPets.contains(pet)) {
            this.activePet = pet;
            System.out.println(pet.getPetName() + " is now active!");
        }else {
            System.out.println("You don't own this pet!");
        }
    }

    public void buyAccessories(Player player, int price) {
        if(coins > price) {
            coins -= price;
            inventory.add(player);
            System.out.printf("%s has bought a %s.%n", getPlayerName(), getAccessories());
            experience += 5;
        }else {
            System.out.printf("You don't have enough coins to buy a %s.%n", getAccessories());
        }
    }
}