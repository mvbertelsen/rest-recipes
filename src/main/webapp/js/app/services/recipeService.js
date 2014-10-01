
angular.module('recipesApp')
    .factory('RecipeService', ['$http', function($http) {

    var getRecipes = function() {
        return $http({method: 'GET', url: 'api/v1/recipes'});
    };

    return {
        getRecipes: getRecipes
    };

}]);