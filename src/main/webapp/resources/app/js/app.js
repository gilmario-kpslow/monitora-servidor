var conexao;
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
    jsf.ajax.request('form', 'null', {render: 'form'});
    console.log("update");
}
iniciaConexao();