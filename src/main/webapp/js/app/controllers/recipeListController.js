
angular.module('recipesApp')
    .controller('RecipeListController', ['$scope', 'RecipeService', function($scope, RecipeService) {

    RecipeService.getRecipes().then(function(promise) {
        $scope.recipes = promise.data;
    });

}]);