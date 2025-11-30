package paw.utils;

import java.util.Scanner;

public class UIUtils {
    
    // Box drawing characters
    public static final String BOX_TOP_LEFT = "╔";
    public static final String BOX_TOP_RIGHT = "╗";
    public static final String BOX_BOTTOM_LEFT = "╚";
    public static final String BOX_BOTTOM_RIGHT = "╝";
    public static final String BOX_HORIZONTAL = "═";
    public static final String BOX_VERTICAL = "║";
    public static final String BOX_CROSS = "╬";
    public static final String BOX_T_LEFT = "╠";
    public static final String BOX_T_RIGHT = "╣";
    public static final String BOX_T_TOP = "╦";
    public static final String BOX_T_BOTTOM = "╩";

    // Method to create a boxed title
    public static String createTitleBox(String title) {
        String border = BOX_TOP_LEFT + BOX_HORIZONTAL.repeat(title.length() + 4) + BOX_TOP_RIGHT;
        String middle = BOX_VERTICAL + "  " + title + "  " + BOX_VERTICAL;
        String bottom = BOX_BOTTOM_LEFT + BOX_HORIZONTAL.repeat(title.length() + 4) + BOX_BOTTOM_RIGHT;
        return border + "\n" + middle + "\n" + bottom + "\n";
    }

    // Method to create a separator line
    public static String createSeparator(int length) {
        return "─".repeat(length);
    }

    // Method to create a progress bar
    public static String createProgressBar(int current, int max, int length) {
        float percentage = (float) current / max;
        int filled = (int) (length * percentage);
        int empty = length - filled;
        
        String bar = "[" + "█".repeat(filled) + "░".repeat(empty) + "]";
        String numbers = " " + current + "/" + max;

        return bar + numbers;
    }

    // Method to center text
    public static String centerText(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(padding);
    }

    // Method to create a menu option
    public static String menuOption(int number, String text) {
        return String.format("%2d. %s", number, text);
    }


    // Method to create ASCII art for different pets
    public static String getPetAsciiArt(String species) {
        switch (species.toLowerCase()) {
            case "dog":
                return 
                    "  __      \n" +
                    "o'')}____//\n" +
                    " `_/      )\n" +
                    " (_(_/-(_/ \n";
            case "cat":
                return
                    " /\\_/\\   \n" +
                    "( o.o )  \n" +
                    " > ^ <   \n";
            case "goldfish":
                return
                    "      .--.   \n" +
                    "     |o_o |  \n" +
                    "     |:_/ |  \n" +
                    "    //   \\ \\ \n" +
                    "   (|     | )\n" +
                    "  /'\\_   _/`\\\n" +
                    "  \\___)=(___/\n";
            case "parrot":
                return
                    "   \\\\\n" +
                    "   (o>\n" +
                    "\\\\_//)\n" +
                    " \\_/_) \n" +
                    "  _|_   \n";
            case "turtle":
                return
                    "   __     \n" +
                    "  /  \\   \n" +
                    " | () |   \n" +
                    "  \\__/   \n";
            case "lizard":
                return
                    "        _/ \n" +
                    "       /   \n" +
                    "  .-._)   \n" +
                    "  \\  -_   \n" +
                    "   \\\\   \\ \n" +
                    "    \\\\   \\\n" +
                    "     \\\\   \\\n";
            default:
                return
                    "  /\\_/\\  \n" +
                    " ( o.o ) \n" +
                    "  > ^ <  \n";
        }
    }

    // Method to create a loading animation
    public static void showLoading(String message) {
        System.out.print(message);
        String[] dots = {"   ", ".  ", ".. ", "..."};
        for (int i = 0; i < 4; i++) {
            System.out.print("\r" + message + dots[i]);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // Method to clear screen (platform independent)
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    // Method to pause execution
    public static void pause() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignore exceptions
        }
    }

    // UNIVERSAL SAFE INTEGER INPUT
    public static int getValidatedInt(Scanner input, int min, int max) {
        while (true) {
            try {
                String raw = input.nextLine().trim();

            // Ensure it's an integer
                int value = Integer.parseInt(raw);

            // Ensure it is within valid ranges
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    System.out.print("Try again: ");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                System.out.print("Try again: ");
            }
        }
    }
}