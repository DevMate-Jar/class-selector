package dev.mate.chooseYourClass.ManagerClasses;

import dev.mate.chooseYourClass.ChooseYourClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ManaManager {

    private static final Map<UUID, BossBar> manaBars = new HashMap<>();
    private static final Map<UUID, Double> currentMana = new HashMap<>();


    private static final double MAX_MANA = 100.0;

    public static void showMana (Player player){
        BossBar bar = Bukkit.createBossBar(
                ChatColor.AQUA + "Mana",
                BarColor.BLUE,
                BarStyle.SEGMENTED_10

        );
        bar.setProgress(1.0);
        bar.addPlayer(player);

        manaBars.put(player.getUniqueId(), bar);
        currentMana.put(player.getUniqueId(), MAX_MANA);


        Bukkit.getScheduler().runTaskLater(ChooseYourClass.getInstance(), () ->{
            bar.removePlayer(player);
            manaBars.remove(player.getUniqueId());
            currentMana.remove(player.getUniqueId());

        }, 100L);
    }
        public static boolean useMana(Player player, double amount){
        UUID uuid = player.getUniqueId();

        if(!manaBars.containsKey(uuid)) showMana(player);
        double mana = currentMana.getOrDefault(uuid, MAX_MANA);

        if(mana < amount){
            player.sendMessage(ChatColor.RED + "You dont have enough mana.");
            return false;
        }
        mana -= amount;
        currentMana.put(uuid, mana);
        manaBars.get(uuid).setProgress(mana / MAX_MANA);
        return true;
        }

    public static void startManaRegenTask(){
        Bukkit.getScheduler().runTaskTimer(ChooseYourClass.getInstance(), () ->{
            for(Player p : Bukkit.getOnlinePlayers()) {
                restoreMana(p, 5);
            }
        }, 0L, 100L);
    }

        public static void restoreMana(Player player, double amount){
        UUID uuid = player.getUniqueId();
        double mana = currentMana.getOrDefault(uuid, MAX_MANA);
        mana = Math.min(MAX_MANA, mana + amount);
        currentMana.put(uuid, mana);

        if(manaBars.containsKey(uuid)){
            manaBars.get(uuid).setProgress(mana / MAX_MANA);
         }




    }

}
