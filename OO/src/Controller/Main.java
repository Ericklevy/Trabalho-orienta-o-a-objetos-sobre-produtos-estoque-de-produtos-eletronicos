package Controller;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Model.*;
import View.*;

/**
 * Verificar os dados salvos,armazena,compara e procura pegos nas classes
 * graficas
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 * 
 */

public class Main {
	public static void main(String[] args) {

		Tecnico teste1 = new Tecnico("Marcos", "(61)99630-9544", "Quadra 300 conjunto 09", "masculino", 3213, 12331,
				1234);
		Tecnico teste11 = new Tecnico("Dante", "(61)99630-9544", "Quadra 600 conjunto 12", "masculino", 3214, 12224,
				4321);
		Main.getTecnicos().add(teste1);
		Main.getTecnicos().add(teste11);
		Cliente teste2 = new Cliente("Erick levy", "(61)99630-9544", "Quadra 450 conjunto 09 casa 08", "3.566.697");
		Main.getClientes().add(teste2);
		Aparelho teste3 = new Aparelho("1234", "Asus", "Bom aparelho de teste");
		Main.getAparelho().add(teste3);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Armazena os dados dos Clientes
	 */
	private final static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	// Salva os dados dos tecnicos;
	/**
	 * Armazena os dados dos Tecnicos
	 */
	private final static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();

	// salvar os aparelhos de teste
	/**
	 * Armazena os dados dos Aparelhos
	 */
	private final static ArrayList<Aparelho> aparelho = new ArrayList<Aparelho>();

	public static ArrayList<Aparelho> getAparelho() {
		return aparelho;
	}

	/**
	 * serve para retorna os Tecnicos
	 * 
	 * @return uma função para retorna os tecnicos
	 */
	public static ArrayList<Tecnico> getTecnicos() {
		return tecnicos;
	}

	/**
	 * serve para retorna os Clientes
	 * 
	 * @return uma função para retorna os Clientes
	 */
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * Pega todos os clientes
	 * 
	 * @return retorna todos os clients pegados da função getClientes()
	 */
	public static Object[] todososClientes() {
		ArrayList<String> modelo = new ArrayList<String>();

		for (Cliente atual : Main.getClientes()) {
			modelo.add(atual.getNome());

		}

		return modelo.toArray();
	}

	/**
	 * Pega todos os tecnicos
	 * 
	 * @return retorna todos os Tecnicos pegados da função getTecnicos()
	 */
	public static Object[] todososTecnicos() {
		ArrayList<String> modelo = new ArrayList<String>();
		for (Tecnico atual : Main.getTecnicos()) {
			modelo.add(atual.getNome());
		}
		return modelo.toArray();
	}

	/**
	 * Verifica se existe uma carteira com o mesmo numero
	 * 
	 * @param n um numero de carteira que deve ver se ja e existente
	 * @return verdadeiro ou falso, indicando se ja existe
	 */
	public static boolean carteira(int n) {
		for (Tecnico atual : Main.getTecnicos()) {
			if (atual.getCarteira() == n) {
				// Carteira existente ja
				return true;
			}

		}
		// carteira não existente
		return false;
	}

	/**
	 * Pega todos os serviços cadastrados da classe Cliente
	 * 
	 * @return retorna os serviços cadastrados de cada clieente
	 */
	public static Object[] pegarservicos() {
		ArrayList<Integer> modelo = new ArrayList<Integer>();
		for (Cliente atual : Main.getClientes()) {
			for (Servico agora : atual.getServicos()) {
				modelo.add(agora.getNumeroServico());
			}
		}
		return modelo.toArray();
	}

	/**
	 * Verifica se os serviços estão vazio
	 * 
	 * @return falso ou verdadeiro , se esta vazio ou não
	 */
	public static boolean servico_vazio() {
		for (Cliente atual : Main.getClientes()) {
			if (!atual.getServicos().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Verifica uma data no formato esperado
	 * 
	 * @param rec uma string data que contem uma data a ser verificada
	 * @return verdadeirro ou falso, indicando se a data valida
	 */
	public static boolean data(String rec) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		try {
			df.parse(rec);
			// data valid
			return false;
		} catch (ParseException ex) {
			// data invalid

			return true;
		}

	}

	/**
	 * Verifica duas string transforma data (1) transforma as duas em datas (2)
	 * Compara rec e ent
	 * 
	 * @param rec uma string data que contem uma data a ser verificada
	 * @param ent uma string data que contem uma data a ser verificada
	 * @return verdadeiro ou falso, se a primeira data e menor que a segunda
	 */
	public static boolean data_menor(String rec, String ent) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = null;
		try {
			data1 = formato.parse(rec);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date data2 = null;
		try {
			data2 = formato.parse(ent);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formato.format(data1);
		formato.format(data2);

		if (data1.before(data2)) {
			return true;

		} else if (data1.after(data2)) {
			return false;

		} else {
			return true;
		}

	}

}