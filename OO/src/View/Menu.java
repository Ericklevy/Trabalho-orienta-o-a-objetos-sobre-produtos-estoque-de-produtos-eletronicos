package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Menu do aplicativo que abre as outras classes graficas
 * 
 * @author Erick levy
 * @version 1.0 (Out 2020)
 */
public class Menu extends JFrame {

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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(8, 1, 0, 0));

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				try {
					tela = new CadastrarCliente();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				tela.setVisible(true);
				setVisible(false);
			}
		});

		panel.add(btnCadastrarCliente);

		JButton btnCadastrarTecnico = new JButton("Cadastrar Tecnico");
		btnCadastrarTecnico.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCadastrarTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new CadastrarTecnico();
				tela.setVisible(true);
				setVisible(false);
			}

		});

		panel.add(btnCadastrarTecnico);

		JButton btnCadastrarAparelho = new JButton("Cadastrar Aparelho");
		btnCadastrarAparelho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new CadastrarAparelho();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarAparelho.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(btnCadastrarAparelho);

		JButton btnOrdemServico = new JButton("Ordem servico");
		btnOrdemServico.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnOrdemServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				try {
					tela = new OrdemServico();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				tela.setVisible(true);
				setVisible(false);
			}

		});

		panel.add(btnOrdemServico);

		JButton btnAnaliseServico = new JButton("Analise servico");
		btnAnaliseServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new AnaliseServico();
				tela.setVisible(true);
				setVisible(false);

			}
		});
		btnAnaliseServico.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(btnAnaliseServico);

		JButton btnDesignar = new JButton("Designar Tecnico");
		btnDesignar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDesignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new DesignarTecnico();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnDesignar);

		JButton btnRelatorio = new JButton("Relatorio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new Relatorio();
				tela.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnTerminarservico = new JButton("Terminar servico");
		btnTerminarservico.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTerminarservico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tela = null;
				tela = new Terminar();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnTerminarservico);
		btnRelatorio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(btnRelatorio);
	}

}
