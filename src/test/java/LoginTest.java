import configuration.Config;
import keywords.Login;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

  protected static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(Config.url + "login/");
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void LoginTest() {
    Login.login(driver, Config.userName, Config.password);
    Assert.assertTrue(Login.validateLoggedInState(driver));
  }
}
