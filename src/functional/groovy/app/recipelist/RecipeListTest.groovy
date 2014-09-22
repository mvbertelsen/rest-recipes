package app.recipelist

import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import static org.junit.Assert.assertNotNull

class RecipeListTest {
    private static WebDriver driver

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

    @Test
    public void shouldListSomeRecipes() {
        driver.get('http://localhost:8080/rest-recipes/')
        WebElement recipeListDiv = this.driver.findElement(By.cssSelector('div.recipe-list'));

        assertNotNull recipeListDiv
    }
}
