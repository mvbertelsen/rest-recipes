package api.status

import api.common.ApiTestBase
import org.junit.Test
import org.unitils.reflectionassert.ReflectionAssert
import recipes.resources.Recipe

import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.GenericType
import javax.ws.rs.core.MediaType

class RecipeApiTest extends ApiTestBase {

    public RecipeApiTest() {
        super("/v1/recipes")
    }

    @Test
    public void getRecipeListGetsARecipeList() {
        def expected = [
                new Recipe(
                        id: 1,
                        name: 'Macaroni and Cheese',
                        description: 'Cheesy goodness'
                ),
                new Recipe(
                        id: 2,
                        name: 'Sausages with Sauerkraut Potato Hash',
                        description: 'Comfort food, Mattias-style'
                ),
                new Recipe(
                        id: 3,
                        name: 'Chicken Noodle Soup',
                        description: 'For the soul!'
                )
        ]

        List<Recipe> allRecipes = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .buildGet()
                .invoke(new GenericType<List<Recipe>>() {})

        ReflectionAssert.assertReflectionEquals(expected, allRecipes)
    }
}
