package br.com.poli.memoriapog.GUI;

import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;


import javax.swing.ImageIcon;


import br.com.poli.memoriapog.partida.*;
import br.com.poli.memoriapog.player.Jogador;

public class Gui extends JFrame implements ActionListener{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5410062311790622946L;
	private JPanel contentPane, menu, dificuldade, jogo;
	private Button botaoP1cpu, botaoP1p2, dificuldade1, dificuldade2, dificuldade3;
	private JButton[][] botoes;
	private int dif, modo, xJogadaPassada, yJogadaPassada, jogada = 1;
	private String nome1, nome2;
	private boolean acerto;
	private Partida partida;
	private Jogador j1, j2;
	private CardLayout cl;
	private ActionListener listenerJogo = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int x = 0, y = 0;
			for(int i = 0; i<(dif*2)+2; i++) {
				for(int o = 0; o<(dif*2)+2; o++) {
					if(e.getSource().equals(botoes[i][o])){
						x = i;
						y = o;
					}

				}
			}
			if(partida.jogadaValida(x, y)) {  // logica de mudar cores e imagens dos botoes do jogo
				botoes[x][y].setIcon(new ImageIcon("src/resources/" + partida.getTabuleiro(x, y) + ".jpg"));
				botoes[x][y].setBackground(Color.yellow);
				setTitle(partida.getJogadorEPontuação());
				if(jogada == 1) {
					xJogadaPassada = x;
					yJogadaPassada = y;
					jogada = 2;
				}
				else if(jogada == 2) {
					
					acerto = partida.fazerJogada(xJogadaPassada, yJogadaPassada, x, y);
					if(acerto) {
						botoes[xJogadaPassada][yJogadaPassada].setBackground(Color.green);
						botoes[x][y].setBackground(Color.green);
						jogada = 1;
						setTitle(partida.getJogadorEPontuação());
						if(!partida.getContinuarPartida()) {
							JOptionPane.showMessageDialog(null, partida.partidaFinalizada());
							dispose();
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "ERROU :(");
						botoes[xJogadaPassada][yJogadaPassada].setBackground(null);
						botoes[x][y].setBackground(null);
						botoes[xJogadaPassada][yJogadaPassada].setIcon(null);
						botoes[x][y].setIcon(null);
						jogada = 1;
						setTitle(partida.getJogadorEPontuação());
						if(modo == 1) {
							int[] jogadaCpu = partida.jogadaCpu();
							do {
								jogadaCpu = partida.jogadaCpu();
								acerto = partida.fazerJogada(jogadaCpu[0], jogadaCpu[1], jogadaCpu[2], jogadaCpu[3]);
								botoes[jogadaCpu[0]][jogadaCpu[1]].setIcon(new ImageIcon("src/resources/" + partida.getTabuleiro(jogadaCpu[0], jogadaCpu[1]) + ".jpg"));
								botoes[jogadaCpu[0]][jogadaCpu[1]].setBackground(Color.yellow);
								botoes[jogadaCpu[2]][jogadaCpu[3]].setIcon(new ImageIcon("src/resources/" + partida.getTabuleiro(jogadaCpu[2], jogadaCpu[3]) + ".jpg"));
								botoes[jogadaCpu[2]][jogadaCpu[3]].setBackground(Color.yellow);
								
								if(acerto) {
									botoes[jogadaCpu[0]][jogadaCpu[1]].setBackground(Color.green);
									botoes[jogadaCpu[2]][jogadaCpu[3]].setBackground(Color.green);
									JOptionPane.showMessageDialog(null, "O CPU ACERTOU");
									jogada = 1;
									setTitle(partida.getJogadorEPontuação());
									if(!partida.getContinuarPartida()) {
										JOptionPane.showMessageDialog(null, partida.partidaFinalizada());
										dispose();
										
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "O CPU ERROU");
									botoes[jogadaCpu[0]][jogadaCpu[1]].setIcon(null);
									botoes[jogadaCpu[0]][jogadaCpu[1]].setBackground(null);
									botoes[jogadaCpu[2]][jogadaCpu[3]].setIcon(null);
									botoes[jogadaCpu[2]][jogadaCpu[3]].setBackground(null);
									jogada = 1;
									setTitle(partida.getJogadorEPontuação());
								}
							
							}while(acerto);
						}
					}
				}
				
			}
			else JOptionPane.showMessageDialog(null, "JOGADA INVALIDA");
			
			
		
	}
	};
	

	
	public Gui() {
		
		setTitle("MEMORIA PROG");
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl = new CardLayout();
		
		
		contentPane = new JPanel(); // configurando os panels
		contentPane.setLayout(cl);
		
		
		menu = new JPanel(new GridLayout(2, 0));
		
		botaoP1cpu = new Button("PLAYER 1 VS CPU");
		menu.add(botaoP1cpu);
		
		botaoP1p2 = new Button("PLAYER 1 VS PLAYER 2");
		menu.add(botaoP1p2);
		
		dificuldade = new JPanel(new GridLayout(0, 3));
		
		dificuldade1 = new Button("Dificuldade:\n Facil");
		dificuldade1.setBackground(Color.green);
		
		dificuldade2 = new Button("Dificuldade: \n Medio");
		dificuldade2.setBackground(Color.orange);
		
		dificuldade3 = new Button("Dificuldade: \n Dificil");
		dificuldade3.setBackground(Color.red);
		
		dificuldade.add(dificuldade1);
		dificuldade.add(dificuldade2);
		dificuldade.add(dificuldade3);
		
		
		
		botaoP1cpu.addActionListener(this);
		
		botaoP1p2.addActionListener(this);
		
		dificuldade1.addActionListener(this);
		
		dificuldade2.addActionListener(this);
		
		dificuldade3.addActionListener(this);
		

		
		
		contentPane.add(menu, "1");
		contentPane.add(dificuldade, "2");

		
		cl.show(contentPane, "1");
		add(contentPane);
		pack();
		
		
		
		
	}
		
	
	public void inicializarBotoesJogo() {
		int tamanhoArray, tamanhoBotoes,xInicial = 0, distanciaX = 0, distanciaY = 0;
		tamanhoArray = (dif*2) + 2;
		tamanhoBotoes = 500/tamanhoArray;
		
		botoes = new JButton[tamanhoArray][tamanhoArray];//fazer esses botoes funcionarem
		for(int i = 0; i <tamanhoArray; i++) {
			distanciaX = xInicial;
			distanciaY = distanciaY + tamanhoBotoes + 5;
			
			for(int o = 0; o < tamanhoArray; o++) {
				distanciaX = distanciaX + tamanhoBotoes + 5;
				botoes[i][o] = new JButton();

				botoes[i][o].addActionListener(listenerJogo);
				jogo.add(botoes[i][o]);
				
					
				
			}
		}
	}
	
	public int getDificuldade() {
		return dif;
	}
	
	public int getModo() {
		return modo;
	}
	public String getNome1() {
		return nome1;
	}
	public String getNome2() {
		return nome2;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(botaoP1cpu)){   // setando o que cada botao nos menus fazem
			modo = 1;
			nome1 = JOptionPane.showInputDialog("NOME DO PLAYER 1");
			j1 = new Jogador(nome1, 1);
			j2 = new Jogador("CPU", 2);
			
			cl.show(contentPane, "2");
		}
		else if(e.getSource().equals(botaoP1p2)) {
			modo = 2;
			nome1 = JOptionPane.showInputDialog("NOME DO PLAYER 1");
			j1 = new Jogador(nome1, 1);
			nome2 = JOptionPane.showInputDialog("NOME DO PLAYER 2");
			j2 = new Jogador(nome2, 2);
			cl.show(contentPane, "2");
		}
		
		else if(e.getSource().equals(dificuldade1)) {
			dif = 1;
			jogo = new JPanel(new GridLayout((dif*2)+2,(dif*2)+2));
			inicializarBotoesJogo();
			contentPane.add(jogo, "3");
			
			cl.show(contentPane, "3");
			partida = new Partida(dif, j1, j2);
			setTitle(partida.getJogadorEPontuação());
		}
		
		else if(e.getSource().equals(dificuldade2)) {
			dif = 2;
			jogo = new JPanel(new GridLayout((dif*2)+2,(dif*2)+2));
			inicializarBotoesJogo();
			contentPane.add(jogo, "3");
			
			cl.show(contentPane, "3");
			partida = new Partida(dif, j1, j2);
			setTitle(partida.getJogadorEPontuação());
			
		}
		else if(e.getSource().equals(dificuldade3)) {
			dif = 3;
			jogo = new JPanel(new GridLayout((dif*2)+2,(dif*2)+2));
			inicializarBotoesJogo();
			contentPane.add(jogo, "3");
			cl.show(contentPane, "3");
			partida = new Partida(dif, j1, j2);
			setTitle(partida.getJogadorEPontuação());
			
		}
		
	};
}
	
	




