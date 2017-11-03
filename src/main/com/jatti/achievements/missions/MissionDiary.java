package com.jatti.achievements.missions;

import com.jatti.ItemBuilder;
import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class with missions diary for players
 * 
 * @author Jatti
 * @version 1.1
 */
public class MissionDiary {


    private static final ItemStack missionBook;

    static {
        missionBook = ItemBuilder.fromScratch().type(Material.WRITTEN_BOOK).name(ChatColor.GRAY + "Dziennik Misji")
                        .lore(Arrays.asList(ChatColor.AQUA + "Dziennik z twoimi misjami", ChatColor.AQUA + "Kliknij by otworzyc"))
                        .build();
    }


    /**
     * Adds book with all user's mission to user's inventory
     * 
     * @param user
     *            user which will have missions diary
     */
    public static void showMissions(User user) {
        Player p = user.getPlayer();
        BookMeta bm = (BookMeta) missionBook.getItemMeta();
        bm.setPages(Collections.<String>emptyList());

        for (Mission m : MissionsList.getAllMissions()) {
            if (user.getMissions().contains(m.getId())) {
                bm.addPage(ChatColor.DARK_GREEN + "Misja nr " + ChatColor.GOLD + m.getId() + "\n" + ChatColor.GREEN + ",,"
                                + m.getName() + ",," + "\n" + ChatColor.GRAY + m.getLore());
            }
        }

        missionBook.setItemMeta(bm);
        p.getInventory().addItem(missionBook);
    }
}