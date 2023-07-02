/**
 * Control da classe Empresa
 * @author Paulo Nery
 * @author Paulo Andre
 * @version 1.1.3
 */
package control;

import model.Empresa;

public class ControleEmpresa {
	private Empresa[] e;
	private int qtdEmpresas;

	public ControleEmpresa(ControleDados d) {
		e = d.getEmpresa();
		qtdEmpresas = d.getQtdEmpresas();

	}

	public String[] getNomeEmpresa() {
		String[] s = new String[qtdEmpresas];
		for (int i = 0; i < qtdEmpresas; i++) {
			s[i] = e[i].getNome();
		}

		return s;
	}

	public int getQtd() {
		return qtdEmpresas;
	}

	public void setQtd(int qtd) {
		this.qtdEmpresas = qtd;
	}

	public String getNome(int i) {
		return e[i].getNome();
	}

	public String getEndereco(int i) {
		return e[i].getEndereco();
	}

	public String getCep(int i) {
		String numCEP = String.valueOf(e[i].getCEP());
		return numCEP;
	}

	public void setQtdEmpresas(int qtdEmpresas) {
		this.qtdEmpresas = qtdEmpresas;
	}

}
