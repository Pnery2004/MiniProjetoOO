import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class Tecnico extends JFrame {
    private JList<Vaga> listaVagas;
    private JTextField campoPesquisa;
    private JLabel labelDetalhesVagas;
    private DefaultListModel<Vaga> modeloLista;
    private JButton botaoEditar;
    private JButton botaoAdicionar;
    private JButton botaoDeletar;

    public Tecnico() {
        setTitle("Técnico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dados de exemplo
        Vaga[] vagas = {
                new Vaga("Vaga 1", "Empresa A", 2000, 40),
                new Vaga("Vaga 2", "Empresa B", 2500, 35),
                new Vaga("Vaga 3", "Empresa C", 1800, 30),
                new Vaga("Vaga 4", "Empresa D", 2200, 40)
        };

        // Criar o modelo de lista com os dados
        modeloLista = new DefaultListModel<>();
        for (Vaga vaga : vagas) {
            modeloLista.addElement(vaga);
        }

        // Criar a JList com o modelo de lista
        listaVagas = new JList<>(modeloLista);
        listaVagas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaVagas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                atualizarBotoes();
                atualizarDetalhesVaga();
            }
        });

        // Adicionar a JList a um JScrollPane para suportar rolagem
        JScrollPane painelScroll = new JScrollPane(listaVagas);

        // Criar o JTextField para a barra de pesquisa
        campoPesquisa = new JTextField();
        campoPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisarVagas();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisarVagas();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisarVagas();
            }
        });

        // Criar o JLabel para exibir os detalhes da vaga selecionada
        labelDetalhesVagas = new JLabel();
        labelDetalhesVagas.setVerticalAlignment(SwingConstants.TOP);

        // Criar os botões para editar, adicionar e deletar vagas
        botaoEditar = new JButton("Editar");
        botaoAdicionar = new JButton("Adicionar");
        botaoDeletar = new JButton("Deletar");

        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarVaga();
            }
        });

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVaga();
            }
        });

        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarVaga();
            }
        });

        // Criar um painel para a barra de pesquisa  
        JPanel painelPesquisa = new JPanel(new BorderLayout());
        painelPesquisa.add(campoPesquisa, BorderLayout.CENTER);
        
        // Criar um painel para os detalhes da vaga
        JPanel painelVaga = new JPanel (new BorderLayout());
        painelVaga.add(labelDetalhesVagas, BorderLayout.CENTER);

        // Criar um painel para os botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(botaoEditar);
        buttonsPanel.add(botaoAdicionar);
        buttonsPanel.add(botaoDeletar);

        // Criar um painel para centralizar a lista de vagas, o painel de pesquisa e o painel de botões
        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.add(painelScroll, BorderLayout.CENTER);
        painelCentral.add(painelPesquisa, BorderLayout.NORTH);
        painelCentral.add(painelVaga, BorderLayout.EAST);
        painelCentral.add(buttonsPanel, BorderLayout.SOUTH);

        // Adicionar o JScrollPane e o JPanel ao JFrame
        getContentPane().add(painelCentral, BorderLayout.CENTER);

        atualizarBotoes();

        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    private void pesquisarVagas() {
        String textoPesquisa = campoPesquisa.getText().toLowerCase();
        modeloLista.clear();

        for (Vaga vaga : getVagas()) {
            String nomeVaga = vaga.getNome().toLowerCase();
            String nomeEmpresa = vaga.getEmpresa().toLowerCase();

            if (nomeVaga.contains(textoPesquisa) || nomeEmpresa.contains(textoPesquisa)) {
                modeloLista.addElement(vaga);
            }
        }
    }

    private void atualizarBotoes() {
        boolean vagaSelecionada = listaVagas.getSelectedIndex() != -1;
        botaoEditar.setEnabled(vagaSelecionada);
        botaoDeletar.setEnabled(vagaSelecionada);
    }

    private void atualizarDetalhesVaga() {
        Vaga vagaSelecionada = listaVagas.getSelectedValue();
        if (vagaSelecionada != null) {
            String detalhes = "<html>Nome: " + vagaSelecionada.getNome() +
                    "<br>Empresa: " + vagaSelecionada.getEmpresa() +
                    "<br>Salário Base: " + vagaSelecionada.getSalarioBase() +
                    "<br>Horas Semanais: " + vagaSelecionada.getHorasSemanais() + "</html>";
            labelDetalhesVagas.setText(detalhes);
        } else {
            labelDetalhesVagas.setText("");
        }
    }

    private void editarVaga() {
        Vaga vagaSelecionada = listaVagas.getSelectedValue();
        if (vagaSelecionada != null) {
            String nomeVaga = JOptionPane.showInputDialog(this, "Digite o nome da vaga:", vagaSelecionada.getNome());
            String nomeEmpresa = JOptionPane.showInputDialog(this, "Digite o nome da empresa:", vagaSelecionada.getEmpresa());
            int salarioBase = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o salário base:", vagaSelecionada.getSalarioBase()));
            int horasSemanais = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a quantidade de horas semanais:", vagaSelecionada.getHorasSemanais()));

            vagaSelecionada.setNome(nomeVaga);
            vagaSelecionada.setEmpresa(nomeEmpresa);
            vagaSelecionada.setSalarioBase(salarioBase);
            vagaSelecionada.setHorasSemanais(horasSemanais);

            modeloLista.setElementAt(vagaSelecionada, listaVagas.getSelectedIndex());
            atualizarDetalhesVaga();
        }
    }

    private void adicionarVaga() {
        String nomeVaga = JOptionPane.showInputDialog(this, "Digite o nome da vaga:");
        String nomeEmpresa = JOptionPane.showInputDialog(this, "Digite o nome da empresa:");
        int salarioBase = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o salário base:"));
        int horasSemanais = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite a quantidade de horas semanais:"));

        Vaga novaVaga = new Vaga(nomeVaga, nomeEmpresa, salarioBase, horasSemanais);
        modeloLista.addElement(novaVaga);
    }

    private void deletarVaga() {
        int indiceSelecionado = listaVagas.getSelectedIndex();
        if (indiceSelecionado != -1) {
            modeloLista.remove(indiceSelecionado);
            atualizarDetalhesVaga();
        }
    }

    private List<Vaga> getVagas() {
        // Retorne sua lista de vagas ou busque-as de uma fonte de dados
        List<Vaga> vagas = new ArrayList<>();
        vagas.add(new Vaga("Vaga 1", "Empresa A", 2000, 40));
        vagas.add(new Vaga("Vaga 2", "Empresa B", 2500, 35));
        vagas.add(new Vaga("Vaga 3", "Empresa C", 1800, 30));
        vagas.add(new Vaga("Vaga 4", "Empresa D", 2200, 40));
        return vagas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tecnico listaVagas = new Tecnico();
            listaVagas.setVisible(true);
        });
    }
}





