package dev.mate.chooseYourClass.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LightningStaffListener implements Listener {

    @EventHandler
    public void onUsingLightningStaff(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Location loc = player.getTargetBlock(null, 50).getLocation();


        if (item != null && item.getType() == Material.TRIDENT && item.hasItemMeta()) {
            String displayName = item.getItemMeta().getDisplayName();


            if(displayName != null && displayName.equals(ChatColor.BLUE + "Lightning Staff") && e.getAction() == Action.RIGHT_CLICK_AIR){

                player.getWorld().strikeLightning(loc);
                player.sendMessage(ChatColor.BLUE + "You used the lightning staff!");
                player.playSound(player, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
            }


        }


    }
}