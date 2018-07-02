(function () {

    angular
        .module("app")
        .controller("UsersController", UsersController);

    UsersController.$inject = ['$http'];


    function UsersController($http) {
        var vm = this;

        vm.users = [];
        vm.getAll = getAll;
        vm.getByName = getByName;
        vm.deleteUser = deleteUser;

        init();

        function init(){
            getAll();
            // console.log(vm.users);
        }


        function getAll() {
            var url = "/users/all";
            var usersPromise = $http.get(url);
            usersPromise.then(function (response) {
                vm.users = response.data;
                console.log(response.data);
                console.log(vm.users);
            })
        }

        function getByName(sValue) {
            var url = "/users/search/" + sValue;
            var usersPromise=$http.get(url);
            usersPromise.then(function (response) {
                vm.users = response.data;
            })
        }



        function deleteUser(id){
            var url = "/users/delete/" + id;
            $http.post(url).then(function (response) {
                vm.users = response.data;
            })
        }

        function addUser(){
            var url = "/users/create/" + id;
            $http.post(url).then(function (response) {
                vm.users = response.data;
            })
        }
    }
    

}




)();