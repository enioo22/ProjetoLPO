package projetoLPO;





public class Tabuleiro {
	private String[][] tabuleiro = {{" "," "," "," "}, {" "," "," "," "}, {" "," "," "," "},{" "," "," "," "}};
	private String[][] pecas =  {{"A", "A", "B", "B"}, {"C", "C", "D", "D"}, {"E", "E", "F", "F"}, {"G", "G", "H", "H"}};

 
		public String getPeca(int x, int y) {
			return pecas[x][y];
		}
		public String[][] getTabuleiro(){
			System.out.println(tabuleiro[0][0]);
			return tabuleiro;
		}
		public void setTabuleiro(String[][] tabuleiroAtual) {
			this.tabuleiro = tabuleiroAtual;
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
