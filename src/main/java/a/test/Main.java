package a.test;

import a.test.listener.JoinListener;
import a.test.listener.QuitListener;
import a.test.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public final class Main extends JavaPlugin {

    private  static  Main instance;

    private Timer timer;

    @Override
    public void onLoad() {
        instance = this;
    }

    private Listener plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "HELLO WORLD");
        System.out.println("");
        System.out.println("");
        System.out.println("");


        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents( new JoinListener(), this);
        manager.registerEvents( new QuitListener(), this);

        timer = new Timer(false, 0);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }
}
