package paw.models;

import java .io.Serializable;

public abstract class Item implements Serializable{
    private String itemName;
    private int itemCost;

    public Item(String itemName, int itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public String getItemName() {return itemName;}
    public int getItemCost() {return itemCost;}

    public abstract void use(Pets pet);
}
