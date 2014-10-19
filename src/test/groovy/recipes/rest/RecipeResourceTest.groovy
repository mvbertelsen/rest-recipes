package recipes.rest

import org.junit.Test
import org.junit.rules.ExpectedException
import org.unitils.reflectionassert.ReflectionAssert
import recipes.resources.Recipe

import javax.ws.rs.BadRequestException
import javax.ws.rs.NotFoundException

import static org.hamcrest.MatcherAssert.assertThat
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertNull

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

    @Test
    public void getRecipeByIdGetsARecipe() {
        def expected = new Recipe(
            id: 2,
            name: 'Sausages with Sauerkraut Potato Hash',
            description: 'Comfort food, Mattias-style'
        )
        ReflectionAssert.assertReflectionEquals(expected, resource.getRecipe('2'))
    }

    @Test(expected = BadRequestException)
    public void getRecipeByBogusIdThrowsBadRequestException() {
        resource.getRecipe('bogus')
    }

    @Test(expected = NotFoundException)
    public void getRecipeWithValidIdNotInCollectionThrowsNotFoundException() {
        resource.getRecipe('0')
    }
}
