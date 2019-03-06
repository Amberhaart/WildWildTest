package keywords;

import enums.ResourceNameEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResourceGeneration {

  public static int getResourceCount (WebDriver driver, ResourceNameEnum resourceNameEnum) {
    if (resourceNameEnum.getResourceName() == "pineapple") {
      return Integer.parseInt(driver.findElement(By.xpath("/html/body/div/main/div/div[1]/div[1]/div[2]/div[1]/ul/li[1]/span")).getText());
    }
    return Integer.parseInt(driver.findElement(By.xpath("/html/body/div/main/div/div[1]/div[1]/div[2]/div[2]/ul/li[1]/span")).getText());
  }
}
