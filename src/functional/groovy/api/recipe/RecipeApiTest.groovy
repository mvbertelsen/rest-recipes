package api.recipe

import api.common.ApiTestBase
import groovyx.net.http.RESTClient
import groovyx.net.http.ResponseParseException
import org.junit.Ignore
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class RecipeApiTest extends ApiTestBase {

    @Test
    public void getAListOfRecipes() {

        def response = rest.get(
                path: "${basePath}/v1/recipes",
                contentType: 'application/json'
        )

        assertThat response.status, equalTo(200)
        assertThat response.data, equalTo([
                [
                        id         : 1,
                        name       : 'Macaroni and Cheese',
                        description: 'Cheesy goodness'
                ],
                [
                        id         : 2,
                        name       : 'Sausages with Sauerkraut Potato Hash',
                        description: 'Comfort food, Mattias-style'
                ],
                [
                        id         : 3,
                        name       : 'Chicken Noodle Soup',
                        description: 'For the soul!'
                ]
        ])
    }

    @Test
    public void getASingleRecipe() {
        def response = rest.get(
                path: "${basePath}/v1/recipes/3",
                contentType: 'application/json'
        )

        assertThat response.status, equalTo(200)
        assertThat response.data, equalTo(
                [
                        id         : 3,
                        name       : 'Chicken Noodle Soup',
                        description: 'For the soul!'
                ]
        )
    }

    // BUG: JSON cannnot parse response because it returns generic text/html jetty 404 content
    // TODO: we need better control of response content!!!
    @Test(expected = ResponseParseException)
    public void failToFindASingleRecipe() {
        def response = rest.get(
                path: "${basePath}/v1/recipes/9",
                contentType: 'application/json'
        )

        assertThat response.status, equalTo(404)
    }

    // BUG: JSON cannnot parse response because it returns generic text/html jetty 404 content
    // TODO: we need better control of response content!!!
    @Test(expected = ResponseParseException)
    public void failToFindASingleRecipeWithBadRequest() {
        def response = rest.get(
                path: "${basePath}/v1/recipes/noogie",
                contentType: 'application/json'
        )

        assertThat response.status, equalTo(400)
    }
}
