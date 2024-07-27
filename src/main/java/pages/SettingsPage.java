package pages;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;


public class SettingsPage extends AnyPageAbs<SettingsPage> {

  public SettingsPage selectLanguage(String language) {
    $(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+language+"\").instance(0))")).click();

    return this;
  }

  public void checkTranslation(String language) {
    String actualLanguage = $(By.xpath("//android.widget.TextView[@text='Translations']/following-sibling::android.widget.TextView"))
        .getText();

    Assert.assertEquals(actualLanguage, language, String.format("Value 'Translations' != '%s'", language));
  }

}
