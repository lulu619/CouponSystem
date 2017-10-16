var module = angular.module("myApp")

module.service("GetCoupon", getCouponCtor)

function getCouponCtor($http)
{
	this.getCoupon = function(coupon) {
	
	var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/company/getcoupon/' + coupon.id)
	 
		return myResponseDate;
	}
}


