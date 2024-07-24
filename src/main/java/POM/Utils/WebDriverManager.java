package POM.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage");
//        if (driver == null) {
//            driver = new ChromeDriver(options);
//        }
//        return driver;
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}