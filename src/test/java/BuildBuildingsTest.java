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
    System.out.println(initialBuildings);
    BuildBuildings.clickOnMine(driver);
    BuildBuildings.waitUntilBuildingFinishes(driver);
    long currentBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(currentBuildings);
    Assert.assertEquals(initialBuildings + 1, currentBuildings);
  }

  @Test
  public void checkSuccessfulFarmBuild() {
    long initialBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(initialBuildings);
    BuildBuildings.clickOnFarm(driver);
    BuildBuildings.waitUntilBuildingFinishes(driver);
    long currentBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(currentBuildings);
    Assert.assertEquals(initialBuildings + 1, currentBuildings);
  }

  @Test
  public void checkSuccessfulAcademyBuild() {
    long initialBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(initialBuildings);
    BuildBuildings.clickOnAcademy(driver);
    BuildBuildings.waitUntilBuildingFinishes(driver);
    long currentBuildings = BuildBuildings.getBuildingsCount(driver);
    System.out.println(currentBuildings);
    Assert.assertEquals(initialBuildings + 1, currentBuildings);
  }
}
