package org.vibemarket.vcore.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.vibemarket.vcore.VCore;
import org.vibemarket.vcore.util.ClassWrapper;

import java.util.Arrays;

public abstract class VCommand extends Command implements PluginIdentifiableCommand {

    protected static final VCore plugin = VCore.getInstance();
    private static final SimpleCommandMap commandMap =
            new ClassWrapper(Bukkit.getPluginManager()).getFieldDeclared("commandMap");

    public VCommand(String label) {
        super(label);

        setPermission(plugin.getName() + "." + label);

        commandMap.register(plugin.getName(), this);
    }

    public VCommand(String label, String... aliases) {
        this(label);

        setAliases(Arrays.asList(aliases));
    }

    public static class Target {

        private Player player = null;
        private boolean self = false;
        private boolean offline = false;

        public Target(CommandSender sender, String[] args) {
            if (args.length == 1) {
                this.player = Bukkit.getPlayer(args[0]);
                this.offline = player == null;
            } else if (args.length == 0 && sender instanceof Player) {
                this.player = (Player) sender;
                this.self = true;
            }
        }

        public Player player() { return player; }

        public boolean self() { return self; }

        public boolean offline() { return offline; }

        public boolean usage() { return player == null && !offline; }

    }

    @Override
    public @NotNull Plugin getPlugin() {
        return plugin;
    }

}
