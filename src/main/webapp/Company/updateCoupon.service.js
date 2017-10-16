var module = angular.module("myApp")

module.service("UpdateCoupon", updateCouponCtor)

function updateCouponCtor($http)
{
	this.updateCoupon = function(coupon) {
	
	var myResponseDate = $http.put('http://localhost:8080/webcouponsystem/webapi/company/updatecoupon/' + coupon.id, coupon)
	 
		return myResponseDate;
	}
}

