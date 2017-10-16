var module = angular.module("myApp")

module.service("createCompany", createCompanyCtor)

function createCompanyCtor($http)
{
	this.createCompany = function(comp) {
	
	var myResponseDate = $http.post('http://localhost:8080/webcouponsystem/webapi/admin/createcompany', comp)
	 
		return myResponseDate;
	}
}

