var conexao;
function iniciaConexao() {
    $(".mostrador").hide("slow");
    var url = new String(document.location.href);
    var path = url.replace("http://" + document.location.host, "");
    path = path.replace("/notificador.xhtml", "");

    conexao = new WebSocket("ws://" + document.location.host + path + "/connector");
    conexao.onmessage = (function (evt) {
        update();
        console.log(evt.data);
    });
    conexao.onerror = (function (evt) {
        console.log('erro');
    });
    conexao.onopen = (function () {
        console.log('open');
        $(".mostrador").show("slow");
    });
}
function update() {
    jsf.ajax.request('form', null, {render: '@form'});
}
iniciaConexao();