package me.cayoten.simplealerts.commands;

import com.google.common.base.Joiner;
import me.cayoten.simplealerts.Simplealerts;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Alert implements CommandExecutor {

    Simplealerts plugin = Simplealerts.getPlugin(Simplealerts.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Define config files for the prefix & color code

        String pluginprefix = plugin.getConfig().getString("pluginprefix");
        String alertprefix = plugin.getConfig().getString("alertprefix");
        String alertmsgcolorcode = plugin.getConfig().getString("alertmsgcolorcode");

        //Return if no perms

        if (!sender.hasPermission("simplealerts.alert")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&cYou do not have the required permission to run this command! (simplealerts.alert)"));
            return true;
        }

        //Return if no defined content

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + "&cPlease specify the content in which to announce!"));
            return true;
        }

        //Broadcast message

        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', alertprefix + alertmsgcolorcode + Joiner.on(" ").join(args)));

        return true;

    }
}
