package dev.mate.chooseYourClass.ClasesPick;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Archer {



    public static void activate(Player player){

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GREEN + "Infinity Bow");
        bow.setItemMeta(bowMeta);
        player.getInventory().addItem(bow);

        ItemStack explosionArrow = new ItemStack(Material.ARROW);
        ItemMeta explosionMeta = explosionArrow.getItemMeta();
        explosionMeta.setDisplayName(ChatColor.RED + "Explosion Arrow");
        explosionArrow.setItemMeta(explosionMeta);
        player.getInventory().addItem(explosionArrow);

        ItemStack teleportArrow = new ItemStack(Material.ARROW);
        ItemMeta teleportMeta = teleportArrow.getItemMeta();
        teleportMeta.setDisplayName(ChatColor.AQUA + "Teleport Arrow");
        teleportArrow.setItemMeta(teleportMeta);
        player.getInventory().addItem(teleportArrow);


    }

}
