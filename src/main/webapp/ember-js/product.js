
 (function(){
	var productapp = angular.module('productapp',['ngRoute']);
	productapp.run(function($rootScope){
		$rootScope.addToCart = function (product) {
    		$rootScope.cart.push({ name: product.productName, price: product.productPrice });
	    	console.log($rootScope.cart);
	    };
	    $rootScope.emptyMyCart = function(){
			$rootScope.cart = [];
		};  
    	$rootScope.cart = [];
    	$rootScope.total = 0;
    	$rootScope.$watch(function(){
			$rootScope.total = $rootScope.cart.reduce((acc,product)=>acc+product.price,0);
		});
	});
	
	
	productapp.config(function($routeProvider) {
  $routeProvider
  .when("/quiz", {
    templateUrl : "quiz.html",
    controller: "quizController"
  })
  .when("/productstore", {
    templateUrl : "productstore.html",
    controller: "storeController"
  })
  .when("/cart", {
    templateUrl : "cart.html",
    controller : "cartController"
  })
  .when("/search", {
    templateUrl : "search.html",
    controller : "searchController"
  })
  .when("/create", {
    templateUrl : "create.html",
    controller : "createController"
  })
  .when("/update/:productId", {
    templateUrl : "update.html",
    controller : "updateController"
  })
  .when("/resume", {
    templateUrl : "resume.html"
  })
  .when("/safety", {
    templateUrl : "safety.html"
  })
  .when("/stack", {
    templateUrl : "stack.html"
  })
  .when("/tipstricks", {
    templateUrl : "tipstricks.html"
  })
  .when("/funfacts", {
    templateUrl : "funfacts.html"    
  })
  .otherwise({
    templateUrl : "main.html"
  });
});
})()