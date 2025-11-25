package paw.managers;

import paw.models.*;
import paw.utils.*;
import java.util.*;

public class ShopManager {
    private List<Item> items = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public ShopManager() {
        items.add(new FoodItem("Dog Treat", 10, 15));
        items.add(new FoodItem("Cat Treat", 10, 12));
        items.add(new FoodItem("Pellets", 7, 9));
        items.add(new FoodItem("Fish Manager" , 8, 10));
        items.add(new FoodItem("Vegetables", 12, 15));
        items.add(new ToyItem("Ball", 10, 15));
        items.add(new ToyItem("Bell", 12, 7));
        items.add(new ToyItem("Duck Toy", 14, 16));
    }

    public void openShop(paw.models.Player player) {
        PetUtils.clearScreen();
        System.out.println("=== Pet Shop ===");
        System.out.println("Coins: " + player.getCoins());
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ". " + items.get(i).getItemName() + " - " + items.get(i).getItemCost() + " coins");
        }
        System.out.println("0. Exit");
        System.out.print("Select: ");
        int choice = input.nextInt();
        input.nextLine();
        if(choice == 0) return;
        if (choice > 0 && choice <= items.size()) {
            Item item = items.get(choice - 1);
            if (player.getCoins() >= item.getItemCost()) {
                player.addItem(item);
                player.setCoins(player.getCoins() - item.getItemCost());
                System.out.println("Purchased " + item.getItemName());
            } else {
                System.out.println("Not enough coins!");
            }
        }
    }
}
