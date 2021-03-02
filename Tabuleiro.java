package projetoLPO;

public class Tabuleiro {
	 private static int[][] tabuleiro = {{1, 2, 3, 4}, {1, 2, 3, 4}, {4, 3, 2, 1}, {4, 3, 2, 1} };
	    public static boolean fazerJogada(int x1, int y1, int x2, int y2) {
	    	return tabuleiro[x1][y1] == tabuleiro[x2][y2];
	    }
	    

}
