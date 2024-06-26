package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;

public class RegistrationPage {
    public By emilInput = By.id("email");
    public By continueButton= By.xpath("//*[text()='Continue']");
    public By passwordInput = By.id("password");
    public By createAccount = By.xpath("//*[@data-testid =\"register-submit-button\"]");


    public void enterEmail(String email) {
        WebDriverManager.getDriver().findElement(emilInput).sendKeys(email);
    }
    public void clickContinue() {
        WebDriverManager.getDriver().findElement(continueButton).click();
    }
    public void enterPassword(String password) {
        WebDriverManager.getDriver().findElement(passwordInput).sendKeys(password);
    }
    public void clickCreateAccount() {
        WebDriverManager.getDriver().findElement(createAccount).click();
    }
}
