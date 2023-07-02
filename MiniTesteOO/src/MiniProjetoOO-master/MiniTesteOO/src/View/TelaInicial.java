/**
 * Esta classe representa a tela inicial da aplicação, onde o usuário pode escolher entre as opções de cliente e administrador.
 * Ela é responsável por exibir a interface gráfica do menu principal e gerenciar as ações dos botões.
 * 
 * @author Paulo Andre
 * @version 1.1.3
 */
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import control.ControleDados;

public class TelaInicial implements ActionListener {

    private static JFrame janela = new JFrame("Tela Inicial");
    private static JLabel titulo = new JLabel("Menu Principal");
    private static JButton cliente = new JButton("Cliente");
    private static JButton admin = new JButton("Administrador");
    public static ControleDados dados = new ControleDados();

    /**
     * Construtor da classe TelaInicial.
     * Cria e exibe a tela inicial com os botões de cliente e administrador.
     */
    public TelaInicial() {
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(120, 10, 150, 30);
        cliente.setBounds(70, 100, 100, 45);
        admin.setBounds(200, 100, 100, 45);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(cliente);
        janela.add(admin);

        janela.setSize(400, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    /**
     * Método principal da classe TelaInicial.
     * Cria uma instância da classe TelaInicial e associa os ouvintes de ação aos botões.
     * 
     * @param args Os argumentos de linha de comando.
     */
    public static void main(String[] args) {
        TelaInicial menu = new TelaInicial();

        cliente.addActionListener(menu);
        admin.addActionListener(menu);
    }

    /**
     * Método de tratamento de eventos.
     * Executa a ação associada ao botão que foi acionado.
     * 
     * @param e O evento acionado.
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == cliente)
            new TelaCliente().mostrarDados(dados);
        if (src == admin)
            new TelaAdmin().mostrarDados(dados);
    }
}
