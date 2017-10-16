var module = angular.module("myApp")

module.service("UpdateCustomer", updateCustomerCtor)

function updateCustomerCtor($http)
{
	this.updateCustomer = function(customer) {
	
	var myResponseDate = $http.put('http://localhost:8080/webcouponsystem/webapi/admin/updatecustomer/' + customer.id, customer)
	 
		return myResponseDate;
	}
}

