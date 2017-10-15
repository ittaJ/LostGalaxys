package com.jatti;

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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Gui {

    private static int getFreeSpace(Inventory inv) {

        for (int i = 0; i < inv.getSize(); i++) {

            while (inv.getItem(i) == null) {
                return i;
            }
        }
        return 0;

    }

    public static void openComputerGui(User user) {

        Inventory inv = Bukkit.createInventory(null, 9, Computer.get(user).getName());

        ItemStack disable = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta mdisable = disable.getItemMeta();
        mdisable.setDisplayName(ChatColor.DARK_RED + "Wylacz");
        mdisable.setLore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by wylaczyc komputer"));
        disable.setItemMeta(mdisable);

        ItemStack rename = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta mrename = rename.getItemMeta();
        mrename.setDisplayName(ChatColor.DARK_GREEN + "Zmien nazwe");
        mrename.setLore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by zmienic nazwe komputera"));
        rename.setItemMeta(mrename);

        ItemStack cameras = new ItemStack(Material.BOOK, 1);
        ItemMeta mcameras = cameras.getItemMeta();
        mcameras.setDisplayName(ChatColor.DARK_GREEN + "Kamery");
        mcameras.setLore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by zobaczyc podglad kamer"));
        cameras.setItemMeta(mcameras);

        ItemStack energy = new ItemStack(Material.REDSTONE, 1);
        ItemMeta menergy = energy.getItemMeta();
        menergy.setDisplayName(ChatColor.DARK_GREEN + "Dodaj energie");
        menergy.setLore(Arrays.asList(ChatColor.GRAY + "Kliknij tu, by dodac energie do komputera"));
        energy.setItemMeta(menergy);


        inv.setItem(0, rename);
        inv.setItem(1, cameras);
        inv.setItem(2, energy);
        inv.setItem(8, disable);

        user.getPlayer().openInventory(inv);


    }

    public static void openCamerasGui(User user) {

        Computer c = Computer.get(user);

        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Kamery");

        for (Camera cam : c.getCameras()) {

            ItemStack is = new ItemStack(Material.BUCKET, 1);
            ItemMeta m = is.getItemMeta();
            m.setDisplayName(ChatColor.AQUA + "" + cam.getValue());
            is.setItemMeta(m);

            inv.setItem(getFreeSpace(inv), is);

        }

        user.getPlayer().openInventory(inv);


    }

    public static void openEnergyGui(User user, Location location) {

        Battery b = Battery.Companion.get(user, location);

        Bukkit.createInventory(null, 0, ChatColor.DARK_GREEN + "Energia w tej baterii to: " + ChatColor.GOLD + b.getEnergy());
    }

    public static void openAddEnergyGui(User user) {

    }

    public static void openAchievementGui(User user) {

        //TODO

    }

}
