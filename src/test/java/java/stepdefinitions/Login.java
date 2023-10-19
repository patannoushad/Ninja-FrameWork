package java.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


import java.factory.DriverFactory;
import java.util.Properties;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	Properties prop = new Properties();
	
	@Given("^User navigates to login page$")
	public void user_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
		
	}
	
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		
		loginPage.enterEmailAddress(emailText);

	}
	
	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
	    
		loginPage.enterPassword(passwordText);
		
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() {
	    
		accountPage = loginPage.clickOnLoginButton();
		
	}

	@Then("^User should get successfully logged in$")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	    
	}

	@When("^User enters invalid email address into email field$")
	public void user_enters_invalid_email_address_into_email_field() throws InterruptedException {
			    
	//	commonUtils = new CommonUtils();
	//	loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());

		loginPage.enterEmailAddress(prop.getProperty("invalidEmail"));

		System.out.println("-------"+ prop.getProperty("invalidEmail")+ "-----------------------------");

		Thread.sleep(3000);
	}

	@And("^User enters invalid password into password field$")
	public void user_enters_invalid_password_into_password_field() {
	    
		loginPage.enterPassword(prop.getProperty("invalidPswd"));

		System.out.println("-------"+ prop.getProperty("invalidPswd")+ "-----------------------------");


	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	  
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
	    
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	    
		loginPage.enterPassword("");
		
	}
}
//-------------------------------------------------------------------->
/*
package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;


public class LoginNoushad {


    WebDriver driver;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private CommonUtils commonUtils;

    Properties prop = new ConfigReader().intializeProperties();

    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {

        driver = DriverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        loginPage = homePage.selectLoginOption();

    }

//    @When("^User enters valid email (.+) into email_the_field$")
//    public void User_enters_valid_email_into_email_the_field(String emailText) {
//
//      //  loginPage.enterEmailAddress(emailText);
//    }

//    @And("^User enters valid password (.+) into the password field$")
//    public void user_enters_valid_password_into_the_password_field(String passwordText) {
//
//       // loginPage.enterPassword(passwordText);
//    }

    @And("User clicks on Login button on page")
    public void user_clicks_on_login_button_on_page() {

        accountPage = loginPage.clickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("User should get successfully loggedin")
    public void user_should_get_successfully_loggedin() {

        Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
    }

    @When("User gives (.*) in field")
    public void User_gives_Condition_in_field(String val) {

        //InvalidEmail
        if(val.equals("invalidEmail") ){

            loginPage.enterEmailAddress(prop.getProperty("invalidEmail"));
            loginPage.enterPassword(prop.getProperty("validPswd"));
        }
        //InvalidPassword
        else if (val.equals("invalidPassword")) {
            loginPage.enterEmailAddress(prop.getProperty("validEmail"));
            loginPage.enterPassword(prop.getProperty("invalidPswd"));
        }
        //emptyEmail
        else if (val.equals("emptyEmail")) {
            loginPage.enterEmailAddress(" ");
            loginPage.enterPassword(prop.getProperty("invalidPswd"));
        }
        //emptyPassword
        else if (val.equals("emptyPassword")) {
            loginPage.enterEmailAddress(prop.getProperty("validEmail"));
            loginPage.enterPassword(" ");
        }
        //emptyCredential
        else if (val.equals("emptyCredential")) {
            loginPage.enterEmailAddress(" ");
            loginPage.enterPassword(" ");
        }
    }
    @Then("User should get a warning message about credentials mismatch")
    public void user_should_get_a_warning_message_about_credentials_mismatch() {

        Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

    }

}
------------------------------------------------------------------>
Feature: LoginNoushad functionalitys


  @positive_testcase
  Scenario: Login with valid credential
    Given User navigate to login page
    When User enters valid email amotooricap1@gmail.com into the email field
    And User enters valid password 12345 into the password field
    And User clicks on Login button on page
    Then User should get successfully loggedin


  @negative_testcase
  Scenario Outline: Login with invalid credential
    Given User navigate to login page
    When User gives <condition> in field
    And User clicks on Login button on page
    Then User should get a warning message about credentials mismatch
    Examples:
      |    condition	 |
      | invalidEmail     |
      | invalidPassword  |
#      | emptyEmail       |
#      | emptyPassword    |
#      | emptyCredential  |


 */