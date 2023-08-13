import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import validators.CNPJValidator;

public class CNPJValidatorTest {

    // POSITIVE:
    @Test
    public void testValidCNPJ() {
        String cnpj = "67.524.965/0001-54";

        CNPJValidator cnpjValidator = new CNPJValidator("CNPJ", "must be inserted: XX.XXX.XXX/XXXX-XX.");

        try {
            cnpjValidator.check(cnpj);
            System.out.println("A valid CNPJ should pass.");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("A valid CNPJ should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidCNPJ() {
        String cnpj = "22.000.965/7777-00";

        CNPJValidator cnpjValidator = new CNPJValidator("CNPJ", "must be inserted: XX.XXX.XXX/XXXX-XX.");

        try {
            cnpjValidator.check(cnpj);
            System.out.println("An invalid CNPJ should fail validation.");
            fail();
        } catch (ValidationException e) {
            System.out.println("An invalid CNPJ should triggers a ValidationException.");
            assertTrue(true);
        }
    }

}
