package model;
public  abstract class Vaga {

	private String empresa;
	private int salarioBase;
	private int jornadaDiaria;
	private String funcao;


	public Vaga(String empresa,int salarioBase,int jornadaDiaria,String funcao) {
		super();
		this.empresa=empresa;
		this.salarioBase=salarioBase;
		this.funcao=funcao;
		this.jornadaDiaria=jornadaDiaria;

	}
	public String getEmpresa() {
		return this.empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getSalariobase() {
		return this.salarioBase;
	}
	public void setSalariobase(int salariobase) {
		this.salarioBase = salariobase;
	}
	public int getJornadaDiaria() {
		return this.jornadaDiaria;
	}
	public void setJornadaDiaria(int jornadaDiaria) {
		this.jornadaDiaria = jornadaDiaria;
	}
	public String getFuncao() {
		return this.funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	
	
	

}

	
	
	
	
	
	

