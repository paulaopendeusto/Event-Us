package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class menuEspacios extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public menuEspacios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionarEspacios = DefaultComponentFactory.getInstance().createTitle("Gestionar Espacios");
		lblGestionarEspacios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGestionarEspacios.setBounds(136, 41, 333, 35);
		contentPane.add(lblGestionarEspacios);
		
		JList list = new JList();
		list.setBounds(46, 104, 484, 191);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Crear espacio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CrearEspacio windowCrearEspacio=new CrearEspacio();
			
			}
		});	
		btnNewButton.setBounds(46, 333, 143, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Espacio");
		btnNewButton_1.setBounds(206, 333, 161, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar Espacio");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(382, 333, 148, 29);
		contentPane.add(btnNewButton_2);
	}
}
