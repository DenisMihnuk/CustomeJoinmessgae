package fr.denismihnuk.customejoinmessage.bungee.listeners;

import fr.denismihnuk.customejoinmessage.bungee.BungeeCustomeJoinMessage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;



public class BungeeJoinListener implements Listener {
    private BungeeCustomeJoinMessage main;


    public BungeeJoinListener(BungeeCustomeJoinMessage bungeeCustomeJoinMessage) {

        this.main = bungeeCustomeJoinMessage;
    }
    @EventHandler
    public void onPostLogin(PostLoginEvent event){
        ProxiedPlayer player = event.getPlayer();
        String playerName = player.getName();
        if(main.getConfig().getBoolean("message", true)) {
            ProxyServer.getInstance().broadcast(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("join").replace("%player%", playerName))));

        }

        if(main.getConfig().getBoolean("title", true)) {
            Title title = ProxyServer.getInstance().createTitle();
            title.title(new TextComponent(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("big-title").replace("%player%", playerName)))));
            title.subTitle(new TextComponent(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("small-title").replace("%player%", playerName)))));
            title.stay(main.getConfig().getInt("time"));
            title.fadeIn(main.getConfig().getInt("fade-in"));
            title.fadeOut(main.getConfig().getInt("fade-out"));
            title.send(player);

        }

        }
        }
