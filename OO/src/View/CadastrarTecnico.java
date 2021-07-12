package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.Main;
import Model.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

/**
 * Classe grafica para cadastrar o Tecnico
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class CadastrarTecnico extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField C_nome;
	private JTextField C_endereco;
	private JFormattedTextField c_telefone;
	private JFormattedTextField c_salario;
	private JFormattedTextField c_carteira;
	private JFormattedTextField c_matricula;

	/**
	 * Launch the application.
	 */

	public CadastrarTecnico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Cadastrar");

		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lblMatricula = new JLabel("Matricula :");
		lblMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblMatricula);

		c_matricula = null;
		try {
			c_matricula = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(c_matricula);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNome);

		C_nome = new JTextField();
		C_nome.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		panel.add(C_nome);
		C_nome.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblSexo);

		JComboBox<String> C_sexo = new JComboBox<>();
		C_sexo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		C_sexo.setModel(new DefaultComboBoxModel<String>(new String[] { "Masculino", "feminino" }));
		panel.add(C_sexo);

		JLabel lblEndereco = new JLabel("Endereco :");
		lblEndereco.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblEndereco);

		C_endereco = new JTextField();
		C_endereco.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(C_endereco);
		C_endereco.setColumns(10);

		JLabel lblSalario = new JLabel("Salario: 4 digitos");
		lblSalario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblSalario);

		c_salario = null;
		try {
			c_salario = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(c_salario);

		JLabel lblTelefone = new JLabel("Telefone :\r\n");
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblTelefone);

		c_telefone = null;
		try {
			c_telefone = new JFormattedTextField(new MaskFormatter("(##)9####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(c_telefone);

		JLabel lblCarteira = new JLabel("Carteira de trabalho :  5 digitos\r\n");
		lblCarteira.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblCarteira);

		c_carteira = null;
		try {
			c_carteira = new JFormattedTextField(new MaskFormatter("#####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(c_carteira);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Validação po causa dos Integer e os campos formatados

				if ((C_nome.getText().length() > 0) && (c_telefone.getText().length() > 0)
						&& (C_endereco.getText().length() > 0) && (c_salario.getText().length() > 0)
						&& (c_carteira.getText().length() > 0) && (c_matricula.getText().length() > 0)) {

					if (c_carteira.getText().trim().length() < 5) {
						JOptionPane.showMessageDialog(null, "Carteira de trabalho invalida");
					}

					if (c_salario.getText().trim().length() < 4) {
						JOptionPane.showMessageDialog(null, "Salario invalido");
					}

					if (Main.carteira(Integer.parseInt(c_carteira.getText()))) {
						JOptionPane.showMessageDialog(null, "Carteira de trabalho ja existente faça outra");
					} else {

						Main.getTecnicos().add(new Tecnico(C_nome.getText(), c_telefone.getText(), C_endereco.getText(),
								(String) C_sexo.getSelectedItem(), Double.parseDouble(c_salario.getText()),
								Integer.parseInt(c_carteira.getText()), Integer.parseInt(c_matricula.getText())));

						JFrame tela = null;
						tela = new Menu();
						tela.setVisible(true);
						setVisible(false);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Cadastre os dados!!");
				}

				// Transfere os dados para a Main.

			}
		});
	}

}