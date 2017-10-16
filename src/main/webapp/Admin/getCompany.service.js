var module = angular.module("myApp")

module.service("GetCompany", getCompanyCtor)

function getCompanyCtor($http)
{
	this.getCompany = function(comp) {
	
	var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/admin/getcompany/' + comp.id)
	 
		return myResponseDate;
	}
}


