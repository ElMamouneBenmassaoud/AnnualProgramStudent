var requestData = new Vue({
    el: '#requestData',
    data: {
        genre: "man",
        taille: 177,
        poids: 69
    },
    methods: {
        computeBMI: function () {
            url = "http://localhost:8080/api/bmi?"
                + "weight=" + requestData.poids
                + "&height=" + requestData.taille
                + "&gender=" + requestData.genre;
            console.log("Appel Rest: " + url);
            axios.get(url)
                .then(function (response) {
                    data = response.data;
                    responseData.imc = data.bmi;
                    responseData.corpulence = data.corpulence;
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
        imc: 0,
        corpulence: ""
    }
});