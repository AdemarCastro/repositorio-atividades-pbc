import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validators.NameValidator;
public class NameValidatorTest {

    // POSITIVE:
    @Test
    public void testValidName() {
        String name = "Ademar Castro";

        NameValidator nameValidator = new NameValidator("Name", "it should just be unaccented letters, with accent and space.");

        try {
            nameValidator.check(name);
            System.out.println("A valid name should pass.");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("A valid name should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidName() {
        String name = "$#$@#@@##ADOJASD912209";

        NameValidator nameValidator = new NameValidator("Name", "it should just be unaccented letters, with accent and space.");

        try {
            nameValidator.check(name);
            System.out.println("An invalid name should fail validation.");
            fail();
        } catch (ValidationException e) {
            System.out.println("An invalid name should triggers a ValidationException.");
            assertTrue(true);
        }
    }

}
