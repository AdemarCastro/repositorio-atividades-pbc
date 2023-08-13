
import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import validators.CPFValidator;

public class CPFValidatorTest {

    // POSITIVE:
    @Test
    public void testValidCPF() {
        String cpf = "139.085.160-56";

        CPFValidator cpfValidator = new CPFValidator("CPF", "must be inserted: XXX.XXX.XXX-XX.");

        try {
            cpfValidator.check(cpf);
            System.out.println("A valid CPF should pass.");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("A valid CPF should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidCPF() {
        String cpf = "555.777.000-00";

        CPFValidator cpfValidator = new CPFValidator("CPF", "must be inserted: XXX.XXX.XXX-XX.");

        try {
            cpfValidator.check(cpf);
            System.out.println("An invalid CPF should fail validation.");
            fail();
        } catch (ValidationException e) {
            System.out.println("An invalid CPF should triggers a ValidationException.");
            assertTrue(true);
        }
    }

}
