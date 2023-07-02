/**
 * Usuario comum que so consegue ver e pesquisar as vagas
 * @author Paulo Andre
 * @author Paulo Nery
 * @version 1.1.2
 */
package model;
public  abstract class Usuario {
	private String userName;
	private String cpf;
	private String nomeCompleto;
	/**
	 * Construtor da classe
	 * @param userName
	 * @param cpf
	 * @param nomeCompleto
	 */
	public Usuario(String userName, String cpf,String nomeCompleto) {
		this.userName=userName;
		this.cpf=cpf;
		this.nomeCompleto=nomeCompleto;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
