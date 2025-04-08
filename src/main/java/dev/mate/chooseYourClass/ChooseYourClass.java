package dev.mate.chooseYourClass;

import dev.mate.chooseYourClass.Comandos.ClassChangerCommand;
import dev.mate.chooseYourClass.Comandos.ClassComando;
import dev.mate.chooseYourClass.Listener.*;

import dev.mate.chooseYourClass.ManagerClasses.ManaManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChooseYourClass extends JavaPlugin {

    private static ChooseYourClass instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

      getCommand("classmenu").setExecutor(new ClassComando(this));
      getCommand("changeclass").setExecutor(new ClassChangerCommand());
      getServer().getPluginManager().registerEvents(new ArrowListeners(), this);
      getServer().getPluginManager().registerEvents(new ListadorClass(this), this);
      getServer().getPluginManager().registerEvents(new MageStaffListener(), this);
      getServer().getPluginManager().registerEvents(new LightningStaffListener(), this);
      getServer().getPluginManager().registerEvents(new BruiserListener(), this);
      getServer().getPluginManager().registerEvents(new AssassinListener(), this);

      ManaManager.startManaRegenTask();

    }

    public static ChooseYourClass getInstance(){
        return instance;
    }

}
