package com.github.talentbank.api.config;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Configuration {

  CompletableFuture<Void> load();

  CompletableFuture<Void> save();

  void setIfNotExists(@NotNull final String path, Object object);

  List<String> getKeys(@NotNull final String path, final boolean deep);

  boolean isNotSet(@NotNull final String path);

  Object get(@NotNull final String path);

  default void createFile(@NotNull final File pluginFolder){
    if (!pluginFolder.exists()){
      try {
        pluginFolder.mkdirs();
        pluginFolder.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}