package paw.managers;

import paw.models.*;
import paw.utils.*;
import java.util.*;

public class ShopManager {
    private List<Item> items = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private PetManager petManager;

    public ShopManager() {
        this.petManager = new PetManager();

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
        int choice;
        do {
            System.out.println("\n=== Pet Shop ===");
            System.out.println("1. Buy Food");
            System.out.println("2. Buy Accessories");
            System.out.println("3. Adopt New Pet");
            System.out.println("0. Exit Shop");
            System.out.print("Choose: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: buyFood(player); break;
                case 2: buyAccessory(player); break;
                case 3: adoptPet(player); break;
                case 0: System.out.println("Leaving shop..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void buyFood(Player player) {

        System.out.println("\n=== Food Shop ===");
        System.out.println("1. Basic Food (10 coins)  → +10 Energy");
        System.out.println("2. Premium Food (25 coins) → +25 Energy");
        System.out.println("0. Cancel");
        System.out.print("Choose: ");

        int choice = input.nextInt();
        input.nextLine();

        int price = 0;
        FoodItem food = null;

        switch (choice) {
            case 1:
                price = 10;
                food = new FoodItem("Basic Food", 10, 10);
                break;

            case 2:
                price = 25;
                food = new FoodItem("Premium Food", 25, 25);
                break;

            case 0:
                System.out.println("Cancelled.");
                return;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (player.getCoins() < price) {
            System.out.println("Not enough coins!");
            return;
        }

    
        player.setCoins(player.getCoins() - price);
        player.getInventory().add(food);

        System.out.println("You bought: " + food.getItemName());
    }

    private void adoptPet(Player player) {
        System.out.println("\n=== Adopt a New Pet ===");
        System.out.println("Price: 50 coins each");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Goldfish");
        System.out.println("4. Turtle");
        System.out.println("5. Lizard");
        System.out.println("6. Parrot");
        System.out.println("0. Cancel");
        System.out.print("Choose: ");

        int choice = input.nextInt();
        input.nextLine();

        if (choice == 0) return;

        if (player.getCoins() < 50) {
            System.out.println("Not enough coins!");
            return;
        }

        String name = input.nextLine();

        Pets newPet = petManager.createPet(choice, name);

        if (newPet == null) {
            System.out.println("Invalid choice.");
            return;
        }

    // Deduct coins and add pet
        player.addPet(newPet);
        player.setCoins(player.getCoins() - 50);

        System.out.println("You adopted " + name + " the " + newPet.getPetSpecies() + "!");
    }

    private void buyAccessory(Player player) {

        System.out.println("\n=== Accessory Shop ===");
        System.out.println("1. Ribbon (15 coins) → +5 Happiness");
        System.out.println("2. Hat (30 coins) → +15 Happiness");
        System.out.println("3. Fancy Outfit (75 coins) → +30 Happiness");
        System.out.println("0. Cancel");
        System.out.print("Choose: ");

        int choice = input.nextInt();
        input.nextLine();

        int price = 0;
        AccessoryItem item = null;

        switch (choice) {
            case 1:
                price = 15;
                item = new AccessoryItem("Ribbon", 15, 5);
                break;

            case 2:
                price = 30;
                item = new AccessoryItem("Hat", 30, 15);
                break;

            case 3:
                price = 75;
                item = new AccessoryItem("Fancy Outfit", 75,30);
                break;

            case 0:
                System.out.println("Cancelled.");
                return;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (player.getCoins() < price) {
            System.out.println("Not enough coins!");
            return;
        }

    // Process purchase
        player.setCoins(player.getCoins() - price);
        player.getInventory().add(item);

        System.out.println("You bought: " + item.getItemName());
    }

}
