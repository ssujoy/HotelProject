var app = angular.module('app', ['ngCookies', 'ngRoute']);

app.config(['$routeProvider', 
	function($routeProvider){
		$routeProvider.when('/',
			{templateUrl:'home.html',
			controller:'contr'})
			.when('/hotels',
			{templateUrl:'hotels.html',
			controller:'hotelsController'})
			.when('/contact',
			{templateUrl:'contact.html',
			controller:'todoViewController'});
	}]);

app.controller('mainController', function($scope,$http){
	console.log("IN Main controller");
	$scope.login = function(){
		console.log($scope.username);
		console.log($scope.password);
		var loginCredential = 
		{
				username : $scope.username,
				password : $scope.password
		}
		$http.post("/service/login", loginCredential)
    	.success(function(data, status, headers, config) 
    	{
    		if(data == null || data == "")
    			alert("Wrong user or password ...");
    		else
    			alert("User Id : "+data);
    	})
    	.error(function(data, status, headers, config)
    	{
        	alert("Oops! Server is down.");
    	});
    	
	}
});

app.controller('contr', function($scope,$http){
	
});

app.controller('hotelsController', function($scope,$http){
	alert("hotelsController");
	$scope.hotels = [];
	$http.get("/get-hotels")
	.success(function(data){
		$scope.hotels = data;
		console.log(data);
	});
});