package projetoLPO;
import java.util.Scanner;

public class Partida {
	private Jogador jogador1 = new Jogador();
	private Jogador jogador2 = new Jogador();
	private static Tabuleiro tabuleiro = new Tabuleiro();
	private char vez;
	
	
	public static void fazerJogada() {
		Scanner scan = new Scanner(System.in);
		System.out.println("X da primeira peça: ");
		int x1 = scan.nextInt();
		System.out.println("Y da primeira peça: ");
		int y1 = scan.nextInt();
		System.out.println("X da segunda peça: ");
		int x2 = scan.nextInt();
		System.out.println("Y da segunda peça: ");
		int y2 = scan.nextInt();
		Tabuleiro.fazerJogada(x1, y1, x2, y2);
		
	}
}
