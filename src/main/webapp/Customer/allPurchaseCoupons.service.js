var module = angular.module("myApp")

module.service("GetAllPurcCoupons", GetAllPurchaseCouponCtor)

function GetAllPurchaseCouponCtor($http)
{
	this.getAllPurcCoupon = function() {
	
	var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/customer/allpurchasedcoupons')
	 
		return myResponseDate;
	}
}

