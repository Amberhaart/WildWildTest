import configuration.Config;
import keywords.ChangeKingdomName;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChangeKingdomNameTest {
  private static WebDriver driver;
  String newKingdomName = "something123";
  String emptyKingdomName = "";
  String newLongKingdomName = "sometsafsgqer354rKJJHGJHGVsfghadfhjtzejhing123";

  @BeforeClass
  public static void initialize() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get(Config.url);
  }
  @Test
  public void canChangeKingdomName(){
    ChangeKingdomName.goToSettings(driver);
    ChangeKingdomName.editKingdomName(driver, newKingdomName);
    Assert.assertEquals(newKingdomName, ChangeKingdomName.getCurrentKingdomName(driver));
  }
}
