import configuration.Config;
import keywords.ConstructionLog;
import keywords.Login;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConstructionLogTest {
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
  public void progressTrackIsVisibleTest() {
    ConstructionLog.clickOnAddFarmBtn(driver);
    Assert.assertTrue(ConstructionLog.progressTrackIsVisible(driver));
  }

  @Test
  public void constructionLogUpdatedTest() {
    String constructionTimeBeforeAddNewBuilding = ConstructionLog.getLastConstructionTime(driver);
    System.out.println(constructionTimeBeforeAddNewBuilding);
    ConstructionLog.clickOnAddFarmBtn(driver);
    try {
      Thread.sleep(31000);
    } catch (Exception e) {
    }
    String constructionTimeAfterAddNewBuilding = ConstructionLog.getLastConstructionTime(driver);
    System.out.println(constructionTimeAfterAddNewBuilding);
    Assert.assertNotEquals(constructionTimeAfterAddNewBuilding, constructionTimeBeforeAddNewBuilding);
  }
}
