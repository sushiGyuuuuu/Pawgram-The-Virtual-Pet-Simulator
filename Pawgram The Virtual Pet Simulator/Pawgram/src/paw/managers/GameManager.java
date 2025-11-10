package paw.managers;

import java.util.Scanner;
import paw.models.*;
import paw.utils.*;

public class GameManager {
    private Player player;
    private Scanner input = new Scanner(System.in);

    public void start() {
        while(true) {
            System.out.println("Enter the name of your character.");
            System.out.print("Name: ");
            String playerName = input.nextLine();
            System.out.print("Confirm (Yes/No): ");
            String choice = input.nextLine();
            String capitalizedChoice = PetUtils.capitalizeFirstLetter(choice);

            if(capitalizedChoice.equalsIgnoreCase("Yes")) {
                player.setPlayerName(playerName);
                break;
            }
        }

        System.out.println("\nWelcome " + player.getPlayerName() + "!");
    }

    public void gameDisplay() {
        
    }
}
