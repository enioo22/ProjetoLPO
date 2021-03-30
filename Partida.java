package projetoLPO;
import java.util.Scanner;

public class Partida {
	private static Jogador[] jogador = new Jogador[2];
	static Tabuleiro tabuleiro = new Tabuleiro();
	private static char jogadorAtual = 0;
	private static String[][] tabuleiroAtual; // para imprimir o tabuleiro em seu estado atual
	Scanner scan = new Scanner(System.in);
	
	
	public void inicializarJogadores() {
		String nome1 = scan.nextLine();
		String nome2 = scan.nextLine();
		jogador[0] = new Jogador(nome1, 1);
		jogador[1] = new Jogador(nome2, 2);
		System.out.println(jogador[0].toString());
	}
	
	public void fazerJogada() {
		boolean acerto;
		tabuleiroAtual = tabuleiro.getTabuleiro();
		
		System.out.println("Jogador da Vez: " + jogador[jogadorAtual].getNome() + jogador[jogadorAtual].getScore());
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
		
		System.out.println("Pressione uma tecla para continuar...");
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
		
		for(int i = 0;i < 10; i++) {
			switch(i) {
				case 0: 
					System.out.println("    (0) (1) (2) (3) ");
					break;
					
				case 1, 3, 5, 7: 
					System.out.println("   .---.---.---.---."); 
				break;
				
				case 2, 4, 6, 8:
					int linhaAtual =(i/2)-1 ;
					System.out.print("(" + linhaAtual + ")");
					for(int o = 0; o <4; o++) {
						System.out.print("| " + tabuleiroAtual[linhaAtual][o] + " ");
					}
					System.out.println("|");
					break;
					
				case 9: System.out.println("   .---.---.---.---."); 
					
			}
		}
		
	}
	public void imprimirTabuleiro(int x1, int y1, int x2, int y2) {
		for(int i = 0;i < 10; i++) {
			switch(i) {
				case 0: 
					System.out.println("    (0) (1) (2) (3) ");
					break;
					
				case 1, 3, 5, 7, 9: 
					System.out.println("   .---.---.---.---."); 
				break;
				
				case 2, 4, 6, 8:
					int linhaAtual =(i/2)-1 ;
					System.out.print("(" + linhaAtual + ")");
					for(int o = 0; o <4; o++) {
						System.out.print("| " + tabuleiroAtual[linhaAtual][o] + " ");
					}
					System.out.println("|");
					break;
					
			}
		}
	}
}
