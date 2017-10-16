var module = angular.module("myApp")

module.service("UpdateCompany", updateCompanyCtor)

function updateCompanyCtor($http)
{
	this.updateCompany = function(comp) {
	
	var myResponseDate = $http.put('http://localhost:8080/webcouponsystem/webapi/admin/updatecompany/' + comp.id, comp)
	 
		return myResponseDate;
	}
}

