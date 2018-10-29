angular.module('app.controllers', [])

.controller('pageCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {
  $scope.mdl={};

}])

.controller('page2Ctrl', ['$scope', '$stateParams', '$http', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams, $http) {
  appid = 'cfbab5d3213652650ce42bf16b2cdabd';
  city = $stateParams.inputtxt;
  url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="
  + appid + "&units=metric";

  $http.get(url).then(function(response){
    $scope.cityname = response.data.name;
    $scope.temperature = response.data.main.temp;
    $scope.commentary = response.data.weather[0].description;
    $scope.icon = response.data.weather[0].icon;
  }, function(error){
    alert("Unable to get the weather");
  })

}])
