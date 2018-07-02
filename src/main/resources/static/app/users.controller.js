(function () {

    angular
        .module("app")
        .controller("UsersController", UsersController);

    UsersController.$inject = ['$http'];


    function UsersController($http) {
        var vm = this;

        vm.users = [];
        vm.sortType='accountNumber';
        vm.sortReverse=false;
        vm.searchName='';
        vm.form={};
        vm.newUserRequest=false;
        vm.editUser={};
        vm.editUserRequest=false;
      //  vm.form.firstName='';
       // vm.form.lastName='';
        vm.getAll = getAll;
        vm.getByName = getByName;
        vm.deleteUser = deleteUser;
        vm.addUser = addUser;
        vm.updateUser = updateUser;

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

        function addUser(formData){
            var url = "/users/create/";
            $http({
                method: 'POST',
                url: url,
                data: JSON.stringify(formData)
            })
                .then(function (success) {
                    console.log(success);
                    vm.users = success.data;
                    //callback(success);
                }, function (error) {
                    console.log(error.data);
                });

        }

        function updateUser(id, formData){
            var url = "/users/update/" + id;
            console.log(formData);
            $http({
                method: 'PUT',
                url: url,
                data: JSON.stringify(formData)
            })
                .then(function (success) {
                    console.log(success);
                    vm.users = success.data;
                    //callback(success);
                }, function (error) {
                    console.log(error.data);
                });

        }
    }


}




)();