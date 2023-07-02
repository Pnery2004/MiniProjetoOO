package model;

public class Dados {
	private Vaga[] vagas = new Vaga[50];
	private int qtdVagas = 0;
	private Empresa[] empresas = new Empresa[50];
	private int qtdEmpresas = 0;

	public void DadosExemplos() {
		for (int i = 0; i < 5; i++) {
			empresas[i] = new Empresa("Nome" + i, "Endereco" + i, (i + 1) * 654321);
			vagas[i] = new Vaga("Funcao" + i, "Empresa" + i, (i + 1) * 4, (i + 1) * 400);
		}

		qtdVagas = 5;
		qtdEmpresas = 5;
	}

	public Vaga[] getVaga() {
		return vagas;
	}

	public void setVaga(Vaga[] vagas) {
		this.vagas = vagas;
	}

	public void inserirEditarVaga(Vaga v, int pos) {
		this.vagas[pos] = v;
		if (pos == qtdVagas)
			qtdVagas++;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public Empresa[] getEmpresa() {
		return empresas;
	}

	public void setEmpresa(Empresa[] empresas) {
		this.empresas = empresas;
	}

	public void inserirEditarEmpresa(Empresa e, int pos) {
		this.empresas[pos] = e;
		if (pos == qtdEmpresas)
			qtdEmpresas++;
	}

	public int getQtdEmpresas() {
		return qtdEmpresas;
	}

	public void setQtdEmpresas(int qtdEmpresas) {
		this.qtdEmpresas = qtdEmpresas;
	}

}
