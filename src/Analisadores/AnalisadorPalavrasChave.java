package Analisadores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Analisadores.Interfaces.Analisador;

public class AnalisadorPalavrasChave implements Analisador {

    private List<String> palavrasChave;
    private AnalisadorLexema analisadorLexema;

    public AnalisadorPalavrasChave() throws Exception {
        init();
    }

    private void init() throws Exception {
        File palavras = new File("palavrasChave.txt");
        Scanner scn = new Scanner(palavras);
        StringBuilder stopWordsString = new StringBuilder(" ");
        while (scn.hasNext()) {
            stopWordsString.append(scn.nextLine().toLowerCase()).append("\n");
        }
        this.palavrasChave = Helper.getStringList(stopWordsString.toString(), "\n");
        analisadorLexema = new AnalisadorLexema();
        this.palavrasChave = analisadorLexema.analisar(palavrasChave);
        scn.close();
    }

    @Override
    public List<String> analisar(List<String> palavras) {
        List<String> listaSimbolos = new ArrayList<>();
        palavras.forEach(palavra -> {
            if(!palavrasChave.contains(palavra)) {
                listaSimbolos.add(palavra);
            }
        });
        return listaSimbolos;
    }
}
