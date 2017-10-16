var module = angular.module("myApp")

module.service("PurchCoupByPrice", PurchCoupByPriceCtor)

function PurchCoupByPriceCtor($http)
{
	this.pricePurchCoup = function(purchaseCoup) {
	
	var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/customer/allpurcoupbyprice/' + purchaseCoup.price)
	 
		return myResponseDate;
	}
}

