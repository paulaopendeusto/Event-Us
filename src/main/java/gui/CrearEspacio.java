package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import data.Spaces;
import gestor.gestorEspacios;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class CrearEspacio {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField txtTextfieldAdress;
	private JTextField txtTextfieldresources;
	private JSpinner spinner;
	private final Action action = new SwingAction();
	gestorEspacios objGestor = new gestorEspacios();


	public CrearEspacio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnadirEspacio = new JButton("Añadir espacio");
		btnAnadirEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldName.getText()!=null) 
				{
					Spaces objEspacio = new Spaces(2,textFieldName.getText(),txtTextfieldAdress.getText(),Integer.parseInt(spinner.getValue().toString()),txtTextfieldresources.getText());
					objGestor.crearEspacio(objEspacio);

				}
				
				
			}
		});
		btnAnadirEspacio.setAction(action);
		btnAnadirEspacio.setBounds(447, 365, 108, 23);
		frame.getContentPane().add(btnAnadirEspacio);
		
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(225, 344, 52, 14);
		frame.getContentPane().add(lblRecursos);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(225, 308, 63, 14);
		frame.getContentPane().add(lblCapacidad);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(225, 273, 52, 14);
		frame.getContentPane().add(lblDireccin);
		
		JLabel lblNombreDelNuevo = new JLabel("Nombre del nuevo espacio:");
		lblNombreDelNuevo.setBounds(148, 242, 159, 14);
		frame.getContentPane().add(lblNombreDelNuevo);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(287, 239, 108, 20);
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setText("TextFieldName");
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		txtTextfieldAdress = new JTextField();
		txtTextfieldAdress.setBounds(287, 270, 108, 20);
		txtTextfieldAdress.setHorizontalAlignment(SwingConstants.CENTER);
		txtTextfieldAdress.setText("TextField Adress");
		frame.getContentPane().add(txtTextfieldAdress);
		txtTextfieldAdress.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(287, 301, 108, 29);
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		frame.getContentPane().add(spinner);
		
		
		txtTextfieldresources = new JTextField();
		txtTextfieldresources.setBounds(287, 341, 108, 20);
		txtTextfieldresources.setText("TextFieldresources");
		frame.getContentPane().add(txtTextfieldresources);
		txtTextfieldresources.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\albae\\Git Projects\\Event-Us\\src\\main\\java\\espacio.jpg"));
		lblNewLabel.setBounds(0, 0, 584, 411);
		frame.getContentPane().add(lblNewLabel);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "CreateAction");
			putValue(SHORT_DESCRIPTION, "Para crear el nuevo espacio");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
