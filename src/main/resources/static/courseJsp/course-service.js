(function(){
    var service = function($http, $log) {
        var getCourses = function(callback) {
            $http.get('/erp/get-courses')
            .then(function(response){
                callback(response.data);
            }, function(response){
                console.log(response);
            });
        };

        return {
           getCourses: getCourses
        };
    };


    var module = angular.module('client');
    module.factory('courseService', ['$http', '$log', service]);
})();
