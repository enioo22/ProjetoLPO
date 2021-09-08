package br.com.poli.memoriapog.player;

public class Jogador extends Pessoa{
    private char score = 0;
    private int numero;
    
    public Jogador(String nome, int numero) {
    	super(nome);
    	this.numero = numero;
    }
    
    public String toString() {
    	return numero + super.toString();
    }
    
    public void fezPonto() {
    	this.score++;
    }

	public int getScore() {
		return score;
	}

	public void setScore(char score) {
		this.score = score;
	}
    
}