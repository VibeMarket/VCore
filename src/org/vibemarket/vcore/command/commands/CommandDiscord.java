package org.vibemarket.vcore.command.commands;

import org.bukkit.command.CommandSender;
import org.vibemarket.vcore.command.VCommand;
import org.vibemarket.vcore.util.MessageUtil;

public final class CommandDiscord extends VCommand {

    public CommandDiscord() {
        super("discord");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        MessageUtil.message(sender, "command.discord");
        return true;
    }

}
