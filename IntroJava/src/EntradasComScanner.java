import java.util.*;
public class EntradasComScanner { //scanner analiza o que escrito no teclado do dispositivo

    public static void main(String[] args) {
        float largura, comprimento, area, perimetro; //variaveis declaradas como numeors, ou seja, caracteres nao serão aceitos
        Scanner sc;
        try {
            System.out.println("Entre com o comprimento: "); //dá informações ao usuário para executar o programa perfeitamente
            sc = new Scanner(System.in); // o "new" é usado para criar um objeto
            comprimento = sc.nextFloat();

            System.out.println("Entre com a largura: ");
            sc = new Scanner(System.in);
            largura = sc.nextFloat();

            area = comprimento * largura;
            perimetro = comprimento * 2 + largura * 2; //faz operações para descobrir o perimetro do solido geometrico

            System.out.println("Area do Terreno: " + area);
            System.out.println("Area do Perimetro: " + perimetro);
        }
        catch (NumberFormatException e) {
            System.out.println("Houve um erro na conversao, digite apenas caracteres numericos!"); //mostra que teve um erro no codigo
        }
    }
}