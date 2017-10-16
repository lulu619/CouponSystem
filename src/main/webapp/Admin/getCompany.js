(function() {

	var module = angular.module("myApp");

	module.controller("GetCompanyCtrl", GetCompanyCtrlCtor);

	function GetCompanyCtrlCtor(GetCompany) {

		this.company = {};
		var self = this

		this.getCompany = function() {

			var promise = GetCompany.getCompany(this.company)
			promise.then(function(resp) {
				console.log(resp.data)
				self.company = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();
