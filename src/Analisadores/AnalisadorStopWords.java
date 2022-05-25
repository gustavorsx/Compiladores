package Analisadores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Analisadores.Interfaces.Analisador;

public class AnalisadorStopWords implements Analisador {

    private List<String> stopWords;

    public AnalisadorStopWords() throws Exception {
        init();
    }

    private void init() throws Exception {
        File palavras = new File("stopwords_ptbr.txt");
        Scanner scn = new Scanner(palavras);
        StringBuilder stopWordsString = new StringBuilder(" ");
        while (scn.hasNext()) {
            stopWordsString.append(scn.nextLine().toLowerCase()).append("\n");
        }
        this.stopWords = Helper.getStringList(stopWordsString.toString(), "\n");
        scn.close();
    }

    @Override
    public List<String> analisar(List<String> palavras) {
        List<String> toRemoveList = new ArrayList<>();
        palavras.forEach(palavra -> {
            if(this.stopWords.contains(palavra)) {
                toRemoveList.add(palavra);
            }
        });
        palavras.removeAll(toRemoveList);

        return palavras;
    }
}
