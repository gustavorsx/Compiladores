package Analisadores;

import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.portugueseStemmer;

import Analisadores.Interfaces.Analisador;

import java.util.List;
import java.util.stream.Collectors;

public class AnalisadorLexema implements Analisador {

    private final SnowballStemmer stemmer;

    public AnalisadorLexema() {
        stemmer = new portugueseStemmer();
    }

    @Override
    public List<String> analisar(List<String> palavras) {
        return palavras.stream().map(this::validLexeme).collect(Collectors.toList());
    }

    private String validLexeme(String palavra) {
        stemmer.setCurrent(palavra);
        if (stemmer.stem()) {
            return stemmer.getCurrent();
        } else {
            return palavra;
        }
    }
}
