package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildTime {

  public static String getReadyByTime(WebDriver driver) {
    String readyByTimeString;
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement readyByTime = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/div[2]/div/div[2]/div/div[1]/p")));
    readyByTimeString = readyByTime.getText();
    System.out.println(readyByTimeString);
    return readyByTimeString;
  }
}
