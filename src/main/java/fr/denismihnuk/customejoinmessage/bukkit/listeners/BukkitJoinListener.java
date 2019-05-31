package fr.denismihnuk.customejoinmessage.bukkit.listeners;

import fr.denismihnuk.customejoinmessage.bukkit.Customejoinmessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BukkitJoinListener implements Listener {
    private Customejoinmessage main;
    public BukkitJoinListener(Customejoinmessage customejoinmessage){
        this.main = customejoinmessage;
           }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String playerName = player.getName();
        if (main.getConfig().getBoolean("message", true)) {
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("join").replace("%player%", playerName)));
            if(main.getConfig().getBoolean("title", true)) {
                String ver = Bukkit.getVersion();
                if (ver.contains("1.7") || ver.contains("1.8") || ver.contains("1.9") || ver.contains("1.10")) {
                    main.print("&cplease use a Bukkit version higher than 1.11 or disable the title");

                }else{
                    player.sendTitle(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("big-title").replace("%player%", playerName)), ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("small-title").replace("%player%", playerName)), main.getConfig().getInt("fade-in"), main.getConfig().getInt("time"), main.getConfig().getInt("fade-out"));

                }
            }


        }
    }
}
