package Utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public abstract class AbstractTest {
    private static final String chromeWebDriverName = "webdriver.chrome.driver";
    private static final String chromeWebDriverPath = "C:\\Program Files\\chromedriver\\chromedriver.exe";
    private static  final String pageUrl = "https://web2.0calc.com/";

    protected ChromeDriver driver;
    protected WebDriverWait wait;

    @Before
    public void startTest() {
        System.setProperty(chromeWebDriverName, chromeWebDriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, ofSeconds(10));
        driver.get(pageUrl);
        driver.manage().window().maximize();
    }

    @After
    public void stop() {
        if (driver != null) driver.quit();
    }
}
