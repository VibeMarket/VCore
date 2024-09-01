package org.vibemarket.vcore.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.vibemarket.vcore.command.VCommand;
import org.vibemarket.vcore.util.MessageUtil;

public final class CommandPing extends VCommand {

    public CommandPing() {
        super("ping");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Target target = new Target(sender, args);

        if (target.usage()) {
            MessageUtil.message(sender, "command.ping.usage", label);
            return true;
        }

        if (target.offline()) {
            MessageUtil.message(sender, "command.ping.offline", args[0]);
            return true;
        }

        Player player = target.player();
        int ping = player.getPing();

        if (target.self())
            MessageUtil.message(sender, "command.ping", ping);
        else
            MessageUtil.message(sender, "command.ping.others", player.getDisplayName(), ping);

        return true;
    }

}
