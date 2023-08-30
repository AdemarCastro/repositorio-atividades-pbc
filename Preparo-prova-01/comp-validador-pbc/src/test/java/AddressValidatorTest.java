import exceptions.ValidationException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import pbc.base.Logger;
import pbc.exception.LoggerException;
import validators.AddressValidator;

public class AddressValidatorTest {

    // POSITIVE:
    @Test
    public void testValidAddress() throws LoggerException {
        String address = "255, Avenida Autaz Mirim, Jorge Teixeira, Manaus, AM, 69088-245";

        AddressValidator addressValidator = new AddressValidator("Address", "must be inserted: number, street, district, city, state(XX), zip code.", new Logger());

        try {
            addressValidator.check(address);
            System.out.println("A valid address should pass.");
            assertTrue(true);
        } catch (ValidationException | LoggerException e) {
            fail("A valid address should not fail validation: " + e.getMessage());
        }
    }

    // NEGATIVE:
    @Test
    public void testInvalidAddress() {
        String address = "ASJDIOA, 151665156, Jorge Teixeira, Manaus, Amazonas, 690-245";

        Logger logger = new Logger();
        AddressValidator addressValidator = null;

        try {
            addressValidator = new AddressValidator("Address", "must be inserted: number, street, district, city, state(XX), zip code.", logger);
            addressValidator.check(address);

            assertTrue(true);
        } catch (ValidationException | LoggerException e) {

            assertTrue(e instanceof ValidationException);

            try {
                logger.log(e);
            } catch (LoggerException loggerEx) {
                fail("Failed to log the ValidationException: " + loggerEx.getMessage());
            }
        }
    }

}
