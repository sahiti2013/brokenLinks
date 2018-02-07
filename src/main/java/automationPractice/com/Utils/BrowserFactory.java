package automationPractice.com.Utils;

import automationPractice.com.pages.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory extends BasePage {

    public static void startBrowser(){
        String path=System.getProperty("user.dir")+"/src/main/resources/";
        if(AutomationConstants.REMOTE_BROWSER==true){
            System.out.println("selenium grid is running");
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setBrowserName("Chrome");
            caps.setPlatform(Platform.WIN10);
            caps.setVersion("");
            try {
                driver=new RemoteWebDriver(new URL(AutomationConstants.GRID_URL),caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        else {
            if (AutomationConstants.BROWSERTYPE.equalsIgnoreCase("Chrome")){
                System.setProperty("webdriver.chrome.driver",path+"chromedriver1.exe");
                driver=new ChromeDriver();
            }
            else if(AutomationConstants.BROWSERTYPE.equalsIgnoreCase("Firefox")){
                System.setProperty("webdriver.gecko.driver",path+"geckodriver.exe");
                driver=new FirefoxDriver();
            }
            else if (AutomationConstants.BROWSERTYPE.equalsIgnoreCase("IE")){
                System.setProperty("webdriver.ie.driver",path+"MicrosoftWebDriver");
                driver = new InternetExplorerDriver();
            }
        }
        driver.get(AutomationConstants.BASEURL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

public static void stopBrowser() {
    if (driver != null) {
        driver.close();
        driver.quit();
    }
}
        public static WebDriver getBrowser(){
            if(driver==null){
                BrowserFactory.startBrowser();

            }
            return driver;
    }

}

