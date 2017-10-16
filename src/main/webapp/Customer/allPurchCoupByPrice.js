(function() {

	var module = angular.module("myApp");

	module.controller("PurchCoupByPriceCtrl", PurchCoupByPriceCtor);

	function PurchCoupByPriceCtor(PurchCoupByPrice) {

		this.purchCoupByPrice = []
		var self = this
		
		this.getCouponByPrice = function () {
		
		var promise = PurchCoupByPrice.pricePurchCoup(this.purchCoupByPrice)
		promise.then(function(resp) {
			console.log(resp.data)
			self.purchCoupByPrice = resp.data
		}, function(err) {
			console.log(err)
			alert(err.data);
		});
		}
	}
})();
