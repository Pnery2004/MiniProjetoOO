/**
 * Classe Vaga simula uma vaga de emprego oferecida por uma empresa
 * @author Paulo Nery
 * @author Paulo Andre
 * @version 1.1
 */

package model;
public  class Vaga {

	private String empresa;
	private int salarioBase;
	private int jornadaDiaria;
	private String funcao;


	public Vaga(String empresa,int salarioBase,int jornadaDiaria,String funcao) {
		super();
		this.empresa=empresa;
		this.setSalarioBase(salarioBase);
		this.funcao=funcao;
		this.jornadaDiaria=jornadaDiaria;

	}

	public Vaga(String empresa2, String string, int jornadaDiaria2, int i) {
		// TODO Auto-generated constructor stub
	}

	public String getEmpresa() {
		return this.empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public void setSalariobase(int salariobase) {
		this.setSalarioBase(salariobase);
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

	public int getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(int salarioBase) {
		this.salarioBase = salarioBase;
	}



	
	
	

}

	
	
	
	
	
	

