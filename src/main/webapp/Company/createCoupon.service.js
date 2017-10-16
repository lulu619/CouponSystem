var module = angular.module("myApp")

module.service("CreateCoupon", createCouponCtor)

function createCouponCtor($http)
{
	this.createCoupon = function(coupon) {
	
	var myResponseDate = $http.post('http://localhost:8080/webcouponsystem/webapi/company/createcoupon', coupon)
	 
		return myResponseDate;
	}
}

