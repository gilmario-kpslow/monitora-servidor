var conexao;
var notificacoes = new Array();
function iniciaConexao() {
    var url = new String(document.location.href);
    var path = url.replace("http://" + document.location.host, "");
    path = path.replace("/notificador.xhtml", "");

    conexao = new WebSocket("ws://" + document.location.host + path + "/connector");
    conexao.onmessage = (function (evt) {
        notificacoes.push(evt.data);
        update();
        console.log(evt.data);
    });
    conexao.onerror = (function (evt) {
        console.log('erro');
    });
    conexao.onopen = (function () {
        console.log('open');
    });
}

function limpar() {
    notificacoes = new Array();
    update();
}

function update() {
    var html = "";
    for (var n in notificacoes) {
        html += "<div class='alert alert-danger'><span>" + notificacoes[notificacoes.length - n - 1] + "</span></div>"
    }
    $("#notificador").html(html);
}

iniciaConexao();