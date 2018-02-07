package automationPractice.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static WebDriver driver;

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public String geturl(){
        return driver.getCurrentUrl();
    }

}
