(function() {

	var module = angular.module("myApp");

	module.controller("GetAllPurcCoupCtrl", GetAllPurcCoupCtor);

	function GetAllPurcCoupCtor(GetAllPurcCoupons) {

		this.allPurchaseCoupons = []
		var self = this
		
		var promise = GetAllPurcCoupons.getAllPurcCoupon()
		promise.then(function(resp) {
			console.log(resp.data)
			self.allPurchaseCoupons = resp.data
		}, function(err) {
			console.log(err)
			alert(err.data);
		});
		
	}
})();
