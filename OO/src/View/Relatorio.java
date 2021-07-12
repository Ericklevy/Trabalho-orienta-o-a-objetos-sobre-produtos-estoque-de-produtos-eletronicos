package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Main;
import Model.Cliente;
import Model.Servico;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * Classe que mostra a quantidade de tecnicos, serviços feitos e em andamento,
 * quantidades de equipamentos e relação dos fabricantes
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Relatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Quantidade de tecnicos :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);

		JLabel Quanti_tecnicos = new JLabel(Main.getTecnicos().size() + " ");
		Quanti_tecnicos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(Quanti_tecnicos);

		JLabel lblNewLabel_2 = new JLabel("Realizados e andamento servicos : \r\n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);

		JTextArea Realizados = prencher();
		panel.add(Realizados);

		JLabel lblNewLabel = new JLabel("Quantidade de equipamentos :\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setToolTipText("");
		panel.add(lblNewLabel);

		JLabel Quanti_equips = new JLabel(Main.getAparelho().size() + " ");
		panel.add(Quanti_equips);

		JLabel lblNewLabel_3 = new JLabel("Rela\u00E7\u00E3o do fabricantes :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_3);

		JComboBox<String> relacao = new JComboBox<>();
		relacao.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		relacao.setModel(new DefaultComboBoxModel<String>(new String[] { "Asus e boa", "Dell excelente", "Samsung ruim",
				"CCE muito boa", "Positivo excelente" }));
		panel.add(relacao);

		panel.add(relacao);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new Menu();
				;
				tela.setVisible(true);
				setVisible(false);
				tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});

		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	private JTextArea prencher() {
		int contador_terminados = 0;
		int contador_nao = 0;
		JTextArea modelo = new JTextArea();
		modelo.setEditable(false);
		modelo.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		for (Cliente atual : Main.getClientes()) {
			for (Servico agora : atual.getServicos()) {
				if (agora.isStatus() == false) {
					contador_terminados++;
				}
			}
		}

		for (Cliente atual : Main.getClientes()) {
			for (Servico agora : atual.getServicos()) {
				if (agora.isStatus() == true) {
					contador_nao++;

				}
			}
		}

		modelo.append("Servicos em execução: " + contador_nao + "\n");
		modelo.append("Servicos teminados:  " + contador_terminados + "\n");
		return modelo;

	}
}
