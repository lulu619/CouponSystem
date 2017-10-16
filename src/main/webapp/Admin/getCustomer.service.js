var module = angular.module("myApp")

module.service("GetCustomer", getCustomerCtor)

function getCustomerCtor($http)
{
	this.getCustomer = function(customer) {
	
	var myResponseDate = $http.get('http://localhost:8080/webcouponsystem/webapi/admin/getcustomer/' + customer.id)
	 
		return myResponseDate;
	}
}


