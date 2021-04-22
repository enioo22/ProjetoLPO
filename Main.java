package br.com.poli.memoriapog;


import br.com.poli.memoriapog.partida.Partida;
import br.com.poli.memoriapog.player.Jogador;
import java.util.Scanner;

// GRUPO: Ênio Ferreira && Bernardo Cabral

public class Main {
	
	public static void main(final String[] args){
		
		boolean continuarPartida = true, erroDificuldade = true;
		int dificuldade;
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("digite o nome do primeiro Jogador");
		String nome1 = scan.nextLine();
		System.out.println("digite o nome do segundo Jogador");
		String nome2 = scan.nextLine();
		
		Jogador jogador1 = new Jogador(nome1, 1);
		Jogador jogador2 = new Jogador(nome2, 2);
		
		do { //garantir que o input seja valido
			System.out.println("            Dificuldade \n1 - Facil || 2 - Medio || 3 - Dificil ");
			System.out.println("    (4x4) ||    (6x6)  ||     (8x8)   ");
			dificuldade = scan.nextInt();
			if(dificuldade<1 || dificuldade>3) {
				erroDificuldade = true;
				System.out.println("DIFICULDADE INVALIDA");
			}
			else erroDificuldade = false;
			
		}while(erroDificuldade);
		
		
		Partida partida = new Partida(dificuldade, jogador1, jogador2);
		
		while(continuarPartida) {
			int i = 1;
			System.out.println("turno " + (i));
			i++;
			partida.fazerJogada();
			continuarPartida = partida.getContinuarPartida();
		}
		
		//System.out.println("gg");
	}
	
		
	
}
