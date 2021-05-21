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
    document.getElementById("nomeAgente").innerHTML = "<h4>Agente Financeiro: "+totais.nomeAgente+"</h4>";
    document.getElementById("volumeAgente").innerHTML = "<h5>Volume de Transações: "+totais.volume+"</h5>";
    document.getElementById("sucesso").innerHTML = "<div class='sucesso'>Operações com sucesso: "+totais.totalSucesso+"</sucesso>";
    document.getElementById("falha").innerHTML = "<div class='falha'>Operações com falha: "+totais.totalFalha+"</falha>";
    document.getElementById("fraude").innerHTML = "<div class='fraude'>Possíveis fraudes: "+totais.totalFraude+"</fraude>";

    var ctx = document.getElementById('meuGrafico').getContext('2d');
    var meuGrafico = new Chart(ctx, 
    {
        type : 'polarArea',
        data : {
            labels: ['Sucesso', 'Falha', 'Fraude'],
            datasets : [{
                label: '# de operaçoes',
                data: [totais.totalSucesso, totais.totalFalha, totais.totalFraude],
                backgroundColor : ['rgba(75, 192, 192, 0.2)','rgba(255, 206, 86, 0.2)','rgba(255, 99, 132, 0.2)']
            }] 
        },
        options : {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true,
                    }
                }]
            }
        }
    }
    );
}

function voltaPagina(){
    window.location.href = "../dashcard-front/agentes.html";
}

function logOut(){
    localStorage.clear();
    window.location.href = "../dashcard-front/index.html";
}