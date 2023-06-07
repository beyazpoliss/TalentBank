package currency;

import com.github.talentbank.api.currency.Currency;
import com.github.talentbank.api.currency.CurrencyManager;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author BeyazPolis
 */
public class DefaultCurrencyManager implements CurrencyManager {
  /**
   * currencies are kept here. In operations like load, this place changes!
   */
  @NotNull
  private final ConcurrentHashMap<String, Currency> currencyMap;
  /**
   * manager ctor.
   */
  public DefaultCurrencyManager(){
    this.currencyMap = new ConcurrentHashMap<>();
  }
  /**
   * Footnote! the name parameter is a custom currency name.
   * not a currency type!
   *
   * @param name specific currency name.
   * @param currency to be added.
   */
  public void add(@NotNull final String name, @NotNull final Currency currency){
    this.currencyMap.put(name,currency);
  }
  /**
   * remove custom currency.
   *
   * @param name specific currency name.
   */
  public void remove(@NotNull final String name){
    this.currencyMap.remove(name);
  }
  /**
   * @return all currency.
   */
  @NotNull
  public Collection<Currency> all(){
    return currencyMap.values();
  }
}
