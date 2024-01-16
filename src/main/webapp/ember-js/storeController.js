(function() {
	var productapp = angular.module('productapp');

	productapp.controller('storeController', function($scope, $http, $location) {

		$scope.getAllSupplies = function() {
			$http.get("/pyrography/webapi/products")
				.then(function(response) {
					$scope.supplies = response.data;
					console.log('number of products: ' + $scope.supplies.length);
				}, function(response) {
					console.log('error http GET products: ' + response.status);
				});
		}
		$scope.goToProductView = function(productId) {
			$location.path('/productview/' + productId);
		}

		$scope.getAllSupplies();
	})
})()