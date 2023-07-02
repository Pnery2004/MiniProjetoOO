/**
 * Esta classe representa a tela do administrador, onde ele pode realizar operações relacionadas a empresas e vagas.
 * Ela exibe uma lista de vagas e fornece botões para cadastrar novas vagas, cadastrar novas empresas, atualizar a lista de vagas e pesquisar vagas por nome.
 * Além disso, permite selecionar uma vaga da lista para visualizar/editar os detalhes.
 * 
 * @author Paulo Andre
 * @author Paulo Nery
 * @version 1.1.3
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import control.ControleDados;
import control.ControleVaga;
import control.ControleEmpresa;

public class TelaAdmin implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JButton cadastroVaga;
    private JButton cadastroEmpresa;
    private JButton atualizar;
    private static ControleDados dados;
    private JList<String> listaVagas;
    private String[] listaNomes = new String[50];
    private String[] listaEmpresas = new String[50];
    private JTextField campoPesquisa;
    private JButton botaoPesquisar;

    /**
     * Exibe a tela do administrador com os dados fornecidos.
     * 
     * @param d Os dados de controle da aplicação.
     */
    public void mostrarDados(ControleDados d) {
        dados = d;
        listaNomes = new ControleVaga(dados).getFuncaoVaga();
        listaEmpresas = new ControleEmpresa(dados).getNomeEmpresa();
        listaVagas = new JList<String>(listaNomes);
        janela = new JFrame("Administrador");
        cadastroVaga = new JButton("CadastraV");
        cadastroEmpresa = new JButton("CadastrarE");
        atualizar = new JButton("Atualizar");

        listaVagas = new JList<>(new DefaultListModel<>());
        DefaultListModel<String> model = (DefaultListModel<String>) listaVagas.getModel();
        for (String nome : listaNomes) {
            model.addElement(nome);
        }

        listaVagas.setBounds(20, 50, 350, 120);
        listaVagas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaVagas.setVisibleRowCount(6);

        cadastroVaga.setBounds(30, 190, 100, 40);
        cadastroEmpresa.setBounds(140, 190, 100, 40);
        atualizar.setBounds(250, 190, 100, 40);

        janela.setLayout(null);

        janela.add(atualizar);
        janela.add(cadastroVaga);
        janela.add(cadastroEmpresa);
        janela.add(listaVagas);

        janela.setSize(400, 300);
        janela.setVisible(true);

        campoPesquisa = new JTextField();
        campoPesquisa.setBounds(10, 10, 250, 30);

        botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(270, 10, 90, 30);

        janela.add(campoPesquisa);
        janela.add(botaoPesquisar);

        cadastroVaga.addActionListener(this);
        cadastroEmpresa.addActionListener(this);
        atualizar.addActionListener(this);
        listaVagas.addListSelectionListener(this);
        botaoPesquisar.addActionListener(this);

    }

    /**
     * Método de tratamento de eventos.
     * Executa a ação associada ao botão que foi acionado.
     * 
     * @param e O evento acionado.
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();


        if (src == cadastroVaga)
            new TelaDetalheVagaAdmin().inserirEditar(1, dados, this, 0);


        if (src == cadastroEmpresa)
            new TelaDetalheVagaAdmin().inserirEditar(1, dados, this, 0);


        if (src == atualizar) {
            listaNomes = new ControleVaga(dados).getFuncaoVaga();
            DefaultListModel<String> model = (DefaultListModel<String>) listaVagas.getModel();
            model.clear();
            for (String nome : listaNomes) {
                model.addElement(nome);
            }
        }


        if (src == botaoPesquisar) {
            String searchTerm = campoPesquisa.getText().trim().toLowerCase();
            DefaultListModel<String> model = new DefaultListModel<>();
            listaVagas.setModel(model);

            for (int i = 0; i < listaNomes.length; i++) {
                String nomeVaga = listaNomes[i];
                String nomeEmpresa = listaEmpresas[i];

                if (nomeVaga.toLowerCase().contains(searchTerm) || nomeEmpresa.toLowerCase().contains(searchTerm)) {
                    model.addElement(nomeVaga);
                }
            }
        }
    }

    /**
     * Método de tratamento de eventos.
     * Executa a ação associada à seleção de um item na lista de vagas.
     * 
     * @param e O evento de seleção.
     */
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (e.getValueIsAdjusting() && src == listaVagas) {
            String selectedValue = listaVagas.getSelectedValue();
            if (selectedValue != null) {
                int originalIndexInArray = -1;
                for (int i = 0; i < listaNomes.length; i++) {
                    if (listaNomes[i].equals(selectedValue)) {
                        originalIndexInArray = i;
                        break;
                    }
                }
                if (originalIndexInArray != -1) {
                    new TelaDetalheVagaAdmin().inserirEditar(2, dados, this, originalIndexInArray);
                }
            }
        }
    }
}
