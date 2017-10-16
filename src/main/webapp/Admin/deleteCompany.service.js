var module = angular.module("myApp")

module.service("DeleteCompany", deleteCompanyCtor)

function deleteCompanyCtor($http)
{
	this.deleteCompany = function(comp) {
	
	var myResponseDate = $http.delete('http://localhost:8080/webcouponsystem/webapi/admin/deletecompany/' + comp.id)
	 
		return myResponseDate;
	}
}

