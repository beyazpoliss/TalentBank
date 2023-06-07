package com.github.talentbank.bukkit;

import com.github.talentbank.api.StructureObject;
import com.github.talentbank.api.config.Configuration;
import com.github.talentbank.api.messenger.Messenger;
import com.github.talentbank.bukkit.config.BukkitConfiguration;
import com.github.talentbank.bukkit.messenger.BukkitMessenger;
import com.github.talentbank.common.DefaultTalentBank;
import org.jetbrains.annotations.NotNull;

public abstract class TBBukkitAdapter extends DefaultTalentBank {

  public TBBukkitAdapter(@NotNull final TBBukkitPlugin plugin){
    final Messenger messenger = new BukkitMessenger(plugin);
    final Configuration configuration = new BukkitConfiguration();
    this.structure().register(
      StructureObject.get(messenger, Messenger.class),
      StructureObject.get(configuration, Configuration.class)
    );
    this.structureChangeComponent();
  }

  @Override
  public void structureChangeComponent() {
    //
  }
}
