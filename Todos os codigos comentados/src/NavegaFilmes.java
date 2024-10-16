package cap12;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class NavegaFilmes extends JFrame {
    private JLabel label1, label2, label3, label4, label5, label6;
    private JTextField tfCodigo, tfTitulo, tfGenero, tfDiretor, tfDuracao, tfData;
    private JButton btProximo, btAnterior, btPrimeiro, btUltimo, bt10Mais, bt10Menos, btSair;
    private BD bd;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public static void main(String[] args) {
        JFrame frame = new NavegaFilmes();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public NavegaFilmes() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Labels
        label1 = new JLabel("Código:");
        label2 = new JLabel("Título:");
        label3 = new JLabel("Gênero:");
        label4 = new JLabel("Diretor:");
        label5 = new JLabel("Duração:");
        label6 = new JLabel("Data de Compra:");

        // TextFields
        tfCodigo = new JTextField(5);
        tfTitulo = new JTextField(40);
        tfGenero = new JTextField(10);
        tfDiretor = new JTextField(20);
        tfDuracao = new JTextField(6);
        tfData = new JTextField(10);

        // Buttons
        btProximo = new JButton(new ImageIcon("icones/proximo.gif"));
        btAnterior = new JButton(new ImageIcon("icones/anterior.gif"));
        btPrimeiro = new JButton(new ImageIcon("icones/primeiro.gif"));
        btUltimo = new JButton(new ImageIcon("icones/ultimo.gif"));
        bt10Mais = new JButton(new ImageIcon("icones/mais10.gif"));
        bt10Menos = new JButton(new ImageIcon("icones/menos10.gif"));
        btSair = new JButton(new ImageIcon("icones/sair.gif"));

        // Add components to the frame
        add(label1);
        add(tfCodigo);
        add(label2);
        add(tfTitulo);
        add(label3);
        add(tfGenero);
        add(label4);
        add(tfDiretor);
        add(label5);
        add(tfDuracao);
        add(label6);
        add(tfData);
        add(btPrimeiro);
        add(btAnterior);
        add(btProximo);
        add(btUltimo);
        add(bt10Menos);
        add(bt10Mais);
        add(btSair);

        setTitle("Navegação na Tabela de Filmes");
        setBounds(300, 400, 600, 120);
        bd = new BD();

        if (!bd.getConnection()) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar, o sistema será fechado.");
            System.exit(0);
        }

        carregarTabela();
        atualizarCampos();
    }

    private void definirEventos() {
        btProximo.addActionListener(e -> {
            try {
                resultSet.next();
                atualizarCampos();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        });

        btAnterior.addActionListener(e -> {
            try {
                resultSet.previous();
                atualizarCampos();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        });

        btPrimeiro.addActionListener(e -> {
            try {
                resultSet.first();
                atualizarCampos();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        });

        btUltimo.addActionListener(e -> {
            try {
                resultSet.last();
                atualizarCampos();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        });

        bt10Mais.addActionListener(e -> {
            try {
                resultSet.relative(10);
                atualizarCampos();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        });

        bt10Menos.addActionListener(e -> {
            try {
                if (resultSet.getRow() > 10) {
                    resultSet.relative(-10);
                } else {
                    resultSet.first();
                }
                atualizarCampos();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        });

        btSair.addActionListener(e -> {
            try {
                resultSet.close();
                statement.close();
                bd.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
            System.exit(0);
        });
    }

    private void carregarTabela() {
        String sql = "SELECT * FROM filmes";
        try {
            statement = bd.connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.toString());
        }
    }

    private void atualizarCampos() {
        try {
            if (resultSet.isAfterLast()) {
                resultSet.last();
            }
            if (resultSet.isBeforeFirst()) {
                resultSet.first();
            }

            tfCodigo.setText(resultSet.getString("codigo"));
            tfTitulo.setText(resultSet.getString("titulo"));
            tfGenero.setText(resultSet.getString("genero"));
            tfDiretor.setText(resultSet.getString("diretor"));
            tfDuracao.setText(resultSet.getString("duracao"));
            tfData.setText(resultSet.getString("dataCompra"));
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
