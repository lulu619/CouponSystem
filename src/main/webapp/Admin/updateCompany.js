(function () {
 
    var module = angular.module("myApp");
 
    module.controller("UpdateCompanyCtrl", UpdateCompanyCtrlCtor);
 
    function UpdateCompanyCtrlCtor(UpdateCompany) {
        this.company = {};
  
		var self = this

		this.updateCompany= function() {

			var promise = UpdateCompany.updateCompany(this.company)
			promise.then(function(resp) {
				alert(resp.data);
				self.company = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();
 