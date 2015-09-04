
'use strict';

/* Services ${objectName}*/

var ${objectName}Module = angular.module('${objectName}Module');

${objectName}Module.factory('${objectName}Service', ['$resource','${moduleBaseUrlParamName}', '$http', '$q', '$log', function($resource,${moduleBaseUrlParamName},$http,$q, $log){
	var api = 'newbiz/api/v1/${objectName}';
	return {
		getAll${objectNameUpper}s : function($scope) {
			var deferred = $q.defer();
			$http.get(${moduleBaseUrlParamName} + api +'/all')
			.then(function(response){
				$scope.${objectName}List = response.data;
				deferred.resolve(response.data);
            },function(response){
                deferred.reject(response);
            });
            return deferred.promise;
		},
		create${objectNameUpper} : function(${objectName}, $scope, Notification){
            var deferred = $q.defer();
            $http.post(${moduleBaseUrlParamName} + api + '/create', ${objectName})
            .then(function(response){
                deferred.resolve(response.data);
                Notification.success('${objectName} à été crée dans NewBiz avec succès');
            },function(response){
                deferred.reject(response);
                Notification.error('Une erreur est survenue, ${objectName} n\'a pas été crée');
            });
            return deferred.promise;
        },
		update${objectNameUpper} : function(${objectName}, Notification){
            var deferred = $q.defer();
            $http.post(${moduleBaseUrlParamName}+ api + '/update?id='+ ${objectName}.id, ${objectName})
            .then(function(response){
            	Notification.success('${objectName} à été mis à jour dans NewBiz avec succès');
                deferred.resolve(response.data);
            },function(response){
                deferred.reject(response);
                Notification.error('Une erreur est survenue, ${objectName} n\'a pas été mis à jour');
            });
            return deferred.promise;
        },
        delete${objectNameUpper} : function(${objectName}){
            var deferred = $q.defer();
            $http.post(${moduleBaseUrlParamName}+ api + '/update?id='+ ${objectName}.id)
            .then(function(response){
                deferred.resolve(response.data);
            },function(response){
                deferred.reject(response);
            });
            return deferred.promise;
        }
	}
}]);
