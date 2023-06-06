package model;
public  abstract class Empresa {
	private int CEP;
	private String endereco;
	private String CNPJ;

	public Empresa(int CEP,String Endereco,String CNPJ, String endereco) {
		this.CEP=CEP;
		this.endereco=endereco;
		this.CNPJ=CNPJ;

	}

	public int getCEP() {
		return this.CEP;
	}

	public void setCEP(int cEP) {
		this.CEP = cEP;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCNPJ() {
		return this.CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		this.CNPJ = cNPJ;
	}

}

