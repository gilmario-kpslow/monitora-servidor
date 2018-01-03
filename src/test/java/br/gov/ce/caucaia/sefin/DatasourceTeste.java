/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin;

import javax.naming.InitialContext;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

/**
 *
 * @author gilmario
 */
@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class DatasourceTeste {

    @ArquillianResource
    InitialContext context;

    @Test
    public void testDataSourceIsBound() throws Exception {
        Object ds = (Object) context.lookup("java:jboss/datasources/testeDS");
        Assert.assertNotNull(ds);
    }
}
