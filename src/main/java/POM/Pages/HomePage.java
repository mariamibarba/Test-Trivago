package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
    public By loginButton = By.xpath("//*[text()='Log in']");
    public By profileButton = By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/div/header/nav/ul/li[4]/div/button/span/span");
    public By yourAccountButton = By.xpath("//*[@data-testid =\"profile-menu-account-settings\"]");
    public By loginProfilleButton = By.xpath("//*[@data-testid =\"header-profile-menu-desktop\"]");
    //location locators
    public By chooseLocationFilld = By.id("input-auto-complete");
    public By chooseCheckInDate = By.xpath("//*[@data-testid =\"search-form-calendar-checkin-label\"]");
    public By startDate = By.xpath("//*[@data-testid =\"valid-calendar-day\"]");
    public By endDate = By.xpath("//*[@data-testid =\"valid-calendar-day\"]");
    public By quantitiyOfAdults = By.xpath("//*[@data-testid=\"adults-amount\"]");
    public By applyButton = By.xpath("//*[@data-testid=\"guest-selector-apply\"]");
    public By searchutton = By.xpath("//*[@data-testid=\"search-button-with-loader\"]");


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

    //    chooose location
    public void clicklocationfilld(String location) {
        WebDriverManager.getDriver().findElement(chooseLocationFilld).sendKeys(location);
        new Actions(WebDriverManager.getDriver()).keyDown(Keys.ENTER).perform();
    }

    public void clickchooseDate() {
        WebDriverManager.getDriver().findElement(chooseCheckInDate).click();
    }

    public void clickStartDate() {
        WebDriverManager.getDriver().findElement(startDate).click();
    }

    public void clickEndDate() {
        WebDriverManager.getDriver().findElement(endDate).click();
    }

    public void selectDates() {
        clickStartDate();
        clickEndDate();
    }

    public void clickDate(String date) {
        String xpath = "//*[@data-testid ='valid-calendar-day-" + date + "']";
        By dateLocator = By.xpath(xpath);
        WebDriverManager.getDriver().findElement(dateLocator).click();
    }

    public void selectDates(String startDate, String endDate) {
        clickDate(startDate);
        clickDate(endDate);
    }

    public void testSelectDates() {
        selectDates("2024-08-28", "2024-08-29");
    }

    public void setQuantityOfAdults(int quantity) {
        WebElement adultsInput = WebDriverManager.getDriver().findElement(quantitiyOfAdults);
        adultsInput.sendKeys(Keys.BACK_SPACE);
        adultsInput.clear();
        adultsInput.sendKeys(String.valueOf(quantity));
    }

    public void clickapplyButton() {
        WebDriverManager.getDriver().findElement(applyButton).click();
    }

    public void clickSearchButton() {
        WebDriverManager.getDriver().findElement(searchutton).click();
    }

}
