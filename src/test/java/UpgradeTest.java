import configuration.Config;
import keywords.Login;
import keywords.Upgrade;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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

  @Test
  public void basicCheck() {
    System.out.println(Upgrade.getTownhallLevel(driver));
    System.out.println(Upgrade.getFarmLevel(driver));
  }
}
