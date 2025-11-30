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
        initializeShopItems();
    }

    private void initializeShopItems() {
        // Food items
        items.add(new FoodItem("Dog Treat", 10, 15));
        items.add(new FoodItem("Cat Treat", 10, 12));
        items.add(new FoodItem("Pellets", 7, 9));
        items.add(new FoodItem("Fish Flakes", 8, 10));
        items.add(new FoodItem("Vegetables", 12, 15));
        
        // Toy items
        items.add(new ToyItem("Ball", 10, 15));
        items.add(new ToyItem("Bell", 12, 7));
        items.add(new ToyItem("Duck Toy", 14, 16));
        items.add(new ToyItem("Chew Toy", 8, 10));
        items.add(new ToyItem("Laser Pointer", 18, 12));
        
        // Accessory items
        items.add(new AccessoryItem("Ribbon", 15, 5));
        items.add(new AccessoryItem("Hat", 30, 15));
        items.add(new AccessoryItem("Fancy Outfit", 75, 30));
        items.add(new AccessoryItem("Colorful Collar", 25, 10));
        items.add(new AccessoryItem("Sparkly Bow", 20, 8));
    }

    public void openShop(Player player) {
        int choice;
        do {
            UIUtils.clearScreen();
            System.out.println(UIUtils.createTitleBox("PET SHOP"));
            
            // Display player info
            System.out.println("Welcome, " + PetUtils.capitalizeFirstLetter(player.getPlayerName()) + "!");
            System.out.println("Coins: " + player.getCoins());
            System.out.println("Pets: " + player.getOwnedPets().size());
            System.out.println(UIUtils.createSeparator(40));
            
            System.out.println(UIUtils.menuOption(1, "Buy Food"));
            System.out.println(UIUtils.menuOption(2, "Buy Accessories"));
            System.out.println(UIUtils.menuOption(3, "Adopt New Pet"));
            System.out.println(UIUtils.menuOption(0, "Exit Shop"));
            System.out.print("\nChoose: ");

            choice = UIUtils.getValidatedInt(input, 0, 3);

            switch (choice) {
                case 1: 
                    buyFood(player); 
                    input.nextLine();
                    break;
                case 2: 
                    buyAccessory(player); 
                    input.nextLine();
                    break;
                case 3: 
                    adoptPet(player); 
                    input.nextLine();
                    break;
                case 0: 
                    System.out.println("Leaving shop...");
                    UIUtils.pause();
                    break;
                default: 
                    System.out.println("Invalid choice.");
                    UIUtils.pause();
            }
        } while (choice != 0);
    }

    private void buyFood(Player player) {
        UIUtils.clearScreen();
        System.out.println(UIUtils.createTitleBox("FOOD SHOP"));
        System.out.println("Your coins: " + player.getCoins());
        System.out.println();
        
        System.out.println("Available Food Items:");
        System.out.println("┌─────┬────────────────────┬──────────┬────────────────┐");
        System.out.println("│ No. │ Item Name          │ Price    │ Effect         │");
        System.out.println("├─────┼────────────────────┼──────────┼────────────────┤");
        System.out.println("│  1. │ Basic Food         │ 10 coins │ +10 Energy     │");
        System.out.println("│  2. │ Premium Food       │ 25 coins │ +25 Energy     │");
        System.out.println("│  3. │ Dog Treat          │ 10 coins │ +15 Energy     │");
        System.out.println("│  4. │ Cat Treat          │ 10 coins │ +12 Energy     │");
        System.out.println("│  5. │ Pellets            │  7 coins │ +9 Energy      │");
        System.out.println("│  6. │ Fish Flakes        │  8 coins │ +10 Energy     │");
        System.out.println("│  7. │ Vegetables         │ 12 coins │ +15 Energy     │");
        System.out.println("└─────┴────────────────────┴──────────┴────────────────┘");
        System.out.println("\n0. Cancel");
        System.out.print("Choose: ");

        int choice = UIUtils.getValidatedInt(input, 0, 7);

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
            case 3:
                price = 10;
                food = new FoodItem("Dog Treat", 10, 15);
                break;
            case 4:
                price = 10;
                food = new FoodItem("Cat Treat", 10, 12);
                break;
            case 5:
                price = 7;
                food = new FoodItem("Pellets", 7, 9);
                break;
            case 6:
                price = 8;
                food = new FoodItem("Fish Flakes", 8, 10);
                break;
            case 7:
                price = 12;
                food = new FoodItem("Vegetables", 12, 15);
                break;
            case 0:
                System.out.println("Purchase cancelled.");
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
        player.getInventory().add(food);

        System.out.println("You bought: " + food.getItemName() + " for " + price + " coins!");
        System.out.println("Remaining coins: " + player.getCoins());
        UIUtils.pause();
    }

    private void buyAccessory(Player player) {
        UIUtils.clearScreen();
        System.out.println(UIUtils.createTitleBox("ACCESSORY SHOP"));
        System.out.println("Your coins: " + player.getCoins());
        System.out.println();
        
        System.out.println("Available Accessories:");
        System.out.println("┌─────┬────────────────────┬──────────┬──────────────────┐");
        System.out.println("│ No. │ Item Name          │ Price    │ Effect           │");
        System.out.println("├─────┼────────────────────┼──────────┼──────────────────┤");
        System.out.println("│  1. │ Ribbon             │ 15 coins │ +5 Happiness     │");
        System.out.println("│  2. │ Colorful Collar    │ 25 coins │ +10 Happiness    │");
        System.out.println("│  3. │ Sparkly Bow        │ 20 coins │ +8 Happiness     │");
        System.out.println("│  4. │ Hat                │ 30 coins │ +15 Happiness    │");
        System.out.println("│  5. │ Fancy Outfit       │ 75 coins │ +30 Happiness    │");
        System.out.println("└─────┴────────────────────┴──────────┴──────────────────┘");
        System.out.println("\n0. Cancel");
        System.out.print("Choose: ");

        int choice = UIUtils.getValidatedInt(input, 0, 5);

        int price = 0;
        AccessoryItem item = null;

        switch (choice) {
            case 1:
                price = 15;
                item = new AccessoryItem("Ribbon", 15, 5);
                break;
            case 2:
                price = 25;
                item = new AccessoryItem("Colorful Collar", 25, 10);
                break;
            case 3:
                price = 20;
                item = new AccessoryItem("Sparkly Bow", 20, 8);
                break;
            case 4:
                price = 30;
                item = new AccessoryItem("Hat", 30, 15);
                break;
            case 5:
                price = 75;
                item = new AccessoryItem("Fancy Outfit", 75, 30);
                break;
            case 0:
                System.out.println("Purchase cancelled.");
                return;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (player.getCoins() < price) {
            System.out.println("Not enough coins!");
            System.out.println("You need " + price + " coins but only have " + player.getCoins() + " coins.");
            UIUtils.pause();
            return;
        }

        // Process purchase
        player.setCoins(player.getCoins() - price);
        player.getInventory().add(item);

        System.out.println("You bought: " + item.getItemName() + " for " + price + " coins!");
        System.out.println("Remaining coins: " + player.getCoins());
        System.out.println("Use it from your inventory to make your pet happier!");
        UIUtils.pause();
    }

    private void adoptPet(Player player) {
        UIUtils.clearScreen();
        System.out.println(UIUtils.createTitleBox("PET ADOPTION CENTER"));
        System.out.println("Your coins: " + player.getCoins());
        System.out.println("Current pets: " + player.getOwnedPets().size());
        System.out.println();
        
        System.out.println("Adoption Fee: 50 coins per pet");
        System.out.println("Available Pets for Adoption:");
        System.out.println("┌─────┬────────────────────┬─────────────────────────────┐");
        System.out.println("│ No. │ Pet Type           │ Description                 │");
        System.out.println("├─────┼────────────────────┼─────────────────────────────┤");
        System.out.println("│  1. │    Dog             │ Loyal, energetic companion  │");
        System.out.println("│  2. │    Cat             │ Independent, graceful friend│");
        System.out.println("│  3. │    Goldfish        │ Colorful, peaceful swimmer  │");
        System.out.println("│  4. │    Turtle          │ Slow, wise shelled friend   │");
        System.out.println("│  5. │    Lizard          │ Cool, exotic reptile        │");
        System.out.println("│  6. │    Parrot          │ Talkative, colorful bird    │");
        System.out.println("└─────┴────────────────────┴─────────────────────────────┘");
        System.out.println("\n0. Cancel");
        System.out.print("Choose pet to adopt: ");

        int choice = UIUtils.getValidatedInt(input, 0, 6);

        if (choice == 0) {
            System.out.println("Adoption cancelled.");
            UIUtils.pause();
            return;
        }

        if (choice < 1 || choice > 6) {
            System.out.println("Invalid choice. Please select 1-6.");
            UIUtils.pause();
            return;
        }

        // Check if player has enough coins
        if (player.getCoins() < 50) {
            System.out.println("Not enough coins for adoption!");
            System.out.println("You need 50 coins but only have " + player.getCoins() + " coins.");
            System.out.println("Earn more coins by caring for your pets!");
            UIUtils.pause();
            return;
        }

        // Check if player has reached pet limit (optional - you can remove this if no limit)
        if (player.getOwnedPets().size() >= 10) {
            System.out.println("You have reached the maximum number of pets (10).");
            System.out.println("Please take good care of your current pets!");
            UIUtils.pause();
            return;
        }

        // Create the new pet
        Pets newPet = petManager.createPet(choice, "");
        
        if (newPet == null) {
            System.out.println("Failed to create pet. Please try again.");
            UIUtils.pause();
            return;
        }

        // Deduct coins and add pet
        player.setCoins(player.getCoins() - 50);
        player.addPet(newPet);
        
        // If this is the first pet, set it as active
        if (player.getOwnedPets().size() == 1) {
            player.setActivePet(newPet);
        }

        UIUtils.clearScreen();
        System.out.println(UIUtils.createTitleBox("ADOPTION SUCCESSFUL!"));
        System.out.println(UIUtils.getPetAsciiArt(newPet.getPetSpecies()));
        System.out.println("Congratulations! You adopted " + PetUtils.capitalizeFirstLetter(newPet.getPetName()) + "!");
        System.out.println("Species: " + newPet.getPetSpecies());
        System.out.println("Gender: " + newPet.getGender());
        System.out.println("Starting Level: " + newPet.getLevel());
        System.out.println("\nRemaining coins: " + player.getCoins());
        System.out.println("Total pets: " + player.getOwnedPets().size());
        
        // Show special message for first pet
        if (player.getOwnedPets().size() == 1) {
            System.out.println(PetUtils.capitalizeFirstLetter(newPet.getPetName()) + " is now your active pet!");
            System.out.println("Take good care of your new friend!");
        } else {
            System.out.println("\nYou can switch active pets from the main menu.");
        }
        
        UIUtils.pause();
    }
}