import configuration.Config;
import keywords.BuildBuildings;
import keywords.BuildTime;
import keywords.Login;
import keywords.Logout;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BuildTimeTest {

  private static WebDriver driver;

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
  public static void tearDown(){
    Logout.logout(driver);
    driver.quit();
  }

  @Test
  public void farmBuildTime() {
    BuildBuildings.clickOnFarm(driver);
    String readyByTime = BuildTime.getReadyByTime(driver);
    String calculatedReadyByTime = BuildTime.getCalculatedReadyByTime();
    Assert.assertEquals(readyByTime, calculatedReadyByTime);
  }

  @Test
  public void academyBuildTime() {
    BuildBuildings.clickOnAcademy(driver);
    String readyByTime = BuildTime.getReadyByTime(driver);
    String calculatedReadyByTime = BuildTime.getCalculatedReadyByTime();
    Assert.assertEquals(readyByTime, calculatedReadyByTime);
  }

  @Test
  public void mineBuildTime() {
    BuildBuildings.clickOnMine(driver);
    String readyByTime = BuildTime.getReadyByTime(driver);
    String calculatedReadyByTime = BuildTime.getCalculatedReadyByTime();
    Assert.assertEquals(readyByTime, calculatedReadyByTime);
  }
}
