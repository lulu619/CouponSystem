(function () {
 
    var module = angular.module("myApp");
 
    module.controller("DeleteCouponCtrl", DeleteCouponCtrlCtor);
 
    function DeleteCouponCtrlCtor(DeleteCuoupon) {
    	
        this.coupon={};
		var self = this

		this.deleteCoupon = function() {

			var promise = DeleteCuoupon.deleteCoupon(this.coupon)
			promise.then(function(resp) {
				alert(resp.data);
				self.coupon = resp.data

			}, function(err) {
				console.log(err.data);
				alert("Failed!")
			});
		}
	}
})();