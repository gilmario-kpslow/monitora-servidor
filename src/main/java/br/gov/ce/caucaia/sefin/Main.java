/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin;

import org.wildfly.swarm.Swarm;

/**
 *
 * @author gilmario
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Swarm swarm = new Swarm(args);
            swarm.start();
            swarm.deploy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
