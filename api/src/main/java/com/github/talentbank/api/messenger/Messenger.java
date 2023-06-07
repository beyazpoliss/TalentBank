package com.github.talentbank.api.messenger;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.logging.Level;

public interface Messenger {

  void sendMessagePlayer(@NotNull final String name, @NotNull final String message);

  void sendMessageUuid(@NotNull final UUID uuid, @NotNull final String message);

  void sendMessageConsole(@NotNull final Level level, @NotNull final String message);

}
