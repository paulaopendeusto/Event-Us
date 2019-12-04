package gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import gestor.gestorEspacios;
import java.util.List;
import javax.swing.JTextField;

import data.Spaces;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowSpacesFrame {
	
	public JFrame frame;
	private JTextField textField;
	private gestorEspacios espacio;

	public ShowSpacesFrame(gestorEspacios espacio) {
		this.espacio= espacio;
		initialize();
	}

	private void initialize( ) { 
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textPane = new JTextArea();
		textPane.setFont(new Font("Calibri Light", Font.PLAIN, 21));
		textPane.setWrapStyleWord(true);
		textPane.setBounds(0, 0, 970, 270);
		List<Spaces> espacios = espacio.listaEspacios();
		
		for (Spaces s : espacios) {
	        textPane.append(s.toString() + "\n"); 
	    }
		
		frame.getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri Light", Font.PLAIN, 19));
		textField.setBounds(164, 300, 107, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID del Espacio:");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 19));
		lblNewLabel.setBounds(15, 305, 134, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(298, 300, 115, 29);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				int id_espacio= Integer.parseInt(textField.getText());
				espacio.eliminarEspacio(id_espacio);
				JOptionPane.showMessageDialog(null, "¡Hemos eliminado el espacio seleccionado!", "Espacio encontrado", JOptionPane.INFORMATION_MESSAGE);	
				
			}});
		
		
		frame.getContentPane().add(btnEliminar);
	}

	public void setVisible(boolean b) {
		
		setVisible(true);
		// TODO Auto-generated method stub
		
	}

}
