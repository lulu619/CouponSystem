(function () {
 
    var module = angular.module("myApp");
 
    module.controller("GetCoupByPrCtrl", GetCoupByPrCtor);
 
    function GetCoupByPrCtor(getAllCoupByPrice) {
    	
        this.couponsByPrice=[];
  		var self = this
		
  		this.getCoupByPrice = function() {
  		  		
		var promise = getAllCoupByPrice.getCoupByPrice(this.couponsByPrice)
		promise.then(function(resp) {
			console.log(resp.data)
			self.couponsByPrice = resp.data
		}, function(err) {
			alert(err.data);
		});

  		}
	}
})();

 