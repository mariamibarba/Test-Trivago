package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;

public class HomePage {
    public By loginButton = By.xpath("//*[text()='Log in']");
    public By profileButton = By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/header/nav/ul/li[4]/div/button/span/span");
    public By yourAccountButton = By.xpath("//*[@data-testid =\"profile-menu-account-settings\"]");
    public By loginProfilleButton = By.xpath("//*[@data-testid =\"header-profile-menu-desktop\"]");


    public void clickSignUpButton() {
        WebDriverManager.getDriver().findElement(loginButton).click();
    }
    public void clickProfileButton() {
        WebDriverManager.getDriver().findElement(profileButton).click();
    }
    public void clickYourAccountButton() {
        WebDriverManager.getDriver().findElement(yourAccountButton).click();
    }
    public void clickLoginProfilleButton() {
        WebDriverManager.getDriver().findElement(loginProfilleButton).click();
    }

}
