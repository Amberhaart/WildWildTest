import configuration.Config;
import keywords.Login;
import keywords.Logout;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

  protected static WebDriver driver;
  protected static String falseUsername = "Trükkös hekker";
  protected static String falsePassword = "kamujelszó";

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

  @After
  public void reset() {
    Login.clearInputFields(driver);
  }

  @Test
  public void LoginWithValidCredentials() {
    Login.login(driver, Config.userName, Config.password);
    Assert.assertTrue(Login.validateLoggedInState(driver));
    Logout.logout(driver);
  }

  @Test
  public void LoginWithInvalidUsername() {
    Login.login(driver, falseUsername, falsePassword);
    Assert.assertEquals("No such user: " + falseUsername + "!", Login.validateErrorMessage(driver));
  }

  @Test
  public void LoginWithInvalidPassword() {
    Login.login(driver, Config.userName, falsePassword);
    Assert.assertEquals("Wrong password!", Login.validateErrorMessage(driver));
  }

  @Test
  public void LoginWithNoPassword() {
    Login.login(driver, Config.userName, "");
    Assert.assertEquals("Please fill out password!", Login.validateErrorMessage(driver));
  }

  @Test
  public void LoginWithNoUsername() {
    Login.login(driver, "", Config.password);
    Assert.assertEquals("Please fill out username!", Login.validateErrorMessage(driver));
  }
}