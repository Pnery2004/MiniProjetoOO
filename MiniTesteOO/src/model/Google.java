package model;
public class Google extends Empresa {       
	private String linguagemProgramacao;
	private String nivelEducacao;

	public Google(int CEP, String Endereco, String CNPJ, String endereco2, String linguagemProgramacao,String nivelEducacao) {
		super(CEP, Endereco, CNPJ, endereco2);
		this.setLinguagemProgramacao(linguagemProgramacao);
		this.setNivelEducacao(nivelEducacao);
	}

	public String getLinguagemProgramacao() {
		return linguagemProgramacao;
	}

	public void setLinguagemProgramacao(String linguagemProgramacao) {
		this.linguagemProgramacao = linguagemProgramacao;
	}

	public String getNivelEducacao() {
		return nivelEducacao;
	}

	public void setNivelEducacao(String nivelEducacao) {
		this.nivelEducacao = nivelEducacao;
	}

}

