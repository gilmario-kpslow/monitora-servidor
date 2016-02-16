var conexao;
var alerta;
function iniciaConexao() {
    $(".mostrador").hide("slow");
    var url = $("#servidorID").val();
    conexao = new WebSocket("ws://" + url + "/connector");
    conexao.onmessage = (function (evt) {
        console.log(evt.data);
        setTimeout(update, 5000);
    });
    conexao.onerror = (function (evt) {
        console.log('erro');
        console.log(evt.data);
    });
    conexao.onopen = (function () {
        console.log('open');
        $(".mostrador").show("slow");
    });
    conexao.onclose = (function () {
        console.log('close');
        $(".mostrador").hide("slow");
    });
}
function update() {
    tocarAlerta();
    jsf.ajax.request('form', 'null', {render: 'form'});
    console.log("update");
}
carregarSom();
iniciaConexao();
manterSessao();
function manterSessao() {
    jsf.ajax.request('form', 'null');
    setTimeout(manterSessao, 300000);
    console.log('mantendo sessao');
}

function carregarSom() {
    alerta = new Audio();
    alerta.src = "resources/snd/alerta.ogg";
    alerta.volume = 0.9;
    alerta.load();
}

function tocarAlerta() {
    alerta.pause();
    alerta.currentTime = 0.0;
    alerta.play();
}