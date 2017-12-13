/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.servidor;

import java.util.Objects;

/**
 *
 * @author gilmario
 */
public final class Ip {
    
    private ValorIp[] valoresIp;
    private final String separador;

    public Ip(String separador) {
        this.separador = separador;
        valoresIp = new ValorIp[3];
    }
    public Ip(String separador, String numero) throws Exception {
        this.separador = separador;
        setNumero(numero);
    }
    
    public void setNumero(String numero) throws Exception{
        String[] valores = numero.split("\\".concat(separador));
        if(valores.length < 4){
            throw new Exception("numero de IP inválido");
        }
        for(int i =0 ;i<4;i++){
        valoresIp[i] = new ValorIp(valores[i]);    
        }
    }
    
    

    private final class ValorIp{
        
        private String valor;

        public ValorIp() {
        }

        public ValorIp(String valor) throws Exception {
            setValor(valor);
        }
        
        
        

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) throws Exception {
            if(Objects.isNull(valor) || valor.length() > 3 || valor.length() < 1){
                throw new Exception("Valor de Ip Inválido");
            }
            this.valor = valor;
        }
    }
    
    
}
