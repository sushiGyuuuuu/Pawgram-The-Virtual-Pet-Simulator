package paw.managers;

import java.util.Scanner;
import paw.models.*;
import paw.services.*;
import paw.utils.*;

public class GameManager {
    private Player player;
    private PetManager petManager;
    private ShopManager shop;
    private Scanner input = new Scanner(System.in);

    public GameManager() {
        this.petManager = new PetManager();
        this.shop = new ShopManager();
    }


    public void start() {
        PetUtils.clearScreen();
        System.out.println("Welcome to Pawgram!");
        PetUtils.pause();
        PetUtils.clearScreen();
        PetUtils.pause();
        System.out.println("1) New Game \n2) Load Game");
        System.out.print("Select: ");
        int sel = input.nextInt();
        input.nextLine();
        if (sel == 2) {
            PetUtils.clearScreen();
            Player loaded = SaveSystem.load();
            PetUtils.pause();
            PetUtils.clearScreen();
            if (loaded != null) {
                this.player = loaded;
                System.out.println("Welcome back, " + PetUtils.capitalizeFirstLetter(player.getPlayerName()) + "!");
                PetUtils.pause();
            } else {
                PetUtils.pause();
                PetUtils.clearScreen();
                System.out.println("Proceeding to creating a new save file...");
                PetUtils.pause();
                PetUtils.clearScreen();
                newPlayerFlow();
            }
        } else {
            PetUtils.clearScreen();
            newPlayerFlow();
        }
        PetUtils.clearScreen();
        mainLoop();
    }

    private void newPlayerFlow() {
        System.out.print("Enter player name: ");
        String name = input.nextLine();
        player = new Player(name);        
        PetUtils.clearScreen();
        System.out.println("Welcome, " + PetUtils.capitalizeFirstLetter(name) + "!");
        PetUtils.pause();
        PetUtils.clearScreen();

        System.out.println("\nChoose starting pet:");
        System.out.println("1. Dog  \n2. Cat  \n3. Goldfish  \n4. Turtle  \n5. Lizard  \n6. Parrot");
        System.out.print("Select: ");

        int choice = input.nextInt();
        input.nextLine();
        PetUtils.clearScreen();

        Pets p = petManager.createPet(choice, name);

        if (p != null) {
            player.addPet(p);
            player.setActivePet(p);
            System.out.println("You got " + PetUtils.capitalizeFirstLetter(p.getPetName()) + " the " + p.getPetSpecies());
        }
    }

    private void mainLoop() {
        int choice;
        String response;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Feed Pet");
            System.out.println("2. Play");
            System.out.println("3. Sleep");
            System.out.println("4. View Stats");
            System.out.println("5. Switch Pet");
            System.out.println("6. Shop");
            System.out.println("7. Inventory");
            System.out.println("8. Save Game");
            System.out.println("9. Load Game");
            System.out.println("0. Exit");
            System.out.print("Select: ");
            choice = input.nextInt();
            input.nextLine();
            PetUtils.clearScreen();

            switch (choice) {
                case 1: 
                    player.getActivePet().eatFood();
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 2:
                    player.getActivePet().play();
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                     break;
                case 3:
                    player.getActivePet().sleep();
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                     break;
                case 4:
                    showStats();
                    System.out.print("\nPress Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 5:
                    petManager.switchPet(player);
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 6:
                    shop.openShop(player);
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 7:
                    openInventory();
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 8:
                    SaveSystem.save(player);
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 9:
                    Player loaded = SaveSystem.load();
                    if (loaded != null){
                        player = loaded;
                    }
                    PetUtils.pause();
                    PetUtils.clearScreen();
                    System.out.print("Press Enter to continue.");
                    response = input.nextLine();
                    if(response == " ") {
                        break;
                    }
                    PetUtils.clearScreen();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }while(choice != 0);
    }
    private void showStats() {
        Pets pet = player.getActivePet();
        System.out.println("-- " + PetUtils.capitalizeFirstLetter(pet.getPetName()) + " --");
        System.out.println("Species: " + pet.getPetSpecies());
        System.out.println("Mood: " + pet.getMoodLevel());
        System.out.println("Energy: " + pet.getEnergy());
        System.out.println("Level: " + pet.getLevel());
        System.out.println("Experience: " + pet.getExperience());
        System.out.println("Sick: " + pet.getIsSick());
    }

    private void openInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Inventory empty.");
            return;
        }
        System.out.println("Inventory:");
        for (int i = 0; i < player.getInventory().size(); i++) {
            System.out.println((i+1) + ". " + player.getInventory().get(i).getItemName());
        }
        System.out.println("0. Back");
        System.out.print("Select item to use: ");
        int sel = input.nextInt();
        input.nextLine();
        if (sel == 0) return;
        if (sel > 0 && sel <= player.getInventory().size()) {
            player.useItem(sel - 1, player.getActivePet());
        } else {
            System.out.println("Invalid selection.");
        }
    }
}

