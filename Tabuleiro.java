package projetoLPO;


public class main {
	public static void main(String[] args){
		
		Partida partida = new Partida();
		partida.inicializarJogadores();
		for(int i = 0; i<20; i++) {
			partida.fazerJogada();
		}
	}
	
		
	
}
