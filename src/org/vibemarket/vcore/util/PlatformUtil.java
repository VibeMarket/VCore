package org.vibemarket.vcore.util;

import org.bukkit.Bukkit;

public final class PlatformUtil {

    private static float minecraftVersion;
    private static String packageVersion;

    static {
        String bukkit = Bukkit.getVersion();
        String result = bukkit.contains("(MC: ") ?
                bukkit.split("\\(MC: ")[1] :
                bukkit.split(" version ")[1];

        try {
            minecraftVersion = Float.parseFloat(result.replaceFirst("(\\d+).(\\d+)(.\\d+)?\\)", "$2$3"));
        } catch (NumberFormatException exception) {
            minecraftVersion = 8; // Default to 1.8
            exception.printStackTrace();
        }

        packageVersion = Bukkit.getServer().getClass().getName().split("\\.")[3];
    }

    public static float getMinecraftVersion() { return minecraftVersion; }

    public static String getPackageVersion() { return packageVersion; }

}
