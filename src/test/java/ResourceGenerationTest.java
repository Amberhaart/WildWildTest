import configuration.Config;
import enums.ResourceNameEnum;
import keywords.Login;
import keywords.Logout;
import keywords.ResourceGeneration;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ResourceGenerationTest {

  private static WebDriver driver;

  @BeforeClass
  public static void initialize() {
    System.setProperty(Config.webDriverName, Config.webDriverPath);
    driver = new FirefoxDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.get(Config.url + "login/");
    Login.login(driver);
  }

  @AfterClass
  public static void tearDown(){
    Logout.logout(driver);
    driver.quit();
  }

  @Test
  public void pineappleGeneration() throws InterruptedException {
    int pineappleCountBefore = ResourceGeneration.getResourceCount(driver, ResourceNameEnum.PINEAPPLE);
    TimeUnit.MINUTES.sleep(1);
    int pineappleCountAfter = ResourceGeneration.getResourceCount(driver, ResourceNameEnum.PINEAPPLE);
    Assert.assertTrue(pineappleCountAfter == pineappleCountBefore + 1);
  }

  @Test
  public void coinGeneration() throws InterruptedException {
    int coinCountBefore = ResourceGeneration.getResourceCount(driver, ResourceNameEnum.COIN);
    TimeUnit.MINUTES.sleep(1);
    int coinCountAfter = ResourceGeneration.getResourceCount(driver, ResourceNameEnum.COIN);
    Assert.assertTrue(coinCountAfter == coinCountBefore + 1);
  }
}
