
angular.module('recipesApp')
    .factory('RecipeSvc', ['$http', function($http) {

    function getRecipes() {
        return [
           { id: 1, name:'Foo', description:'Bar' },
           { id: 2, name:'Garb', description:'Shnozzle' },
           { id: 3, name:'Shit', description:'Bacon' }
        ];
    };

    return {
        getRecipes: getRecipes
    }

}]);