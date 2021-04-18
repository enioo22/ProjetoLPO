package br.com.poli.memoriapog.partida;
import java.util.Scanner;

import br.com.poli.memoriapog.player.Jogador;
import br.com.poli.memoriapog.tabuleiro.Tabuleiro;

public class Partida {
	private int numeroDeLinhas;
	
	private static Jogador[] jogador = new Jogador[2];
	private Tabuleiro tabuleiro;
	private static char jogadorAtual = 0;
	private static String[][] tabuleiroAtual; // para imprimir o tabuleiro em seu estado atual
	Scanner scan = new Scanner(System.in);
	
	
	public Partida(int dif, Jogador j1, Jogador j2) {
		this.numeroDeLinhas = (dif*2) + 2;
		tabuleiro = new Tabuleiro(numeroDeLinhas);
		this.jogador[0] = j1;
		this.jogador[1] = j2;
	}
	
	
	public void fazerJogada() {
		boolean acerto;
		tabuleiroAtual = tabuleiro.getTabuleiro();
		
		System.out.println("Jogador da Vez: " + jogador[jogadorAtual].getNome());
		System.out.println("linha da primeira peça: ");
		int x1 = scan.nextInt();
		System.out.println("coluna da primeira peça: ");
		int y1 = scan.nextInt();
		tabuleiroAtual[x1][y1] = tabuleiro.getPeca(x1, y1);
		imprimirTabuleiro(x1, y1);
		
		System.out.println("linha da segunda peça: ");
		int x2 = scan.nextInt();
		System.out.println("coluna da segunda peça: ");
		int y2 = scan.nextInt();
		tabuleiroAtual[x2][y2] = tabuleiro.getPeca(x2, y2);
		imprimirTabuleiro(x1, y1, x2, y2);
		
		System.out.println("Pressione enter para continuar...");
		try   //o scan.nextline n funcionou :(
        	{
				System.in.read();
        	}  
			catch(Exception e)
			{}
		
		
		acerto = tabuleiro.fazerJogada(x1, y1, x2, y2); //retorna o resultado da jogada,  true == acerto
		
		System.out.println("jogador " + jogador[jogadorAtual].getNome() + " fez a jogada " + x1 + " e " + y1 + " e depois a proxima jogada " + x2 + " e " + y2);
		
		if(acerto) {
			jogador[jogadorAtual].fezPonto();
		}
		
		else if(acerto == false && jogadorAtual == 0) {
			jogadorAtual = 1;//mudança de player se errou na jogada
		}
			
		else if(acerto == false && jogadorAtual == 1) {
			jogadorAtual = 0;
		}
		
		
	}
	public void imprimirTabuleiro(int x, int y) {
		
		System.out.print("    ");              //printa a primeira linha do tabuleiro
		for(int o = 0; o< numeroDeLinhas; o++) {
			if(o == numeroDeLinhas-1) {
				System.out.println("("  + String.valueOf(o) + ") ");
			}
			else System.out.print("("  + String.valueOf(o) + ") ");
			
		}
		for(int i = 0;i <numeroDeLinhas; i++) {
			System.out.print("   .");
			for(int o = 0; o<numeroDeLinhas; o++) {
				if(o == numeroDeLinhas-1) System.out.println("---.");
				else System.out.print("---.");
			}
			System.out.print("(" + i + ")");
			for(int o = 0; o <numeroDeLinhas; o++) {
				System.out.print("| " + tabuleiroAtual[i][o] + " ");
			}
			System.out.println("|");
			
		}
		System.out.print("    ");
		for(int i = 0; i < numeroDeLinhas; i++) {
			if(i == numeroDeLinhas-1) System.out.println("---.");
			else System.out.print("---.");
		}
		
	}
	public void imprimirTabuleiro(int x1, int y1, int x2, int y2) {

		System.out.print("    ");              //printa a primeira linha do tabuleiro
		for(int o = 0; o< numeroDeLinhas; o++) {
			if(o == numeroDeLinhas-1) {
				System.out.println("("  + String.valueOf(o) + ") ");
			}
			else System.out.print("("  + String.valueOf(o) + ") ");
			
		}
		for(int i = 0;i <numeroDeLinhas; i++) {
			System.out.print("   .");
			for(int o = 0; o<numeroDeLinhas; o++) {
				if(o == numeroDeLinhas-1) System.out.println("---.");
				else System.out.print("---.");
			}
			System.out.print("(" + i + ")");
			for(int o = 0; o <numeroDeLinhas; o++) {
				System.out.print("| " + tabuleiroAtual[i][o] + " ");
			}
			System.out.println("|");
			
		}
		System.out.print("    ");
		for(int i = 0; i < numeroDeLinhas; i++) {
			if(i == numeroDeLinhas-1) System.out.println("---.");
			else System.out.print("---.");
		}
	}
}