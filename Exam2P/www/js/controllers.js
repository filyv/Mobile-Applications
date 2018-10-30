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
  appid = 'FXSSAHT99HH0LPBF';
  symbol = $stateParams.inputradio;
  url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol
  + "&apikey=" + appid;

  $http.get(url).then(function(response){
    console.log(url);
    $scope.name = response.data["Global Quote"]["01. symbol"];
    $scope.price = parseInt(response.data["Global Quote"]["05. price"]);
    $scope.date = response.data["Global Quote"]["07. latest trading day"];
    $scope.difference = parseInt(response.data["Global Quote"]["05. price"]) - parseInt(response.data["Global Quote"]["08. previous close"]);
    $scope.recomendation = (parseInt(response.data["Global Quote"]["05. price"]) - parseInt(response.data["Global Quote"]["08. previous close"])) > 0 ? "Keep" : "Sell";
    $scope.color=(parseInt(response.data["Global Quote"]["05. price"]) - parseInt(response.data["Global Quote"]["08. previous close"])) > 0 ? "black" : "red";
  }, function(error){
    alert("Unable to get the weather");
  })

}])
