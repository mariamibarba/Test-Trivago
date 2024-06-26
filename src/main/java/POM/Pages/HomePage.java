package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;

public class HomePage {
    public By loginButton = By.xpath("//*[text()='Log in']");

    public void clickSignUpButton() {
        WebDriverManager.getDriver().findElement(loginButton).click();
    }

}
