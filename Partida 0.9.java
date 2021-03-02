package projetoLPO;
import java.util.Scanner;

public class Partida {
	private static Jogador[] jogador = new Jogador[2];
	private static Tabuleiro tabuleiro = new Tabuleiro();
	static char jogadorAtual = 1;
	
	public static void inicializarJogadores() {
		jogador[0].chamarNome();
		jogador[1].chamarNome();
	}
	
	public static void fazerJogada() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Jogador da Vez: " + jogadorAtual);
	
		System.out.println("X da primeira peça: ");
		int x1 = scan.nextInt();
		System.out.println("Y da primeira peça: ");
		int y1 = scan.nextInt();
		System.out.println("X da segunda peça: ");
		int x2 = scan.nextInt();
		System.out.println("Y da segunda peça: ");
		int y2 = scan.nextInt();
		if(Tabuleiro.fazerJogada(x1, y1, x2, y2) == false && jogadorAtual == 1) jogadorAtual = 2;
		else if(Tabuleiro.fazerJogada(x1, y1, x2, y2) == false && jogadorAtual == 2) jogadorAtual = 1;
		//else jogador[jogadorAtual-1	].fezPonto();
		System.out.println("jogador " + jogadorAtual + " fez a jogada " + x1 + " e " + y1 + "e depois a proxima jogada " + x2 + " e " + y2);
		
	}
}
