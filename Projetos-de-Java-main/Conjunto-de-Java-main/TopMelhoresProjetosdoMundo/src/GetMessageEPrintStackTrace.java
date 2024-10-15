package cap03;
import javax.swing.JOptionPane;
public class GetMessageEPrintStackTrace {
    public static void main(String args[]) {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Forneça um número!: "));
        try {
            int y = x / 0;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            erro.printStackTrace();
        }
    }
}
