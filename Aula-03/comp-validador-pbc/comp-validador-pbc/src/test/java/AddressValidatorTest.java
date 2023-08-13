import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import validators.AddressValidator;
import validators.NameValidator;

public class AddressValidatorTest {

    // POSITIVE:
    @Test
    public void testValidAddress() {
        String address = "255, Avenida Autaz Mirim, Jorge Teixeira, Manaus, AM, 69088-245";

        AddressValidator addressValidator = new AddressValidator("Address", "must be inserted: number, street, district, city, state(XX), zip code.");

        try {
            addressValidator.check(address);
            System.out.println("A valid address should pass.");
            assertTrue(true);
        } catch (ValidationException e) {
            fail("A valid address should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidAddress() {
        String address = "ASJDIOA, 151665156, Jorge Teixeira, Manaus, Amazonas, 690-245";

        AddressValidator addressValidator = new AddressValidator("Address", "must be inserted: number, street, district, city, state(XX), zip code.");

        try {
            addressValidator.check(address);
            System.out.println("An invalid address should fail validation.");
            fail();
        } catch (ValidationException e) {
            System.out.println(" An invalid name should triggers a ValidationException.");
            assertTrue(true);
        }
    }

}
