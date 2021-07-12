package Model;

import java.util.ArrayList;

/**
 * Classe do Cliente auxilia como para armazenar os dados na Arraylist Cliente
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Cliente extends Pessoa {
	private String rg;

	/**
	 * ArrayList de serviços para seta para o clientes
	 */
	private ArrayList<Servico> servicos;

	public Cliente() {
	}

	public Cliente(String nome, String telefone, String endereco, String rg) {
		super(nome, telefone, endereco);
		this.rg = rg;
		this.servicos = new ArrayList<Servico>();
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String identidade) {
		this.rg = identidade;
	}

	/**
	 * metodo do ArrayList servico
	 * 
	 * @return os serviços que foram guardados
	 */
	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Servico servicos) {
		this.servicos.add(servicos);
	}

}
