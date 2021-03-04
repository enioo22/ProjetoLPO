package projetoLPO;
import java.util.Scanner;

public class Jogador {
    private String nome = "flemis";
    private char pontuacao = 0;

    public void chamarNome() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome do Jogador");
        this.nome = entrada.nextLine();
    }
    
    public void fezPonto() {
    	this.pontuacao++;
    }
}
