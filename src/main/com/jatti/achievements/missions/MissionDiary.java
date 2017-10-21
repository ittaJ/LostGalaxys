package com.jatti.achievements.missions;


import com.jatti.user.User;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class with missions diary for players
 * @author Jatti
 * @version 1.1
 */
public class MissionDiary {

    private static List<Mission> getAllMissions(){

        List<Mission> missions = new ArrayList<Mission>();
        missions.add(new TestMission());
        missions.add(new ViewTutorialMission());

        return missions;
    }

    /**
     * Adds book with all user's mission to user's inventory
     * @param user user which will have missions diary
     */
    public static void showMissions(User user){

        Player p = user.getPlayer();
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta bm = (BookMeta) book.getItemMeta();
        bm.setDisplayName(ChatColor.GRAY + "Dziennik Misji");
        bm.setLore(Arrays.asList(ChatColor.AQUA + "Dziennik z twoimi misjami", ChatColor.AQUA + "Kliknij by otworzyc"));

        //TODO Make it better
        for(int i=0; i<user.getMissions().size(); i++){

            for(int ii=0; ii<getAllMissions().size(); i++){

                if(user.getMissions().get(i) == getAllMissions().get(ii).getId()){

                    Mission m = getAllMissions().get(ii);
                    //Misja nr. ID
                    //<Nazwa Misji>
                    //Opis misji

                    bm.addPage(ChatColor.DARK_GREEN + "Misja nr. " + ChatColor.GOLD + m.getId() + "\n"
                    + ChatColor.GREEN + ",," + m.getName() + ",," + "\n"
                    + ChatColor.GRAY + m.getLore());

                }

            }

        }

        book.setItemMeta(bm);

        p.getInventory().addItem(book);

    }

}
