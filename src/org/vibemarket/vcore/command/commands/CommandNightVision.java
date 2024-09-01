package org.vibemarket.vcore.command.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.vibemarket.vcore.command.VCommand;
import org.vibemarket.vcore.util.MessageUtil;
import org.vibemarket.vcore.util.PlatformUtil;

public final class CommandNightVision extends VCommand {

    private static final int DURATION = PlatformUtil.getMinecraftVersion() >= 19.4f ? -1 : Integer.MAX_VALUE;

    public CommandNightVision() {
        super("nightvision", "nv", "see", "c");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                MessageUtil.message(sender, "command.nightvision.off");
            } else {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, DURATION, 0));
                MessageUtil.message(sender, "command.nightvision.on");
            }
        } else
            MessageUtil.message(sender, "command.nightvision.playeronly");

        return true;
    }

}
