public class TiposPrimitivos {
    public static void main(String[] args) {

        char sexo ='m'; //mostra a letra do sexo da pessoa
        byte idade = 16; //mostra a idade em numero inteiro da pessoa
        short codigo = 256;
        float nota = 9.4f; //o "f" significa que vai pular um numero apos a virgula
        int alunos = 100, classes = 10;
        long habitantes = 55000;
        double dolar = 4.99; //dia 12/03/24//
        boolean alternativa = false; //boolean significa falso ou verdadeiro, apenas essas opcoes

        System.out.println("Sexo: " + sexo +" / " + "Idade: " + idade + " / " + "Código" + codigo);
        System.out.println("Nota: " + nota +" / " + "Alunos: " + alunos + " / " + "Classes" + classes);
        System.out.println("Habitantes: " + habitantes +" / " + "Dólar: " + dolar + " / " + "Alternativa" + alternativa); //imprime na tela as informações
    }
}