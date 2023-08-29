package ifam.pbccomponentewebserviceaula.controller;

import exceptions.ValidationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validators.NameValidator;

import javax.naming.Name;
import java.io.IOException;

@RestController
@RequestMapping("/api/validation")
public class ValidationController {

    //    http://localhost:8080/api/validation/name/entrada
    @GetMapping(value="/name/{input}")
    public String validationName(@PathVariable("input") String input) throws ValidationException, IOException {

        try{
            NameValidator validator = new NameValidator(
                    "Name",
                    "deve conter apenas letras e espaço"
            );

            validator.check(input);

            return "Recebi "+input;
        }catch (ValidationException e){
            return "NÃO PASSEI: "+e.getMessage();
        }
    }

}
