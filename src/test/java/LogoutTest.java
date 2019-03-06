import configuration.Config;
import keywords.Logout;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogoutTest {

  private static WebDriver driver;

  @BeforeClass
  public static void initialize() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
  }

  @Before
  public void setUp() {
    driver.get(Config.url); // instead of this line here comes the login method
  }

  @AfterClass
  public static void tearDown(){
    driver.quit();
  }

  @Test
  public void logout(){
    Logout.logout(driver);
    Assert.assertTrue(Logout.isLoggedOut(driver));
  }
}
