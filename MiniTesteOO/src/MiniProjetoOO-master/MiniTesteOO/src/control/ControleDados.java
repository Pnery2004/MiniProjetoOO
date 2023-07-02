/**
 * Control da classe Dados
 * @author Paulo Nery
 * @author Paulo Andre
 * @version 1.1.3
 */
package control;
import model.Vaga;
import model.Dados;
import model.Empresa;

public class ControleDados {
	private Dados d = new Dados();

	public ControleDados() {
		d.DadosExemplos();
	}

	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}

	public Vaga[] getVaga() {
		return this.d.getVaga();
	}

	public int getQtdVagas() {
		return this.d.getQtdVagas();
	}

	public int getQtdEmpresas() {
		return this.d.getQtdEmpresas();
	}

	public Empresa[] getEmpresa() {
		return this.d.getEmpresa();
	}

	public boolean inserirEditarVaga(String[] dadosVaga) {
		if (!dadosVaga[3].matches("[0-9]+") || !dadosVaga[4].matches("[0-9]+")) {
			return false;
		} else {
			Vaga v = new Vaga(dadosVaga[1], dadosVaga[2], Integer.parseInt(dadosVaga[3]),
					Integer.parseInt(dadosVaga[4]));
			d.inserirEditarVaga(v, Integer.parseInt(dadosVaga[0]));
			return true;
		}
	}

	public boolean inserirEditarEmpresa(String[] dadosEmpresa) {
		if (!dadosEmpresa[3].matches("[0-9]+")) {
			return false;
		} else {
			Empresa e = new Empresa(dadosEmpresa[5], dadosEmpresa[6], Integer.parseInt(dadosEmpresa[7]));
			d.inserirEditarEmpresa(e, Integer.parseInt(dadosEmpresa[0]));
			return true;
		}
	}

	public boolean removerVaga(int i) {
		String vagaRemovida = d.getVaga()[i].getFuncao();

		if (i == (d.getQtdVagas() - 1)) { // O aluno a ser removido est� no final do array
			d.setQtdVagas(d.getQtdVagas() - 1);
			d.getVaga()[d.getQtdVagas()] = null;
			return true;
		} else { // o aluno a ser removido est� no meio do array
			int cont = 0;
			while (d.getVaga()[cont].getFuncao().compareTo(vagaRemovida) != 0) {
				cont++;
			}
			// Rotina swap
			for (int j = cont; j < d.getQtdVagas() - 1; j++) {
				d.getVaga()[j] = null;
				d.getVaga()[j] = d.getVaga()[j + 1];
			}
			d.getVaga()[d.getQtdVagas()] = null;
			d.setQtdVagas(d.getQtdVagas() - 1);
			return true;
		}
	}

}
