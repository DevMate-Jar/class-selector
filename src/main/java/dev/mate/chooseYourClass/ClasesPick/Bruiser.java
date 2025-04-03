package dev.mate.chooseYourClass.ClasesPick;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Bruiser {



    public static void activate(Player player){

        ItemStack shieldBr = new ItemStack(Material.SHIELD);
        ItemMeta shieldMeta = shieldBr.getItemMeta();
        shieldMeta.setDisplayName(ChatColor.RED + "Shield");
        shieldBr.setItemMeta(shieldMeta);



        player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, PotionEffect.INFINITE_DURATION, 1));
        if (player.hasPotionEffect(PotionEffectType.RESISTANCE)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, PotionEffect.INFINITE_DURATION, 1));
            player.getInventory().addItem(shieldBr);

        }
    }
}
