import configuration.Config;
import keywords.BuildBuildings;
import keywords.Login;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConstructionLogOverflowTest {

  protected static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get(Config.url + "login/");
    Login.login(driver, Config.userName, Config.password);
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void IsOverflowingConstructionLogStillCreateRequestedBuildings() {
    Long initialBuildingCount = BuildBuildings.getBuildingsCount(driver);
    for (int i = 0; i <= 6; i++) {
      BuildBuildings.clickOnMine(driver);
    }
    BuildBuildings.waitUntilBuildingFinishes(driver);
    Long currentBuildingCount = BuildBuildings.getBuildingsCount(driver);
    Assert.assertTrue(initialBuildingCount + 7 == currentBuildingCount);
  }
}
