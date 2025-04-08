package dev.mate.chooseYourClass.Listener;

import dev.mate.chooseYourClass.ManagerClasses.ManaManager;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class BruiserListener implements Listener {

    @EventHandler
    public void onShieldBruiser(EntityDamageByEntityEvent event){
        if(!((event.getEntity()) instanceof Player)) return;

        Player player = (Player)  event.getEntity();


        if (!player.isBlocking()) return;

        if(!(event.getDamager() instanceof LivingEntity)) return;

        LivingEntity attacker = (LivingEntity) event.getDamager();

        @NotNull Vector knockBackDirection = attacker.getLocation().toVector().subtract(player.getLocation().toVector()).normalize();

        knockBackDirection.multiply(1.5);
        attacker.setVelocity(knockBackDirection);



        attacker.getWorld().spawnParticle(Particle.CRIMSON_SPORE, attacker.getLocation(), 100);
        attacker.getWorld().playSound(attacker.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0f,1.0f);

        player.sendMessage(ChatColor.RED + "You blocked the attack!");

        if(ManaManager.useMana(player, 25)){

        }else{
            player.sendMessage(ChatColor.RED + "You dont have enough mana.");
        }





    }


}
