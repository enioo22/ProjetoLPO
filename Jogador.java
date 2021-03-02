package projetoLPO;
import java.util.Scanner;

public class Jogador {
    private String nome;

    public String chamarNome() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Infrome o nome do Jogador");
        nome = entrada.next();
        return nome;
    }
}
