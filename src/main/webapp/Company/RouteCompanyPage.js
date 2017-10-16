(function () {
 
    var module = angular.module("myApp");

        // http://stackoverflow.com/questions/41211875/angularjs-1-6-0-latest-now-routes-not-working
        module.config(['$locationProvider', function ($locationProvider) {
                $locationProvider.hashPrefix('');
            }]);

        
        module.config(function ($stateProvider, $urlRouterProvider) {

            $stateProvider
            .state("createCoupon", {
            	url: "/createcoupon",
            	templateUrl: "createCoupon.html",
            	controller: "CreateCouponCtrl as b"
         })
            $stateProvider
            .state("DeleteCoupon", {
            	url: "/deletecoupon",
            	templateUrl: "deleteCoupon.html",
            	controller: "DeleteCouponCtrl as c"
            })
            $stateProvider
            .state("UpdateCoupon", {
            	url: "/updatecoupon",
            	templateUrl: "updateCoupon.html",
            	controller: "UpdateCouponCtrl as d"
            })
            $stateProvider
            .state("GetCoupon", {
            	url: "/getcoupon",
            	templateUrl: "getCoupon.html",
            	controller: "GetCouponCtrl as e"
            })
            $stateProvider
            .state("GetAllCoupons", {
            	url: "/getallcoupons",
            	templateUrl: "getAllCoupons.html",
            	controller: "GetAllCouponsCtrl as f"
            })
            $stateProvider
            .state("getAllCoupByType", {
            	url: "/getallcoupbytype",
            	templateUrl: "getAllCoupByType.html",
            	controller: "GetCouponByTypeCtrl as g"
            })
            $stateProvider
            .state("getAllCoupByPrice", {
            	url: "/getallcoupbyprice",
            	templateUrl: "getAllCoupByPrice.html",
            	controller: "GetCoupByPrCtrl as h"
            })
            
            $urlRouterProvider.when("", "/createcoupon");

           
    });
 
})();



