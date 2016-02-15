var conexao;
function iniciaConexao() {
    $(".mostrador").hide("slow");
//    var url = new String(document.location.href);
    var url = document.getElementById("servidorID").value;
    var path = url.replace("http://" + document.location.host, "");
    path = path.replace("/notificador.xhtml", "");

    conexao = new WebSocket("ws://" + document.location.host + path + "connector");
    conexao.onmessage = (function (evt) {
        console.log(evt.data);
        setTimeout(update, 5000);
    });
    conexao.onerror = (function (evt) {
        console.log('erro');
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
    jsf.ajax.request('form', 'null', {render: 'form'});
    console.log("update");
}
iniciaConexao();