
angular.module('recipesApp')
    .factory('RecipeService', ['$http', function($http) {

    function getRecipes() {
        return $http({method: 'GET', url: 'api/v1/recipes'});
    }

    return {
        getRecipes: getRecipes
    };

}]);