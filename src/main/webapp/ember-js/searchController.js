/**
 * Access the previously created module.
 */
(function() {
	var productapp = angular.module('productapp');

	productapp.controller('searchController', function($scope, $http, $location) {
		
		$scope.showSpinner = true;
		
		$scope.getAllSupplies = function() {
			$scope.showSpinner = true;
			$http.get("/pyrography/webapi/products")
			
				.then(function(response) {
					$scope.supplies = response.data;
					console.log('number of products: ' + $scope.supplies.length);
					$scope.showSpinner = false;
				}, function(response) {
					console.log('error http GET products: ' + response.status);
				});
				
		}
		
		$scope.goToUpdateView = function(productId) {
			$location.path('/update/' + productId);
			
		}
		
		$scope.getAllSupplies();
		
		$scope.orderByColumn = function(column) {
			$scope.orderByValue = column;
			if($scope.reverse) {
				$scope.reverse = false;
			} else {
				$scope.reverse = true;
			}
		}
		
		$scope.reverse = false;
	})
})()