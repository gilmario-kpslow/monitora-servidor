/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.servico.testadores;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author gilmario
 */
@ServerEndpoint("/connector")
@Singleton
public class Connector implements Serializable {

    private List<Session> sessions = new ArrayList<>();

    @OnMessage
    public void onMessage(Session session, String msg) {
//        try {
//            enviarMensagem();
//        } catch (IOException ex) {
//            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void enviarMensagem(String mensagem) throws IOException {
        for (Session session : sessions) {
            session.getBasicRemote().sendText(mensagem);
        }
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        sessions.remove(session);
    }

    void notificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
