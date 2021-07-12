package Model;

/**
 * Classe do tecnico aqui contem os metodos desta classe e servem para ser
 * armazenados no ArrayList Tecnico
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Tecnico extends Pessoa {

	private String sexo;
	private double salario;
	private int carteira;
	private int matricula;

	public Tecnico() {
	}

	public Tecnico(String nome, String telefone, String endereco, String sexo, double salario, int carteira,
			int matricula) {
		super(nome, telefone, endereco);

		this.sexo = sexo;
		this.salario = salario;
		this.carteira = carteira;
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	// podem alterar o salario do tecnico com base no aumento de serviços
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCarteira() {
		return carteira;
	}

	// recebe um numero aleatorio se entre 1 e 2 se for 1 pode ser concertado se 2
	// não pode

	// Explica o defeito do produto ao cliente

}