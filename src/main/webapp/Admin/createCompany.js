(function() {

	var module = angular.module("myApp");

	module.controller("CreateCompanyCtrl", CreateCompanyCtrlCtor);

	function CreateCompanyCtrlCtor(createCompany) {

		this.company = {};
		var self = this

		this.createCompany= function() {

			var promise = createCompany.createCompany(this.company)
			promise.then(function(resp) {
				alert(resp.data);
				self.company = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();
