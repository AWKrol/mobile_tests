import com.google.inject.Inject;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SettingsPage;

@Test
public class AndyTest extends AbsBaseTest{

  @Inject
  private MainPage mainPage;

  @Inject
  private SettingsPage settingsPage;

  @Test
  public void checkAlert() {

    mainPage.open()
      .clickByText("Next")
      .clickByText("Next")
      .clickByText("Skip >")
        .checkAlert();

  }

  public void settings() {

    String language = "Russian";

    mainPage
      .open()
      .clickByText("Next")
      .clickByText("Next")
      .clickByText("Skip >")
      .clickOk()
      .clickByText("Stats")
        .clickByText("Settings");

    settingsPage
      .clickByText("Translations")
      .selectLanguage(language)
        .checkTranslation(language);
  }

}
