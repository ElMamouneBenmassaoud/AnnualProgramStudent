var requestData = new Vue({
    el: '#requestData',
    data: {
        id: "INT1",
    },
    methods: {
        getCourse: function () {
            console.log("call getCourse()");
            url = "http://localhost:8080/api/course/"
                + requestData.id;
            console.log("Appel Rest: " + url);
            axios.get(url)
                .then(function (response) {
                    data = response.data;
                    responseData.id = data.id;
                    responseData.title = data.title;
                    responseData.credits = data.credits;
                })
                .catch(function (error) {
                    alert("Erreur appel REST");
                });
        }
    }
});

var responseData = new Vue({
    el: '#responseData',
    data: {
        id: "",
        title: "",
        credits: 0
    }
});
