import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import validators.NameValidator;
public class NameValidatorTest {

    // POSITIVE: NameValidator
    @Test
    public void testValidName() {
        String name = "Ademar Castro";

        NameValidator nameValidator = new NameValidator("Name", "it should just be unaccented letters, with accent and space.");

        try {
            nameValidator.check(name);
            assertTrue(true, "A valid name should pass.");
        } catch (ValidationException e) {
            fail("A valid name should not fail validation.");
            System.out.println("!ERROR: "+e.getMessage());
        }
    }

    // NEGATIVE: NameValidator
    @Test
    public void testInvalidName() {
        String name = "6731862##817%$#@@";

        NameValidator nameValidator = new NameValidator("Name", "it should just be unaccented letters, with accent and space.");

        try {
            nameValidator.check(name);
            fail("An invalid name should fail validation.");
        } catch (ValidationException e) {
            assertTrue(true, "An invalid name should triggers a ValidationException.");
        }
    }

}
