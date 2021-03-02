package projetoLPO;
import java.util.Scanner;

public class Jogador {
    private String nome = "0";
    private char pontuacao = 0;

    public String chamarNome() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome do Jogador");
        this.nome = entrada.next();
        return nome;
    }
    
    public void fezPonto() {
    	this.pontuacao++;
    }
}
