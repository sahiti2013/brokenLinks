package automationPractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class HomePage extends BasePage {
    @FindBy(css="#contact-link")
    WebElement contactUsLink;
    @FindBy(css=".login")
    WebElement signInLink;
    @FindBy(xpath="//a[text()='Women']")
    WebElement womenLink;
    @FindBy(xpath="//div[@id='block_top_menu']/ul/li[2]/a")
    WebElement DressesLink;
    @FindBy(xpath="//div[@id='block_top_menu']/ul/li[3]/a")
    WebElement TshirtsLink;
    @FindBy(xpath="//div[@id='htmlcontent_home']/ul/li[1]/a/img")
    WebElement ToptrendsImageLink;
    @FindBy(xpath="//section[@id='social_block']/ul/li[3]/a")
    WebElement YoutubeLink;
    @FindBy(linkText="Our stores")
    WebElement ourStores;
    @FindBy(linkText = "My orders")
    WebElement myorders;
@FindBy (xpath="//*[@id='header']/div[3]/div/div/div[3]/div/a/b")
WebElement cartLink;
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void setContactUsLink(){
        contactUsLink.click();
    }

    public void setSignInLink() {
        signInLink.click();

    }
    public void setWomenLink(){
        womenLink.click();
    }
    public void setDressesLink(){
        DressesLink.click();
    }
    public void setTshirtsLink(){
        TshirtsLink.click();
    }
    public void setToptrendsImageLink(){
        ToptrendsImageLink.click();
    }
    public void setYoutubeLink(){
        YoutubeLink.click();
        Set<String> windows=driver.getWindowHandles();
        Object[] handles=windows.toArray();
        String currentWindow=handles[0].toString();
        String youtubeWindow=handles[1].toString();
        driver.switchTo().window(youtubeWindow);
        System.out.println(driver.getTitle());
    }
    public void setOurStores(){
        ourStores.click();
    }
    public void setMyOrders(){
        myorders.click();
    }

    public void clickcart() {
        cartLink.click();
    }
}
