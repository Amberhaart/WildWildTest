import configuration.Config;
import keywords.Registration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
  static WebDriver driver;
  final private String kingdomName = "TestKingdom";

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
    Registration.clickOnRegisterBtn(driver);
    Registration.fillUserNameField(driver);
    Registration.fillPassword(driver);
    Registration.fillKingdomName(driver, kingdomName);
    Registration.clickOnSignUpBtn(driver);
  }
}
