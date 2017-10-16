var module = angular.module("myApp")

module.service("getAllCustomers", GetAllCustCtor)

function GetAllCustCtor($http)
{
    this.getCustomers = function()
    {
       var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/admin/getallcustomers')
    
         return myResponseDate;
    }
    
}

