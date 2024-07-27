package actions;

import static com.codeborne.selenide.Selenide.$;

public class CommonActions<T> {

  public T clickByText(String text) {
    $(String.format("[text='%s']", text)).click();

    return (T)this;
  }

}
