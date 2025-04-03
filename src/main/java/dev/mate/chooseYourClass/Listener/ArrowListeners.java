package dev.mate.chooseYourClass.Listener;

import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowListeners implements Listener {

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof Arrow)) return;

        Arrow arrow = (Arrow) event.getEntity();

        if (!(arrow.getShooter() instanceof Player)) return;

        Player shooter = (Player) arrow.getShooter();

        String arrowType = arrow.getCustomName();
        if (arrowType == null) return;

        Location loc = arrow.getLocation();

        if (arrowType.equals(ChatColor.RED + "Explosion Arrow")) {
            shooter.getWorld().createExplosion(loc, 3.0F, false, false);
            shooter.sendMessage(ChatColor.RED + "¡Tu flecha explosiva explotó!");

        }

        if (arrowType.equals(ChatColor.AQUA + "Teleport Arrow")) {
            shooter.teleport(loc);
            shooter.getWorld().spawnParticle(Particle.PORTAL, loc, 50);
            shooter.getWorld().playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            shooter.sendMessage(ChatColor.BLUE + "¡Te has teletransportado con la flecha!");
        }
        arrow.remove();
    }
}





