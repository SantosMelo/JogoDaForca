package Experimentos;

import java.io.BufferedWriter;

import jdk.jfr.events.FileWriteEvent;

public class EscreverNumArquivo1 {

	public static void main(String[] args) {
		BufferedWriter escritor = new BufferedWriter(new FileWriteEvent("teste.txt"));
		escritor.append("TESTE");//adicionar
		escritor.close();

	}

}
