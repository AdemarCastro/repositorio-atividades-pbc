import exceptions.ValidationException;
import org.junit.jupiter.api.Test;
import validators.PhoneValidator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class PhoneValidatorTest {

    // POSITIVE:
    @Test
    public void testValidPhone() {
        String phone = "+55 (99) 92222-3333";

        PhoneValidator phoneValidator = new PhoneValidator("Phone", "must be inserted: +DD (XX) XXXXX-XXXX.");

        try {
            phoneValidator.check(phone);
            System.out.println("A valid Phone should pass.");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("A valid Phone should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidPhone() {
        String phone = "55922223333";

        PhoneValidator phoneValidator = new PhoneValidator("Phone", "must be inserted: +DD (XX) XXXXX-XXXX.");

        try {
            phoneValidator.check(phone);
            System.out.println("An invalid Phone should fail validation.");
            fail();
        } catch (ValidationException e) {
            System.out.println("An invalid Phone should triggers a ValidationException.");
            assertTrue(true);
        }
    }

}
