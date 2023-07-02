/**
 * Esta classe representa a tela que exibe os detalhes de uma vaga específica, com a opção de edição.
 * Os detalhes incluem informações sobre a vaga e a empresa contratante.
 * A tela permite editar as informações da vaga e da empresa, bem como excluir a vaga.
 * Implementa a interface ActionListener para lidar com eventos de botões.
 * 
 * @author Paulo Andre
 * @author Paulo Nery
 * @version 1.1.3
 */
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import control.ControleDados;

public class TelaDetalheVagaAdmin implements ActionListener {
    private JFrame janela;
    private JLabel titulo1 = new JLabel("Vaga");
    private JLabel labelFuncao = new JLabel("Funcao: ");
    private JTextField valorFuncao;
    private JLabel labelEmpresa = new JLabel("Empresa: ");
    private JTextField valorEmpresa;
    private JLabel labelJornadaDiaria = new JLabel("Jornada Diaria: ");
    private JTextField valorJornadaDiaria;
    private JLabel labelSalarioBase = new JLabel("Salario Base: ");
    private JTextField valorSalarioBase;
    private JLabel titulo2 = new JLabel("Empresa");
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField valorNome;
    private JLabel labelEndereco = new JLabel("Endereço: ");
    private JTextField valorEndereco;
    private JLabel labelCep = new JLabel("Cep: ");
    private JTextField valorCep;
    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");
    private String[] novoDado = new String[9];
    private static ControleDados dados;
    private int posicao;
    private int opcao;
    private String s;

    /**
     * Insere ou edita as informações da vaga.
     * 
     * @param op A opção selecionada (1 - Cadastro de Vaga, 2 - Detalhe de Vaga).
     * @param d Os dados de controle da aplicação.
     * @param a A instância da classe TelaAdmin.
     * @param pos A posição da vaga na lista.
     */
    public void inserirEditar(int op, ControleDados d, TelaAdmin a, int pos) {
        opcao = op;
        posicao = pos;
        dados = d;

        if (op == 1)
            s = "Cadastro Vaga";
        if (op == 2)
            s = "Detalhe Vaga";

        janela = new JFrame(s);
        if (op == 2) {
            valorFuncao = new JTextField(dados.getVaga()[pos].getFuncao(), 200);
            valorEmpresa = new JTextField(dados.getVaga()[pos].getEmpresa(), 200);
            valorJornadaDiaria = new JTextField(String.valueOf(dados.getVaga()[pos].getJornadaDiaria()), 200);
            valorSalarioBase = new JTextField(String.valueOf(dados.getVaga()[pos].getSalarioBase()), 200);

            valorNome = new JTextField(dados.getEmpresa()[pos].getNome(), 200);
            valorEndereco = new JTextField(dados.getEmpresa()[pos].getEndereco(), 200);
            valorCep = new JTextField(String.valueOf(dados.getEmpresa()[pos].getCEP()), 200);
        } else {
            valorFuncao = new JTextField(200);
            valorEmpresa = new JTextField(200);
            valorJornadaDiaria = new JTextField(200);
            valorSalarioBase = new JTextField(200);
            valorNome = new JTextField(200);
            valorEndereco = new JTextField(200);
            valorCep = new JTextField(200);
            botaoSalvar.setBounds(245, 175, 115, 30);
        }
        titulo1.setFont(new Font("Arial", Font.BOLD, 20));
        titulo1.setBounds(60, 10, 200, 35);
        labelFuncao.setBounds(30, 50, 150, 25);
        valorFuncao.setBounds(180, 50, 180, 25);
        labelEmpresa.setBounds(30, 80, 150, 25);
        valorEmpresa.setBounds(180, 80, 180, 25);
        labelJornadaDiaria.setBounds(30, 110, 180, 25);
        valorJornadaDiaria.setBounds(180, 110, 180, 25);
        labelSalarioBase.setBounds(30, 140, 150, 25);
        valorSalarioBase.setBounds(180, 140, 180, 25);

        titulo2.setFont(new Font("Arial", Font.BOLD, 20));
        titulo2.setBounds(60, 170, 200, 35);
        labelNome.setBounds(30, 210, 150, 25);
        valorNome.setBounds(180, 210, 180, 25);
        labelEndereco.setBounds(30, 240, 150, 25);
        valorEndereco.setBounds(180, 240, 180, 25);
        labelCep.setBounds(30, 270, 150, 25);
        valorCep.setBounds(180, 270, 180, 25);

        if (op == 2) {
            botaoExcluir.setBounds(30, 300, 140, 30);
            botaoSalvar.setBounds(190, 300, 140, 30);
            this.janela.add(botaoExcluir);
        }

        janela.add(titulo1);
        janela.add(labelFuncao);
        janela.add(valorFuncao);
        janela.add(labelEmpresa);
        janela.add(valorEmpresa);
        janela.add(labelJornadaDiaria);
        janela.add(valorJornadaDiaria);
        janela.add(labelSalarioBase);
        janela.add(valorSalarioBase);
        janela.add(titulo2);
        janela.add(labelNome);
        janela.add(valorNome);
        janela.add(labelEndereco);
        janela.add(valorEndereco);
        janela.add(labelCep);
        janela.add(valorCep);
        janela.add(botaoSalvar);

        janela.setLayout(null);

        janela.setSize(400, 370);
        janela.setVisible(true);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == botaoSalvar) {
            if (opcao == 1)
                novoDado[0] = Integer.toString(dados.getQtdVagas());
            else
                novoDado[0] = Integer.toString(posicao);

            novoDado[1] = valorFuncao.getText();
            novoDado[2] = valorEmpresa.getText();
            novoDado[3] = valorJornadaDiaria.getText();
            novoDado[4] = valorSalarioBase.getText();
            novoDado[5] = valorNome.getText();
            novoDado[6] = valorEndereco.getText();
            novoDado[7] = valorCep.getText();
            dados.inserirEditarVaga(novoDado);
            dados.inserirEditarEmpresa(novoDado);

        }
        if (src == botaoExcluir) {
            dados.removerVaga(posicao);

        }

    }
}
