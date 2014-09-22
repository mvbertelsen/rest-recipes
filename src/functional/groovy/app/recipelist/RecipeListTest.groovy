package app.recipelist

import app.common.SeleniumTestBase
import app.page.RecipeListPage
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

import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*

class RecipeListTest extends SeleniumTestBase {

    @Test
    public void shouldListSomeRecipes() {
        driver.get('http://localhost:8080/rest-recipes/')
        RecipeListPage recipeListPage = new RecipeListPage(driver)

        assertThat recipeListPage.recipeData, is([
                ['1', 'Macaroni and Cheese', 'Cheesy goodness'],
                ['2', 'Sausages with Sauerkraut Potato Hash', 'Comfort food, Mattias-style'],
                ['3', 'Chicken Noodle Soup', 'For the soul!']
        ])
    }

}
