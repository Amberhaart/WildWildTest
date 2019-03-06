import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

  @Test
  public void openLogin() {
  System.setProperty("webdriver.gecko.driver", "/Users/Roland/Gecko-drivers/Mozilla/geckodriver");
  WebDriver driver = new FirefoxDriver();
  driver.manage().window().maximize();
  driver.get("http://localhost:3001/");
  }
}
