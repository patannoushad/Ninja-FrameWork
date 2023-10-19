package java.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;

import java.factory.DriverFactory;

public class EndtoEnd {
    WebDriver driver;
    @Given("User opens the Applications")
    public void user_opens_the_application() {
        //  driver = DriverFactory.getDriver();

    }

    @When("User Add Product to Cart")
    public void User_Add_Product_to_Cart()  {
        AccountPage accountPage=new AccountPage(DriverFactory.getDriver());
        accountPage.dropdownComponent();
        accountPage.selectMonitor();
        System.out.println("When ======"+driver);
    }

    @Then("User should Verify Total Amount")
    public void User_should_Verify_Total_Amount(){
        System.out.println("Then -======="+driver);

    }

    @When("User Add MacBook and IPhone to Cart")
    public void User_Add_MacBook_and_IPhone_to_Cart(){
        AccountPage accountPage=new AccountPage(driver);
        accountPage.MacBookAddtoCart();
        accountPage.iPhoneAddtoCart();
        accountPage.viewCartLink();
    }
    @And("User Selected View Cart")
    public void User_Selected_View_Cart(){
        AccountPage accountPage=new AccountPage(DriverFactory.getDriver());
        accountPage.cartButton();
        accountPage.viewCartLink();
    }
    @Then("User should Verify Product Name")
    public void User_should_Verify_Product_Name(){
    }
}
