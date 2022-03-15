package simple;

import com.google.common.io.Resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import simple.config.TestConfigFactory;

public class WebDriverFactory {
    private static TestConfigFactory config = TestConfigFactory.getInstance();

    public static WebDriver getWebDriver() {
        switch (config.getWebConfig().getBrowser()) {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
            default:
                return getChromeDriver();
        }
    }

    private static ChromeDriver getChromeDriver() {
        String chromeBinaryName;

        switch(System.getProperty("os.name").toLowerCase()){
            case "mac os x":
            default:
                chromeBinaryName = "chromedriver";
                break;
            case "windows 7":
                chromeBinaryName = "chromedriver.exe";
                break;
        }

        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver").getPath());
        //System.setProperty("webdriver.chrome.driver", "/home/liana/IdeaProjects/selenium-example-1/target/test-classes/chromedriver");
        return new ChromeDriver();
    }

    public enum Browser{
        CHROME,FIREFOX
    }
}
