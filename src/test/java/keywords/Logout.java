package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {

  public static void logout(WebDriver driver) {
    WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div/header/nav/button[2]"));
    logoutBtn.click();
  }

  public static Boolean isLoggedOut(WebDriver driver) {
    WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
    return (loginBtn.getText() == "Login");
  }
}
