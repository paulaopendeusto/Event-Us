package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;

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
		btnGestionarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				menuEventos windowEventos=new menuEventos();
		    	windowEventos.setVisible(true);
			}
		});
		btnGestionarEventos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnGestionarEventos.setBounds(39, 155, 248, 107);
		contentPane.add(btnGestionarEventos);
		
		JButton btnGestionarEspacios = new JButton("Gestionar Espacios");
		btnGestionarEspacios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				menuEspacios windowEspacios=new menuEspacios();
		    	windowEspacios.setVisible(true);
			}
		});	
		btnGestionarEspacios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnGestionarEspacios.setBounds(302, 154, 248, 107);
		contentPane.add(btnGestionarEspacios);
	}
}
