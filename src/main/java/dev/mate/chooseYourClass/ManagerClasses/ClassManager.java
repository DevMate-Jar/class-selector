package dev.mate.chooseYourClass.ManagerClasses;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClassManager {

    private static final Map<UUID, String> playerClasses = new HashMap<>();

    public static boolean hasClass(Player player){
        return playerClasses.containsKey(player.getUniqueId());
    }

    public static String getClass(Player player){
        return playerClasses.get(player.getUniqueId());
    }

    public static void setClass(Player player, String className){
    playerClasses.put(player.getUniqueId(), className);
    }

    public static void clearClass(Player player){
        playerClasses.remove(player.getUniqueId());
    }


}