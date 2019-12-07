package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.Event;
import gestor.gestorEventos;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class CrearEvento {

	private JFrame frame;
	private JSpinner spinner;
	private final Action action = new SwingAction();
	gestorEventos objGestor = new gestorEventos();
	private JTextField textFieldName;
	private JTextField textFieldtipo;
	private JTextField textFieldresources;
	private JTextField textFieldhora;
	private JTextField textFieldminuto;
	private JFormattedTextField frmtdtxtfldFecha;

	public CrearEvento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnadirEspacio = new JButton("Añadir evento");
		btnAnadirEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldName.getText()!=null) 
				{
					String pattern = "MM-dd-yyyy";
					SimpleDateFormat format = new SimpleDateFormat(pattern);
					Date date = null;
					try {
						date = (Date) format.parse(frmtdtxtfldFecha.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Event objevento = new Event(0, textFieldName.getText(), textFieldtipo.getText(), Float.parseFloat(spinner.getValue().toString()), textFieldresources.getText(),date , Integer.parseInt(textFieldhora.getText(), Integer.parseInt(textFieldminuto.getText())), 0);					
					objGestor.crearEvento(objevento);

				}
				
				
			}
		});
		btnAnadirEspacio.setAction(action);
		btnAnadirEspacio.setBounds(447, 365, 108, 23);
		frame.getContentPane().add(btnAnadirEspacio);
		
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(84, 323, 52, 14);
		frame.getContentPane().add(lblRecursos);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(84, 273, 63, 14);
		frame.getContentPane().add(lblPrecio);
		
		spinner = new JSpinner();
		spinner.setBounds(169, 256, 108, 29);
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(5)));
		frame.getContentPane().add(spinner);
		
		
		textFieldresources = new JTextField();
		textFieldresources.setBounds(169, 320, 108, 20);
		textFieldresources.setText("TextFieldresources");
		frame.getContentPane().add(textFieldresources);
		textFieldresources.setColumns(10);
		
		JLabel lblNombreEvento = new JLabel("Nombre Evento:");
		lblNombreEvento.setBounds(84, 200, 91, 14);
		frame.getContentPane().add(lblNombreEvento);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(176, 197, 86, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblTipologa = new JLabel("Tipología:");
		lblTipologa.setBounds(84, 228, 46, 14);
		frame.getContentPane().add(lblTipologa);
		
		textFieldtipo = new JTextField();
		textFieldtipo.setBounds(176, 225, 86, 20);
		frame.getContentPane().add(textFieldtipo);
		textFieldtipo.setColumns(10);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora:");
		lblFechaYHora.setBounds(400, 200, 74, 14);
		frame.getContentPane().add(lblFechaYHora);
		
		frmtdtxtfldFecha = new JFormattedTextField();
		frmtdtxtfldFecha.setBounds(396, 228, 86, 20);
		frame.getContentPane().add(frmtdtxtfldFecha);
		
		textFieldhora = new JTextField();
		textFieldhora.setToolTipText("hh");
		textFieldhora.setBounds(406, 260, 27, 20);
		frame.getContentPane().add(textFieldhora);
		textFieldhora.setColumns(10);
		
		JLabel label = new JLabel(":");
		label.setBounds(436, 263, 4, 14);
		frame.getContentPane().add(label);
		
		textFieldminuto = new JTextField();
		textFieldminuto.setToolTipText("mm");
		textFieldminuto.setBounds(447, 260, 27, 20);
		frame.getContentPane().add(textFieldminuto);
		textFieldminuto.setColumns(10);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Espacio 1", "Espacio 2", "Espacio 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(169, 146, 244, -89);
		frame.getContentPane().add(list);
		
		JLabel lblSeleccioneElEspacio = new JLabel("Seleccione el espacio donde ocurrirá el evento:");
		lblSeleccioneElEspacio.setBounds(169, 24, 244, 14);
		frame.getContentPane().add(lblSeleccioneElEspacio);
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
