package com.github.talentbank.api.currency;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface CurrencyManager {
  /**
   * Footnote! the name parameter is a custom currency name.
   * not a currency type!
   *
   * @param name specific currency name.
   * @param currency to be added.
   */
  void add(@NotNull final String name, @NotNull final Currency currency);
  /**
   * remove custom currency.
   *
   * @param name specific currency name.
   */
  void remove(@NotNull final String name);
  /**
   * @return all currency.
   */
  @NotNull
  Collection<Currency> all();
}
