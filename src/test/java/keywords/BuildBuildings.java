package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildBuildings {

  public static Long getBuildingsCount(WebDriver driver) {
    try {
      Thread.sleep(2000);
    } catch (Exception e) {
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Long childElementCount = (Long) js.executeScript("return document.getElementsByClassName(\"mybuildings\")[0].childElementCount");
    return childElementCount;
  }

  public static void clickOnFarm(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[2]/div[1]"))).click();
  }

  public static void clickOnAcademy(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[2]/div[2]"))).click();
  }

  public static void clickOnMine(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[2]/div[3]"))).click();
  }

  public static void waitUntilBuildingFinishes(WebDriver driver) {
    try {
      Thread.sleep(16000);
    } catch (Exception e) {
    }
  }

}
