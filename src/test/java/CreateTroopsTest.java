import configuration.Config;
import keywords.CreateTroops;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTroopsTest {
  private static WebDriver driver;
  String numberOfTroops = "1";
  String numberOfMaxTroops = "21";

  @BeforeClass
  public static void initialize() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get(Config.url);
  }
  @Test
  public void canAddTroops(){
    int currentGoldNumber = Integer.parseInt(CreateTroops.getAmountOfCurrentGold(driver));
    CreateTroops.goToAcademy(driver);
    CreateTroops.createTroops(driver, Integer.parseInt(numberOfTroops));
    Assert.assertNotEquals(currentGoldNumber, currentGoldNumber-10);
    Assert.assertEquals(numberOfTroops, CreateTroops.checkCreatedTroops(driver));
  }
  @Test
  public void maxNumberOfTroops(){
    CreateTroops.goToAcademy(driver);
    CreateTroops.createTroops(driver, Integer.parseInt(numberOfMaxTroops));
    Assert.assertEquals(numberOfMaxTroops, CreateTroops.checkCreatedTroops(driver));
  }
  @Test
  public void overMaxNumberOfTroops(){
    CreateTroops.goToAcademy(driver);
    CreateTroops.createTroops(driver, Integer.parseInt(numberOfMaxTroops)+1);
    Assert.assertNotEquals(numberOfMaxTroops, CreateTroops.checkCreatedTroops(driver));
  }
}
