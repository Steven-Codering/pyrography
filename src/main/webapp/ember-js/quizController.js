
(function() {
var productapp = angular.module('productapp');

productapp.controller('quizController', function ($scope) {
  $scope.answers = {};
  $scope.showSuggestions = false;
  $scope.suggestedProducts = [];
  $scope.submitQuiz = function () {
    // Example logic for product suggestions based on user responses
    // Customize this based on your database and product criteria
    $scope.suggestedProducts = suggestProducts($scope.answers.q1, $scope.answers.q2, $scope.answers.q3);

    // Display suggestions
    $scope.showSuggestions = true;
  };
  
  
  

  function suggestProducts(answer1, answer2, answer3) {	
	
    let suggestions = []; 
    
    if (answer1 === '1 to 2 years' && answer2 === '2 to 3 times per week' && answer3 === 'More than 1 hour' ||
     answer1 === '1 to 2 years' && answer2 === '3 to 5 times per week' && answer3 === 'More than 1 hour' ||
     answer1 === '1 to 2 years' && answer2 === '3 to 5 times per week' && answer3 === 'Less than 1 hour') {
     	 suggestions = ['Great Book of Woodburning',
     	 'Tekchic Wood Burning Kit',
     	 'Parsons Colwood Detailer Single Burner Kit',
     	 'Parsons Colwood Cub Compact Burner Kit',
     	 'ColWood 1mm Stylus Tip, RT-Ball',
     	 '5/32 Rounded Heel Pen(FT-KR)',
     	 'Fixed Tip Pen Ball #1(FTB1)',
     	 '3/32 Skew Pen(FT-M)',
     	 'Fixed Tip Writing Pen(FT-C)'
     	 ];      
    } else if (answer1 === '2 to 4 years' && answer2 === '3 to 5 times per week' ||
     answer1 === '2 to 4 years' && answer2 === '2 to 3 times per week' && answer3 === 'More than 1 hour') {
     	 suggestions = ['Landscape Pyrography Techniques/Projects',
     	 'Colwood Super Pro 2 Kit',
     	 'Razertip SL3 Triple Burner Starter Kit W/4 Pens(KIT02-SL3)',
     	 'Razertip Pen Extra Small Knife(F14XS)',
     	 'Replaceable Tip Handle/CE99992',
     	 '3/16 Small Round Pen(FT-D)',
     	 'Woodburning/Pyrography Detail Nib Kit'
     	 ];
    } else if(answer1 === '2 to 4 years' && answer2 === 'Once a week' ||
    answer1 === '2 to 4 years' && answer2 === '2 to 3 times per week' && answer3 === 'Less than 1 hour') {
		 suggestions = ['Great Book of Woodburning',
     	 'Tekchic Wood Burning Kit',
     	 'Parsons Colwood Detailer Single Burner Kit',
     	 'Parsons Colwood Cub Compact Burner Kit',
     	 'ColWood 1mm Stylus Tip, RT-Ball',
     	 '5/32 Rounded Heel Pen(FT-KR)',
     	 'Fixed Tip Pen Ball #1(FTB1)',
     	 '3/32 Skew Pen(FT-M)',
     	 'Fixed Tip Writing Pen(FT-C)'
     	 ];
	} else {
		 suggestions = ['Woodburning Project & Pattern Tre',
     	 'Big Book of Pyrography Projects',
     	 'Pyrography Workbook',
     	 'Quick Start Woodburning Guide',
     	 'Walnut Hollow Kit',
     	 'Woodburning/Pyrography Mega Kit'
     	 ];
	}

    return suggestions;
  }
})
})()