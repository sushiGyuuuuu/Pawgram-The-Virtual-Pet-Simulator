package paw.utils;

public class PetUtils {
    
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void clearScreen() {
        UIUtils.clearScreen();
    }

    public static void pause() {
        UIUtils.pause();
    }

    // New method to display pet status in a formatted way
    public static String formatPetStatus(String name, String species, int mood, int energy, int level, boolean isSick, String gender, boolean isPregnant) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(UIUtils.createTitleBox(name + " the " + species));
        sb.append(UIUtils.getPetAsciiArt(species)).append("\n");
        
        sb.append("Status:\n");
        sb.append("  ").append(" Gender: ").append(gender);
        if (isPregnant) {
            sb.append(" ").append((true));
        }
        sb.append("\n");
        
        sb.append("  ").append(" Mood: ").append(UIUtils.createProgressBar(mood, 100, 10)).append("\n");
        sb.append("  ").append(" Energy: ").append(UIUtils.createProgressBar(energy, 100, 10)).append("\n");
        sb.append("  ").append( " Level: ").append(level).append("\n");
        sb.append("  ").append(" Health: ").append(isSick ? "Sick" : "Healthy").append("\n");
        
        return sb.toString();
    }
}