package api.common

import groovyx.net.http.RESTClient

class ApiTestBase {

    RESTClient rest = new RESTClient('http://localhost:8080')
    String basePath = '/rest-recipes/api'

}
