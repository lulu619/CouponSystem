(function () {
 
    var module = angular.module("myApp");
 
    module.controller("UpdateCouponCtrl", UpdateCouponCtrlCtor);
 
    function UpdateCouponCtrlCtor(UpdateCoupon) {
        this.coupon={};
  		var self = this

		this.updateCoupon= function() {

			var promise = UpdateCoupon.updateCoupon(this.coupon)
			promise.then(function(resp) {
				alert(resp.data);
				self.coupon = resp.data
			}, function(err) {
				alert(err.data);
			});
		}
	}
})();
 
 