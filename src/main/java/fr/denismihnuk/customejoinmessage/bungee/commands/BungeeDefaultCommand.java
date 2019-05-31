package fr.denismihnuk.customejoinmessage.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BungeeDefaultCommand extends Command {
    public BungeeDefaultCommand() {
        super("bungeecustomejoinmessage", "bungeecustomejoinmessage.use");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            player.sendMessage(new TextComponent("§d<----------------------------------------> \n §b/setjoinmessage §c<Join Message> \n §b/setquitmessage §c<Quit Message>  \n §d<---------------------------------------->"));
        }


    }
}



