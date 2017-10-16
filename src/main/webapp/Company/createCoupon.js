(function () {
 
    var module = angular.module("myApp");
 
    module.controller("CreateCouponCtrl", CreateCouponCtrlCtor);
 
    function CreateCouponCtrlCtor(CreateCoupon) {
    	
        this.coupon={};
		var self = this

		this.createCoupon= function() {

			var promise = CreateCoupon.createCoupon(this.coupon)
			promise.then(function(resp) {
				alert(resp.data);
				self.coupon = resp.data
			}, function(err) {
				alert(err.data);
	
			});
		}
	}
})();

 