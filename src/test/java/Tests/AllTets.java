package Tests;

import POM.Pages.HomePage;
import POM.Pages.RegistrationPage;
import POM.Utils.GenerateRandom;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

public class AllTets extends ConfigTest{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void test() throws InterruptedException {
    homePage.clickSignUpButton();
        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());
        registrationPage.enterEmail(data.get("email").asText());
        registrationPage.clickContinue();
        
        registrationPage.enterPassword("Password123");

        registrationPage.clickCreateAccount();



    }
}
