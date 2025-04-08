package dev.mate.chooseYourClass.Listener;

import dev.mate.chooseYourClass.ClasesPick.Archer;
import dev.mate.chooseYourClass.ClasesPick.Assassin;
import dev.mate.chooseYourClass.ChooseYourClass;
import dev.mate.chooseYourClass.ClasesPick.Bruiser;
import dev.mate.chooseYourClass.ClasesPick.Mage;
import dev.mate.chooseYourClass.ManagerClasses.ClassManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ListadorClass implements Listener {

    private final ChooseYourClass plugin;

    public ListadorClass(ChooseYourClass plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSelectClass(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.BLUE + "Choose your class!")) {
            e.setCancelled(true);

            HumanEntity whoClicked = e.getWhoClicked();
            if (!(whoClicked instanceof Player)) return;
            Player player = (Player) whoClicked;

            ItemStack item = e.getCurrentItem();

            if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                String displayName = item.getItemMeta().getDisplayName();

                if(ClassManager.hasClass(player)){
                    player.sendMessage(ChatColor.RED + "You have already selected a class!");
                    player.playSound(player, Sound.ENTITY_WANDERING_TRADER_NO, 1.0f, 1.0f);
                    player.closeInventory();
                    e.setCancelled(true);
                    return;
                }
                e.setCancelled(true);
                player.closeInventory();

                if(displayName.equals(ChatColor.RED + "Bruiser")){
                    player.setMaxHealth(player.getMaxHealth() * 2);
                }else{
                    player.setMaxHealth(20.0);
                }
                if (displayName.equals(ChatColor.DARK_GRAY + "Assassin")) {
                    ClassManager.setClass(player, "Assassin");
                    Assassin.activate(player);
                    player.sendMessage(ChatColor.DARK_GRAY + "You picked: Assassin!");
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

                } else if (displayName.equals(ChatColor.BLUE + "Mage")) {
                    ClassManager.setClass(player, "Mage");
                    Mage.activate(player);
                    player.sendMessage(ChatColor.BLUE + "You picked: Mage!");
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

                } else if (displayName.equals(ChatColor.RED + "Bruiser")) {
                    ClassManager.setClass(player, "Bruiser");
                    Bruiser.activate(player);
                    player.sendMessage(ChatColor.RED + "You picked: Bruiser!");
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

                } else if (displayName.equals(ChatColor.GREEN + "Archer")) {
                    ClassManager.setClass(player, "Archer");
                    Archer.activate(player);
                    player.sendMessage(ChatColor.GREEN + "You picked: Archer!");
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                }
            }
        }
    }
}