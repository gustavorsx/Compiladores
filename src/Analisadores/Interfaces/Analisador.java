package Analisadores.Interfaces;

import java.util.List;

public interface Analisador {

    List<String> analisar(List<String> palavras) throws RuntimeException;
}
