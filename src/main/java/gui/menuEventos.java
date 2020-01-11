package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import data.Event;
import gestor.gestorEventos;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class menuEventos extends JFrame {
	
	gestorEventos objGestorE=new gestorEventos();

	private JPanel contentPane;
	public JFrame frame;


	/**
	 * Create the frame.
	 */
	public menuEventos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionarEspacios = DefaultComponentFactory.getInstance().createTitle("Gestionar Eventos");
		lblGestionarEspacios.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGestionarEspacios.setBounds(136, 41, 333, 35);
		contentPane.add(lblGestionarEspacios);
			
		gestorEventos geventos = new gestorEventos();
		java.util.List<Event> eventos = geventos.listaEventos();
		for(int i = 0; i<eventos.size(); i++) {
			System.out.println(eventos.get(i).toString());}
		Event[] arrayeventos = new Event[eventos.size()];
		eventos.toArray(arrayeventos);
		
		JList <Event> listaEventos = new JList(arrayeventos);
		listaEventos.setVisibleRowCount(4);
		listaEventos.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(46, 104, 484, 191);
		scrollLista.setViewportView(listaEventos);
		contentPane.add(scrollLista);

		
		
		frame = new JFrame();
		
		
		JButton btnCrearEvento = new JButton("Crear Evento");
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearEvento windowCrearEvento=new CrearEvento();
				setVisible(false);
				dispose();
			}
		});
		btnCrearEvento.setBounds(46, 333, 143, 29);
		contentPane.add(btnCrearEvento);
		
		JButton btnModEvento = new JButton("Modificar Evento");
		btnModEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ModificarEvento windowModificarEvento=new ModificarEvento();
//				setVisible(false);
//				dispose();
			}
		});
		btnModEvento.setBounds(206, 333, 161, 29);
		contentPane.add(btnModEvento);
		
		JButton btnEliminarEvento = new JButton("Eliminar Evento");
		btnEliminarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaEventos.getSelectedIndex() != -1) {

				geventos.eliminarEvento(listaEventos.getSelectedValue().getIdEvent());
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(frame,"Evento eliminado correctamente.");
				menuEventos windowEventos=new menuEventos();
		    	windowEventos.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame,
					    "Por favor, seleccione un evento para poder eliminarlo.",
					    "Ningún evento seleccionado",
					    JOptionPane.ERROR_MESSAGE);
			} 
				
			}
		});
		btnEliminarEvento.setBounds(382, 333, 148, 29);
		contentPane.add(btnEliminarEvento);
	}
}
