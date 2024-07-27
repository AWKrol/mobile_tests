package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;

public class MainPage extends AnyPageAbs<MainPage> {

  public MainPage open() {
    Selenide.open();

    return this;
  }

  public void checkAlert() {
    String headerAlert = $("#alertTitle").getText();
    String descriptionAlert = $("#message").getText();

    Assert.assertEquals("Alert", headerAlert);
    Assert.assertEquals("Must use physical device for Push Notifications", descriptionAlert);

  }

  public MainPage clickOk() {
    $("#button1").click();

    return this;
  }

  public MainPage clickStats() {
    $("[text='Stats']").click();

    return this;
  }

}
