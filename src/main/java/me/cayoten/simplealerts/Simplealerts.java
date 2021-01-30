package me.cayoten.simplealerts;

import me.cayoten.simplealerts.commands.Alert;
import me.cayoten.simplealerts.commands.Reload;
import me.cayoten.simplealerts.commands.StaffAlert;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Simplealerts extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("alert")).setExecutor(new Alert());
        Objects.requireNonNull(getCommand("staffalert")).setExecutor(new StaffAlert());
        Objects.requireNonNull(getCommand("sareload")).setExecutor(new Reload());
    }

    @Override
    public void onDisable() {
    }
}