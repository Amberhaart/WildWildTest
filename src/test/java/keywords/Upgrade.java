package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

  public static int getUpgradedTownhallLevel(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    String levelText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[1]/div[1]/div/p[2]"))).getText();
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

  public static int getUpgradedFarmLevel(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    String levelText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[1]/div[1]/div/p[2]"))).getText();
    String substringedlevelText = levelText.substring(6, levelText.length());
    int buildingLevel = Integer.parseInt(substringedlevelText);
    return buildingLevel;
  }

  public static void upgradeTownhall(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[1]/div[1]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/button"))).click();
  }

  public static void upgradeFarm(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[1]/div[2]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/button"))).click();
  }

  public static void waitUntilUpgradeFinishes(WebDriver driver) {
    try {
      Thread.sleep(31000);
    } catch (Exception e) {
    }
  }

  public static void tryToUpgradeFarmBeyondTownhall(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    int farmAndTownhallLevelDifference = getTownhallLevel(driver) - getFarmLevel(driver);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div[1]/div[2]"))).click();

    for (int i = 0; i <= farmAndTownhallLevelDifference - 1; i++) {
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/button"))).click();
      waitUntilUpgradeFinishes(driver);
    }
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/button"))).click();
  }

  public static boolean errorMessageWhenTryingToUpgradeBeyondTownhall(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]")));
    return errorMessage.isDisplayed();
  }

  public static void goToBuildings(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[1]/div[1]/div[1]"))).click();
  }
}
