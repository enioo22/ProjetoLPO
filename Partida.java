package br.com.poli.memoriapog.partida;
import java.util.Scanner;

import br.com.poli.memoriapog.player.Jogador;
import br.com.poli.memoriapog.tabuleiro.Tabuleiro;

public class Partida {
	private int numeroDeLinhas;
	private boolean continuarPartida = true;
	
	private Jogador[] jogador = new Jogador[2];
	private Tabuleiro tabuleiro;
	private char jogadorAtual = 0;
	private String[][] tabuleiroAtual; // para imprimir o tabuleiro em seu estado atual
	Scanner scan = new Scanner(System.in);
	
	
	public Partida(int dif, Jogador j1, Jogador j2) {
		this.numeroDeLinhas = (dif*2) + 2;
		tabuleiro = new Tabuleiro(numeroDeLinhas);
		this.jogador[0] = j1;
		this.jogador[1] = j2;
	}
	
	
	public void fazerJogada() {
		boolean acerto, pecaValida, jogadaInvalida;
		int x1, y1, x2, y2;
		
		pecaValida = true;
		jogadaInvalida = true;
		tabuleiroAtual = tabuleiro.getTabuleiro();
		
		imprimirTabuleiro();
		
		System.out.println("Jogador da Vez: " + jogador[jogadorAtual].getNome());
		
		do { // verificar se a peça ja foi descoberta
		
			do{ //verificar se a posição é valida
				System.out.println("linha da primeira peça: ");
				x1 = scan.nextInt();
				if(x1 < 0 || x1 >= numeroDeLinhas) {
					System.out.println("JOGADA INVALIDA");
					pecaValida = true;
				}
				else {
					pecaValida = false;
				}
			} while(pecaValida);

			do{ 
				System.out.println("coluna da primeira peça: ");
				y1 = scan.nextInt();
				if(y1 < 0 || y1 >= numeroDeLinhas) {
					System.out.println("JOGADA INVALIDA");
					pecaValida = true;
				}
				else {
					pecaValida = false;
				}
			
			} while(pecaValida);
			
			if(!(tabuleiro.getPecaTabuleiro(x1,y1).equals(" "))) {
				System.out.println("JOGADA INVALIDA PEÇA JA DESCOBERTA");
				jogadaInvalida = true;
			}
			else jogadaInvalida = false;
			
			tabuleiroAtual[x1][y1] = tabuleiro.getPeca(x1, y1);
			imprimirTabuleiro();
			
			
		}while(jogadaInvalida);
		
		jogadaInvalida = true;
		
		
		do {
			do{
				System.out.println("linha da segunda peça: ");
				x2 = scan.nextInt();
				if(x2 < 0 || x2 >= numeroDeLinhas) {
					System.out.println("JOGADA INVALIDA");
					pecaValida = true;
				}
				else {
					pecaValida = false;
				}
			} while(pecaValida);
		
		
			do{
				System.out.println("coluna da segunda peça: ");
				y2 = scan.nextInt();
				if(y2 < 0 || y2 >= numeroDeLinhas) {
					System.out.println("JOGADA INVALIDA");
					pecaValida = true;
				}
				else {
					pecaValida = false;
				}
			} while(pecaValida);
		
			if(!(tabuleiro.getPecaTabuleiro(x2,y2).equals(" "))) {
				System.out.println("JOGADA INVALIDA - PEÇA JA DESCOBERTA");
				jogadaInvalida = true;
				
			}
			else jogadaInvalida = false;

		
			tabuleiroAtual[x2][y2] = tabuleiro.getPeca(x2, y2);
			imprimirTabuleiro();
		}while(jogadaInvalida);
		
		
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
			continuarPartida = tabuleiro.continuarPartida();
			if(continuarPartida==false) partidaFinalizada();
			
		}
			
		else if(acerto == false && jogadorAtual == 0) {
		jogadorAtual = 1;//mudança de player se errou na jogada
		}
		
		else if(acerto == false && jogadorAtual == 1) {
		jogadorAtual = 0;
		}
		
	}
	
	public void partidaFinalizada() {
		if(jogador[0].getScore() > jogador[1].getScore()) {
			System.out.println("O jogador " + jogador[0] + " venceu com " + jogador[0].getScore() + " pontos!");
			System.out.println("O jogador " + jogador[1] + " perdeu com " + jogador[1].getScore() + " pontos.");
		}
		else if(jogador[1].getScore() > jogador[0].getScore()) {
			System.out.println("O jogador " + jogador[1] + " venceu com " + jogador[1].getScore() + " pontos!");
			System.out.println("O jogador " + jogador[0] + " perdeu com " + jogador[0].getScore() + " pontos.");
		}
		else System.out.println("Partida Empatada");
		
	}
	
	
	public void imprimirTabuleiro() {
		
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
	
	public boolean getContinuarPartida() {
		return this.continuarPartida;
	}
	
}
