package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTroops {
  public static void goToAcademy(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement academy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[1]/div[4]/img")));
    Actions actions = new Actions(driver);
    actions.moveToElement(academy);
    academy.click();
  }

  public static void createTroops(WebDriver driver, Integer numberOfExpectedTroops) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement createTroopBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/button[1]/div/span[1]")));
    for (int i = 0; i < numberOfExpectedTroops; i++) {
      createTroopBtn.click();
    }
  }

  public static String checkCreatedTroops(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement troopsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[1]/div[1]/div[2]")));
    troopsTab.click();
    WebElement upgradeBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/form/button")));
    return upgradeBtn.getAttribute("value");
  }

  public static String getAmountOfCurrentGold(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement numberOfGold = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[1]/div[2]/div[2]/ul/li[1]/span")));
    return numberOfGold.getAttribute("value");
  }
}