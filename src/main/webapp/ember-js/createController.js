/**
 * Access the previously created module 'movieapp'
 */

(function() {
	var productapp = angular.module('productapp');

	productapp.controller('createController', function($scope, $http) {			
		
		$scope.difficultys = ['Beginner','Intermediate','Expert','Artisan'];
		
		$scope.createProduct = function() {
			$http.post("/pyrography/webapi/products", $scope.product)
			.then(function(response) {				
				$scope.createStatus = 'create successful';
				$scope.disableCreate = true;
			}, function(response) {
				$scope.createStatus = 'error trying to create product';	
				console.log('error http POST products: ' + response.status);
			});
		}
		
		$scope.clear = function() {
			$scope.product.productName = '';
			$scope.product.productRating = '';
			$scope.product.productPrice = '';
			$scope.product.productQuantity = '';
			$scope.product.experience = '';
			
			$scope.createForm.$setUntouched();
			$scope.createForm.$setPristine();
			
			$scope.disableCreate = false;
		}
		
	});
	
})()