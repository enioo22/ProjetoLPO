package projetoLPO;
import java.util.Scanner;

public class Partida {
	private static Jogador[] jogador = new Jogador[2];{
	jogador[0] = new Jogador();
	jogador[1] = new Jogador();
	}
	private static Tabuleiro tabuleiro = new Tabuleiro();
	static char jogadorAtual = 0;
	
	public static void inicializarJogadores() {
		jogador[0].chamarNome();
		jogador[1].chamarNome();
	}
	
	public static void fazerJogada() {
		boolean acerto;
		Scanner scan = new Scanner(System.in);
		System.out.println("Jogador da Vez: " + jogador[jogadorAtual].nome);
		
		System.out.println("X da primeira peça: ");
		int x1 = scan.nextInt();
		System.out.println("Y da primeira peça: ");
		int y1 = scan.nextInt();
		System.out.println("X da segunda peça: ");
		int x2 = scan.nextInt();
		System.out.println("Y da segunda peça: ");
		int y2 = scan.nextInt();
		acerto = tabuleiro.fazerJogada(x1, y1, x2, y2);
		
		System.out.println("jogador " + jogador[jogadorAtual].nome + " fez a jogada " + x1 + " e " + y1 + " e depois a proxima jogada " + x2 + " e " + y2);
		
		if(acerto == false && jogadorAtual == 0) jogadorAtual = 1;
		else if(acerto == false && jogadorAtual == 1) jogadorAtual = 0;
		else jogador[jogadorAtual].fezPonto();
		
	}
}

