var module = angular.module("myApp")

module.service("PurchCoupByType", PurchCoupByTypeCtor)

function PurchCoupByTypeCtor($http)
{
	this.typePurchCoup = function(purchaseCoup) {
	
	var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/customer/allpurcoupbytype/' + purchaseCoup.type)
	 
		return myResponseDate;
	}
}

