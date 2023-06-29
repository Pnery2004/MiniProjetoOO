/**
 * O Admin que cria, edita, e exclui vagas e empresas
 */
package model;
public class Administrador extends Usuario {
	private int senhaCriadora;
	/**
	 * Construtor da classe
	 * @param userName
	 * @param cpf
	 * @param nomeCompleto
	 */
	public Administrador(String userName, String cpf, String nomeCompleto) {
		super(userName, cpf, nomeCompleto);
		// TODO Auto-generated constructor stub
	}

	public int getSenhaCriadora() {
		return senhaCriadora;
	}

	public void setSenhaCriadora(int senhaCriadora) {
		this.senhaCriadora = senhaCriadora;
	}

}
