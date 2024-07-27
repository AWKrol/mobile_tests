import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.inject.Guice;
import com.google.inject.Injector;
import drivers.AppiumDriver;
import modules.GuiceModule;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbsBaseTest {

  private Injector injector;

  @BeforeMethod
  public void init() {
    Configuration.screenshots = false;
    Configuration.browserSize = null;
    Configuration.browser = AppiumDriver.class.getName();

    injector = Guice.createInjector(new GuiceModule());
    injector.injectMembers(this);
  }

  @AfterMethod
  public void close() {
    Selenide.closeWebDriver();
  }

}
