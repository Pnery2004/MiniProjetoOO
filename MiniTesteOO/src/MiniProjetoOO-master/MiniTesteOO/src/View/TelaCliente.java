/**
 * Esta classe representa a tela do usuário comum, onde ele pode visualizar a lista de vagas disponíveis e pesquisar por vagas.
 * A tela exibe uma lista de vagas e fornece um campo de pesquisa para filtrar as vagas por nome.
 * Além disso, permite selecionar uma vaga da lista para visualizar os detalhes.
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
import control.ControleEmpresa;
import control.ControleVaga;

public class TelaCliente implements ActionListener, ListSelectionListener {
    private JFrame janela;
    private JButton atualizar;
    private JList<String> listaVagas;
    private String[] listaNomes = new String[50];
    private String[] listaEmpresas = new String[50];
    private JTextField campoPesquisa;
    private JButton botaoPesquisar;
    private static ControleDados dados;
    private DefaultListModel<String> modeloListaVagas;

    /**
     * Exibe a tela do usuário comum com os dados fornecidos.
     * 
     * @param d Os dados de controle da aplicação.
     */
    public void mostrarDados(ControleDados d) {
        dados = d;
        listaNomes = new ControleVaga(dados).getFuncaoVaga();
        listaEmpresas = new ControleEmpresa(dados).getNomeEmpresa();
        modeloListaVagas = new DefaultListModel<>();
        listaVagas = new JList<>(modeloListaVagas);
        janela = new JFrame("Tela do Usuário Comum");
        atualizar = new JButton("Atualizar");

        listaVagas.setBounds(20, 50, 350, 120);
        listaVagas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaVagas.setVisibleRowCount(6);

        atualizar.setBounds(150, 190, 100, 40);

        janela.setLayout(null);

        janela.add(atualizar);
        janela.add(listaVagas);

        janela.setSize(400, 300);
        janela.setVisible(true);

        campoPesquisa = new JTextField();
        campoPesquisa.setBounds(10, 10, 250, 30);

        botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(270, 10, 90, 30);

        janela.add(campoPesquisa);
        janela.add(botaoPesquisar);

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

        // Atualiza a lista de nomes das funções mostradas no JList
        if (src == atualizar) {
            listaNomes = new ControleVaga(dados).getFuncaoVaga();
            DefaultListModel<String> model = (DefaultListModel<String>) listaVagas.getModel();
            model.clear();
            for (String nome : listaNomes) {
                model.addElement(nome);
            }
        }

        // Pesquisa pelo nome na JList
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
                    new TelaDetalheVagaCliente().inserirEditar(dados, this, originalIndexInArray);
                }
            }
        }
    }
}
