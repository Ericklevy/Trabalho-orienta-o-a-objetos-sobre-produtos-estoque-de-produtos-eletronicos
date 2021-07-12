package Model;

/**
 * Class do aparelho serve para adicionar os dados na Arraylist Aparelhos
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 * 
 */
public class Aparelho {
	private String n_serie;
	private String fabricante;
	private String descricao;

	public String getN_serie() {
		return n_serie;
	}

	public void setN_serie(String n_serie) {
		this.n_serie = n_serie;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aparelho(String n_serie, String fabricante, String descricao) {
		super();
		this.n_serie = n_serie;
		this.fabricante = fabricante;
		this.descricao = descricao;
	}

}
