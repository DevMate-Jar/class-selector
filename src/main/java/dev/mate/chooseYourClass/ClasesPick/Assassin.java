package dev.mate.chooseYourClass.ClasesPick;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Assassin {


    public static void activate(Player player){

        ItemStack daggerItem = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta daggerMeta = daggerItem.getItemMeta();
        daggerMeta.setDisplayName(ChatColor.DARK_GRAY + "Dagger");
        daggerItem.setItemMeta(daggerMeta);
        player.getInventory().addItem(daggerItem);
        if(player.isSneaking()){
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, PotionEffect.INFINITE_DURATION, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 1));
        }


    }

}
