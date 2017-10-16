(function() {

	var module = angular.module("myApp");

	module.controller("PurchCoupByTypeCtrl", PurchCoupByTypeCtor);

	function PurchCoupByTypeCtor(PurchCoupByType) {

		this.purchCoupByType = []
		var self = this
		
		this.getCouponByType = function () {
		
		var promise = PurchCoupByType.typePurchCoup(this.purchCoupByType)
		promise.then(function(resp) {
			console.log(resp.data)
			self.purchCoupByType = resp.data
		}, function(err) {
			console.log(err)
			alert(err.data);
		});
		}
	}
})();
