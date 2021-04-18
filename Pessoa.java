package br.com.poli.memoriapog.player;

public class Pessoa {
	private String nome;
	public Pessoa(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return (" - O nome do jogador é " +nome);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
