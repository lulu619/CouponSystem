(function () {
 
    var module = angular.module("myApp");
 
    module.controller("GetCustomerCtrl", GetCustomerCtrlCtor);
 
    function GetCustomerCtrlCtor(GetCustomer) {
    	
        this.customer={};
		var self = this

		this.getCustomer = function() {

			var promise = GetCustomer.getCustomer(this.customer)
			promise.then(function(resp) {
				console.log(resp.data)
				self.customer = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();