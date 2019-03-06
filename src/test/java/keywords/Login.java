package keywords;

import configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

  public static void login(WebDriver driver, String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/form/input[1]")));
    usernameInput.sendKeys(username);

    WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/form/input[2]")));
    passwordInput.sendKeys(password);

    WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div/form/button")));
    loginBtn.click();
  }

  public static boolean validateLoggedInState(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Config.timeOutInSeconds);

    WebElement logoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/header/nav/button[2]")));

    return logoutBtn.isDisplayed();
  }

}
