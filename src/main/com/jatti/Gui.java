package com.jatti;

import com.jatti.achievements.Achievement;
import com.jatti.battery.Battery;
import com.jatti.camera.Camera;
import com.jatti.computer.Computer;
import com.jatti.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * Class for making guis
 *
 * @author Jatti
 * @version 1.1
 */
public class Gui {

    private static final ItemStack nameItem;
    private static final ItemStack cameraItem;
    private static final ItemStack energyItem;
    private static final ItemStack offItem;

    static {
        nameItem = ItemBuilder.fromScratch().type(Material.NAME_TAG).name(ChatColor.DARK_GREEN + "Zmien nazwe")
                .lore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by zmienic nazwe komputera")).build();

        cameraItem = ItemBuilder.fromScratch().type(Material.BOOK).name(ChatColor.DARK_GREEN + "Kamery")
                .lore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by zobaczyc podglad kamer")).build();

        energyItem = ItemBuilder.fromScratch().type(Material.REDSTONE).name(ChatColor.DARK_GREEN + "Dodaj energie")
                .lore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by dodac energie do komputera")).build();

        offItem = ItemBuilder.fromScratch().type(Material.REDSTONE_BLOCK).name(ChatColor.DARK_RED + "Wylacz")
                .lore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by wylaczyc komputer")).build();

    }

    /**
     * Opens Computer's gui
     *
     * @param user user which will have this gui opened
     */
    public static void openComputerGui(User user) {
        Inventory computerGUI = Bukkit.createInventory(null, 9, Computer.get(user).getName());
        computerGUI.setItem(0, nameItem);
        computerGUI.setItem(1, cameraItem);
        computerGUI.setItem(2, energyItem);
        computerGUI.setItem(8, offItem);

        user.getPlayer().openInventory(computerGUI);
    }

    /**
     * Open guis with cameras
     *
     * @param user user which will have this gui opened
     */
    public static void openCamerasGui(User user) {
        List<Camera> cameras = Computer.get(user).getCameras();
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Kamery");

        for (int i = 0; i < 9 && i < cameras.size(); i++) {
            Camera c = cameras.get(i);
            inv.setItem(i, ItemBuilder.fromScratch().type(Material.BUCKET).name(ChatColor.AQUA + "" + c.getValue()).build());

        }

        user.getPlayer().openInventory(inv);
    }

    /**
     * Opens gui for battery
     *
     * @param user     user which will have this gui opened
     * @param location battery's location
     */
    @Deprecated
    public static void openEnergyGui(User user, Location location) {
        Battery b = Battery.Companion.get(user, location);
        Bukkit.createInventory(null, 0, ChatColor.DARK_GREEN + "Energia w tej baterii to: " + ChatColor.GOLD + b.getEnergy());
    }

    /**
     * Opens gui with achievements
     *
     * @param user user which will have this gui opened
     */
    public static void openAchievementGui(User user) {
        List<Achievement> achievements = user.getAchievements();
        Inventory inv = Bukkit.createInventory(null, achievements.size() / 9 * 9 + 9, ChatColor.DARK_GREEN + "Osiagniecia");

        for (Achievement a : achievements) {
            switch (a.getDifficulty()) {
                case EASY:
                    inv.setItem(inv.firstEmpty(), ItemBuilder.fromScratch().type(Material.STAINED_GLASS_PANE).durability((short) 5)
                            .name(ChatColor.GREEN + a.getName()).build());
                    break;

                case MEDIUM:
                    inv.setItem(inv.firstEmpty(), ItemBuilder.fromScratch().type(Material.STAINED_GLASS_PANE).durability((short) 4)
                            .name(ChatColor.YELLOW + a.getName()).build());
                    break;

                case HARD:
                    inv.setItem(inv.firstEmpty(), ItemBuilder.fromScratch().type(Material.STAINED_GLASS_PANE).durability((short) 14)
                            .name(ChatColor.RED + a.getName()).build());
                    break;
            }
        }

        user.getPlayer().closeInventory();
        user.getPlayer().openInventory(inv);
    }
}