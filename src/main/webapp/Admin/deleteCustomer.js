(function () {
 
    var module = angular.module("myApp");
 
    module.controller("DeleteCustomerCtrl", DeleteCustomerCtrlCtor);
 
    function DeleteCustomerCtrlCtor(DeleteCustomer) {
    	
        this.customer={};
		var self = this

		this.deleteCustomer = function() {

			var promise = DeleteCustomer.deleteCustomer(this.customer)
			promise.then(function(resp) {
				alert(resp.data);
				self.customer = resp.data

			}, function(err) {
				console.log(err.data);
				alert("Failed!")
			});
		}
	}
})();
