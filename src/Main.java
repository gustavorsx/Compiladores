import java.io.File;
import java.util.Scanner;

import Analisadores.AnalisadorLexico;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            File palavras = new File("textoCliente.txt");
            Scanner scn = new Scanner(palavras);
            StringBuilder texto = new StringBuilder(" ");
            while (scn.hasNext()) {
                texto.append(scn.nextLine()).append("\n");
            }
            String textoFormatado = texto.toString().replaceAll("\\p{Punct}","");
            AnalisadorLexico analisador = new AnalisadorLexico(textoFormatado.toString());
            analisador.analisar();
            System.out.println("Lista de tokens: \n" + analisador.exibeListaTokens());
            System.out.println("Tabela de símbolos: \n" + analisador.exibeListaSimbolos());
            scn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
