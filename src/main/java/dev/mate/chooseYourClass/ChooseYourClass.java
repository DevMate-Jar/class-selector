package dev.mate.chooseYourClass;

import dev.mate.chooseYourClass.Comandos.ClassComando;
import dev.mate.chooseYourClass.Listener.ArrowListeners;

import dev.mate.chooseYourClass.Listener.LightningStaffListener;
import dev.mate.chooseYourClass.Listener.ListadorClass;
import dev.mate.chooseYourClass.Listener.MageStaffListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChooseYourClass extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

      getCommand("classmenu").setExecutor(new ClassComando(this));
      getServer().getPluginManager().registerEvents(new ArrowListeners(), this);
      getServer().getPluginManager().registerEvents(new ListadorClass(this), this);
      getServer().getPluginManager().registerEvents(new MageStaffListener(), this);
      getServer().getPluginManager().registerEvents(new LightningStaffListener(), this);

    }

}
