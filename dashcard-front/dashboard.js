function geraRelatorio(){
    var strUser = localStorage.getItem("userCARD");
    if(!strUser){
        window.location="index.html";
    }

    var strId = window.location.search;

    console.log("capturado da url = "+strId);
    var id = strId.substr(4);

    console.log("ID Filtrado = "+id);

    fetch("http://localhost:8080/transacoestotais/"+id)
        .then(res=>res.json())
        .then(totais=> montaDashboard(totais));
}

function montaDashboard(totais){
    document.getElementById("nomeAgente").innerHTML = "<h4>"+totais.nomeAgente+"</h4>";
    document.getElementById("volumeAgente").innerHTML = "<h4>"+totais.volume+"</h4>";
    document.getElementById("sucesso").innerHTML = totais.totalSucesso;
    document.getElementById("falha").innerHTML = totais.totalFalha;
    document.getElementById("fraude").innerHTML = totais.totalFraude;
}

function voltaPagina(){
    window.location.href = "../dashcard-front/agentes.html";
}

function logOut(){
    window.location.href = "../dashcard-front/agentes.html";
}