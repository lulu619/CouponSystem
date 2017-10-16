(function() {

	var module = angular.module("myApp");

	module.controller("DeleteCompanyCtrl", DeleteCompanyCtrlCtor);

	function DeleteCompanyCtrlCtor(DeleteCompany) {

		this.company = {};
		var self = this

		this.deleteCompany = function() {

			var promise = DeleteCompany.deleteCompany(this.company)
			promise.then(function(resp) {
				alert(resp.data);
				self.company = resp.data

			}, function(err) {
				console.log(err.data);
				alert("Failed!")
			});
		}
	}
})();
