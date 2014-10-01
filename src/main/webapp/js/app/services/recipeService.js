
angular.module('recipesApp')
    .factory('RecipeService', ['$http', function($http) {

    function getRecipes(callback) {
        $http({method: 'GET', url: 'api/v1/recipes'}).
            success(function(data, status, headers, config) {
                callback(data);
            });
    };

    return {
        getRecipes: getRecipes
    }

}]);