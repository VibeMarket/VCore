package org.vibemarket.vcore.util;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationOptions;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.vibemarket.vcore.VCore;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class VConfiguration implements Configuration {

    private static final VCore plugin = VCore.getInstance();
    private final File file;
    private FileConfiguration config;

    public VConfiguration(String fileName) {
        file = new File(plugin.getDataFolder(), fileName);

        load();
    }

    public void load() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(file.getName(), false);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public @NotNull Set<String> getKeys(boolean deep) {
        return config.getKeys(deep);
    }

    @Override
    public @NotNull Map<String, Object> getValues(boolean deep) {
        return config.getValues(deep);
    }

    @Override
    public boolean contains(@NotNull String path) {
        return config.contains(path);
    }

    @Override
    public boolean contains(@NotNull String path, boolean ignoreDefault) {
        return config.contains(path, ignoreDefault);
    }

    @Override
    public boolean isSet(@NotNull String path) {
        return config.isSet(path);
    }

    @Override
    public @NotNull String getCurrentPath() {
        return config.getCurrentPath();
    }

    @Override
    public @NotNull String getName() {
        return config.getName();
    }

    @Override
    public @Nullable Configuration getRoot() {
        return config.getRoot();
    }

    @Override
    public @Nullable ConfigurationSection getParent() {
        return config.getParent();
    }

    @Override
    public @Nullable Object get(@NotNull String path) {
        return config.get(path);
    }

    @Override
    public @Nullable Object get(@NotNull String path, @Nullable Object def) {
        return config.get(path, def);
    }

    @Override
    public void set(@NotNull String path, @Nullable Object value) {
        config.set(path, value);
    }

    @Override
    public @NotNull ConfigurationSection createSection(@NotNull String path) {
        return config.createSection(path);
    }

    @Override
    public @NotNull ConfigurationSection createSection(@NotNull String path, @NotNull Map<?, ?> map) {
        return config.createSection(path, map);
    }

    @Override
    public @Nullable String getString(@NotNull String path) {
        return config.getString(path);
    }

    @Override
    public @Nullable String getString(@NotNull String path, @Nullable String def) {
        return config.getString(path, def);
    }

    @Override
    public boolean isString(@NotNull String path) {
        return config.isString(path);
    }

    @Override
    public int getInt(@NotNull String path) {
        return config.getInt(path);
    }

    @Override
    public int getInt(@NotNull String path, int def) {
        return config.getInt(path, def);
    }

    @Override
    public boolean isInt(@NotNull String path) {
        return config.isInt(path);
    }

    @Override
    public boolean getBoolean(@NotNull String path) {
        return config.getBoolean(path);
    }

    @Override
    public boolean getBoolean(@NotNull String path, boolean def) {
        return config.getBoolean(path, def);
    }

    @Override
    public boolean isBoolean(@NotNull String path) {
        return config.isBoolean(path);
    }

    @Override
    public double getDouble(@NotNull String path) {
        return config.getDouble(path);
    }

    @Override
    public double getDouble(@NotNull String path, double def) {
        return config.getDouble(path, def);
    }

    @Override
    public boolean isDouble(@NotNull String path) {
        return config.isDouble(path);
    }

    @Override
    public long getLong(@NotNull String path) {
        return config.getLong(path);
    }

    @Override
    public long getLong(@NotNull String path, long def) {
        return config.getLong(path, def);
    }

    @Override
    public boolean isLong(@NotNull String path) {
        return config.isLong(path);
    }

    @Override
    public @Nullable List<?> getList(@NotNull String path) {
        return config.getList(path);
    }

    @Override
    public @Nullable List<?> getList(@NotNull String path, @Nullable List<?> def) {
        return config.getList(path, def);
    }

    @Override
    public boolean isList(@NotNull String path) {
        return config.isList(path);
    }

    @Override
    public @NotNull List<String> getStringList(@NotNull String path) {
        return config.getStringList(path);
    }

    @Override
    public @NotNull List<Integer> getIntegerList(@NotNull String path) {
        return config.getIntegerList(path);
    }

    @Override
    public @NotNull List<Boolean> getBooleanList(@NotNull String path) {
        return config.getBooleanList(path);
    }

    @Override
    public @NotNull List<Double> getDoubleList(@NotNull String path) {
        return config.getDoubleList(path);
    }

    @Override
    public @NotNull List<Float> getFloatList(@NotNull String path) {
        return config.getFloatList(path);
    }

    @Override
    public @NotNull List<Long> getLongList(@NotNull String path) {
        return config.getLongList(path);
    }

    @Override
    public @NotNull List<Byte> getByteList(@NotNull String path) {
        return config.getByteList(path);
    }

    @Override
    public @NotNull List<Character> getCharacterList(@NotNull String path) {
        return config.getCharacterList(path);
    }

    @Override
    public @NotNull List<Short> getShortList(@NotNull String path) {
        return config.getShortList(path);
    }

    @Override
    public @NotNull List<Map<?, ?>> getMapList(@NotNull String path) {
        return config.getMapList(path);
    }

    @Override
    public <T> @Nullable T getObject(@NotNull String path, @NotNull Class<T> clazz) {
        return config.getObject(path, clazz);
    }

    @Override
    public <T> @Nullable T getObject(@NotNull String path, @NotNull Class<T> clazz, @Nullable T def) {
        return config.getObject(path, clazz, def);
    }

    @Override
    public <T extends ConfigurationSerializable> @Nullable T getSerializable(@NotNull String path, @NotNull Class<T> clazz) {
        return config.getSerializable(path, clazz);
    }

    @Override
    public <T extends ConfigurationSerializable> @Nullable T getSerializable(@NotNull String path, @NotNull Class<T> clazz, @Nullable T def) {
        return config.getSerializable(path, clazz, def);
    }

    @Override
    public @Nullable Vector getVector(@NotNull String path) {
        return config.getVector(path);
    }

    @Override
    public @Nullable Vector getVector(@NotNull String path, @Nullable Vector def) {
        return config.getVector(path, def);
    }

    @Override
    public boolean isVector(@NotNull String path) {
        return config.isVector(path);
    }

    @Override
    public @Nullable OfflinePlayer getOfflinePlayer(@NotNull String path) {
        return config.getOfflinePlayer(path);
    }

    @Override
    public @Nullable OfflinePlayer getOfflinePlayer(@NotNull String path, @Nullable OfflinePlayer def) {
        return config.getOfflinePlayer(path, def);
    }

    @Override
    public boolean isOfflinePlayer(@NotNull String path) {
        return config.isOfflinePlayer(path);
    }

    @Override
    public @Nullable ItemStack getItemStack(@NotNull String path) {
        return config.getItemStack(path);
    }

    @Override
    public @Nullable ItemStack getItemStack(@NotNull String path, @Nullable ItemStack def) {
        return config.getItemStack(path, def);
    }

    @Override
    public boolean isItemStack(@NotNull String path) {
        return config.isItemStack(path);
    }

    @Override
    public @Nullable Color getColor(@NotNull String path) {
        return config.getColor(path);
    }

    @Override
    public @Nullable Color getColor(@NotNull String path, @Nullable Color def) {
        return config.getColor(path, def);
    }

    @Override
    public boolean isColor(@NotNull String path) {
        return config.isColor(path);
    }

    @Override
    public @Nullable Location getLocation(@NotNull String path) {
        return config.getLocation(path);
    }

    @Override
    public @Nullable Location getLocation(@NotNull String path, @Nullable Location def) {
        return config.getLocation(path, def);
    }

    @Override
    public boolean isLocation(@NotNull String path) {
        return config.isLocation(path);
    }

    @Override
    public @Nullable ConfigurationSection getConfigurationSection(@NotNull String path) {
        return config.getConfigurationSection(path);
    }

    @Override
    public boolean isConfigurationSection(@NotNull String path) {
        return config.isConfigurationSection(path);
    }

    @Override
    public @Nullable ConfigurationSection getDefaultSection() {
        return config.getDefaultSection();
    }

    @Override
    public void addDefault(@NotNull String path, @Nullable Object value) {
        config.addDefault(path, value);
    }

    @Override
    public @NotNull List<String> getComments(@NotNull String path) {
        return config.getComments(path);
    }

    @Override
    public @NotNull List<String> getInlineComments(@NotNull String path) {
        return config.getInlineComments(path);
    }

    @Override
    public void setComments(@NotNull String path, @Nullable List<String> comments) {
        config.setComments(path, comments);
    }

    @Override
    public void setInlineComments(@NotNull String path, @Nullable List<String> comments) {
        config.setInlineComments(path, comments);
    }

    @Override
    public void addDefaults(@NotNull Map<String, Object> defaults) {
        config.addDefaults(defaults);
    }

    @Override
    public void addDefaults(@NotNull Configuration defaults) {
        config.addDefaults(defaults);
    }

    @Override
    public void setDefaults(@NotNull Configuration defaults) {
        config.setDefaults(defaults);
    }

    @Override
    public @Nullable Configuration getDefaults() {
        return config.getDefaults();
    }

    @Override
    public @NotNull ConfigurationOptions options() {
        return config.options();
    }

}
