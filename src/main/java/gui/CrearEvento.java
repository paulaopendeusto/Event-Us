package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.Event;
import data.Spaces;
import gestor.gestorEspacios;
import gestor.gestorEventos;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class CrearEvento {

	private JFrame frame;
	private JSpinner spinner;
	gestorEspacios gespacios = new gestorEspacios();
	gestorEventos objGestor = new gestorEventos();
	private JTextField textFieldName;
	private JTextField textFieldtipo;
	private JTextField textFieldresources;
	private JTextField textFieldhora;
	private JTextField textFieldminuto;
	private JFormattedTextField frmtdtxtfldFecha;
	private JTextField mes;
	private JTextField dia;

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
				
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(84, 303, 82, 14);
		frame.getContentPane().add(lblRecursos);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(84, 263, 91, 14);
		frame.getContentPane().add(lblPrecio);
		
		spinner = new JSpinner();
		spinner.setBounds(176, 256, 108, 29);
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(5)));
		frame.getContentPane().add(spinner);
		
		
		textFieldresources = new JTextField();
		textFieldresources.setBounds(176, 300, 108, 20);
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
		lblTipologa.setBounds(84, 228, 91, 14);
		frame.getContentPane().add(lblTipologa);
		
		textFieldtipo = new JTextField();
		textFieldtipo.setBounds(176, 225, 86, 20);
		frame.getContentPane().add(textFieldtipo);
		textFieldtipo.setColumns(10);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora:");
		lblFechaYHora.setBounds(396, 203, 108, 14);
		frame.getContentPane().add(lblFechaYHora);
		
		frmtdtxtfldFecha = new JFormattedTextField();
		frmtdtxtfldFecha.setText("YYYY");
		frmtdtxtfldFecha.setToolTipText("yyyy");
		frmtdtxtfldFecha.setBounds(396, 228, 35, 20);
		frame.getContentPane().add(frmtdtxtfldFecha);
		
		textFieldhora = new JTextField();
		textFieldhora.setText("hh");
		textFieldhora.setToolTipText("hh");
		textFieldhora.setBounds(406, 260, 27, 20);
		frame.getContentPane().add(textFieldhora);
		textFieldhora.setColumns(10);
		
		JLabel label = new JLabel(":");
		label.setBounds(438, 263, 4, 14);
		frame.getContentPane().add(label);
		
		textFieldminuto = new JTextField();
		textFieldminuto.setText("mm");
		textFieldminuto.setToolTipText("mm");
		textFieldminuto.setBounds(447, 260, 27, 20);
		frame.getContentPane().add(textFieldminuto);
		textFieldminuto.setColumns(10);
		
		JLabel lblSeleccioneElEspacio = new JLabel("Seleccione el espacio donde ocurrirá el evento:");
		lblSeleccioneElEspacio.setBounds(169, 24, 305, 14);
		frame.getContentPane().add(lblSeleccioneElEspacio);
		
		mes = new JTextField();
		mes.setText("MM");
		mes.setToolTipText("MM");
		mes.setBounds(434, 228, 25, 20);
		frame.getContentPane().add(mes);
		mes.setColumns(10);
		
		dia = new JTextField();
		dia.setText("dd");
		dia.setToolTipText("dd");
		dia.setBounds(462, 228, 27, 20);
		frame.getContentPane().add(dia);
		dia.setColumns(10);
		
		java.util.List<Spaces> espacios = gespacios.listaEspacios();
		Spaces[] arrayespacios = new Spaces[espacios.size()];
		espacios.toArray(arrayespacios);
		
		JList <Spaces> listaEspacios = new JList(arrayespacios);
		listaEspacios.setVisibleRowCount(4);
		listaEspacios.setBounds(50, 49, 505, 126);
		listaEspacios.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(listaEspacios);
		
		
		JButton btnAnadirEspacio = new JButton("Añadir evento");
		btnAnadirEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEspacios.getSelectedIndex() != -1) {                       
	                    System.out.println(listaEspacios.getSelectedValue());   
	                 } 
			}
		});
		btnAnadirEspacio.setBounds(406, 365, 149, 23);
		frame.getContentPane().add(btnAnadirEspacio);
		
	}
	
}
