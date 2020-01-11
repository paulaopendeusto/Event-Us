package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import data.Event;
import gestor.gestorEventos;

import javax.swing.JList;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		Event[] arrayeventos = new Event[eventos.size()];
		eventos.toArray(arrayeventos);
		
		JList <Event> listaEventos = new JList(arrayeventos);
		listaEventos.setVisibleRowCount(4);
		listaEventos.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setBounds(46, 104, 484, 191);
		scrollLista.setViewportView(listaEventos);
		contentPane.add(scrollLista);

		
		
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1000, 400);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JTextArea textPane = new JTextArea();
//		textPane.setFont(new Font("Calibri Light", Font.PLAIN, 21));
//		textPane.setWrapStyleWord(true);
//		textPane.setBounds(0, 0, 970, 270);
//		gestorEventos objGestorEventos=new gestorEventos();
//		List<Event> eventos = objGestorEventos.listaEventos();
//		
//		for (Event e : eventos) {
//	        textPane.append(e.toString() + "\n"); 
//	    }
//		
//		frame.getContentPane().add(textPane);
		
		
		JButton btnNewButton = new JButton("Crear Evento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearEvento windowCrearEvento=new CrearEvento();
			}
		});
		btnNewButton.setBounds(46, 333, 143, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Evento");
		btnNewButton_1.setBounds(206, 333, 161, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar Evento");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(382, 333, 148, 29);
		contentPane.add(btnNewButton_2);
	}
}
