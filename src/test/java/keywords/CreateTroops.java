package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

  public static int checkCreatedTroops(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement troopsTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[1]/div[1]/div[2]")));
    troopsTab.click();
    if (elementIsPresent(driver)) {
      WebElement createTroopBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/form/button")));
      String numberOfTroops = createTroopBtn.getText();
      int space = numberOfTroops.indexOf(' ');
      return Integer.parseInt(numberOfTroops.substring(0, space));
    }
    return 0;
  }

  public static boolean elementIsPresent(WebDriver driver) {
    try {
      driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[2]/form/button"));
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public static void waitToCreateTroops() {
    try {
      Thread.sleep(25000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}