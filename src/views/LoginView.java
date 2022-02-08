package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView {

	private JFrame frame;
	private JPasswordField pwfPin;
	private JLabel lblPin;
	private JButton btnAcceso;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		frame.setVisible(true);
		this.usuarioDAO = new UsuarioDAO();
	}

	/**
	 * Initialize the the view with components and listeners.
	 */
	private void initialize() {
		frame = new JFrame();
		this.configureUIComponents();
		this.configureUIListeners();
	}
	
	public void configureUIComponents() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPin = new JLabel("Introduzca su PIN de acceso:");
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPin.setBounds(0, 10, 436, 71);
		frame.getContentPane().add(lblPin);
		
		pwfPin = new JPasswordField();
		pwfPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		pwfPin.setHorizontalAlignment(SwingConstants.CENTER);
		pwfPin.setBounds(149, 91, 134, 42);
		frame.getContentPane().add(pwfPin);
		
		btnAcceso = new JButton("Acceso");
		btnAcceso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAcceso.setBounds(149, 165, 134, 42);
		frame.getContentPane().add(btnAcceso);
	}
	
	public void configureUIListeners() {
		btnAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			login();
			}
		});
		
		pwfPin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
			}
		});
	}
	
	public void login() {
		String pin = new String (pwfPin.getPassword());
		usuario = new Usuario(0, pin);
		boolean loggedIn = usuarioDAO.login(usuario);
		
		if (loggedIn) {
			JOptionPane.showMessageDialog(btnAcceso, "PIN correcto.");
			frame.dispose();
			new StockView();
			
		} else {
			JOptionPane.showMessageDialog(btnAcceso, "PIN no válido.");
		}
	}
}
