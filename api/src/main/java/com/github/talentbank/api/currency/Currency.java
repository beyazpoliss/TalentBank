package com.github.talentbank.api.currency;

import org.jetbrains.annotations.NotNull;
/**
 * @author BeyazPolis
 */
public interface Currency {

  @NotNull
  CurrencyType type();

  @NotNull
  String name();

}

