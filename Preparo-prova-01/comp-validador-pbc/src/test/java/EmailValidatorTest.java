import exceptions.ValidationException;
import org.junit.jupiter.api.Test;
import pbc.base.Logger;
import pbc.exception.LoggerException;
import validators.EmailValidator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class EmailValidatorTest {

    // POSITIVE:
    @Test
    public void testValidEmail() throws LoggerException {
        String email = "ademar.castro@outlook.com";

        EmailValidator emailValidator = new EmailValidator("Email", "must be inserted: exemplo@exemplo.com", new Logger());

        try {
            emailValidator.check(email);
            System.out.println("A valid Email should pass.");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("A valid CPF should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidEmail() throws LoggerException {
        String email = "adsasdasdoutlook>>222";

        EmailValidator emailValidator = new EmailValidator("Email", "must be inserted: exemplo@exemplo.com", new Logger());

        try {
            emailValidator.check(email);
            System.out.println("An invalid Email should fail validation.");
            fail();
        } catch (ValidationException e) {
            System.out.println("An invalid Email should triggers a ValidationException.");
            assertTrue(true);
        }
    }

}
