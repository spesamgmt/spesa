var employeeApp = angular.module("employee",[]);
employeeApp.controller("employeeController", function(){
	this.clearFields = function($event){
		$event.target.value = '';
	};
	
	this.setDefaultValues = function($event, label){
		if($event.target.value == ''){
			console.log('setDefaultValues');
			$event.target.value = label;
		}
	}
	
});


employeeApp.controller("myCon", function($scope){
	$scope.go = function(){
		console.log('hereva');
	};

});