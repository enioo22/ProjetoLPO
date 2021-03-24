package projetoLPO;

public class Tabuleiro {
	 private String[][] tabuleiro;
	 
	 public Tabuleiro(){
		 this.tabuleiro = new String[][] {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"4", "3", "2", "1"}, {"4", "3", "2", "1"}};
		 
	 }
	 
	 
	    public boolean fazerJogada(int x1, int y1, int x2, int y2) {
	    	return tabuleiro[x1][y1].equals(tabuleiro[x2][y2]);
	    }
	    

}
