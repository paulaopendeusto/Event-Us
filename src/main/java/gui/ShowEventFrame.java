package gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import gestor.gestorEventos;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.Event;
import gestor.gestorEspacios;

public class ShowEventFrame {
	public JFrame frame;
	private JTextField textField;
	private gestorEspacios  espacio;
	private gestorEventos evento;


	public ShowEventFrame(gestorEspacios espacoio,gestorEventos evento ) {
		this.evento= evento;
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
		List<Event> eventos = evento.listaEventos();
		
		for (Event e : eventos) {
	        textPane.append(e.toString() + "\n"); 
	    }
		
		frame.getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri Light", Font.PLAIN, 19));
		textField.setBounds(164, 300, 107, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID del Evento:");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 19));
		lblNewLabel.setBounds(15, 305, 134, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(298, 300, 115, 29);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				int id_evento= Integer.parseInt(textField.getText());
				evento.eliminarEvento(id_evento);
				JOptionPane.showMessageDialog(null, "¡Hemos eliminado el evento seleccionado!", "Evento encontrado", JOptionPane.INFORMATION_MESSAGE);	
				
			}});
		
		
		frame.getContentPane().add(btnEliminar);
	}

}





