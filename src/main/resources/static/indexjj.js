angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/library';

    $scope.init = function(){
       $http.get(contextPath + '/prepods')
                   .then(function (response) {
                       $scope.prepods = response.data;
                   });
    };

    $scope.init();

    $scope.createNewPrepod = function () {
            $http.post(contextPath + '/prepods', $scope.newPrepod)
                .then(function successCallback(response) {
                    $scope.loadPage(1);
                    $scope.newPrepod = null;
                }, function errorCallback(response) {
                    alert('Error: ' + response.data.messages);
                });
        };

    $scope.getInfoToConsole = function (prepod) {
            console.log(prepod);
    }

    $scope.loadPage = function (pageNumber) {
            $http({
                url: contextPath + '/prepods',
                method: 'GET',
                params: {
                    p: pageNumber
                }
            }).then(function (response) {
                $scope.prepodsPage = response.data;

                let minPageIndex = pageNumber - 2;
                if (minPageIndex < 1) {
                    minPageIndex = 1;
                }

                let maxPageIndex = pageNumber + 2;
                if (maxPageIndex > $scope.prepodsPage.totalPages) {
                    maxPageIndex = $scope.prepodsPage.totalPages;
                }

                $scope.paginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);

                console.log("PAGE FROM BACKEND")
            });
        };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadPage(1);

});