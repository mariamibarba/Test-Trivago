package Tests;

import POM.Pages.HomePage;
import POM.Pages.HotelsPage;
import POM.Pages.MyProfilePage;
import POM.Pages.RegistrationPage;
import POM.Utils.GenerateRandom;
import POM.Utils.Waits;
import POM.Utils.WebDriverManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    MyProfilePage myProfilePage = new MyProfilePage();
    HotelsPage hotelsPage = new HotelsPage();


    @Test(priority = 1,groups = "Positive")
    public void registrationRandomTest() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(), 10);
        homePage.clickSignUpButton();
        Assert.assertEquals(registrationPage.checkPageTitle(), "Unlock more savings as a member");
        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());
        registrationPage.enterEmail(data.get("email").asText());
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkPageTitlePassword(), "Create a password for your new account");
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(), 10);
        registrationPage.enterPassword("Password123");
        Waits.waitUnits(registrationPage.createAccount, WebDriverManager.getDriver(), 10);
        registrationPage.clickCreateAccount();
        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(), 10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();
    }

    @Test(priority = 2,groups = "Positive")
    public void registrationTest2() throws InterruptedException {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(), 10);
        homePage.clickSignUpButton();
        registrationPage.enterEmail("mariami@gmail.com");
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkPageTitleEnterPassword(), "Enter your password");
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(), 10);
        registrationPage.enterPassword("Pass12345m");
        Waits.waitUnits(registrationPage.loginButton, WebDriverManager.getDriver(), 10);
        registrationPage.clickLogin();
        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(), 10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();

    }

    @Test(priority = 3,groups = "Positive")
    public void changeProfileData() {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(), 10);
        homePage.clickSignUpButton();
        registrationPage.enterEmail("mariami@gmail.com");
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkPageTitleEnterPassword(), "Enter your password");
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(), 10);
        registrationPage.enterPassword("Pass12345m");
        Waits.waitUnits(registrationPage.loginButton, WebDriverManager.getDriver(), 10);
        registrationPage.clickLogin();
        Waits.waitUnits(homePage.profileButton, WebDriverManager.getDriver(), 10);
        homePage.clickProfileButton();
        Waits.waitUnits(homePage.yourAccountButton, WebDriverManager.getDriver(), 10);
        homePage.clickYourAccountButton();
        myProfilePage.enterFirstName("Test111");
        myProfilePage.enterLastName("TestTest111");
        myProfilePage.clickUpdateButton();
        Assert.assertEquals(myProfilePage.clickUpdateinformatiopnAllert(), "Your changes have been saved!");
        Waits.waitUnits(homePage.loginProfilleButton, WebDriverManager.getDriver(), 10);
        homePage.clickLoginProfilleButton();
        myProfilePage.clickLogOutButton();


    }

    @Test(priority = 4,groups = "Positive")
    public void searchCity() {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(), 10);
        homePage.clicklocationfilld("Batumi");
        homePage.clickSearchButton();
    }

    @Test(priority = 5,groups = "Positive")
    public void searchHotel() {
        homePage.clicklocationfilld("Batumi");
        homePage.clickchooseDate();
        homePage.testSelectDates();
        homePage.setQuantityOfAdults(2);
        homePage.clickapplyButton();
        homePage.clickSearchButton();
    }

    @Test(priority = 6,groups = "Positive")
    public void filterHotels() {
        homePage.clicklocationfilld("Batumi");
        homePage.clickchooseDate();
        homePage.testSelectDates();
        homePage.setQuantityOfAdults(4);
        Waits.waitUnits(homePage.quantitiyOfAdults, WebDriverManager.getDriver(), 10);
        homePage.clickapplyButton();
        homePage.clickSearchButton();
        Waits.waitUnits(hotelsPage.priceFilterButton, WebDriverManager.getDriver(), 10);
        hotelsPage.clickPriceFilterButton();
        Waits.waitUnits(hotelsPage.minPriceInput, WebDriverManager.getDriver(), 10);
        hotelsPage.setMinPrice(20);
        hotelsPage.setMaxPrice(600);
        Waits.waitUnits(hotelsPage.applyPriceFilterButton, WebDriverManager.getDriver(), 10);
        hotelsPage.applyPriceFilter();

//        Add hotel to wishlist
        hotelsPage.clickAddToWishlistForFirstHotel();

    }

    @Test(priority = 8,groups = "Negative")
    public void registrationWIthIncorrectData() {
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(), 10);
        homePage.clickSignUpButton();
        registrationPage.enterEmail("test");
        registrationPage.clickContinue();
        Assert.assertEquals(registrationPage.checkErrormessagetext(), "Enter your complete email address. For example: name@example.com");


    }
    @Test(priority = 7, groups = "Negative")
    public void registrationWithWeakPassword(){
        Waits.waitUnits(homePage.loginButton, WebDriverManager.getDriver(), 10);
        homePage.clickSignUpButton();
        registrationPage.enterEmail("mariami@gmail.com");
        registrationPage.clickContinue();
        Waits.waitUnits(registrationPage.passwordInput, WebDriverManager.getDriver(), 10);
        registrationPage.enterPassword("12345678");
        registrationPage.clickLogin();
        Assert.assertEquals(registrationPage.checkckAllert(),
                "The email/password combination you entered is wrong. Please double-check both or click “Forgot your password?”.");


    }




}
