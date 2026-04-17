var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $scope.welcomeMessage = "Welcome to my web application!";
    $scope.observations = [];

    // Fetch existing observations
    $http.get("/api/observations")
    .then(function(response) {
        $scope.observations = response.data;
    });

    // Add new observation
    $scope.addObservation = function() {
        if ($scope.newObservation && $scope.newObservation.date && $scope.newObservation.details) {
            $http.post("/api/observations", $scope.newObservation)
            .then(function(response) {
                $scope.observations.push(response.data);
                $scope.newObservation = {}; // Clear the form
            }, function(error) {
                console.error("Error adding observation:", error);
            });
        } else {
            alert("Please fill in both date and details.");
        }
    };
});