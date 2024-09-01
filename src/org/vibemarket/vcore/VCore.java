package org.vibemarket.vcore;

import org.bukkit.plugin.java.JavaPlugin;
import org.vibemarket.vcore.util.VConfiguration;

public final class VCore extends JavaPlugin {

    private static VCore instance;
    private VConfiguration messageConfig;

    public static VCore getInstance() { return instance; }

    public VConfiguration getMessageConfig() { return messageConfig; }

    @Override
    public void onEnable() {
        instance = this;
        messageConfig = new VConfiguration("messages.yml");
    }

}
