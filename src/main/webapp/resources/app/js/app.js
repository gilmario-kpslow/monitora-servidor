var conexao;
function iniciaConexao() {
    conexao = new WebSocket("ws://localhost:8080/testador/connector");

    conexao.onmessage = (function (evt) {
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
function update() {
    jsf.ajax.request('form', null, {render: '@form'});
}
iniciaConexao();