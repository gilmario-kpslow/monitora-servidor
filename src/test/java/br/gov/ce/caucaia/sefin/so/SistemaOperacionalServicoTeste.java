package br.gov.ce.caucaia.sefin.so;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author gilmario
 */
//@RunWith(Arquillian.class)
//@DefaultDeployment(type = DefaultDeployment.Type.JAR)
public class SistemaOperacionalServicoTeste {

    @Test
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
}
