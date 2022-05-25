package Analisadores;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Analisadores.Interfaces.Analisador;

public class AnalisadorAlfabeto implements Analisador {

    private final Pattern regex = Pattern.compile("[a-zA-Zá-úÁ-Ú0-9_@./#?&+-ç]*");

    @Override
    public List<String> analisar(List<String> palavras) throws RuntimeException {
        List<String> palavrasInvalidas = validarAlfabeto(palavras);

        if(palavrasInvalidas.size() != 0) {
            throw new RuntimeException("As palavras a seguir não pertencem ao Português: " + palavrasInvalidas.toString());
        }
        return palavras;
    }

    private List<String> validarAlfabeto(List<String> palavras) {
        List<String> palavrasInvalidas = new ArrayList<>();
        palavras.forEach(palavra -> {
            if(!palavra.matches(regex.pattern())) {
                palavrasInvalidas.add(palavra);
            }
        });

        return palavrasInvalidas;
    }
}
