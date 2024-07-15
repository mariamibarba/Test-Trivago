package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HotelsPage {

    public By sortByLocation = By.xpath("//button[@name='location_filters' and @title='City center/10 miles']");
    public By sliderHandle = By.xpath("//div[@data-testid='slider-handle']");
    public By sliderTrack = By.cssSelector("div.absolute.inset-0.mx-3");
    public By applyFilterButton = By.xpath("//div[@data-testid='filters-popover-apply-button']");
    public By allhotelsLists = By.xpath("//ol[@data-testid='accommodation-list']");
    public By addToWishlistButton = By.xpath(".//button[@data-testid='accommodation-card-favorite-list-button']");
    public By priceFilterButton = By.xpath("//span[contains(@class, 'RefinementRowElement_buttonConfigText__5tSnR') and contains(text(), '$2 - $600 +')]");


    public By minPriceInput = By.xpath("//input[@data-testid='price-filter-value-min']");
    public By maxPriceInput = By.xpath("//input[@data-testid='price-filter-value-max']");
    public By applyPriceFilterButton = By.xpath("//button[@data-testid='filters-popover-apply-button']");


    public List<WebElement> hotelsLists() {
        return WebDriverManager.getDriver().findElements(allhotelsLists);
    }

    public void clickAddToWishlistForFirstHotel() {
        WebElement firstHotel = hotelsLists().get(0);
        WebElement addToWishlistBtn = firstHotel.findElement(addToWishlistButton);
        addToWishlistBtn.click();
    }


    public void clickSortByLocation() {
        WebDriverManager.getDriver().findElement(sortByLocation).click();
    }

    public void moveSliderToMiles(double targetMiles) {
        WebElement slider = WebDriverManager.getDriver().findElement(sliderHandle);
        WebElement track = WebDriverManager.getDriver().findElement(sliderTrack);

        // Get the slider track width
        int trackWidth = track.getSize().width;

        // Define the slider range
        double minMiles = 0.5;
        double maxMiles = 10.0;

        // Calculate the target position as a percentage of the track width
        double targetPercentage = (targetMiles - minMiles) / (maxMiles - minMiles);
        int xOffset = (int) (trackWidth * targetPercentage);

        // Move the slider to the calculated position
        Actions move = new Actions(WebDriverManager.getDriver());
        move.clickAndHold(slider)
                .moveByOffset(xOffset - slider.getLocation().getX(), 0)
                .release()
                .build()
                .perform();
    }

    public void clickApplyFilterButton() {
        WebDriverManager.getDriver().findElement(sortByLocation).click();
    }

    public void clickPriceFilterButton() {
        WebDriverManager.getDriver().findElement(priceFilterButton).click();
    }


    public void setMinPrice(int minPrice) {
        WebElement minPriceElement = WebDriverManager.getDriver().findElement(minPriceInput);
        minPriceElement.sendKeys(Keys.BACK_SPACE);
        minPriceElement.clear();
        minPriceElement.sendKeys(String.valueOf(minPrice));

    }

    public void setMaxPrice(int maxPrice) {
        WebElement maxPriceElement = WebDriverManager.getDriver().findElement(maxPriceInput);
        maxPriceElement.sendKeys(Keys.BACK_SPACE);
        maxPriceElement.clear();
        maxPriceElement.sendKeys(String.valueOf(maxPrice));
    }

    public void applyPriceFilter() {
        WebDriverManager.getDriver().findElement(applyPriceFilterButton).click();
    }


}
