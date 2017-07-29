package selenide.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import selenium.core.TestListener;

import static org.openqa.selenium.remote.BrowserType.CHROME;
@Listeners({TestListener.class})
public class SelenideTestBase {

    private String browser = System.getProperty("browser", CHROME);

    @BeforeClass
    public void setUp() {
        switch (browser) {
            case WebDriverRunner.CHROME:
                ChromeDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                break;
        }
        Configuration.browser = browser;
    }
}
