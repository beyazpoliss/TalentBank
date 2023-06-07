package com.github.talentbank.common;

import com.github.talentbank.api.Structure;
import com.github.talentbank.api.StructureObject;
import com.github.talentbank.api.TalentBank;
import com.github.talentbank.api.currency.CurrencyManager;
import com.github.talentbank.api.currency.CurrencyReLoader;
import currency.DefaultCurrencyManager;
import currency.DefaultCurrencyReLoader;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public abstract class DefaultTalentBank implements TalentBank {

  @NotNull
  private final Structure structure;

  public DefaultTalentBank(){
    final CurrencyManager currencyManager = new DefaultCurrencyManager();
    final CurrencyReLoader reLoader = new DefaultCurrencyReLoader();
    this.structure = Structure.create().register(
      StructureObject.get(currencyManager, CurrencyManager.class),
      StructureObject.get(reLoader, CurrencyReLoader.class)
    );
    this.structureChangeComponent();
  }

  @Override
  public Structure structure() {
    return structure;
  }

  @Override
  public void enable() {
    this.messenger().sendMessageConsole(Level.INFO,"Welcome the TalentBank. This plugin economy & bank plugin.");
    this.configuration().load().thenAccept(unused -> {
      System.out.println("Configuration be loaded.");
    });
  }
}
