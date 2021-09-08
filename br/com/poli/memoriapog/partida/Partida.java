package br.com.poli.memoriapog.partida;
import java.util.Scanner;
import java.util.Random;

import br.com.poli.memoriapog.player.Jogador;
import br.com.poli.memoriapog.tabuleiro.Tabuleiro;


public class Partida {
	private int numeroDeLinhas;
	private Random geradorCPU = new Random();
	private boolean continuarPartida = true;
	private Jogador[] jogador = new Jogador[2];
	private Tabuleiro tabuleiro;
	private char jogadorAtual = 0;
	Scanner scan = new Scanner(System.in);
	
	
	public Partida(int dif, Jogador j1, Jogador j2) {
		this.numeroDeLinhas = (dif*2) + 2;
		tabuleiro = new Tabuleiro(numeroDeLinhas);
		this.jogador[0] = j1;
		this.jogador[1] = j2;
	}
	
	public boolean jogadaValida(int jX, int jY) {	
		return tabuleiro.verificarPeca(jX, jY);
		
	}
	
	public boolean jogadaValida(int jX, int jY, int jX2, int jY2) {	
		return (jX != jX2 && jY != jY2);
	}
	
	
	
	public boolean fazerJogada(int jogadaX1,int jogadaY1, int jogadaX2, int jogadaY2) {
		boolean acerto;
		int x1= jogadaX1, y1= jogadaY1, x2 = jogadaX2, y2 = jogadaY2;
		
		
		acerto = tabuleiro.fazerJogada(x1, y1, x2, y2); //retorna o resultado da jogada,  true == acerto
		
		if(acerto) {
			System.out.println("jogador " + jogador[jogadorAtual].getNome() + " fez a jogada " + x1 + " e " + y1 + " e depois a proxima jogada " + x2 + " e " + y2 + " e acertou!");
			jogador[jogadorAtual].fezPonto();
			continuarPartida = tabuleiro.continuarPartida();
		}
			
		else if(acerto == false && jogadorAtual == 0) {
			System.out.println("jogador " + jogador[jogadorAtual].getNome() + " fez a jogada " + x1 + " e " + y1 + " e depois a proxima jogada " + x2 + " e " + y2 + " e errou :(");
			jogadorAtual = 1;//mudança de player se errou na jogada

		
		}
		
		else if(acerto == false && jogadorAtual == 1) {
			System.out.println("jogador " + jogador[jogadorAtual].getNome() + " fez a jogada " + x1 + " e " + y1 + " e depois a proxima jogada " + x2 + " e " + y2 + " e errou :(");
			jogadorAtual = 0; 

		}
		
		return acerto;
		
	}
	
	public String partidaFinalizada() {
		if(jogador[0].getScore() > jogador[1].getScore()) {
			return ("O jogador " + jogador[0].getNome() + " venceu com " + jogador[0].getScore() + " pontos!");
		}
		else if(jogador[1].getScore() > jogador[0].getScore()) {
			return ("O jogador " + jogador[1].getNome() + " venceu com " + jogador[1].getScore() + " pontos!");
			
		}
		else return ("Partida Empatada");
		
	}
	
	public int[] jogadaCpu() {
		int coords[] = new int[4];
		do {
			do {
				coords[0] = geradorCPU.nextInt(numeroDeLinhas);
				coords[1] = geradorCPU.nextInt(numeroDeLinhas);
			}while(!jogadaValida(coords[0], coords[1]));
			do {
				coords[2] = geradorCPU.nextInt(numeroDeLinhas);
				coords[3] = geradorCPU.nextInt(numeroDeLinhas);
			}while(!jogadaValida(coords[2], coords[3]));
		}while(coords[0] == coords[2] && coords[1] == coords[3]);
		return coords;
		
	}
	
	public String getJogadorEPontuação() {
		return "Jogador da Vez: " + jogador[jogadorAtual].getNome() + " - " + jogador[jogadorAtual].getScore();
	}
	
	
	public String getTabuleiro(int x, int y) {
		return tabuleiro.getPeca(x, y);
	}
	
	
	public boolean getContinuarPartida() {
		return this.continuarPartida;
	}
	
}