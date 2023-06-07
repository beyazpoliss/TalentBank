package com.github.talentbank.api.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
/**
 * a type enum class holds the types of currencies.
 * @author BeyazPolis
 */
@Getter
@RequiredArgsConstructor
public enum CurrencyType {
  /**
   * a visual currency type.
   */
  VISUAL("visual",0),
  /**
   * an item currency type.
   */
  ITEM("item",1),
  /**
   * a xp currency type.
   */
  XP("xp",2);
  /**
   * returns all currency type variables as array.
   */
  @NotNull
  private static final CurrencyType[] types = CurrencyType.values();
  /**
   * a currency type name.
   */
  private final String name;
  /**
   * a currency type id.
   */
  private final int id;
  /**
   * @param name currency name
   * @return currency type get by name.
   */
  @NotNull
  public Optional<CurrencyType> getTypeByName(@NotNull final String name){
    for (CurrencyType type : types) {
      if (!type.getName().equalsIgnoreCase(name)) continue;
      return Optional.of(type);
    }
    return Optional.empty();
  }
  /**
   * @param id currency id.
   * @return currency type get by id.
   */
  @NotNull
  public Optional<CurrencyType> getTypeById(final int id){
    for (CurrencyType type : types) {
      if (!(type.getId() == id)) continue;
      return Optional.of(type);
    }
    return Optional.empty();
  }
}
