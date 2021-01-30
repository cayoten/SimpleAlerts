package me.cayoten.simplealerts.commands;

import com.google.common.base.Joiner;
import me.cayoten.simplealerts.Simplealerts;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffAlert implements CommandExecutor {

    Simplealerts plugin = Simplealerts.getPlugin(Simplealerts.class);

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Define config files for the prefix & color code

        String pluginprefix = plugin.getConfig().getString("pluginprefix");
        String staffalertprefix = plugin.getConfig().getString("staffalertprefix");
        String staffalertmsgcolorcode = plugin.getConfig().getString("staffalertmsgcolorcode");

        //Return if no perms

        if (!sender.hasPermission("simplealerts.staffalert")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&cYou do not have the required permission to run this command! (simplealerts.staffalert)"));
            return true;
        }

        //Return if no defined content

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&cPlease specify the content in which to announce!"));
            return true;
        }

        //Broadcast with extra steps (extra perms required!)

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("simplealerts.readstaffalerts")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', staffalertprefix + staffalertmsgcolorcode + Joiner.on(" ").join(args)));
            }

            if (player.hasPermission("simplealerts.staffalert") && !player.hasPermission("simplealerts.readstaffalerts")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&6A staff alert was sent out, but you are missing the permission " + ChatColor.BOLD + "simplealerts.readstaffalerts"));
            }

            return true;
        }
        return true;
    }
}
