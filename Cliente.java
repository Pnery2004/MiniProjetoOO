import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends JFrame {
    private JList<Vaga> listaVagas;
    private JTextField campoPesquisa;
    private JLabel labelDetalhesVagas;
    private DefaultListModel<Vaga> modeloLista;

    public Cliente() {
        setTitle("Cliente");
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
                Vaga vagaSelecionada = listaVagas.getSelectedValue();
                if (vagaSelecionada != null) {
                    String detalhes = "<html>Nome: " + vagaSelecionada.getNome() +
                            "<br>Empresa: " + vagaSelecionada.getEmpresa() +
                            "<br>Salário Base: " + vagaSelecionada.getSalarioBase() +
                            "<br>Horas Semanais: " + vagaSelecionada.getHorasSemanais() + "</html>";
                    labelDetalhesVagas.setText(detalhes);
                }
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

        // Criar um painel para a barra de pesquisa e os detalhes da vaga
        JPanel painelPesquisa = new JPanel(new BorderLayout());
        painelPesquisa.add(campoPesquisa, BorderLayout.CENTER);
        
        JPanel painelVaga = new JPanel (new BorderLayout());
        painelVaga.add(labelDetalhesVagas, BorderLayout.CENTER);

        // Criar um painel para centralizar a lista de vagas e o painel de pesquisa
        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.add(painelScroll, BorderLayout.CENTER);
        painelCentral.add(painelPesquisa, BorderLayout.NORTH);
        painelCentral.add(painelVaga, BorderLayout.EAST);

        // Adicionar o JScrollPane e o JPanel ao JFrame
        getContentPane().add(painelCentral, BorderLayout.CENTER);

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
            Cliente listaVagas = new Cliente();
            listaVagas.setVisible(true);
        });
    }
}



class Vaga {
    private String nome;
    private String empresa;
    private int salarioBase;
    private int horasSemanais;

    public Vaga(String nome, String empresa, int salarioBase, int horasSemanais) {
        this.nome = nome;
        this.empresa = empresa;
        this.salarioBase = salarioBase;
        this.horasSemanais = horasSemanais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(int horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    @Override
    public String toString() {
        return nome;
    }
} 

