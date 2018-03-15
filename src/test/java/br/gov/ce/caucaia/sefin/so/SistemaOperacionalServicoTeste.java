package br.gov.ce.caucaia.sefin.so;

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gilmario
 */
//@RunWith(Arquillian.class)
//@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class SistemaOperacionalServicoTeste {

//    @Test
    public void testaValidacao() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        SistemaOperacional operacional = new SistemaOperacional();
        //operacional.setNome("qwerty qwerty qwerty qwe rty qwe ert erty rty rty rty rty rty rty rty rt");
        operacional.setNome("12");
        Set<ConstraintViolation<SistemaOperacional>> sets = validator.validate(operacional);

        sets.forEach(s -> {
            System.out.println(s.getMessage());
            System.out.println(s.getLeafBean());
            System.out.println(s.getRootBean());
            System.out.println(s.getInvalidValue());
            System.out.println(s.getMessageTemplate());
            System.out.println(s.getPropertyPath());
        });
        Assert.assertTrue(true);
    }

    //@ArquillianResource
    //InitialContext context;
    //@EJB
    //private SistemaOperacionalServico servico;
//    @Test
    public void testDataSourceIsBound() throws Exception {
        /**
         * SistemaOperacionalServico servico = (SistemaOperacionalServico)
         * context.lookup("java:global/testador/SistemaOperacionalServico!br.gov.ce.caucaia.sefin.so.SistemaOperacionalServico");
         * if (Objects.isNull(servico)) { servico = (SistemaOperacionalServico)
         * context.lookup("java:app/testador/SistemaOperacionalServico!br.gov.ce.caucaia.sefin.so.SistemaOperacionalServico");
         * } else { System.out.println("Funcionaou 1"); } if
         * (Objects.isNull(servico)) { servico = (SistemaOperacionalServico)
         * context.lookup("java:module/SistemaOperacionalServico!br.gov.ce.caucaia.sefin.so.SistemaOperacionalServico");
         * } else { System.out.println("Funcionaou 2"); } if
         * (Objects.isNull(servico)) { servico = (SistemaOperacionalServico)
         * context.lookup("java:global/testador/SistemaOperacionalServico"); }
         * else { System.out.println("Funcionaou 3"); } if
         * (Objects.isNull(servico)) { servico = (SistemaOperacionalServico)
         * context.lookup("java:module/SistemaOperacionalServico"); } else {
         * System.out.println("Funcionou 4"); }
         *
         * Assert.assertNotNull(servico);
         *
         */
    }

//    @Test
    public void testaGet() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/api/v1");
        String lista = target.path("/so").request(MediaType.APPLICATION_JSON).get(String.class);
        String espected = "[{\"id\":4,\"nome\":\"\"},{\"id\":3,\"nome\":\"Cent OS\"},{\"id\":25,\"nome\":\"ddf\"},{\"id\":14,\"nome\":\"dfd\"},{\"id\":42,\"nome\":\"dff\"},{\"id\":7,\"nome\":\"dfgdfgdgfd\"},{\"id\":15,\"nome\":\"ere\"},{\"id\":43,\"nome\":\"fdfdgdgdfdf\"},{\"id\":19,\"nome\":\"ksjdhkjh\"},{\"id\":10,\"nome\":\"rsdfsdfsdfsd\"},{\"id\":11,\"nome\":\"sadfsd\"},{\"id\":16,\"nome\":\"sdfs\"},{\"id\":8,\"nome\":\"sdfsd\"},{\"id\":13,\"nome\":\"sdfsdf\"},{\"id\":21,\"nome\":\"sdfsdfsd\"},{\"id\":24,\"nome\":\"sdfsdl kjlkj\"},{\"id\":23,\"nome\":\"sdfsf\"},{\"id\":45,\"nome\":\"sdfsfdfdf\"},{\"id\":9,\"nome\":\"sdlçfksdçflskçdf\"},{\"id\":44,\"nome\":\"sdwdw\"},{\"id\":12,\"nome\":\"ssdfgsdfsdffffffff\"},{\"id\":26,\"nome\":\"ssss\"},{\"id\":1,\"nome\":\"TESTE\"},{\"id\":2,\"nome\":\"Ubuntu\"},{\"id\":6,\"nome\":\"Window Server 2011\"}]";
        System.out.println(lista);
        Assert.assertEquals(espected, lista);
    }

    @Test
    public void testaPost() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/api/v1");
        Entity<String> soEntity = Entity.entity("{\"nome\":\"Ubuntu 16.10\"}", MediaType.APPLICATION_JSON);
        System.out.println(soEntity.toString());
        String resposta = target.path("/so").request().header("Accept", "application/json").header("Content-Type", "application/json").post(soEntity, String.class);

        String espected = "";
        System.out.println(resposta);
        Assert.assertEquals(espected, resposta);
    }
}
