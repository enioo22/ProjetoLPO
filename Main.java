package br.com.poli.memoriapog;


import br.com.poli.memoriapog.partida.Partida;
import br.com.poli.memoriapog.player.Jogador;
import java.util.Scanner;

// GRUPO: Ênio Ferreira && Bernardo Cabral

public class Main {
	
	public static void main(final String[] args){
		

		Scanner scan = new Scanner(System.in);
		System.out.println("digite o nome do primeiro Jogador");
		String nome1 = scan.nextLine();
		System.out.println("digite o nome do segundo Jogador");
		String nome2 = scan.nextLine();
		
		Jogador jogador1 = new Jogador(nome1, 1);
		Jogador jogador2 = new Jogador(nome2, 2);
		
		System.out.println("            Dificuldade \n1 - Facil || 2 - Medio || 3 - Dificil ");
		int dificuldade = scan.nextInt();
		Partida partida = new Partida(dificuldade, jogador1, jogador2);
		
		for(int i = 0; i<20; i++) {
			System.out.println("turno " + (i+1));
			partida.fazerJogada();
		}
		
		//System.out.println("gg");
	}
	
		
	
}
