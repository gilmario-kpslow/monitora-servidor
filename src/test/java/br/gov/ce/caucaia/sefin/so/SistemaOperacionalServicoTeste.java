package br.gov.ce.caucaia.sefin.so;

import java.util.Objects;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;
import org.wildfly.swarm.spi.api.JARArchive;

/**
 *
 * @author gilmario
 */
//@RunWith(Arquillian.class)
//@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class SistemaOperacionalServicoTeste {

    @ArquillianResource
    InitialContext context;

    //@EJB
    //private SistemaOperacionalServico servico;
//    @Test
    public void testDataSourceIsBound() throws Exception {
        SistemaOperacionalServico servico = (SistemaOperacionalServico) context.lookup("java:global/testador/SistemaOperacionalServico!br.gov.ce.caucaia.sefin.so.SistemaOperacionalServico");
        if (Objects.isNull(servico)) {
            servico = (SistemaOperacionalServico) context.lookup("java:app/testador/SistemaOperacionalServico!br.gov.ce.caucaia.sefin.so.SistemaOperacionalServico");
        } else {
            System.out.println("Funcionaou 1");
        }
        if (Objects.isNull(servico)) {
            servico = (SistemaOperacionalServico) context.lookup("java:module/SistemaOperacionalServico!br.gov.ce.caucaia.sefin.so.SistemaOperacionalServico");
        } else {
            System.out.println("Funcionaou 2");
        }
        if (Objects.isNull(servico)) {
            servico = (SistemaOperacionalServico) context.lookup("java:global/testador/SistemaOperacionalServico");
        } else {
            System.out.println("Funcionaou 3");
        }
        if (Objects.isNull(servico)) {
            servico = (SistemaOperacionalServico) context.lookup("java:module/SistemaOperacionalServico");
        } else {
            System.out.println("Funcionou 4");
        }

        Assert.assertNotNull(servico);
    }
}
