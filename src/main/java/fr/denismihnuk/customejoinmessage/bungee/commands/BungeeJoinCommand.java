package fr.denismihnuk.customejoinmessage.bungee.commands;


import fr.denismihnuk.customejoinmessage.bungee.BungeeCustomeJoinMessage;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BungeeJoinCommand extends Command {

    private BungeeCustomeJoinMessage main;

    public BungeeJoinCommand(BungeeCustomeJoinMessage bungeeCustomeJoinMessage) {
        super("bungeesetjoinmessage", "bungeesetjoinmessage.use");
        this.main = bungeeCustomeJoinMessage;
    }


    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if (strings.length == 0) {

                player.sendMessage(new TextComponent("§4Error §c: §b/setjoinmessage §c<Join Message>"));
            }

            if (strings.length >= 1) {
                player.sendMessage(new TextComponent("§aSuccessfuly set Join Message"));
                StringBuilder join = new StringBuilder();
                for (String part : strings) {
                    join.append(part + " ");
                }

                main.getConfig().set("join", join.toString());
                main.saveConfig();
            }

        }
    }
}

