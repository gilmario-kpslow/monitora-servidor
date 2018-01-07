/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class LoggerMonitor {

    private static final Logger LOG = Logger.getLogger(LoggerMonitor.class.getName());

    public static void LOG(Exception e) {
        LOG.log(Level.SEVERE, "Ocorreu uma exceção ineperada", e);
    }

}
