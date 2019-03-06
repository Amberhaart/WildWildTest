package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Upgrade {

  public static int getTownhallLevel(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    String levelText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[1]/div[1]/p[2]"))).getText();
    String substringedlevelText = levelText.substring(6, levelText.length());
    int buildingLevel = Integer.parseInt(substringedlevelText);
    return buildingLevel;
  }

  public static int getFarmLevel(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    String levelText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[1]/div[2]/p[2]"))).getText();
    String substringedlevelText = levelText.substring(6, levelText.length());
    int buildingLevel = Integer.parseInt(substringedlevelText);
    return buildingLevel;
  }
}
