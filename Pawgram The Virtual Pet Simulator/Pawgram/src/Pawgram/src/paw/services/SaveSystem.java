package paw.services;

import paw.models.Player;
import java.io.*;

public class SaveSystem {
    private static final String SAVE_FILE = "pawgram_save.dat";

    public static void save(Player player) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(player);
            System.out.println("Game saved to " + SAVE_FILE);
        } catch (Exception e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    public static Player load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Player p = (Player) in.readObject();
            System.out.println("Game loaded from " + SAVE_FILE);
            return p;
        } catch (Exception e) {
            System.out.println("Load failed: " + e.getMessage());
            return null;
        }
    }
}
