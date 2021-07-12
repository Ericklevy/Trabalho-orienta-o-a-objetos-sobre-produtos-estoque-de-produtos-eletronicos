package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Controller.Main;
import Model.Cliente;
import Model.Servico;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Classe grafica para ver os serviços
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class AnaliseServico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea servicoss;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AnaliseServico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton(" Visualizar serviços ");
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

		servicoss = new JTextArea();
		verServicos();
		servicoss.setEditable(false);
		servicoss.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(servicoss, BorderLayout.CENTER);
	}

	private void verServicos() {
		for (Cliente atual : Main.getClientes()) {
			servicoss.append("************************\n");
			servicoss.append(atual.getNome() + "\n");
			for (Servico agora : atual.getServicos()) {
				servicoss.append("Data de recebimento: " + agora.getRecebimento() + "\n");
				servicoss.append("Marca: " + agora.getMarca() + "\n");
				servicoss.append("Numero de serie: " + agora.getNumero_serie() + "\n");
				servicoss.append("Descrição do defeito : " + agora.getDefeito() + "\n");
				servicoss.append("Data de entrega: " + agora.getEntrega() + "\n");
				servicoss.append("Numero do serviço: " + agora.getNumeroServico() + "\n");
				servicoss.append("---------------------------------------");
				servicoss.append("\n");
			}
		}
	}
}
