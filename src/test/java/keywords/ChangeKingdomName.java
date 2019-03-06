package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeKingdomName {

  public static void goToSettings(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/header/nav/button[1]"))).click();
  }
  public static void editKingdomName(WebDriver driver, String newName){
    WebDriverWait wait = new WebDriverWait(driver,Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/section/form/input"))).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/section/form/input"))).sendKeys(newName);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/section/form/button/text()"))).click();
  }
  public static String getCurrentKingdomName(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("navtitle"))).getAttribute("value");
  }
}
