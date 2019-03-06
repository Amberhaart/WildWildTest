package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class BuildTime {

  public static String getReadyByTime(WebDriver driver) {
    String readyByTimeString;
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement readyByTime = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/main/div/div[2]/div/div[2]/div/div[1]/p")));
    readyByTimeString = readyByTime.getText();
    return readyByTimeString.substring(12, 20);
  }

  public static String getCalculatedReadyByTime() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.SECOND, 15);
    return calendar.getTime().toString().substring(11, 19);
  }
}
