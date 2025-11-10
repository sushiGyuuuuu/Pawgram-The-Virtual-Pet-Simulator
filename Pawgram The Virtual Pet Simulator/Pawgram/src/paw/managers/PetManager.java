package paw.managers;

import paw.models.*;
import java.util.Scanner;

public class PetManager {
    public void namePet(Pets pet) {
    Scanner input = new Scanner(System.in);

    System.out.println("Do you want to name your pet (Yes/No)?");
    System.out.print("Answer: ");
    String answer = input.nextLine();

    if(answer.equalsIgnoreCase("Yes")) {
        System.out.print("Name your pet: ");
        String petName = input.nextLine();
        pet.setPetName(petName);
        System.out.println("Your " + pet.getPetSpecies() + " is now named " + petName + "!");
    }else{
        System.out.println("Your pet will not be named.");
    }
    input.close();
    }
}
