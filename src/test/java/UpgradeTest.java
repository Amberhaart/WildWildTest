import configuration.Config;
import keywords.Login;
import keywords.Upgrade;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpgradeTest {

  protected static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(Config.url + "login/");
    Login.login(driver, Config.userName, Config.password);
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }

  @After
  public void reset() {
    Upgrade.goToBuildings(driver);
  }

  @Test
  public void upgradeTownhall() {
    int initialLevel = Upgrade.getTownhallLevel(driver);
    Upgrade.upgradeTownhall(driver);
    Upgrade.waitUntilUpgradeFinishes(driver);
    Assert.assertEquals(initialLevel + 1, Upgrade.getUpgradedTownhallLevel(driver));
  }

  @Test
  public void upgradeBeyondTownhallLevel() {
    Upgrade.tryToUpgradeFarmBeyondTownhall(driver);
    Assert.assertTrue(Upgrade.errorMessageWhenTryingToUpgradeBeyondTownhall(driver));
  }

}
