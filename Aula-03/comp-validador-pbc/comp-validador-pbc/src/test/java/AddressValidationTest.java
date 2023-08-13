import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validators.EndressValidator;
import validators.NameValidator;

public class AddressValidationTest {

    @Test
    public void testValidEndress() {
        //String endress = "255, Avenida Autaz Mirim, Jorge Teixeira, Manaus, AM, 69088‑245";

        String address = "1515515";

        EndressValidator endressValidator = new EndressValidator("Endress", "must be inserted: number, street, district, city, state(XX), zip code.");

        try {
            endressValidator.check(address);
            System.out.println("A valid endress should pass.");
        } catch (ValidationException e) {
            fail("!ERROR: A valid endress should not fail validation: " + e.getMessage());
        }
    }

}
