package fr.denismihnuk.customejoinmessage.bungee.commands;

import fr.denismihnuk.customejoinmessage.bungee.BungeeCustomeJoinMessage;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BungeeQuitCommand extends Command {

    private BungeeCustomeJoinMessage main;

    public BungeeQuitCommand(BungeeCustomeJoinMessage bungeeCustomeJoinMessage){
        super("bungeesetquitmessage", "bungeesetquitmessage.use");
        this.main = bungeeCustomeJoinMessage;
    }



    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if (strings.length == 0) {
                player.sendMessage(new TextComponent("§4Error §c: §b/setquitnmessage §c<Join Message>"));
            }
            if (strings.length >= 1) {
                player.sendMessage(new TextComponent("§aSuccessfuly set Quit Message"));
                StringBuilder quit = new StringBuilder();
                for (String part : strings) {
                    quit.append(part + " ");
                }
                main.getConfig().set("quit", quit.toString());
                main.saveConfig();
            }
        }
    }

}

