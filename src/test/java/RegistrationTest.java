import configuration.Config;
import keywords.Registration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
  static WebDriver driver;
  final private String kingdomName = "TestKingdom";
  final private long myTimeStamp = Registration.getTimeStamp(driver);
  final private String myUsername = "name"+ myTimeStamp;

  @BeforeClass
  public static void setUp(){
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get(Config.url);
  }

  @Test
  public void registrationTest(){
    Registration.register(driver, myUsername, kingdomName);
  }
}
