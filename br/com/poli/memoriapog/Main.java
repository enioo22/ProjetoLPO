package br.com.poli.memoriapog;


import br.com.poli.memoriapog.GUI.Gui;


// GRUPO: Ênio Ferreira && Bernardo Cabral

public class Main {
	
	
	public static void main(final String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	           Gui gui = new Gui();
	           gui.setVisible(true);
	           gui.setSize(600, 600);
	        }
	    });
	}	
}