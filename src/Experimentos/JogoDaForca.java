package Experimentos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
//42:16
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
	
	public static void main (String [] args) throws Exception {
		//SORTEADOR- Sortear as palavras.
		Random random = new Random();
		
		//SCANNER-entrada de dados
		Scanner in = new Scanner(System.in);
		
		//LIsta de Palavras
		//String [] palavras = //new String [30000]; ={"ORTODOXO", "PALAVRA", "MACARRONADA", "COMPLEXIDADE",
		//"AMIGO", "PNEUMONIA", "MITOCONDRIA", "CAVALEIRO", "FEITICEIRA"};
		
		//CONTAR AS PALAVRAS / LINHAS DE UM ARQUIVO
		LineNumberReader leitorLinhas = new LineNumberReader(new FileReader("GeradorPalavra.txt"));
		leitorLinhas.skip(Long.MAX_VALUE);// PULA ATÉ A ULTIMA LINHA
		int quantPalavras = leitorLinhas.getLineNumber() + 1;
		System.out.println("Tente a sorte, temos " + quantPalavras + " palavras!!!") ;
		leitorLinhas.close();
		
		String[] palavras = new String[quantPalavras];

		BufferedReader leitorArquivo = new BufferedReader(new FileReader("GeradorPalavra.txt")); 
		String linhaLida;
		int linha = 0;
		while ((linhaLida = leitorArquivo.readLine()) != null) { //quando for null significa no final do arquivo
			palavras [linha] = linhaLida;
			linha++;
		}
		leitorArquivo.close();
		//QUANTIDADE DE PALAVRAS
		//int quantPalavras = palavras.length;// funciona com vetores!! tamanho do vetor
		int indiceSorteado = random.nextInt(quantPalavras);//posicao no vetor da palavra sorteada.
		String sorteada = palavras[indiceSorteado];// PALAVRA SORTEADA
					//palavras na posicao indiceSorteado
					//
		/*controla os acertos do usuario... a ideia q que cada letra seja um acerto
		//A M I G O
		//0 1 2 3 4  Posicao
		//0 0 0 0 0 acertos
		//Ususario acerta a letra G
		//Acertou a letra M
	   /0 1 0 1 0
	    * */
	    
		char[] acertos = new char[sorteada.length()];
		for (int i = 0; i < acertos.length; i++) { //para cada uma das posicoes (posicao e'representada pela letra i)
			acertos[i] = 0;
		if(sorteada.charAt(i) == '-')
			acertos[i] = 1;
		}
		
		String letrasUtilizadas = "";
		
		char letra;
		
		boolean ganhou = false;
		int vidas = 5; //sorteada.length();  //Tamanho da palavra sorteada, ou seja, AMIGO = 5. CEU = 3 VIDAS
		
		for (int i = 0; i < sorteada.length(); i++) {
			if(acertos[i] == 1) {	
			System.out.print(" - ");
			} else {
				System.out.print(" __ ");
			}
			}
		System.out.println("\n");
		//System.out.println(sorteada);
		//Para sempre
		do {//
			
		
		System.out.println("\n"
				+ "Você tem " + vidas + " vidas"
				+ "\nletras utilizadas: " + letrasUtilizadas
				+ "\nQual letra vc deseja tentar?");
		String digitado = in.next().toUpperCase(); //Usa scanner para ler.. to uppercase para colocar
													//em maiusculo e depois o charAT(0) para pegar a primeira letra
		if(digitado.length() > 1) {
			if (digitado.equals(sorteada)) {
			ganhou = true;
			break;
		}else {
				vidas = 0;
				break;
			}
		} else {
			
		letra = digitado.charAt(0);
		letrasUtilizadas += " " + letra;// Concatenar ou juntar a letra nas letras utilizadas
		// VERIFICA SE A LETRA DIGITADA E IGUAL A LETRA DA PALAVRA SORTEADA
		//NA POSIÇAÕ I
		boolean perdeVida = true;
		
		//Mostra os underlines com o tamanho da palavra
		for (int i = 0; i < sorteada.length(); i++) {
			if (letra == sorteada.charAt(i)) {
				//System.out.println(//"Tem essa letra na posição " + i);
				acertos[i] = 1;
				perdeVida = false;
				
			}
		}
		if (perdeVida) {
			vidas--;// Executa só se o usuario nao acertar a letras nesta rodada
		}
		}
		System.out.println("\n");
		ganhou = true;// Digo que o usuario pode ter ganho
		for (int i = 0; i < sorteada.length(); i++) {
			
			if (acertos [i]== 0) {
			System.out.print(" __ ");
			ganhou = false;//Se existir alguns acertos[i] == 0 (alguma letra que não acertou)
							// eu digo que ele não ganhou!
			}
			else {
				System.out.print(" " + sorteada.charAt(i) + " ");
			}
		
			}
		
					System.out.println("\n");
		
		}while(!ganhou && vidas > 0);//se nao ganhou e se anida tem vida...repete
		
		if (vidas != 0){
		System.out.println("\n\t *** Você é um genio das palavras!! ***");
		}else {
			System.out.println("\n\t Leia mais...");
			System.out.println("\t A palavra era " + sorteada);
		}
	}

}
