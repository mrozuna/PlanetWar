var planetWar.user = angular.module('planetWar.user', []);

planetWar.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
 }]);

function UserController($scope, $http) {
    $scope.user = {};
    $scope.createUser = function() {
      	$http.post('https://testapi-16.appspot.com/_ah/api/user/v1/addUser/', $scope.user).
		success(function(data, status, headers, config) {
        	alert("success " + data)
        }).
        error(function(data, status, headers, config) {
			alert("error " + data)
        });
    }
    
    $scope.getUser = function() {
        $http.get('https://testapi-16.appspot.com/_ah/api/user/v1/collectionresponse_userapi/').
        success(function(data, status, headers, config) {
            var table = document.getElementById("table");
            var content="";
            content="<tr><th>ID</th><th>Username</th><th>Email</th><th>Points</th></tr>"; 
            for(var i=0;i<data.items.length;i++){
                content="<tr><td>"+data.items[i].id+"</td><td>"+data.items[i].nameUser+"</td><td>"+data.items[i].email+"</td><td>"+ data.items[i].points + "</td></tr>"; 
            }
        }).
        error(function(data, status, headers, config) {
            alert("error " + data)
        });
    }
}