package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;

public class MyProfilePage {
    public By firstNameInput = By.id("input-3");
    public By lastNameInput = By.id("input-4");
    public By updateButton = By.xpath("//button[span[text()='Update personal information']]");
    public By updateinformatiopnAllert = By.xpath("//*[@data-testid =\"alert-notification\"]");
    public By logOutButton = By.xpath("//*[@data-testid =\"header-logout\"]");

    public void enterFirstName(String firstName) {
        WebDriverManager.getDriver().findElement(firstNameInput).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        WebDriverManager.getDriver().findElement(lastNameInput).sendKeys(lastName);
    }
    public void clickUpdateButton() {
        WebDriverManager.getDriver().findElement(updateButton).click();

    }
    public String clickUpdateinformatiopnAllert() {
        return WebDriverManager.getDriver().findElement(updateinformatiopnAllert).getText();

    }
    public void clickLogOutButton() {
        WebDriverManager.getDriver().findElement(logOutButton).click();
    }
}
