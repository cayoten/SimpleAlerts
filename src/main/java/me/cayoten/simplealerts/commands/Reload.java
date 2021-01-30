package me.cayoten.simplealerts.commands;

import com.google.common.base.Joiner;
import me.cayoten.simplealerts.Simplealerts;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {

    Simplealerts plugin = Simplealerts.getPlugin(Simplealerts.class);

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String pluginprefix = plugin.getConfig().getString("pluginprefix");

        if (!sender.hasPermission("simplealerts.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',pluginprefix + "&cYou do not have the required permission to run this command! (simplealerts.reload)"));
            return true;
        }

        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + "&aIt is done, my lord."));
        return true;
    }
}