(function(){
    var controller = function($timeout, $log, $scope, $route, socketService, uploadService, courseService, messageService) {
        var vm = this;

        $scope.courses = [];

        vm.activate = function() {
            messageService.subscribe('event', 'cosClientController', function(channel, message){
                var eventMessage = JSON.parse(message);
                $timeout((function(_event){
                    return function() {
                        if(_event.eventType == 'progress'){
                            toastr.info(_event.state.name);
                            loadCourses();
                        } else if(_event.eventType == 'start') {
                            toastr.info(_event.state);
                        } else if(_event.eventType == 'end') {
                            toastr.info(_event.state);
                            loadCourses();
                        }
                    };
                })(eventMessage), 100);

            });

            socketService.connect(function(state, message){
                messageService.route(state, message);
            });
        };

        $scope.token = 'mocked-token';

        function loadCourses() {
            courseService.getCourses(function(courses){
                $scope.courses = courses;
            });
        }

        $scope.uploadCourseExcel = function() {
            var hasCourseExcel = uploadService.hasCourseExcel();
            if(hasCourseExcel) {
                uploadService.uploadCourseExcel($scope.token, function(result) {
                    if(result.success) {
                        toastr.info('Your Excel has been uploaded.' + result.id, 'Excel Uploaded');
                        $timeout(function(){
                             loadCourses();
                        }, 1000);
                    } else {
                        toastr.error(reason, 'Upload Error');
                    }
                });
            } else {
                toastr.error('Please select your image to upload First!', 'Invalid Upload');
            }
        };
        vm.activate();
    };
    var app = angular.module('client');
    app.controller("cosClientController", ['$timeout', '$log', '$scope', '$route', 'socketService', 'uploadService', 'courseService', 'messageService', controller]);

})();
