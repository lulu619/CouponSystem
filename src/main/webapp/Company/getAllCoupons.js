(function() {

	var module = angular.module("myApp");

	module.controller("GetAllCouponsCtrl", GetAllCouponsCtrlCtor);

	function GetAllCouponsCtrlCtor(getAllCoupons) {

		this.coupons = []
		var self = this
		
		var promise = getAllCoupons.getCoupons()
		promise.then(function(resp) {
			console.log(resp.data)
			self.coupons = resp.data
		}, function(err) {
			alert(err.data);
		});

	}
})();
