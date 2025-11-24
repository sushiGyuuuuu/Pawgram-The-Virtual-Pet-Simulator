package paw.managers;

import paw.models.*;
import paw.utils.PetUtils;
import java.util.Scanner;

public class PetManager {
    private Scanner input = new Scanner(System.in);

    public Pets namePet(int choice) {
    System.out.print("Name your pet: ");
        String name = input.nextLine();
        PetUtils.capitalizeFirstLetter(name);


        return switch (choice) {
            case 1 -> new Dog(PetUtils.capitalizeFirstLetter(name),"Collar", false); 
            case 2 -> new Cat(PetUtils.capitalizeFirstLetter(name),"Bell", false);
            case 3 -> new Goldfish(PetUtils.capitalizeFirstLetter(name), "Decor", false); 
            case 4 -> new Turtle(PetUtils.capitalizeFirstLetter(name), "Shell Polish", false); 
            case 5 ->new Lizard(PetUtils.capitalizeFirstLetter(name), "Rock", false); 
            case 6 -> new Parrot(PetUtils.capitalizeFirstLetter(name), "Bell", false); 
            default -> null;
        };
    }

    public void switchPet(paw.models.Player player) {
        if (player.getOwnedPets().size() <= 1) {
            System.out.println("You only have one pet.");
            return;
        }
        System.out.println("\n=== Choose Pet ===");
        for (int i = 0; i < player.getOwnedPets().size(); i++) {
            System.out.println((i + 1) + ". " + player.getOwnedPets().get(i).getPetName());
        }
        System.out.print("Select: ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice > 0 && choice <= player.getOwnedPets().size()) {
            player.setActivePet(player.getOwnedPets().get(choice - 1));
            System.out.println("Switched active pet to " + player.getActivePet().getPetName());
        }
    }
}
