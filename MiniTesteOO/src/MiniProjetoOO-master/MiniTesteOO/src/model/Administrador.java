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
	 * @param senhaCriadora 
	 * @param senhaCriadora
	 */
	public Administrador(String userName, String cpf, String nomeCompleto, int senhaCriadora) {
		super(userName, cpf, nomeCompleto);
		this.senhaCriadora=senhaCriadora;
	}

	public int getSenhaCriadora() {
		return senhaCriadora;
	}

	public void setSenhaCriadora(int senhaCriadora) {
		this.senhaCriadora = senhaCriadora;
	}

}
