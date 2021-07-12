package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import Controller.Main;
import Model.Cliente;
import Model.Servico;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
import javax.swing.JComboBox;

/**
 * Classe para cadastrar os serviços
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class OrdemServico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField C_descricao;

	public OrdemServico() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Cadastrar servico");

		btnNewButton.setForeground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 2, 0, 0));

		JLabel lbldatarec_1 = new JLabel("Data de recebimento :");
		lbldatarec_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lbldatarec_1);

		JFormattedTextField C_datarecebimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		panel.add(C_datarecebimento);

		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblMarca);

		JComboBox<String> C_marca = new JComboBox<>();
		C_marca.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		C_marca.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Asus", "Dell\t", "Samsung", "CCE", "Positivo" }));
		panel.add(C_marca);

		JLabel lblNserie = new JLabel("Numero de serie : ");
		lblNserie.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNserie);

		JFormattedTextField C_numeroSerie = new JFormattedTextField(new MaskFormatter("####"));
		panel.add(C_numeroSerie);

		JLabel lbldefeito = new JLabel("Descricao do defeito :");
		lbldefeito.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lbldefeito);

		C_descricao = new JTextField();
		C_descricao.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(C_descricao);
		C_descricao.setColumns(10);

		JLabel lblEntrega = new JLabel("Data de entrega :");
		lblEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblEntrega);

		JFormattedTextField C_dataEntrega = new JFormattedTextField(new MaskFormatter("##/##/####"));
		panel.add(C_dataEntrega);

		JLabel lblservico = new JLabel("Numero sevico : 1 a 99");
		lblservico.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblservico);

		NumberFormatter nf = new NumberFormatter();
		nf.setMinimum(1);
		nf.setMaximum(99);
		JFormattedTextField C_nservico = new JFormattedTextField(nf);

		panel.add(C_nservico);

		JLabel lblcliente = new JLabel("Nome do Cliente :");
		lblcliente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblcliente);

		JComboBox<Object> comboBox = new JComboBox<Object>(Main.todososClientes());
		panel.add(comboBox);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/**
				 * Não deixa passar campos nulos
				 */
				if ((C_datarecebimento.getText().length() > 0) && (C_numeroSerie.getText().length() > 0)
						&& (C_dataEntrega.getText().length() > 0) && (C_descricao.getText().length() > 0)
						&& (C_nservico.getText().length() > 0)) {

					/**
					 * Verifica se os campos das datas são validos
					 */
					if (Main.data(C_datarecebimento.getText()) || Main.data(C_dataEntrega.getText())) {
						JOptionPane.showMessageDialog(null, "Data invalidada");

					} else if (Main.data_menor(C_datarecebimento.getText(), C_dataEntrega.getText()) == false) {

						JOptionPane.showMessageDialog(null, "Data errada, digite uma posteriorr a data de recebimento");

					} else {
						Servico atual = new Servico(C_datarecebimento.getText(), (String) C_marca.getSelectedItem(),
								C_numeroSerie.getText(), C_dataEntrega.getText(), C_descricao.getText(),
								Integer.parseInt(C_nservico.getText()));

						for (Cliente agora : Main.getClientes()) {
							if (comboBox.getSelectedItem() != null) {
								if (agora.getNome() == comboBox.getSelectedItem()) {
									agora.setServicos(atual);
									break;
								}
							} else {
								return;
							}

						}
						JFrame tela = null;
						tela = new Menu();
						;
						tela.setVisible(true);
						setVisible(false);
						tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					}

				} else {
					JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");
				}

			}
		});
	}

}
