package util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Validacao {

    public static void validarSomenteLetrasEEspaco(String texto) {
        if (!texto.matches("[a-zA-Z\\s]+")) {
            throw new RuntimeException("Somente pode conter letras e espaço.");
        }
    }

    public static void validarSomenteLetrasEEspacoComAcentos(String texto) {
        if (!Pattern.matches("[\\p{L}\\s]+", texto)) {
            throw new RuntimeException("Somente pode conter letras, espaço e acentos.");
        }
    }

    public static void validarFormatoEmail(String texto) {
        if (!texto.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new RuntimeException("Insira um formato válido. Exemplo: exemplo@exemplo.com.");
        }
    }

    public static void validarFomatoNumeroTelefone(String texto) {
        if (!texto.matches("^\\+\\d{2} \\(\\d{2}\\) \\d{5}-\\d{4}$")) {
            throw new RuntimeException("Insira um formato válido. Exemplo: +DD (XX) XXXXX-XXXX.");
        }
    }

    public static void validarFormatoCpf(String texto) {
        if (!texto.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new RuntimeException("Insira um formato válido. Exemplo: XXX.XXX.XXX-XX.");
        }
    }

    // Outras funções de validação podem ser adicionadas aqui, se necessário.
}
