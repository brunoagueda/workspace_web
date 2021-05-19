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
    console.log(lista);

                                                        
}