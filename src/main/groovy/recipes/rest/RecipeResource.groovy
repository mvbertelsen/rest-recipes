package recipes.rest

import recipes.resources.Recipe

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/v1/recipes')
class RecipeResource {

    static List<Recipe> allRecipes = [
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

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Recipe> getRecipeList() {
        allRecipes
    }
}
