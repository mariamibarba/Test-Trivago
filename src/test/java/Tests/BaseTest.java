package Tests;

import POM.Utils.WebDriverManager;
import POM.Utils.workingJson;
import com.fasterxml.jackson.databind.JsonNode;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected JsonNode data;


    @BeforeClass(groups = {"Positive", "Negative"})
    @Story("Opening url for all tests")
    @Description("Maximize browser windows")
    public void setup() throws IOException {

        WebDriverManager.getDriver().manage().window().maximize();
        WebDriverManager.getDriver().get("https://www.trivago.com/");
        WebDriverManager.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        File screenshot = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshots/","screenshot.png"));
        data = workingJson.getResourcesFromJson();


    }




    @AfterSuite(groups = {"Positive", "Negative"})
    public void teardown() {
        WebDriverManager.quit();
    }
}
