package fr.denismihnuk.customejoinmessage.bungee;

import fr.denismihnuk.customejoinmessage.bungee.commands.BungeeDefaultCommand;
import fr.denismihnuk.customejoinmessage.bungee.commands.BungeeJoinCommand;
import fr.denismihnuk.customejoinmessage.bungee.commands.BungeeQuitCommand;
import fr.denismihnuk.customejoinmessage.bungee.listeners.BungeeJoinListener;
import fr.denismihnuk.customejoinmessage.bungee.listeners.BungeeQuitListener;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


public class BungeeCustomeJoinMessage extends Plugin {


 private Configuration config;

    @Override
    public void onEnable() {
        this.print("&a>--------------------------------<");
        this.print("&bCustomeJoinMessage is Enable");
        this.print("&a>--------------------------------<");
       config = this.loadConfig(this);


        getProxy().getPluginManager().registerListener(this, new BungeeQuitListener(this));
        getProxy().getPluginManager().registerListener(this, new BungeeJoinListener(this));
        getProxy().getPluginManager().registerCommand(this, new BungeeDefaultCommand());
        getProxy().getPluginManager().registerCommand(this, new BungeeJoinCommand(this));
        getProxy().getPluginManager().registerCommand(this, new BungeeQuitCommand(this));
    }

    private void print(String string) {
        this.getProxy().getLogger().info(ChatColor.translateAlternateColorCodes('&', string));
    }

    public static Configuration loadConfig(Plugin plugin) {

        try {

            File configFile = new File(plugin.getDataFolder(), "config.yml");



            if (!configFile.exists()) {

                plugin.getDataFolder().mkdir();



                try (InputStream is = plugin.getResourceAsStream("config.yml")) {

                    Files.copy(is, configFile.toPath());

                }

            }

            return ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);

        } catch (IOException e) {

            throw new RuntimeException("Unable to load configuration file", e);

        }

    }



    public static void saveConfig(Plugin plugin, Configuration config) {

        File configFile = new File(plugin.getDataFolder(), "config.yml");



        if (config != null) {

            try {

                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);

            } catch (IOException e) {

                throw new RuntimeException("Unable to save configuration file", e);

            }

        }

    }

    public Configuration getConfig(){
        return config;
    }

    public void saveConfig() {
        this.saveConfig(this, config);

    }


    @Override
    public void onDisable() {
        this.print("&a>--------------------------------<");
        this.print("&bCustomeJoinMessage is Disable");
        this.print("&a>--------------------------------<");
    }


}