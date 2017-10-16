(function() {

	var module = angular.module("myApp");

	module.controller("PurchaseCouponCtrl", PurchaseCouponCtor);

	function PurchaseCouponCtor(PurchaseCoupon) {

		this.purchaseCoupon = {}
		var self = this
		
		this.purchaseTheCoupon = function () {
		
		var promise = PurchaseCoupon.puCoupon(this.purchaseCoupon)
		promise.then(function(resp) {
			alert(resp.data);
			self.purchaseCoupon = resp.data
		}, function(err) {
			alert(err.data);
			console.log(err.data)
		});
		}
	}
})();
