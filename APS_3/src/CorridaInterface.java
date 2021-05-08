import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CorridaInterface extends JFrame {

	private JPanel contentPane;
	
	BancoDeDados Banco = new BancoDeDados();
	Carro carro = new Carro();

	/**
	 * Launch the application.
	 */
	public static void Iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorridaInterface frame = new CorridaInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CorridaInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel primeiraVolt = new JLabel("");
		primeiraVolt.setBounds(172, 71, 70, 14);
		contentPane.add(primeiraVolt);
		
		JLabel segundaVolt = new JLabel("");
		segundaVolt.setBounds(172, 109, 70, 14);
		contentPane.add(segundaVolt);
		
		JLabel totalVolt = new JLabel("");
		totalVolt.setBounds(172, 147, 70, 14);
		contentPane.add(totalVolt);
		
		JLabel titulo = new JLabel("CORRIDA APS");
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(41, 11, 346, 30);
		contentPane.add(titulo);
		
		JButton btnVisua2 = new JButton("VISUALIZAR 2\u00AA");
		btnVisua2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro.voltaDois();
				segundaVolt.setText(carro.getDados2());
				totalVolt.setText(carro.getTotal());
			}
		});
		btnVisua2.setBounds(284, 105, 127, 23);
		contentPane.add(btnVisua2);
		
		JButton btnVisua1 = new JButton("VISUALIZAR 1\u00AA");
		btnVisua1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro.voltaUm();
				primeiraVolt.setText(carro.getDados1());
				totalVolt.setText(carro.getTotal());
			}
		});
		btnVisua1.setBounds(284, 67, 127, 23);
		contentPane.add(btnVisua1);
		
		JLabel lblNewLabel = new JLabel("1\u00AA Volta:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(87, 71, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2\u00AA Volta:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(87, 109, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTempoTotal = new JLabel("Tempo Total:");
		lblTempoTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTempoTotal.setBounds(58, 147, 75, 14);
		contentPane.add(lblTempoTotal);
		
		JButton btnImprimirDados = new JButton("DADOS DA\r\n ULTIMA CORRIDA");
		btnImprimirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carro.GuardarDados();
				carro.MostrarDados();
				JOptionPane.showMessageDialog(null, carro.getImprimir());;
			}
		});
		btnImprimirDados.setBounds(31, 196, 199, 35);
		contentPane.add(btnImprimirDados);
		
		JButton btnImprimirRelatorio = new JButton("IMPRIMIR RELATORIO");
		btnImprimirRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimirRelatorio.setBounds(240, 196, 184, 35);
		contentPane.add(btnImprimirRelatorio);
	}
}
