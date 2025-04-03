package dev.mate.chooseYourClass.Comandos;

import dev.mate.chooseYourClass.ChooseYourClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class ClassComando implements CommandExecutor {


    private ChooseYourClass plugin;

    public ClassComando(ChooseYourClass plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p){
            openClassMenu(p);
        }
        return true;
    }

    private void openClassMenu(Player player){
        Inventory menu = plugin.getServer().createInventory(null, 9, ChatColor.BLUE +  "Choose your class!");


        ItemStack assassinItem = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta assassinMeta = assassinItem.getItemMeta();
        assassinMeta.setDisplayName(ChatColor.DARK_GRAY + "Assassin");
        assassinItem.setItemMeta(assassinMeta);
        menu.setItem(0, assassinItem);


        ItemStack mageItem = new ItemStack(Material.FIRE_CHARGE, 1);
        ItemMeta mageMeta = mageItem.getItemMeta();
        mageMeta.setDisplayName(ChatColor.BLUE + "Mage");
        mageItem.setItemMeta(mageMeta);
        menu.setItem(1, mageItem);


        ItemStack bruiserItem = new ItemStack(Material.SHIELD, 1);
        ItemMeta bruiserMeta = bruiserItem.getItemMeta();
        bruiserMeta.setDisplayName(ChatColor.RED + "Bruiser");
        bruiserItem.setItemMeta(bruiserMeta);
        menu.setItem(2, bruiserItem);


        ItemStack archerItem = new ItemStack(Material.BOW, 1);
        ItemMeta archerMeta = archerItem.getItemMeta();
        archerMeta.setDisplayName(ChatColor.GREEN + "Archer");
        archerItem.setItemMeta(archerMeta);
        menu.setItem(3, archerItem);


        player.openInventory(menu);
    }
}
