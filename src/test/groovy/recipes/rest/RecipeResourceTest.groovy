package recipes.rest

import org.junit.Test
import org.unitils.reflectionassert.ReflectionAssert
import recipes.resources.Recipe

import static org.hamcrest.MatcherAssert.assertThat

class RecipeResourceTest {

    RecipeResource resource = new RecipeResource()

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
        ReflectionAssert.assertReflectionEquals(expected, resource.recipeList)
    }
}
