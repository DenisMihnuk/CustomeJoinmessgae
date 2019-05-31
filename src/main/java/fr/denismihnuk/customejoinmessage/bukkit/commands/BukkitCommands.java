package fr.denismihnuk.customejoinmessage.bukkit.commands;

import fr.denismihnuk.customejoinmessage.bukkit.Customejoinmessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BukkitCommands implements CommandExecutor {
    private Customejoinmessage main;

    public BukkitCommands(Customejoinmessage customejoinmessage){
        this.main = customejoinmessage;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(command.getName().equalsIgnoreCase("customejoinmessage")){
                    sender.sendMessage("§d<----------------------------------------> \n §b/setjoinmessage §c<Join Message> \n §b/setquitmessage §c<Quit Message> \n §b/customejoinmessagereload §cReload Config \n §d<---------------------------------------->");
return true;
            }

            if(command.getName().equalsIgnoreCase("customejoinmessagereload")){
                main.reloadConfig();
                sender.sendMessage("§aSuccessfuly Reload Config");
                return true;
            }

            if(command.getName().equalsIgnoreCase("setjoinmessage" )){

                if(args.length == 0){
                    sender.sendMessage("§4Error §c: §b/setjoinmessage §c<Join Message>");
                }
                if (args.length >= 1){
                    sender.sendMessage("§aSuccessfuly set Join Message");
                    StringBuilder join = new StringBuilder();
                    for (String part : args){
                        join.append(part + " ");
                    }
                    main.getConfig().set("join", join.toString());
                    main.saveConfig();
                }
return true;
            }

            if(command.getName().equalsIgnoreCase("setquitmessage" )) {


                if (args.length == 0){
                    sender.sendMessage("§4Error §c: §b/setquitmessage §c<Quit Message>");
                }


                if (args.length >= 1){
                    sender.sendMessage("§aSuccessfuly set Quit Message");
                    StringBuilder quit = new StringBuilder();
                    for (String part : args){
                        quit.append(part + " ");
                    }
                    main.getConfig().set("quit", quit.toString());
                    main.saveConfig();
                }
return true;
            }
        }

        return false;
    }
}

