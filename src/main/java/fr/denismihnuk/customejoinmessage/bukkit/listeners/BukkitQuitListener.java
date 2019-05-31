package fr.denismihnuk.customejoinmessage.bukkit.listeners;

import fr.denismihnuk.customejoinmessage.bukkit.Customejoinmessage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitQuitListener implements Listener {
    private Customejoinmessage main;
    public BukkitQuitListener(Customejoinmessage customejoinmessage){
        this.main = customejoinmessage;
    }
@EventHandler
    public void onQuit(PlayerQuitEvent event){
        if (main.getConfig().getBoolean("message", true)) {
            Player player = event.getPlayer();
            String playerName = player.getName();
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("quit").replace("%player%", playerName)));
        }
    }
}
