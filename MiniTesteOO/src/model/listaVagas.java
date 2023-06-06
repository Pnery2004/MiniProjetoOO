package model;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class listaVagas {
	private String empresa;
	private int salarioBase;
	private int jornadaDiaria;
	private String funcao;

	private List<Vaga> listaVagas = new ArrayList<>(); 
	public void lerDados(){
		try (Scanner leitor = new Scanner(System.in)) {
			System.out.print("Empresa: ");
			empresa = leitor.nextLine();


			System.out.print("Funcao: ");
			leitor.nextLine();
			funcao = leitor.nextLine();


			System.out.print("SalarioBase: ");
			salarioBase = leitor.nextInt();

			System.out.print("Jornada Diaria em horas: ");
			jornadaDiaria = leitor.nextInt();
		}

	}
	public Vaga retornarVaga(){

		Vaga vaga= new Vaga(empresa, jornadaDiaria, jornadaDiaria, empresa); 
		vaga.setEmpresa(empresa);
		vaga.setFuncao(funcao);
		vaga.setJornadaDiaria(jornadaDiaria);
		vaga.setSalariobase(salarioBase);
		return vaga;
	}
	public void alterarVaga(Vaga vaga){
		if(vaga != null){
			for(int i = 0; i < listaVagas.size(); i++){
				if(listaVagas.get(i).getEmpresa() == vaga.getEmpresa())
					listaVagas.set(i, vaga);
			}
		}
	}

	public void salvarvaga(Vaga vaga){
		if(vaga != null){
			listaVagas.add(vaga);
			
		}else{
			System.out.println("Ocorreu um erro. Impossível salvar o cliente!");
		}
	}
	
	public void excluirVaga(Vaga vaga){
		if(vaga != null){
			for(int i = 0; i < listaVagas.size(); i++){
				if(listaVagas.get(i).getFuncao() == vaga.getFuncao())
					listaVagas.remove(vaga);
			}
		}
	}

}

