var module = angular.module("myApp")

module.service("DeleteCuoupon", deleteCouponCtor)

function deleteCouponCtor($http)
{
	this.deleteCoupon = function(coupon) {
	
	var myResponseDate = $http.delete('http://localhost:8080/webcouponsystem/webapi/company/deletecoupon/' + coupon.id)
	 
		return myResponseDate;
	}
}

