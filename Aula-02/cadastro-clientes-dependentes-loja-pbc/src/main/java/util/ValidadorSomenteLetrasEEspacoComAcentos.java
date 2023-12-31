package util;

import java.util.regex.Pattern;

public class ValidadorSomenteLetrasEEspacoComAcentos implements Validacao {
    public void validar(Object value) {

        String texto = (String) value;

        if (!Pattern.matches("[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+", texto)) {
            throw new RuntimeException("Nome ou Endereço inválidos: Somente pode conter letras, espaço e acentos.");
        }
    }
}
