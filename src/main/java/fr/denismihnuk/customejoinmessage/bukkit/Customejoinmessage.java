package fr.denismihnuk.customejoinmessage.bukkit;

import fr.denismihnuk.customejoinmessage.bukkit.commands.BukkitCommands;
import fr.denismihnuk.customejoinmessage.bukkit.listeners.BukkitJoinListener;
import fr.denismihnuk.customejoinmessage.bukkit.listeners.BukkitQuitListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Customejoinmessage extends JavaPlugin {

    @Override

    public void onEnable() {
        this.print("&a>--------------------------------<");
        this.print("&bCustomeJoinMessage is Enable");
        this.print("&a>--------------------------------<");
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new BukkitQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new BukkitJoinListener(this), this);
        getCommand("customejoinmessage").setExecutor(new BukkitCommands(this));
        getCommand("setquitmessage").setExecutor(new BukkitCommands(this));
        getCommand("setjoinmessage").setExecutor(new BukkitCommands(this));
        getCommand("customejoinmessagereload").setExecutor(new BukkitCommands(this));

    }
    public void print(String string) {
        this.getServer().getLogger().info(ChatColor.translateAlternateColorCodes('&', string));
    }


    @Override
    public void onDisable() {
        this.print("&a>--------------------------------<");
        this.print("&bCustomeJoinMessage is Disable");
        this.print("&a>--------------------------------<");
        }
}






