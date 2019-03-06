import configuration.Config;
import keywords.BuildBuildings;
import keywords.Login;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BuildBuildingsTest {

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
  public void checkSuccessfulMineBuild() {
    long initialBuildings = BuildBuildings.getBuildingsCount(driver);
    BuildBuildings.clickOnMine(driver);
    BuildBuildings.waitUntilBuildingFinishes(driver);
    long currentBuildings = BuildBuildings.getBuildingsCount(driver);
    Assert.assertEquals(initialBuildings + 1, currentBuildings);
    Assert.assertEquals(BuildBuildings.getNewBuildingName(driver), "Mine");
  }

  @Test
  public void checkSuccessfulFarmBuild() {
    long initialBuildings = BuildBuildings.getBuildingsCount(driver);
    BuildBuildings.clickOnFarm(driver);
    BuildBuildings.waitUntilBuildingFinishes(driver);
    long currentBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(currentBuildings);
    Assert.assertEquals(initialBuildings + 1, currentBuildings);
    Assert.assertEquals(BuildBuildings.getNewBuildingName(driver), "Farm");
  }

  @Test
  public void checkSuccessfulAcademyBuild() {
   long initialBuildings = BuildBuildings.getBuildingsCount(driver);
    BuildBuildings.clickOnAcademy(driver);
    BuildBuildings.waitUntilBuildingFinishes(driver);
    long currentBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(currentBuildings);
    Assert.assertEquals(initialBuildings + 1, currentBuildings);
    Assert.assertEquals(BuildBuildings.getNewBuildingName(driver), "Academy");
  }
}
