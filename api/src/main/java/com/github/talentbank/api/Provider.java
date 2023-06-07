package com.github.talentbank.api;

import com.google.common.base.Preconditions;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
/**
 * @author BeyazPolis
 */
@UtilityClass
public class Provider {
  /**
   * the bank instance.
   */
  @Nullable
  private TalentBank bank;
  /**
   * obtains the bank.
   *
   * @return bank.
   */
  @NotNull
  public TalentBank bank() {
    return Objects.requireNonNull(Provider.bank, "The bank not set yet!");
  }
  /**
   * sets the bank.
   *
   * @param bank the bank to set.
   * @throws IllegalStateException if the bank is already set.
   */
  public void bank(@NotNull final TalentBank bank) {
    Preconditions.checkState(
        Provider.bank == null,
        "The bank has been set already!",
        Provider.bank
    );
    Provider.bank = bank;
  }
}
