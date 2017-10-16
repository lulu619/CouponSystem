var module = angular.module("myApp")

module.service("getAllCoupByType", GetAllCoupByTypeCtor)

function GetAllCoupByTypeCtor($http)
{
    this.getCoupByType = function(coupon)
    {
         var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/company/allcoupbytype/' + coupon.type)
         
         return myResponseDate;
    }

}

