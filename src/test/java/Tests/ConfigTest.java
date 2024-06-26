package Tests;

import POM.Utils.WebDriverManager;
import POM.Utils.workingJson;
import com.fasterxml.jackson.databind.JsonNode;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class ConfigTest {
    protected JsonNode data;
    @BeforeClass(groups = {"positive", "negative"})
    @Story("Opening url for all tests")
    @Description("Maximize browsers windows")
    public void setup() throws IOException {
        data= workingJson.getResourcesFromJson();
        WebDriverManager.getDriver().manage().window().maximize();
        WebDriverManager.getDriver().get("https://www.trivago.com/");
//        WebDriverManager.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @AfterSuite(groups = {"positive", "negative"})
    public void teardown() {
        WebDriverManager.quit();

    }
}
