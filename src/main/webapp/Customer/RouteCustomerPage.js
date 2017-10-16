(function () {
 
    var module = angular.module("myApp");

        // http://stackoverflow.com/questions/41211875/angularjs-1-6-0-latest-now-routes-not-working
        module.config(['$locationProvider', function ($locationProvider) {
                $locationProvider.hashPrefix('');
            }]);

        
        module.config(function ($stateProvider, $urlRouterProvider) {

        	
            $stateProvider
            .state("purchaseCoupon", {
            	url: "/purchasecoupon",
            	templateUrl: "purchaseCoupon.html",
            	controller: "PurchaseCouponCtrl as b"
         })
            $stateProvider
            .state("allPurchCoup", {
            	url: "/allpurchcoup",
            	templateUrl: "allPurchaseCoupons.html",
            	controller: "GetAllPurcCoupCtrl as c"
            })
            $stateProvider
            .state("allPurchCoupByType", {
            	url: "/allpurchcoupbytype",
            	templateUrl: "allPurchCoupByType.html",
            	controller: "PurchCoupByTypeCtrl as d"
            })
            $stateProvider
            .state("allPurchCoupByPrice", {
            	url: "/allpurchcoupbyprice",
            	templateUrl: "allPurchCoupByPrice.html",
            	controller: "PurchCoupByPriceCtrl as e"
            })
            
            $urlRouterProvider.when("", "/purchasecoupon");
            
    });
 
})();



