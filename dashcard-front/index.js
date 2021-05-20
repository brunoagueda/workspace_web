function enviarDados(){
    var txtLogin = document.getElementById("txtLogin").value;
    var txtSenha = document.getElementById("txtSenha").value;

    

    // passo 1 - vou montar a msg de login

    var msgBody = {
        email   : txtLogin,
        racf    : txtLogin,
        senha   : txtSenha,
    }

    // passo 2 - vou montar o cabeçalho da requisição

    var cabecalho = {
        method  : "POST",
        body    : JSON.stringify(msgBody),
        headers :{
            "content-type":"application/json"
        }
    }

    // passo 3 - vou enviar a requisição para o back-end

    fetch("http://localhost:8080/login",cabecalho).then(res=> trataResultado(res))

    // passo 4 - vou tratar a resposta

}

function trataResultado(res){

    if(res.status == 200){
        res.json().then(usuario => {
            localStorage.setItem("userCARD", JSON.stringify(usuario));
            window.location = "agentes.html";

        });
    }
    else if(res.status == 403){
        document.getElementById("msgErro").innerHTML = "Senha Inválida";
    }
    else if(res.status == 404){
        document.getElementById("msgErro").innerHTML = "Usuário Desconhecido";
    }
    else {
        document.getElementById("msgErro").innerHTML = "Erro Desconhecido";
    }

}

var pswd = document.getElementById("txtSenha");

/* Call 'checkPswd' when the 'Enter' key is released. */
pswd.onkeyup = function (e) {
   if (e.which == 13) enviarDados();
};