public class ConversaoDeTipos {
    public static void main(String[] args) {
        String s1 = "10";

        int v = Integer.parseInt(s1);

        float x = Float.parseFloat(s1);//comando float indica que x é um numero real

        double y = Double.parseDouble(s1);

        int w = (int) x;//int indica que w é um numero inteiro

        int z  = (int) y;

        String s2= String.valueOf(v);

        System.out.println(s2 + w + z);//mostra a soma de s2 w e z na tela

    }
}