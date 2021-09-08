package br.com.poli.memoriapog.tabuleiro;

import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class Tabuleiro {
	
	private String[][] tabuleiro, pecas;


	public Tabuleiro(int numeroDeLinhas){
		
		String[][] tabuleiro = new String[numeroDeLinhas][numeroDeLinhas];
		for(int i = 0; i <numeroDeLinhas; i++) {
			for(int o = 0; o<numeroDeLinhas; o++) {
				tabuleiro[i][o] = " ";
			}
		}
		int peca = 1;
		int contador = -1;
		
		String[][] pecas = new String[numeroDeLinhas][numeroDeLinhas];
		for(int i = 0; i < numeroDeLinhas; i++) { // gerando as peças
			for(int o = 0; o < numeroDeLinhas; o++) {
				if(i < (numeroDeLinhas/2)) {
					 contador++;
					 pecas[i][o]= String.valueOf((int) (peca+contador));
				 }
				 else {
					 pecas[i][o]= String.valueOf((int) (peca+contador));
					 contador--;
				 }

			 
			}
			
		}
		this.pecas = pecas;
		
		this.tabuleiro = tabuleiro;
		
		Random gerador = new Random();
		int x1, x2, y1, y2;
		String holder;
		
		for(int i=0; i<Math.pow(numeroDeLinhas, 2); i++) { // reorganizar os arrays
			x1 = gerador.nextInt(numeroDeLinhas);
			y1 = gerador.nextInt(numeroDeLinhas);
			x2 = gerador.nextInt(numeroDeLinhas);
			y2 = gerador.nextInt(numeroDeLinhas);
			holder = pecas[x1][y1];
			pecas[x1][y1] = pecas[x2][y2];
			pecas[x2][y2] = holder;
			
			
		}
		
		for(int i = 0; i < numeroDeLinhas; i++) { //embaralhar as peças aleatoriamente
			Collections.shuffle(Arrays.asList(pecas[i]));
		}
		Collections.shuffle(Arrays.asList(pecas));
		
	}
	
	public boolean continuarPartida() {
		
		for(int i = 0; i<pecas.length; i++) {
			for( int o = 0; o <pecas.length; o++) {
				if(pecas[i][o].equalsIgnoreCase(tabuleiro[i][o]) == false ) { // se alguma peca no array tabuleiro não estiver solucionada a partida continua
					return true;
				}
			}
		}
		return false;
	}
	
	 
	public String getPeca(int x, int y) {
		return pecas[x][y];
	}
	
	public String getPecaTabuleiro(int x,int y) {
		return tabuleiro[x][y];
	}
	
	public boolean verificarPeca(int x, int y) {
		boolean valida = tabuleiro[x][y].equals(" ");
		return valida;
	}
	 
 
    public boolean fazerJogada(int x1, int y1, int x2, int y2) {
    	boolean acerto = pecas[x1][y1].equals(pecas[x2][y2]);
    	if(acerto) {
    		tabuleiro[x1][y1] = pecas[x1][y1];
    		tabuleiro[x2][y2] = pecas[x2][y2];
    	}
    	else {
    		tabuleiro[x1][y1] = " ";
    		tabuleiro[x2][y2] = " ";
    	}
    	return acerto;
    }
    
}