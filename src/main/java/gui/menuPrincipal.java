package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.Font;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
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
	public menuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEventus = DefaultComponentFactory.getInstance().createTitle("EVENT-US");
		lblEventus.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblEventus.setBounds(184, 64, 209, 29);
		contentPane.add(lblEventus);
		
		JButton btnGestionarEventos = new JButton("Gestionar Eventos");
		btnGestionarEventos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnGestionarEventos.setBounds(39, 155, 248, 107);
		contentPane.add(btnGestionarEventos);
		
		JButton btnGestionarEspacios = new JButton("Gestionar Espacios");
		btnGestionarEspacios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGestionarEspacios.setBounds(302, 154, 248, 107);
		contentPane.add(btnGestionarEspacios);
	}
}
