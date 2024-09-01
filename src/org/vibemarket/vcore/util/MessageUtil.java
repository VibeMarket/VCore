package org.vibemarket.vcore.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.vibemarket.vcore.VCore;

public final class MessageUtil {

    private static final Configuration messages = VCore.getInstance().getMessageConfig();
    private static final String prefix = messages.getString("global.prefix");

    public static void message(CommandSender sender, String node, Object... placeholders) {
        String message = messages.getString(node);

        if (message == null)
            throw new IllegalArgumentException("No configuration node " + node + " in messages.yml");

        for (int i = 0; i < placeholders.length; i++)
            message = message.replace("{$" + i + "}", placeholders[i].toString());

        message = prefix + message;

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
