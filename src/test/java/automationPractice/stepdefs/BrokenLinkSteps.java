package automationPractice.stepdefs;

import automationPractice.com.Utils.BrowserFactory;
import automationPractice.com.pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BrokenLinkSteps {

    @Before
     public void startup(){
        BrowserFactory.startBrowser();
    }
    @After
            public void closeup(){
        BrowserFactory.stopBrowser();
    }
    HomePage homePage;

    @Given("^user is on home page$")
    public void user_is_on_home_page(){
        homePage=new HomePage();
       String title= homePage.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase("My Store"));


    }

    @When("^user clicks the \"([^\"]*)\"$")
    public void user_clicks_the_something(String links){
        switch (links){
            case"contact us":
                homePage.setContactUsLink();
                break;
            case"sign in":
                homePage.setSignInLink();
                break;
            case "women":
                homePage.setWomenLink();
                break;
            case "dresses":
                homePage.setDressesLink();
                break;
            case"t shirt":
                homePage.setTshirtsLink();
                break;
            case "cart":
                homePage.clickcart();
                break;
            case "top trends":
                homePage.setToptrendsImageLink();
                break;
            case "our stores":
                homePage.setOurStores();
                break;
            case"my orders":
                homePage.setMyOrders();
                break;
            case"youtube":
                homePage.setYoutubeLink();
                break;

        }


    }

    @Then("^user should be able to navigate to \"([^\"]*)\"$")
    public void user_should_be_able_to_navigate_to_something(String correctpage){
      Assert.assertTrue(homePage.getTitle().equalsIgnoreCase(correctpage));
    }

}
