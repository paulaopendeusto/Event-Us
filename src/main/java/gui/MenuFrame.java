package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestor.gestorEspacios;
import gestor.gestorEventos;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;

public class MenuFrame extends JFrame {
private static final long serialVersionUID = 1L;
	

	private JPanel contentPane;
	
public MenuFrame(gestorEspacios gestorEspacios, gestorEventos gestorEventos) {
		
		setTitle("EVENT US");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(3, 3, 1020, 800);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 700, 500);
		contentPane.add(panel);
		panel.setLayout(null);
			
		
		JLabel bienvenida = new JLabel("WELCOME TO EVENT US");
		bienvenida.setFont(new Font("Arial", Font.BOLD, 50));
		bienvenida.setBounds(330, 40, 600, 40);
		bienvenida.setForeground(Color.decode("#5FB404"));
		
		panel.add(bienvenida);
		
							
		JButton btnEspacios = new JButton("Gestionar Espacios");
		btnEspacios.setBounds(400, 110, 345, 25);
		btnEspacios.setOpaque(false);
		btnEspacios.setContentAreaFilled(false);
		btnEspacios.setBorderPainted(false);
		btnEspacios.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnEspacios.setForeground(Color.decode("#5FB404"));
		
		btnEspacios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ShowSpacesFrame fespaces = new ShowSpacesFrame(gestorEspacios);
				fespaces.setVisible(true);
				
			}
		});
		
	
		JButton btnEventos = new JButton("Gestionar Eventos");
		btnEventos.setBounds(600, 190, 290, 35);
		btnEventos.setBackground(Color.DARK_GRAY);
		btnEventos.setContentAreaFilled(false);
		btnEventos.setOpaque(true);
		btnEventos.setBorderPainted(false);
		btnEventos.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnEventos.setForeground(Color.decode("#5FB404"));	
				
				
		btnEventos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ShowEventFrame feventos = new ShowEventFrame(gestorEventos);
				feventos.setVisible(true);
		
			}
		});
		
	}
	

}



