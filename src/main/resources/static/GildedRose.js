angular.module('gildedRose', [])
.controller('gildedRoseController', function($scope,$http) {
            var self = this;
            $scope.orderAttr = 'sellIn'
            $scope.reverse =  false



            $scope.onUpdateClicked = function(){
                    $http({
                          method: 'PUT',
                          url: 'http://localhost:8080/api/glidedRose/items'
                        }).then(function successCallback(response) {
                            $scope.data = response.data
                          }, function errorCallback(response) {

                          });
            }
            $http({
              method: 'GET',
              url: 'http://localhost:8080/api/glidedRose/items'
            }).then(function successCallback(response) {

                $scope.data = response.data
              }, function errorCallback(response) {

              });
});