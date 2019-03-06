package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configuration.Config;

import java.sql.Timestamp;


public class Registration {
  public static void clickOnRegisterBtn(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/header/nav/button[@name=\"/register\"]"))).click();
  }

  public static long getTimeStamp(WebDriver driver) {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    return timestamp.getTime();
  }

  public static void fillUserNameField(WebDriver driver, String myUserName) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement userNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"app\"]//form//input[@name=\"username\"]")));
    userNameField.clear();
    userNameField.sendKeys(myUserName);
  }

  public static void fillPassword(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"app\"]//form//input[@name=\"password\"]")));
    passwordField.clear();
    passwordField.sendKeys(Config.password);
  }

  public static void fillKingdomName(WebDriver driver, String kingdomName) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement kingdomNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"app\"]//form//input[@name=\"kingdom\"]")));
    kingdomNameField.clear();
    kingdomNameField.sendKeys(kingdomName);
  }

  public static void clickOnSignUpBtn(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/form/button"))).click();
  }

  public static void register(WebDriver driver, String myUsername, String kingdomName) {
    clickOnRegisterBtn(driver);
    fillUserNameField(driver, myUsername);
    fillPassword(driver);
    fillKingdomName(driver, kingdomName);
    clickOnSignUpBtn(driver);
  }
}
