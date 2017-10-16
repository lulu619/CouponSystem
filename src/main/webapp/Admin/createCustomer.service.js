var module = angular.module("myApp")

module.service("CreateCustomer", createCustomerCtor)

function createCustomerCtor($http)
{
	this.createCustomer= function(customer) {
	
	var myResponseDate = $http.post('http://localhost:8080/webcouponsystem/webapi/admin/createcustomer', customer)
	 
		return myResponseDate;
	}
}



