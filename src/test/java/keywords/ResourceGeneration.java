package keywords;

import configuration.Config;
import enums.ResourceNameEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ResourceGeneration {

  public static int getResourceCount (WebDriver driver, ResourceNameEnum resourceNameEnum) throws InterruptedException {
    WebElement resourceCount;
    int resourceCountInt;
    driver.manage().timeouts().implicitlyWait(Config.timeOutInSeconds, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    Thread.sleep(1000);
    if (resourceNameEnum.getResourceName() == "pineapple") {
      resourceCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/div[1]/div[1]/div[2]/div[1]/ul/li[1]/span")));
    } else {
      resourceCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/div[1]/div[1]/div[2]/div[2]/ul/li[1]/span")));
    }
    resourceCountInt = Integer.parseInt(resourceCount.getText());
    return resourceCountInt;
  }
}
