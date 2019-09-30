package core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.close;
import static data.TestData.START_PAGE_URL;


public class TestBase {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = START_PAGE_URL;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }

    @AfterClass
    public void tearDown() {
        close();
    }
}
