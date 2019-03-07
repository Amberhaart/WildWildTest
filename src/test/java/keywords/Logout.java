package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {

  public static void logout(WebDriver driver) {
    WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div/header/nav/button[2]"));
    logoutBtn.click();
  }

  public static Boolean isLoggedOut(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);
    WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/form/button")));
    return (loginBtn.getText().equals("LOGIN"));
  }
}
