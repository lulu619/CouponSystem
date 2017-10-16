(function() {

	var module = angular.module("myApp");

	module.controller("GetAllCompaniesCtrl", GetAllCompaniesCtrlCtor);

	function GetAllCompaniesCtrlCtor(getAllCompanies) {

		this.companies = []
		var self = this
		var promise = getAllCompanies.getCompanies()
		promise.then(function(resp) {
			console.log(resp.data)
			self.companies = resp.data
		}, function(err) {
			alert(err.data);
			console.log(err.data)
		});

	}
})();
