package Tests;

import POM.Pages.HomePage;
import POM.Pages.MyProfilePage;
import POM.Pages.RegistrationPage;
import POM.Utils.GenerateRandom;
import POM.Utils.Waits;
import POM.Utils.WebDriverManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AllTets extends ConfigTest{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    MyProfilePage myProfilePage = new MyProfilePage();

    @Test
    public void test() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(),10);

        homePage.clickSignUpButton();

        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());
        registrationPage.enterEmail(data.get("email").asText());
        registrationPage.clickContinue();
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(),10);
        registrationPage.enterPassword("Password123");
        Waits.waitUnits(registrationPage.createAccount, WebDriverManager.getDriver(),10);
        registrationPage.clickCreateAccount();
        Waits.waitUnits(homePage.profileButton, WebDriverManager.getDriver(),10);
        homePage.clickProfileButton();
        Waits.waitUnits(homePage.yourAccountButton, WebDriverManager.getDriver(),10);
        homePage.clickYourAccountButton();

        myProfilePage.enterFirstName("Test");
        myProfilePage.enterLastName("TestTest");

        myProfilePage.clickUpdateButton();

        Assert.assertEquals(myProfilePage.clickUpdateinformatiopnAllert(), "Your changes have been saved!");

        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(),10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();
    }
    
    @Test
    public void test1() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(),10);

        homePage.clickSignUpButton();
//
//        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());
//        registrationPage.enterEmail(data.get("email").asText());
        registrationPage.enterEmail("mariami@gmail.com");
        registrationPage.clickContinue();
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(),10);
        registrationPage.enterPassword("Pass12345m");
        Waits.waitUnits(registrationPage.loginButton, WebDriverManager.getDriver(),10);
        registrationPage.clickLogin();
        Waits.waitUnits(homePage.profileButton, WebDriverManager.getDriver(),10);
        homePage.clickProfileButton();
        Waits.waitUnits(homePage.yourAccountButton, WebDriverManager.getDriver(),10);
        homePage.clickYourAccountButton();

        myProfilePage.enterFirstName("Test111");
        myProfilePage.enterLastName("TestTest111");

        myProfilePage.clickUpdateButton();

        Assert.assertEquals(myProfilePage.clickUpdateinformatiopnAllert(), "Your changes have been saved!");

    }
}
