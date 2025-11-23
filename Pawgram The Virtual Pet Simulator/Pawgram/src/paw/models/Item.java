package paw.models;

import java .io.Serializable;

public abstract class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    private String itemName;
    private int itemCost;

    public Item(String itemName, int itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public String getItemName() {return itemName;}
    public int getItemCost() {return itemCost;}

    public abstract void useItem(Pets pet);
}
