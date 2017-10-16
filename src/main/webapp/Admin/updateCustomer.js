(function () {
 
    var module = angular.module("myApp");
 
    module.controller("UpdateCustomerCtrl", UpdateCustomerCtrlCtor);
 
    function UpdateCustomerCtrlCtor(UpdateCustomer) {
        this.customer={};
		var self = this

		this.updateCustomer= function() {

			var promise = UpdateCustomer.updateCustomer(this.customer)
			promise.then(function(resp) {
				alert(resp.data);
				self.customer = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();
 
 