import configuration.Config;
import keywords.CreateTroops;
import keywords.Login;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTroopsTest {
  private static WebDriver driver;
  int numberOfTroops = 1;
  int numberOfMaxTroops = 10;

  @BeforeClass
  public static void initialize() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get(Config.url + "login/");
    Login.login(driver, Config.userName, Config.password);
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void canAddTroops() {
    int currentTroopsNumber = CreateTroops.checkCreatedTroops(driver);
    driver.get("http://localhost:3001/kingdom/buildings");
    CreateTroops.goToAcademy(driver);
    CreateTroops.createTroops(driver, numberOfTroops);
    CreateTroops.waitToCreateTroops();
    Assert.assertEquals(currentTroopsNumber + numberOfTroops, CreateTroops.checkCreatedTroops(driver));
  }

  @Test
  public void overMaxNumberOfTroops() {
    int currentTroopsNumber = CreateTroops.checkCreatedTroops(driver);
    driver.get("http://localhost:3001/kingdom/buildings");
    CreateTroops.goToAcademy(driver);
    CreateTroops.createTroops(driver, numberOfMaxTroops);
    CreateTroops.waitToCreateTroops();
    Assert.assertNotEquals(currentTroopsNumber + numberOfMaxTroops, CreateTroops.checkCreatedTroops(driver));
  }
}
