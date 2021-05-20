function verificaUsuario(){
    var usuario = localStorage.getItem("userCARD");

    if(!usuario){
        window.location = "index.html";
    }

    usuario = JSON.parse(usuario);
    console.log("usuario conectado = " +usuario.nome);

    document.getElementById("fotoUsuario").innerHTML = `<img src="${usuario.linkFoto}" width="100%">`;
    document.getElementById("bioUsuario").innerHTML = `<h3>${usuario.nome}</h3>
                                                        <hr>
                                                        <strong>RACF</strong> ${usuario.racf} <br>
                                                        <strong>EMAIL</strong> ${usuario.email} <br>
                                                        <strong>RAMAL</strong> ${usuario.ramal} <br>
                                                        <strong>DEPTO</strong> ${usuario.nomeDepto}`;



    fetch("http://localhost:8080/agentes")
        .then(res => res.json())
        .then(lista => preencheTabela(lista));

        // sabem como eu leio esse fetch?
/*
    res = fetch("http://localhost:8080/agentes")
    lista = res.json();
    preencheTabela(lista);
*/
}

function preencheTabela(lista){


    var strSelect = `   <label for="agente">Selecione o Agente Financeiro</label>
                        <select id="agente" name="agente" class="form-control mb-3 mt-3" onchange="usaAgente()">
                            <option value="-1">**SELECIONE SEU AGENTE***</option>`;


    var strTabela = `<table class ="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th scope="col"> Nome do Parceiro </th>
                                <th scope="col"> Volume Transacional </th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        `;
    for (i=0; i<lista.length; i++){
        var agente = lista[i];
        strTabela = strTabela + `<tr>
                                    <td> ${agente.nome} </td>
                                    <td> ${agente.volume} </td>
                                </tr>`;
        strSelect = strSelect + `<option value="${agente.id}"> ${agente.nome} </option>`
    
    }

    strTabela = strTabela +`</tbody>
                            </table>`;
    
    strSelect = strSelect + `</select>`;


    document.getElementById("tabelaAgentes").innerHTML = strTabela;   
    document.getElementById("seletorAgentes").innerHTML = strSelect;
    

                                                        
}


function usaAgente(){
    
    var idAgente = document.getElementById("agente").value;
    
    console.log("mudou para agente ="+idAgente);
    
    if(idAgente != -1){
        window.location = "dashboard.html?id="+idAgente;
    }
}

function logOut(){
    localStorage.clear();
    window.location.href = "../dashcard-front/index.html";
}