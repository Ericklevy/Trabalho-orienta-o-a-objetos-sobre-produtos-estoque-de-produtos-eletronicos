package Model;

/**
 * Classe que sera herdada por Tecnico e Cliente
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Pessoa {

	private String nome;
	private String telefone;
	private String endereco;

	public Pessoa() {
	}

	public Pessoa(String nome, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
