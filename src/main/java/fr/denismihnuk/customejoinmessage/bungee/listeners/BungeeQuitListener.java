package fr.denismihnuk.customejoinmessage.bungee.listeners;

import fr.denismihnuk.customejoinmessage.bungee.BungeeCustomeJoinMessage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeeQuitListener implements Listener {
    private BungeeCustomeJoinMessage main;


    public BungeeQuitListener(BungeeCustomeJoinMessage bungeeCustomeJoinMessage) {

        this.main = bungeeCustomeJoinMessage;
    }
    @EventHandler
    public void onPostLogin(PlayerDisconnectEvent event){
        if(main.getConfig().getBoolean("message", true)) {
            ProxiedPlayer player = event.getPlayer();
            String playerName = player.getName();
            ProxyServer.getInstance().broadcast(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("quit").replace("%player%", playerName))));
        }
        }
}

