(function () {
 
    var module = angular.module("myApp");

        module.config(['$locationProvider', function ($locationProvider) {
                $locationProvider.hashPrefix('');
            }]);

        module.config(function ($stateProvider, $urlRouterProvider) {

 
            $stateProvider
            .state("createCompany", {
            	url: "/createcompany",
            	templateUrl: "createCompany.html",
            	controller: "CreateCompanyCtrl as b"
         })
            $stateProvider
            .state("DeleteCompany", {
            	url: "/deletecompany",
            	templateUrl: "deleteCompany.html",
            	controller: "DeleteCompanyCtrl as c"
            })
            $stateProvider
            .state("UpdateCompany", {
            	url: "/updatecompany",
            	templateUrl: "updateCompany.html",
            	controller: "UpdateCompanyCtrl as d"
            })
            $stateProvider
            .state("GetCompany", {
            	url: "/getcompany",
            	templateUrl: "getCompany.html",
            	controller: "GetCompanyCtrl as e"
            })
            $stateProvider
            .state("GetAllCompanies", {
            	url: "/getallcompanies",
            	templateUrl: "getAllCompanies.html",
            	controller: "GetAllCompaniesCtrl as f"
            })
            $stateProvider
            .state("CreateCustomer", {
            	url: "/createcustomer",
            	templateUrl: "createCustomer.html",
            	controller: "CreateCustomerCtrl as g"
            })
            $stateProvider
            .state("DeleteCustomer", {
            	url: "/deletecustomer",
            	templateUrl: "deleteCustomer.html",
            	controller: "DeleteCustomerCtrl as h"
            })
            $stateProvider
            .state("UpdateCustomer", {
            	url: "/updatecustomer",
            	templateUrl: "updateCustomer.html",
            	controller: "UpdateCustomerCtrl as i"
            })
            $stateProvider
            .state("GetCustomer", {
            	url: "/getcustomer",
            	templateUrl: "getCustomer.html",
            	controller: "GetCustomerCtrl as j"
            })
            $stateProvider
            .state("GetAllCustomer", {
            	url: "/getallcustomers",
            	templateUrl: "getAllCustomers.html",
            	controller: "GetAllCustomersCtrl as k"
            })

            $urlRouterProvider.when("", "/createcompany");
    });
 
})();



