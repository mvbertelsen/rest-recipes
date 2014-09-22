package app.common

import org.junit.AfterClass
import org.junit.BeforeClass
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class SeleniumTestBase {
    protected static WebDriver driver

    @BeforeClass
    public static void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe")
        ChromeOptions options = new ChromeOptions()
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("ignore-certificate-errors"));
        driver = new ChromeDriver(options)
    }

    @AfterClass
    public static void tearDownDriver() {
        driver.quit()
    }
}
