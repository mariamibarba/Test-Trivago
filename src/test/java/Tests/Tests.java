package Tests;
import POM.Pages.HomePage;
import POM.Pages.HotelsPage;
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

import static org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data;

public class Tests extends ConfigTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    MyProfilePage myProfilePage = new MyProfilePage();
    HotelsPage hotelsPage = new HotelsPage();


    @Test
    public void registrationRandomTest() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(),10);
        homePage.clickSignUpButton();
        Assert.assertEquals(registrationPage.checkPageTitle(), "Unlock more savings as a member");
        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());
        registrationPage.enterEmail(data.get("email").asText());
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkPageTitlePassword(), "Create a password for your new account");
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(),10);
        registrationPage.enterPassword("Password123");
        Waits.waitUnits(registrationPage.createAccount, WebDriverManager.getDriver(),10);
        registrationPage.clickCreateAccount();
        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(),10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();
    }
    @Test
    public void registrationTest2() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(),10);
        homePage.clickSignUpButton();
        registrationPage.enterEmail("mariami@gmail.com");
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkPageTitleEnterPassword(), "Enter your password");
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(),10);
        registrationPage.enterPassword("Pass12345m");
        Waits.waitUnits(registrationPage.loginButton, WebDriverManager.getDriver(),10);
        registrationPage.clickLogin();
        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(),10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();

    }

    @Test
    public void changeProfileData() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(),10);
        homePage.clickSignUpButton();
        registrationPage.enterEmail("mariami@gmail.com");
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkPageTitleEnterPassword(), "Enter your password");
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
        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(),10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();


    }
    @Test
    public void searchCity() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(),10);
        homePage.clicklocationfilld("Batumi");
        homePage.clickSearchButton();
    }
    @Test
    public void searchHotel() throws InterruptedException {
        homePage.clicklocationfilld("Batumi");
        homePage.clickchooseDate();
        homePage.testSelectDates();
        homePage.setQuantityOfAdults(2);
        homePage.clickapplyButton();
        homePage.clickSearchButton();
    }


}
