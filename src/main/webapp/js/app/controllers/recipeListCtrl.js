
angular.module('recipesApp')
    .controller('RecipeListCtrl', ['$scope', 'RecipeSvc', function($scope, RecipeSvc) {

    RecipeSvc.getRecipes(function(data) {
        $scope.recipes = data;
    });

}]);