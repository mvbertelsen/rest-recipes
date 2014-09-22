package app.page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class RecipeListPage {

    WebDriver driver

    public RecipeListPage(WebDriver driver) {
        this.driver = driver
    }

    public List<List<String>> getRecipeData() {
        driver.findElements(By.cssSelector('div.recipe-list tbody tr')).collect { WebElement row ->
            row.findElements(By.cssSelector('td')).collect {WebElement cell ->
                cell.text
            }
        }
    }
}
