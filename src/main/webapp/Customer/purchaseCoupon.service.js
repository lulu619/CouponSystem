var module = angular.module("myApp")

module.service("PurchaseCoupon", PurchaseCouponCtor)

function PurchaseCouponCtor($http)
{
	this.puCoupon = function(purchaseCoup) {
	
	var myResponseDate = $http.post('http://localhost:8080/webcouponsystem/webapi/customer/purchasecoupon/' + purchaseCoup.id)
	 
		return myResponseDate;
	}
}

