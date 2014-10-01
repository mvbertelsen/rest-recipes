
angular.module('recipesApp')
    .controller('RecipeListController', ['$scope', 'RecipeService', function($scope, RecipeService) {

    RecipeService.getRecipes(function(data) {
        $scope.recipes = data;
    });

}]);