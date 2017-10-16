(function () {
 
    var module = angular.module("myApp");
 
    module.controller("CreateCustomerCtrl", CreateCustomerCtrlCtor);
 
    function CreateCustomerCtrlCtor(CreateCustomer) {
    	
        this.customer={};
  		var self = this

		this.createCustomer= function() {

			var promise = CreateCustomer.createCustomer(this.customer)
			promise.then(function(resp) {
				alert(resp.data);
				self.customer = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();
 