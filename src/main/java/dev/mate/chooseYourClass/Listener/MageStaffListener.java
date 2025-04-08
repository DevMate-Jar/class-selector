package dev.mate.chooseYourClass.Listener;

import dev.mate.chooseYourClass.ManagerClasses.ManaManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MageStaffListener implements Listener {

    @EventHandler
    public void onStaffUse(PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack item = e.getItem();


        if(item != null && item.getType() == Material.BLAZE_ROD && item.hasItemMeta()){
            String displayName = item.getItemMeta().getDisplayName();

            if(displayName.equals(ChatColor.RED + "Fire Staff") && e.getAction() == Action.RIGHT_CLICK_AIR){
                player.launchProjectile(Fireball.class);
                player.sendMessage(ChatColor.RED + "You used the fire staff!");
                player.playSound(player, Sound.ENTITY_BLAZE_SHOOT, 1.0f, 1.0f);
            }
            if(ManaManager.useMana(player, 25)){

            }else{
                player.sendMessage(ChatColor.RED + "You dont have enough mana.");
            }

        }




    }




}
