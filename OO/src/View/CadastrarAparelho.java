package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.Main;
import Model.Aparelho;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

/**
 * Classe grafica para cadastrar o aparelho
 * 
 * @author erick
 * @version 1.0 (Out 2020)
 */
public class CadastrarAparelho extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Descricao;
	private JFormattedTextField c_numeroSerie;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CadastrarAparelho() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblNserien = new JLabel("Numero de serie :");
		lblNserien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblNserien);

		try {
			c_numeroSerie = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(c_numeroSerie);

		JLabel lblFab = new JLabel("Fabricante :");
		lblFab.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblFab);

		JComboBox<String> C_fabricante = new JComboBox<>();
		C_fabricante.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		C_fabricante.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Asus", "Dell\t", "Samsung", "CCE", "Positivo" }));
		panel.add(C_fabricante);

		JLabel lblMostraDescri = new JLabel("Descricao :");
		lblMostraDescri.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lblMostraDescri);

		Descricao = new JTextField();
		panel.add(Descricao);
		Descricao.setColumns(10);

		JButton btnNewButton = new JButton("Cadastra aparelho");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (c_numeroSerie.getText().isEmpty() || Descricao.getText().isEmpty()) {
					lblNserien.setVisible(true);
					lblMostraDescri.setVisible(true);
				} else {
					lblNserien.setVisible(false);
					lblMostraDescri.setVisible(false);
				}

				if ((c_numeroSerie.getText().length() > 0) && (Descricao.getText().length() > 0)) {
					Main.getAparelho().add(new Aparelho(c_numeroSerie.getText(),
							(String) C_fabricante.getSelectedItem(), Descricao.getText()));

					JFrame tela = null;
					tela = new Menu();
					tela.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Volte e cadastre um aparelho", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
