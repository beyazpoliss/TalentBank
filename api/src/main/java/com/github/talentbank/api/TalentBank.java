package com.github.talentbank.api;

import com.github.talentbank.api.config.Configuration;
import com.github.talentbank.api.currency.CurrencyManager;
import com.github.talentbank.api.currency.CurrencyReLoader;
import com.github.talentbank.api.messenger.Messenger;
import org.jetbrains.annotations.NotNull;
/**
 * the main core class of the Talent-Bank plugin.
 */
public interface TalentBank {
  /**
   * method that starts and runs the plugin.
   */
  void enable();
  /**
   * The default build is loaded when the plugin is first opened.
   * if You want to change it immediately you can change all api layers here.
   */
  void structureChangeComponent();
  /**
   * Manages all api classes.
   *
   * @return plugin structure.
   */
  Structure structure();
  /**
   * common proxy to send messages to different places.
   *
   * @return common messenger.
   */
  @NotNull
  default Messenger messenger(){
    return this.structure().provideOrThrow(Messenger.class);
  }
  /**
   * manager class that holds currencies, adds and removes them.
   *
   * @see CurrencyManager
   */
  @NotNull
  default CurrencyManager currencyManager(){
    return this.structure().provideOrThrow(CurrencyManager.class);
  }
  /**
   * It does operations like reload and load.
   *
   * @see CurrencyReLoader
   */
  @NotNull
  default CurrencyReLoader currencyReLoader(){
    return this.structure().provideOrThrow(CurrencyReLoader.class);
  }
  /**
   * It does operations like config.
   *
   * @see Configuration
   */
  @NotNull
  default Configuration configuration(){
    return this.structure().provideOrThrow(Configuration.class);
  }
}
