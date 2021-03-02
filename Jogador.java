package projetoLPO;
import java.util.Scanner;

public class Jogador {
    String nome = "flemis";
    char pontuacao = 0;

    public String chamarNome() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome do Jogador");
        nome = entrada.nextLine();
        return nome;
    }
    
    public void fezPonto() {
    	this.pontuacao++;
    }
}