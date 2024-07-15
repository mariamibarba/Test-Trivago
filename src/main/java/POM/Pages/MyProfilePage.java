package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyProfilePage {
    public By firstNameInput = By.id("input-3");
    public By lastNameInput = By.id("input-4");
    public By updateButton = By.xpath("//button[span[text()='Update personal information']]");
    public By updateinformatiopnAllert = By.xpath("//*[@data-testid =\"alert-notification\"]");
    public By logOutButton = By.xpath("//*[@data-testid =\"header-logout\"]");
    public By oldPassword = By.id("input-5");
    public By NewPassword = By.id("input-6");
    public By updatePasswordButton = By.xpath("//button[span[text()='Change your password']]");



    public void enterFirstName(String firstName) {
        WebElement firstNameElement = WebDriverManager.getDriver().findElement(firstNameInput);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        WebElement lastNameElement = WebDriverManager.getDriver().findElement(lastNameInput);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }
    public void clickUpdateButton() {
        WebDriverManager.getDriver().findElement(updateButton).click();

    }
    public String clickUpdateinformatiopnAllert() {
        return WebDriverManager.getDriver().findElement(updateinformatiopnAllert).getText();

    }
//    public void enterOldPassword(String oldPasswordText) {
//        WebElement oldPasswordElement = WebDriverManager.getDriver().findElement(oldPassword);
//        oldPasswordElement.clear(); // Clear the input field first
//        oldPasswordElement.sendKeys(oldPasswordText);
//    }
//
//    public void enterNewPassword(String newPasswordText) {
//        WebElement newPasswordElement = WebDriverManager.getDriver().findElement(NewPassword);
//        newPasswordElement.clear(); // Clear the input field first
//        newPasswordElement.sendKeys(newPasswordText);
//    }

    public void clickUpdatePasswordButton() {
        WebDriverManager.getDriver().findElement(updatePasswordButton).click();
    }
    public void clickLogOutButton() {
        WebDriverManager.getDriver().findElement(logOutButton).click();
    }
}
