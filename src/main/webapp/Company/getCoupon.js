(function () {
 
    var module = angular.module("myApp");
 
    module.controller("GetCouponCtrl", GetCouponCtrlCtor);
 
    function GetCouponCtrlCtor(GetCoupon) {
    	
        this.coupon={};
 		var self = this

		this.getCoupon = function() {

			var promise = GetCoupon.getCoupon(this.coupon)
			promise.then(function(resp) {
				console.log(resp.data)
				self.coupon = resp.data
			}, function(err) {
				console.log(err.data)
				alert("Failed!")
				
			});
		}
	}
})();

 