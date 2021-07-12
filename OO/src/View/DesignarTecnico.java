package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Main;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Color;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * Classe grafica para escolher um Tecnico para um servico
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class DesignarTecnico extends JFrame {

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
	public DesignarTecnico() {
		setForeground(new Color(0, 250, 154));
		setTitle("Designar Tecnico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("Nome do Tecnico:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		JComboBox<Object> comboBoxTecnico = new JComboBox<Object>(Main.todososTecnicos());
		panel.add(comboBoxTecnico);

		JLabel lblNewLabel_1 = new JLabel("Numero do servico");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);

		JComboBox<Object> comboBoxNumeroservico = new JComboBox<Object>(Main.pegarservicos());
		panel.add(comboBoxNumeroservico);

		JButton btnNewButton = new JButton("Designar\r\n");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Main.getTecnicos().size() == 0 || Main.servico_vazio()) {
					JOptionPane.showMessageDialog(null, "Volte e cadastre um serviço", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JFrame tela = null;
					tela = new Menu();
					;
					tela.setVisible(true);
					setVisible(false);
					tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.GREEN);

		JButton btnNewButton_1 = new JButton("Voltar ao menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new Menu();
				;
				tela.setVisible(true);
				setVisible(false);
				tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(btnNewButton_1);
	}

}
