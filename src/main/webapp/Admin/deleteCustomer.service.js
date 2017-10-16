var module = angular.module("myApp")

module.service("DeleteCustomer", deleteCustomerCtor)

function deleteCustomerCtor($http)
{
	this.deleteCustomer = function(customer) {
	
	var myResponseDate = $http.delete('http://localhost:8080/webcouponsystem/webapi/admin/deletecustomer/' + customer.id)
	 
		return myResponseDate;
	}
}

