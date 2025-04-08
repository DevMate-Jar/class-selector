package dev.mate.chooseYourClass.Listener;

import dev.mate.chooseYourClass.ManagerClasses.ManaManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AssassinListener implements Listener {

    @EventHandler
    public void onInvisibility(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() != Material.NETHERITE_SWORD || !item.hasItemMeta()) return;

        ItemMeta meta = item.getItemMeta();
        if(!meta.hasDisplayName() || !meta.getDisplayName().equals(ChatColor.DARK_GRAY + "Dagger")) return;



        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200 * 5, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200 * 5, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200 * 2, 1));

        player.getWorld().spawnParticle(Particle.SOUL, player.getLocation(), 150 , 0.5, 1, 0.5);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 1.0f, 1.0f);
        player.getWorld().playSound(player, Sound.AMBIENT_CAVE, 1.0f, 1.0f);
        player.sendMessage(ChatColor.DARK_GRAY + "You vanished into the shadows...");

        if(ManaManager.useMana(player, 25)){

        }else{
            player.sendMessage(ChatColor.RED + "You dont have enough mana.");
        }


    }


}
