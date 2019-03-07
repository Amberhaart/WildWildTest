import configuration.Config;
import keywords.Login;
import keywords.Registration;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
  static WebDriver driver;
  final private String kingdomName = "TestKingdom";
  final private long myTimeStamp = Registration.getTimeStamp(driver);
  final private String myUniqueUsername = "name" + myTimeStamp;
  final private int timeOut = 10;
  final private String registrationAssertUrl = "http://localhost:3001/map";

  @BeforeClass
  public static void setUp() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
  }

  @Before
  public void getUrl() {
    driver.get(Config.url);
  }

  @AfterClass
  public static void tearDown(){
    driver.quit();
  }
  @Test
  public void reachMapAfterRegistration() {
    Registration.register(driver, myUniqueUsername, kingdomName);
    Assert.assertEquals(Registration.getUrl(driver, timeOut), registrationAssertUrl);
  }

  @Test
  public void canLoginAfterRegistration() {
    Registration.register(driver, myUniqueUsername, kingdomName);
    driver.get(Config.url + "login");
    Login.login(driver, myUniqueUsername, Config.password);
    Assert.assertTrue(Login.validateLoggedInState(driver));
  }

  @Test
  public void cannotRegisterWithUsedUsername() {
    Registration.register(driver, Config.userName, kingdomName);
    Assert.assertTrue(Registration.registErrorAllertIsVisible(driver));
  }
}
