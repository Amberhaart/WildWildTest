import configuration.Config;
import keywords.ChangeKingdomName;
import keywords.Login;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChangeKingdomNameTest {
  private static WebDriver driver;
  String newKingdomName = "something12";
  String emptyKingdomName = "";

  @BeforeClass
  public static void initialize() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get(Config.url  + "login/");
    Login.login(driver, Config.userName, Config.password);
  }
  @Test
  public void canChangeKingdomName(){
    ChangeKingdomName.goToSettings(driver);
    ChangeKingdomName.editKingdomName(driver, newKingdomName);
    driver.get("http://localhost:3001/kingdom/buildings");
    Assert.assertEquals(newKingdomName, ChangeKingdomName.getCurrentKingdomName(driver));
  }
  @Test
  public void canChangeToEmptyKingdomName(){
    ChangeKingdomName.goToSettings(driver);
    ChangeKingdomName.editKingdomName(driver, emptyKingdomName);
    Assert.assertEquals("Empty input! Enter a name!", ChangeKingdomName.getErrorMessage(driver));
    driver.get("http://localhost:3001/kingdom/buildings");
    Assert.assertEquals(newKingdomName, ChangeKingdomName.getCurrentKingdomName(driver));
  }
}
