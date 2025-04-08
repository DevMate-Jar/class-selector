package dev.mate.chooseYourClass.Comandos;

import com.mojang.brigadier.CommandDispatcher;
import dev.mate.chooseYourClass.ManagerClasses.ClassManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ClassChangerCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player p){

            if(!ClassManager.hasClass(p)){
                p.sendMessage(ChatColor.YELLOW + "You dont have a class to change!");
                p.playSound(p, Sound.ENTITY_VILLAGER_NO, 1.0f,1.0f);
                return true;
            }
            if(!p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 64)){
                p.sendMessage(ChatColor.DARK_PURPLE + "You need at least" + ChatColor.AQUA + " 64 diamonds" + ChatColor.DARK_PURPLE + " to change your class.");
                p.playSound(p, Sound.BLOCK_AMETHYST_BLOCK_RESONATE, 1.0f,1.0f);
                p.playSound(p, Sound.BLOCK_AMETHYST_BLOCK_CHIME,1.0f,1.0f);
                p.playSound(p, Sound.BLOCK_AMETHYST_BLOCK_PLACE,1.0f,1.0f);
                return true;
            }
            p.getInventory().removeItem(new ItemStack(Material.DIAMOND, 64));
            ClassManager.clearClass(p);

            p.sendMessage(ChatColor.LIGHT_PURPLE + "You can now change your class! Enjoy your new one!");
            p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP,1.0f,1.0f);
            return true;
        }

        return true;
    }
}
