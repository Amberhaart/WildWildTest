package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ConstructionLog {
  public static void clickOnAddFarmBtn(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[2]/div[1]"))).click();
  }

  public static boolean progressTrackIsVisible(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement progressTrack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"app\"]//div[@class=\"progresstrack\"]//div[@class=\"displayprogress\"]")));
    return progressTrack.isDisplayed();
  }

  public static String getLastConstructionTime(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/div[2]/div/div[2]/div/div[1]/p"))).getText();
  }
}
