(function(){
    var service = function($http, $log) {
        var courseExcel = null;
        var courseExcelType = null;



        var hasCourseExcel = function() {
            return courseExcel != null;
        };

        var storeCourseExcel = function(obj) {

            var name = obj.name;

            var fileExtension = name.toLowerCase().split('.').pop();

            $log.debug(fileExtension);

            if(fileExtension != 'xlsx') {
                toastr.alert('Only xlsx file is supported', 'Excel Upload Error');
                return;
            }

            courseExcel = obj;
            courseExcelType = fileExtension;

        };

        var uploadCourseExcel =  function(token, callback) {
             var fd = new FormData();

             fd.append('file', courseExcel);
             fd.append('token', token);

             var url = '/erp/upload-course-excel';

             $log.debug(url);

             $http({
                 method: 'POST',
                 url: url,
                 headers: {
                     'Content-Type': undefined
                 },
                 transformRequest: angular.identity,
                 data: fd
             }).success(function(response) {
                $log.debug(response);
                courseExcel = null;
                courseExcelType = null;
                if(callback) callback(response);
             }).error(function(response) {
                 $log.debug(response.exception);
                 $log.debug(response.message);
             });
        };

        return {
            uploadCourseExcel: uploadCourseExcel,
            storeCourseExcel: storeCourseExcel,
            hasCourseExcel: hasCourseExcel,
        };
    };

    var module = angular.module('client');
    module.factory('uploadService', ['$http', '$log', service]);

    module.directive('courseExcelUpload', ['uploadService', function (uploadService) {
        return {
            restrict: 'A',
            scope : {
                productDataSet : "=ngModel"
            },
            link: function (scope, element, attr) {

                element.bind('change', function () {
                    uploadService.storeCourseExcel(element[0].files[0]);
                });

            }
        };
    }]);

})();
