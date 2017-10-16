var module = angular.module("myApp")

module.service("getAllCoupByPrice", GetAllCoupbyPriceCtor)

function GetAllCoupbyPriceCtor($http)
{
    this.getCoupByPrice = function(coupon)
    {
         var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/company/getallcoupbyprice/' + coupon.price)
         
         return myResponseDate;
    }

}

