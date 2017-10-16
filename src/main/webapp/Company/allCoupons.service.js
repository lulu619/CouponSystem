var module = angular.module("myApp")

module.service("getAllCoupons", GetAllCoupCtor)

function GetAllCoupCtor($http)
{
    this.getCoupons = function()
    {
        var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/company/getallcoupons')
        
        return myResponseDate;
    }

}

