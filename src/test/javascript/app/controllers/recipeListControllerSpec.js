
describe('Unit: RecipeListController', function() {

    beforeEach(module('recipesApp'));

    var controller, scope, RecipeService, httpBackend;

    // this test runs with a mock $http, but the real RecipeService.
    beforeEach(inject(function($controller, $rootScope, _RecipeService_, $httpBackend) {
        scope = $rootScope.$new();
        RecipeService = _RecipeService_;
        httpBackend = $httpBackend;
        controller = $controller('RecipeListController', {
            $scope: scope,
            RecipeService: RecipeService
        });
    }));

    afterEach(function () {
        httpBackend.verifyNoOutstandingExpectation();
        httpBackend.verifyNoOutstandingRequest();
    });

    var sampleData = [
        {'id':1,'name':'Macaroni and Cheese','description':'Cheesy goodness'},
        {'id':2,'name':'Sausages with Sauerkraut Potato Hash','description':'Comfort food, Mattias-style'},
        {'id':3,'name':'Chicken Noodle Soup','description':'For the soul!'}
    ];

    it('should get the list of recipes right away', function() {
        httpBackend.expectGET('api/v1/recipes').respond(200, sampleData);
        httpBackend.flush();
        expect(scope.recipes).toEqual(sampleData);
    });
});