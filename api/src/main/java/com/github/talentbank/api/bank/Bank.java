package com.github.talentbank.api.bank;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;
/**
 * @author BeyazPolis
 */
public interface Bank {

  /**
   * @return bank uuid.
   */
  @NotNull
  UUID uuid();

  @NotNull
  Collection<Money> moneys();

}
