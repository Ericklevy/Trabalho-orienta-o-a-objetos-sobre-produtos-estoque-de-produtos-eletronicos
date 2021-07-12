package Model;

/**
 * Classe serviço aqui contem seus metodos para serem usados armazenados no
 * ArrayList Servico da classe cliente
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Servico {
	private String recebimento;
	public String marca;
	public String numero_serie;
	public String entrega;
	private String defeito;
	private int numeroServico;

	private boolean status;

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public int getNumeroServico() {
		return numeroServico;
	}

	public void setNumeroServico(int numeroServico) {
		this.numeroServico = numeroServico;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}

	public Servico(String recebimento, String marca, String numero_serie, String entrega, String defeito,
			int numeroServico) {
		super();
		this.recebimento = recebimento;
		this.marca = marca;
		this.numero_serie = numero_serie;
		this.entrega = entrega;
		this.defeito = defeito;
		this.numeroServico = numeroServico;
		this.status = true;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public String getMarca() {
		return marca;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public String getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(String data) {
		this.recebimento = data;
	}

	/**
	 * metodo que verifica os status do servico
	 * 
	 * @return retorna os status do serviço
	 */
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;

	}

}
