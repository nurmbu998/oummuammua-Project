var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $scope.welcomeMessage = {};
    $scope.observations = [];

    // Fetch welcome message
    $http.get('/api/welcome').then(function(response) {
        $scope.welcomeMessage = response.data;
    });

    // Fetch existing observations
    $http.get('/api/observations').then(function(response) {
        $scope.observations = response.data;
    });

    // Add new observation
    $scope.addObservation = function() {
        if ($scope.newObservation && $scope.newObservation.observationDate && $scope.newObservation.details) {
            var dateValue = $scope.newObservation.observationDate;
            if (dateValue instanceof Date) {
                var year = dateValue.getFullYear();
                var month = ('0' + (dateValue.getMonth() + 1)).slice(-2);
                var day = ('0' + dateValue.getDate()).slice(-2);
                dateValue = year + '-' + month + '-' + day;
            }

            var payload = {
                observationDate: dateValue,
                details: $scope.newObservation.details
            };

            $http.post('/api/observations', payload).then(function(response) {
                $scope.observations.push(response.data);
                $scope.newObservation = {}; // Clear the form
            }, function(error) {
                console.error('Error adding observation:', error);
                var serverMessage = error.data && error.data.message ? error.data.message : 'Check the browser console for details.';
                alert('Error adding observation: ' + serverMessage);
            });
        } else {
            alert('Please fill in both date and details.');
        }
    };
});
