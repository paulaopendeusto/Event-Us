package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import data.Spaces;
import gestor.gestorEspacios;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class menuEspacios extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();

	/**
	 * Create the frame.
	 */
	public menuEspacios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionarEspacios = DefaultComponentFactory.getInstance().createTitle("Gestionar Espacios");
		lblGestionarEspacios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGestionarEspacios.setBounds(136, 41, 333, 35);
		contentPane.add(lblGestionarEspacios);
		
		gestorEspacios gespacios = new gestorEspacios();
		java.util.List<Spaces> espacios = gespacios.listaEspacios();
		for(int i = 0; i<espacios.size(); i++) {
			System.out.println(espacios.get(i).toString());}
		Spaces[] arrayespacios = new Spaces[espacios.size()];
		espacios.toArray(arrayespacios);
		
		JList <Spaces> listaEspacios = new JList(arrayespacios);
		listaEspacios.setVisibleRowCount(4);
		listaEspacios.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(50, 100, 505, 126);
		scrollLista.setViewportView(listaEspacios);
		contentPane.add(scrollLista);

		
		JButton btnCrearEspacio = new JButton("Crear espacio");
		btnCrearEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CrearEspacio windowCrearEspacio=new CrearEspacio();
				setVisible(false);
				dispose();
			
			}
		});	
		btnCrearEspacio.setBounds(46, 333, 143, 29);
		contentPane.add(btnCrearEspacio);
		
		JButton btnModEspacio = new JButton("Modificar Espacio");
		btnModEspacio.setBounds(206, 333, 161, 29);
		btnModEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ModificarEspacio windowModEspacio = new  ModificarEspacio(listaEspacios.getSelectedValue());
				setVisible(false);
				dispose();
			
			}
		});	
		contentPane.add(btnModEspacio);
		
		JButton btnEliminarEspacio = new JButton("Eliminar Espacio");
		btnEliminarEspacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEspacios.getSelectedIndex() != -1) {

					gespacios.eliminarEspacio(listaEspacios.getSelectedValue().getIdSpace());
					//listaEventos.remove(listaEventos.getSelectedIndex());
					setVisible(false);
					dispose();
					JOptionPane.showMessageDialog(frame, "Espacio eliminado correctamente, así como sus eventos asociados");
					menuEspacios windowEventos=new menuEspacios();
			    	windowEventos.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frame,
						    "Por favor, seleccione un espacio para poder eliminarlo.",
						    "Ningún espacio seleccionado",
						    JOptionPane.ERROR_MESSAGE);
				} 
				
			}
		});
		btnEliminarEspacio.setBounds(382, 333, 148, 29);
		contentPane.add(btnEliminarEspacio);
	}
}
