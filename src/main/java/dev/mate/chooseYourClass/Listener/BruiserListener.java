package dev.mate.chooseYourClass.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BruiserListener implements Listener {


    // To be continued...
    @EventHandler
    public void onShieldBruiser(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
    }


}
