
angular.module('recipesApp')
    .controller('RecipeListCtrl', ['$scope', 'RecipeSvc', function($scope, RecipeSvc) {

    $scope.recipes = RecipeSvc.getRecipes();

}]);