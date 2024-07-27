package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriver  implements WebDriverProvider {

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {

    UiAutomator2Options options = new UiAutomator2Options();
    options.merge(capabilities);
    options.setAdbExecTimeout(Duration.ofSeconds(60));
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setPlatformName("Android");
    options.setDeviceName("mobile");
    options.setPlatformVersion("7,0");
    options.setApp(System.getProperty("user.dir") + "/Andy.apk");
    options.setAppPackage("com.pyankoff.andy");
    options.setAppActivity(".MainActivity");
    options.setAndroidInstallTimeout(Duration.ofSeconds(60));
    options.setAdbExecTimeout(Duration.ofSeconds(60));
    //options.setAppWaitForLaunch(true);

    try {
      String appiumUrl = System.getProperty("appium.url",System.getProperty("base.url"));
      return new AndroidDriver(new URL(appiumUrl), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

}
