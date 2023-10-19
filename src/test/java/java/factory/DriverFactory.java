package java.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import utils.CommonUtils;

import java.time.Duration;

public class DriverFactory {

    static WebDriver driver;

    public static WebDriver initializeBrowser(String browserName) {

        if (browserName.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
          //  option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            option.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(option);
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
