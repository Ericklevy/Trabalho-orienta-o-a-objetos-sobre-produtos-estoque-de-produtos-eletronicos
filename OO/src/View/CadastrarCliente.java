package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.Main;
import Model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

/**
 * Classe grafica para cadastrar o Cliente
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class CadastrarCliente extends JFrame {
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField rg;
	private JFormattedTextField c_telefone;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CadastrarCliente() {

		setTitle("Cadastro Cliente");
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
		panel.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		JTextField Nome = new JTextField();
		Nome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(Nome);
		Nome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Registro de identidade :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_3);

		try {
			rg = new JFormattedTextField(new MaskFormatter("#.###.###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(rg);

		JLabel lblNewLabel_2 = new JLabel("Endereco :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		panel.add(lblNewLabel_2);

		JTextField Endereco = new JTextField();
		Endereco.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(Endereco);
		Endereco.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Telefone :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);

		try {
			c_telefone = new JFormattedTextField(new MaskFormatter("(##)9####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c_telefone.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		c_telefone.setToolTipText("");
		panel.add(c_telefone);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (Nome.getText().trim().equals("") || c_telefone.getText().trim().length() != 14
						|| Endereco.getText().trim().equals(" ") || rg.getText().trim().length() != 9) {
					JOptionPane.showMessageDialog(null, "Cadastre os dados", "Alerta", JOptionPane.WARNING_MESSAGE);
				} else {
					Main.getClientes()
							.add(new Cliente(Nome.getText(), c_telefone.getText(), Endereco.getText(), rg.getText()));
					JFrame tela = null;
					tela = new Menu();
					tela.setVisible(true);
					setVisible(false);
				}

			}

		});

	}

}
