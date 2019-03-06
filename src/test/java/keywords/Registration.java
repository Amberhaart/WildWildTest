package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configuration.Config;


public class Registration {
  public static void clickOnRegisterButton(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver,Config.timeOutInSeconds);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/header/nav/button[@name=\"/register\"]"))).click();
  }

  public static void getUserNameField(WebDriver driver){

  }
}
