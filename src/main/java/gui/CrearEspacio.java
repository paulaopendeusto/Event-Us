package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.Spaces;
import gestor.gestorEspacios;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearEspacio {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textfieldAdress;
	private JTextField textfieldResources;
	private JSpinner spinner;
	gestorEspacios objGestor = new gestorEspacios();


	public CrearEspacio() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnadirEspacio = new JButton("Añadir espacio");
		btnAnadirEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldName.getText()!=null) 
				{
					Spaces objEspacio = new Spaces(textFieldName.getText(),textfieldAdress.getText(),Integer.parseInt(spinner.getValue().toString()),textfieldResources.getText());
					objGestor.crearEspacio(objEspacio);
					frame.setVisible(false);

				}
				
				
			}
		});
		btnAnadirEspacio.setBounds(399, 365, 156, 23);
		frame.getContentPane().add(btnAnadirEspacio);
		
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(307, 194, 93, 14);
		frame.getContentPane().add(lblRecursos);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(307, 133, 93, 14);
		frame.getContentPane().add(lblCapacidad);
		
		JLabel lblDir = new JLabel("Dirección:");
		lblDir.setBounds(10, 194, 84, 14);
		frame.getContentPane().add(lblDir);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 133, 84, 14);
		frame.getContentPane().add(lblNombre);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(93, 130, 108, 20);
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textfieldAdress = new JTextField();
		textfieldAdress.setBounds(93, 191, 108, 20);
		textfieldAdress.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textfieldAdress);
		textfieldAdress.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(399, 126, 108, 29);
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		frame.getContentPane().add(spinner);
		
		
		textfieldResources = new JTextField();
		textfieldResources.setBounds(399, 191, 108, 20);
		frame.getContentPane().add(textfieldResources);
		textfieldResources.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Introduzca los datos del nuevo espacio:");
		lblTitulo.setBounds(142, 53, 235, 14);
		frame.getContentPane().add(lblTitulo);
	}
}
