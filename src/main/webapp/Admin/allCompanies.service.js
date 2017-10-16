
var module = angular.module("myApp")

module.service("getAllCompanies", GetAllCompCtor)

function GetAllCompCtor($http)
{
    this.getCompanies = function()
    {
        var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/admin/getallcompanies')
        
        return myResponseDate;
    }

}

