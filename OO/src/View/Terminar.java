package View;

import Model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * Classe grafica que termina o serviço
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Terminar extends JFrame {

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
	public Terminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("Escolha servico :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		JComboBox<Object> comboBox = new JComboBox<Object>(Main.pegarservicos());
		contentPane.add(comboBox);

		JButton btnTerminar = new JButton("Terminar servico");
		btnTerminar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTerminar.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {

				if (Main.servico_vazio()) {
					JOptionPane.showMessageDialog(null, "Volte e cadastre um serviço", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					for (Cliente atual : Main.getClientes()) {
						for (Servico agora : atual.getServicos()) {
							if ((Integer) comboBox.getSelectedItem() == agora.getNumeroServico()) {
								agora.setStatus(false);
								break;
							}
						}
					}
					JFrame tela = null;
					tela = new Menu();
					;
					tela.setVisible(true);
					setVisible(false);
					tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				}

			}
		});

		contentPane.add(btnTerminar);

		JButton btnNewButton_1 = new JButton("Voltar para menu :");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame tela = null;
				tela = new Menu();
				tela.setVisible(true);
				setVisible(false);
				tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		contentPane.add(btnNewButton_1);
	}

}
