package com.github.talentbank.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public class StructureObject {

  private final Object object;
  private final Class<?> aClass;

  public static StructureObject get(@NotNull final Object object,@NotNull final Class<?> aClass){
    return new StructureObject(object,aClass);
  }
}
