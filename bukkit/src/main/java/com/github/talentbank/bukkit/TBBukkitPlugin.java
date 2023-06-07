package com.github.talentbank.bukkit;

import com.github.talentbank.api.Provider;
import org.bukkit.plugin.java.JavaPlugin;

public class TBBukkitPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    final var bukkit =  new TBBukkitAdapter(this){};
    Provider.bank(bukkit);
    bukkit.enable();
  }

  @Override
  public void onDisable() {
    super.onDisable();
  }
}