package projetoLPO;


public class main {
	public static void main(String[] args){
		
		Partida partida = new Partida();
		partida.inicializarJogadores();
		for(int i = 0; i<20; i++) {
			System.out.println("turno " + (i+1));
			partida.fazerJogada();
		}
		
		//System.out.println("gg");
	}
	
		
	
}
