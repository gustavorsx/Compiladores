package Analisadores;

import java.util.List;

import Analisadores.Interfaces.Analisador;

import static java.util.Arrays.asList;

public class AnalisadorLexico  {

    private final String textoCliente;
    private List<String> listaTokens, listaSimbolos;
    private final List<Analisador> analisadores;
    private AnalisadorPalavrasChave analisadorPalavrasChave;

    public AnalisadorLexico(String textoCliente) throws Exception {
        this.textoCliente = textoCliente;
        this.analisadores = asList(new AnalisadorAlfabeto(), new AnalisadorStopWords(), new AnalisadorLexema()
        );
        this.analisadorPalavrasChave = new AnalisadorPalavrasChave();
    }

    public void analisar() throws RuntimeException{
        this.listaTokens = Helper.getStringList(this.textoCliente, " ");
        analisadores.forEach(analisador -> {
            this.listaTokens = analisador.analisar(listaTokens);
        });
        listaSimbolos = analisadorPalavrasChave.analisar(listaTokens);
    }

    public String exibeListaTokens() {
        if (listaTokens != null) {
            return listaTokens.toString();
        } else {
            return "";
        }
    }

    public String exibeListaSimbolos() {
        if (listaSimbolos != null) {
            return listaSimbolos.toString();
        } else {
            return "";
        }
    }
}
