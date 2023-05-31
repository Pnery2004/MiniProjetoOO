package model;
public class Avon extends Empresa {
	private String produtos;
	private int minimoVendas;
	private int produtosMensais;

	public Avon(int CEP, String Endereco, String CNPJ, String endereco2,String produtos,int minimoVendas,int produtosMensais) {
		super(CEP, Endereco, CNPJ, endereco2);
		this.minimoVendas=minimoVendas;
		this.produtos=produtos;
		this.produtosMensais=produtosMensais;
	}

	public String getProdutos() {
		return produtos;
	}

	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}

	public int getMinimoVendas() {
		return minimoVendas;
	}

	public void setMinimoVendas(int minimoVendas) {
		this.minimoVendas = minimoVendas;
	}

	public int getProdutosMensais() {
		return produtosMensais;
	}

	public void setProdutosMensais(int produtosMensais) {
		this.produtosMensais = produtosMensais;
	}






}
