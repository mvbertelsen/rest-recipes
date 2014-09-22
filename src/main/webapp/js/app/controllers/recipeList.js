
angular.module('recipesApp')
    .controller('RecipeListController', ['$scope', function($scope) {

    $scope.recipes = [
        { id: 1, name:'Foo', description:'Bar' },
        { id: 2, name:'Garb', description:'Shnozzle' },
        { id: 3, name:'Shit', description:'Bacon' }
    ];

}]);