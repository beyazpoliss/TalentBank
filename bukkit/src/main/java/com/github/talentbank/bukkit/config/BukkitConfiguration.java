package com.github.talentbank.bukkit.config;

import com.github.talentbank.api.config.Configuration;
import lombok.AllArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class BukkitConfiguration implements Configuration {

  private final File pluginFolder = new File("config.yml");
  private FileConfiguration configuration;

  @Override
  public CompletableFuture<Void> load() {
    return CompletableFuture.supplyAsync(() -> {
      createFile(pluginFolder);
      if (!pluginFolder.exists()){
        try {
          pluginFolder.createNewFile();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      this.configuration = YamlConfiguration.loadConfiguration(pluginFolder);
      return null;
    });
  }

  @Override
  public CompletableFuture<Void> save() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        this.configuration.save(pluginFolder);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    });
  }

  @Override
  public void setIfNotExists(final @NotNull String path, final Object o) {
    if (isNotSet(path)){
      this.configuration.set(path, o);
    }
  }

  @Override
  public List<String> getKeys(final @NotNull String path, final boolean deep){
    if (isNotSet(path)) return new ArrayList<>();
    return new ArrayList<>(Objects.requireNonNull(configuration.getConfigurationSection(path)).getKeys(deep));
  }

  @Override
  public boolean isNotSet(final @NotNull String path){
    return !this.configuration.isSet(path);
  }

  @Override
  @NotNull
  public Object get(final @NotNull String path) {
    return Objects.requireNonNull(configuration.get(path));
  }
}
