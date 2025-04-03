package dev.mate.chooseYourClass.ClasesPick;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mage {


    public static void activate(Player player){

        ItemStack fireStaff = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta fireMeta = fireStaff.getItemMeta();
        fireMeta.setDisplayName(ChatColor.RED + "Fire Staff");
        fireStaff.setItemMeta(fireMeta);
        player.getInventory().addItem(fireStaff);


        ItemStack lightningStaff = new ItemStack(Material.TRIDENT, 1);
        ItemMeta lightMeta = lightningStaff.getItemMeta();
        lightMeta.setDisplayName(ChatColor.BLUE + "Lightning Staff");
        lightningStaff.setItemMeta(lightMeta);
        player.getInventory().addItem(lightningStaff);

        }


    }


