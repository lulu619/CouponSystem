(function() {

	var module = angular.module("myApp");

	module.controller("GetAllCustomersCtrl", GetAllCustomersCtrlCtor);

	function GetAllCustomersCtrlCtor(getAllCustomers) {

		this.customers = []
		var self = this
		var promise = getAllCustomers.getCustomers()
		promise.then(function(resp) {
			console.log(resp.data)
			self.customers = resp.data
		}, function(err) {
			alert(err.data);
		});

	}
})();
