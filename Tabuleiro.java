package projetoLPO;

public class Tabuleiro {
	 private static int[][] tabuleiro = new int[4][4];

	    public static boolean fazerJogada(int x1, int y1, int x2, int y2) {
	    	if(tabuleiro[x1][y1] == tabuleiro[x2][y2]) {
	    			return true;
	    	}
	    	else return false;
	    }
	    

}
