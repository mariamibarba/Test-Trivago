package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    public By emilInput = By.id("email");
    public By continueButton = By.xpath("//*[text()='Continue']");
    public By passwordInput = By.id("password");
    public By createAccount = By.xpath("//*[@data-testid =\"register-submit-button\"]");
    public By loginButton = By.xpath("//*[@data-testid =\"login-submit\"]");
    public By pageTitleMail = By.xpath("//h1[text()='Unlock more savings as a member']");
    public By pageTitlePassword = By.xpath("//h1[text()='Create a password for your new account']");
    public By pageTitleEnterPassword = By.xpath("//h1[text()='Enter your password']");
    public By errormessagetext = By.xpath("//*[@data-testid =\"form-field-error-notification\"]");
    public By allertText = By.className("Alert_message__s9VF2");



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

    public void clickLogin() {
        WebDriverManager.getDriver().findElement(loginButton).click();
    }

    public String checkPageTitle() {
        return WebDriverManager.getDriver().findElement(pageTitleMail).getText();

    }

    public String checkPageTitlePassword() {
        return WebDriverManager.getDriver().findElement(pageTitlePassword).getText();
    }

    public String checkPageTitleEnterPassword() {
        return WebDriverManager.getDriver().findElement(pageTitleEnterPassword).getText();
    }
    public String checkErrormessagetext() {
        return WebDriverManager.getDriver().findElement(errormessagetext).getText();
    }
    public String  checkckAllert() {
       return WebDriverManager.getDriver().findElement(allertText).getText();

    }
}
