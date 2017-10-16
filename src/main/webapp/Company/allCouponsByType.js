(function () {
 
    var module = angular.module("myApp");
 
    module.controller("GetCouponByTypeCtrl", GetCouponByTypeCtrlCtor);
 
    function GetCouponByTypeCtrlCtor(getAllCoupByType) {
    	
        this.couponsByType=[];
		var self = this
		
		this.getAllCoupType = function() {
					
		var promise = getAllCoupByType.getCoupByType(this.couponsByType)
		promise.then(function(resp) {
			console.log(resp.data)
			self.couponsByType = resp.data
		}, function(err) {
			alert(err.data);
		});

		}
	}
})();

 