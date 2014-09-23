package api.recipe

import api.common.ApiTestBase
import groovyx.net.http.RESTClient
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

class RecipeApiTest extends ApiTestBase {

    @Test
    public void shouldGetAListOfRecipes() {

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
}
