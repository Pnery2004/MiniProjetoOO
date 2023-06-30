/**
 * O Admin que cria, edita, e exclui vagas e empresas
 * @author Paulo Andre
 * @author Paulo Nery
 * @version 1.1.2
 */
package model;
public class Administrador extends Usuario {
	private int senhaCriadora;
	/**
	 * Construtor da classe
	 * @param userName
	 * @param cpf
	 * @param nomeCompleto
	 * @param senhaCriadora
	 */
	public Administrador(String userName, String cpf, String nomeCompleto) {
		this.senhaCriadora=senhaCriadora;
		this.userName=userName;
		this.cpf=cpf;
		this.nomeCompleto=nomeCompleto;
	}

	public int getSenhaCriadora() {
		return senhaCriadora;
	}

	public void setSenhaCriadora(int senhaCriadora) {
		this.senhaCriadora = senhaCriadora;
	}

}
