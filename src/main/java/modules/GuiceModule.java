package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import pages.MainPage;
import pages.SettingsPage;

public class GuiceModule extends AbstractModule {


  @Provides
  @Singleton
  public MainPage getMainPage() {
    return new MainPage();
  }

  @Provides
  @Singleton
  public SettingsPage getSettingsPage() {
    return new SettingsPage();
  }

}
