package control;

import model.Vaga;

public class ControleVaga {
	private Vaga[] v;
	private int qtdVagas;

	public ControleVaga(ControleDados d) {
		v = d.getVaga();
		qtdVagas = d.getQtdVagas();

	}

	public String[] getFuncaoVaga() {
		String[] s = new String[qtdVagas];
		for (int i = 0; i < qtdVagas; i++) {
			s[i] = v[i].getFuncao();
		}

		return s;
	}

	public int getQtd() {
		return qtdVagas;
	}

	public void setQtd(int qtd) {
		this.qtdVagas = qtd;
	}

	public String getFuncao(int i) {
		return v[i].getFuncao();
	}

	public String getEmpresa(int i) {
		return v[i].getEmpresa();
	}

	public String getJornadaDiaria(int i) {
		String numJD = String.valueOf(v[i].getJornadaDiaria());
		return numJD;
	}

	public String getSalarioBase(int i) {
		String numSB = String.valueOf(v[i].getSalarioBase());
		return numSB;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

}
