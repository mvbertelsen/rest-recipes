package recipes.rest

import recipes.resources.Recipe

import javax.ws.rs.BadRequestException
import javax.ws.rs.GET
import javax.ws.rs.NotFoundException
import javax.ws.rs.Path
import javax.ws.rs.PathParam
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

    @GET @Path('{id}')
    @Produces(value = MediaType.APPLICATION_JSON)
    public Recipe getRecipe(@PathParam('id') String id) {
        // TODO: persistence as a layer
        def recipe = allRecipes.find { recipe->
            // TODO: request validation as a layer to return 400 bad request responses
            try {
                recipe.id == Long.valueOf(id)
            } catch (NumberFormatException e) {
                // TODO: custom handling so we can return input to requester with meaningful error messages
                throw new BadRequestException()
            }
        }

        if (!recipe) throw new NotFoundException() // triggers jersey default 404 handling

        recipe
    }
}
