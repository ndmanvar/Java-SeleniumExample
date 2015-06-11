import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.net.URL;

public class SampleSauceTest {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
    caps.setCapability(CapabilityType.VERSION, "11");
    caps.setCapability(CapabilityType.PLATFORM, "Windows 7");
    caps.setCapability("name", "Sauce Sample Test");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.amazon.com");
    WebElement element = driver.findElement(By.name("field-keywords"));

    element.sendKeys("Sauce Labs");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}
