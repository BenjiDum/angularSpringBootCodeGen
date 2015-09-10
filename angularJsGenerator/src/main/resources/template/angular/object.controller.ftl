
'use strict';

var ${objectName}Module = angular.module('${objectName}Module', ['ngResource', 'ui-notification']);

${objectName}Module.controller('${objectName}Ctrl', ['$rootScope','$scope','$http','$log','$filter', 'Notification', '$modal', '${objectName}Service',
	function($rootScope,$scope,$http,$log,$filter,Notification,$modal,${objectName}Service) {

	
		$scope.steperrors = [];
		$scope.loading = 0;
        $scope.${objectName}List = [];
		${objectName}Service.getAll${objectNameUpper}s($scope);
				
		$scope.openEditModal = function (selected${objectNameUpper}) {
			var modalInstance = $modal.open({
				templateUrl: '${objectName}EditModalContent.html',
				controller: '${objectName}ModalEditInstanceCtrl',
				backdrop: 'static',
				resolve: {
					selected${objectNameUpper}: function () {
						return selected${objectNameUpper};
					}
				}
			});
			modalInstance.result.then(function (selected${objectNameUpper}) {
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
		};
		
		$scope.openCreateModal = function (created${objectNameUpper}) {
			var modalInstance = $modal.open({
				templateUrl: '${objectName}CreateModalContent.html',
				controller: '${objectName}ModalCreateInstanceCtrl',
				backdrop: 'static',
				resolve: {
					created${objectNameUpper}: function () {
						return created${objectNameUpper};
					}
				}
			});
			modalInstance.result.then(function (created${objectNameUpper}) {
			    $scope.${objectName}List.push(created${objectNameUpper});
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
		};


	}]);

angular.module('${objectName}Module').controller('${objectName}ModalCreateInstanceCtrl', function ($rootScope, $scope, $modalInstance, $log, Notification, ${objectName}Service) {

	$scope.edit = function (created${objectNameUpper}) {
		$scope.created${objectNameUpper} = created${objectNameUpper};
		$scope.created${objectNameUpper} = ${objectName}Service.create${objectNameUpper}($scope.created${objectNameUpper}, $scope, Notification);
		$modalInstance.close($scope.created${objectNameUpper});
	};

	$scope.cancel = function () {
    	$modalInstance.dismiss('cancel');
	};
});	

angular.module('${objectName}Module').controller('${objectName}ModalEditInstanceCtrl', function ($scope, $modalInstance, Notification, selected${objectNameUpper}, ${objectName}Service) {

	$scope.selected${objectNameUpper} = selected${objectNameUpper};
	$scope.backup = angular.copy($scope.selected${objectNameUpper});

	$scope.edit = function (selected${objectNameUpper}) {
		$scope.selected${objectNameUpper} = selected${objectNameUpper};
		$scope.selected${objectNameUpper} = ${objectName}Service.update${objectNameUpper}($scope.selected${objectNameUpper}, Notification);
		$modalInstance.close($scope.selected${objectNameUpper});
	};

  $scope.cancel = function () {
	angular.copy($scope.backup, $scope.selected${objectNameUpper});
    $modalInstance.dismiss('cancel');
  };
});


