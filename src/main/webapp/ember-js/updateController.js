/**
 * Access the previously created module.
 */
(function() {
	var productapp = angular.module('productapp');

	productapp.controller('updateController', function($scope, $http, $routeParams, $location) {
		
		$scope.difficultys = ['Beginner','Intermediate','Expert','Artisan'];		
		$scope.getSuppliesById = function() {
			$http.get("/pyrography/webapi/products/" + $routeParams.productId)
			.then(function(response) {
				var supplies = response.data;
				if (supplies.length == 1) {
					$scope.product = supplies[0];
				} else {
					//TODO error message
				}				
			}, function(response) {
				console.log('error http GET products by id: ' + response.status);
			});
		}

		$scope.getSuppliesById();
		
		$scope.updateProduct = function() {
			$http.put("/pyrography/webapi/products", $scope.product)
			.then(function(response) {				
				$scope.updateStatus = 'update successful';			
			}, function(response) {
				$scope.updateStatus = 'error trying to update product';	
				console.log('error http PUT products: ' + response.status);
			});
		}
		$scope.deleteProduct = function() {
			$http.delete("/pyrography/webapi/products/" + $scope.product.id)
			.then(function(response) {				
				$scope.updateStatus = 'delete successful';	
				$scope.disableUpdate = true;
			}, function(response) {
				$scope.updateStatus = 'error trying to delete product';	
				console.log('error http DELETE products: ' + response.status);
			});
		}
		
		$scope.goToSearchView = function() {
			$location.path('/search')
		}
	})
})()

