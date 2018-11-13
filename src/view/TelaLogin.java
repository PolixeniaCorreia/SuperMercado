package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField campoLogin;
	private JPasswordField pass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Login = new JLabel("Login :");
		Login.setBounds(56, 44, 46, 14);
		contentPane.add(Login);
		
		JLabel Senha = new JLabel("Senha :");
		Senha.setBounds(56, 83, 37, 19);
		contentPane.add(Senha);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(122, 41, 163, 20);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEntrar.setBounds(174, 163, 89, 23);
		contentPane.add(btnEntrar);
		
		pass = new JPasswordField();
		pass.setBounds(122, 82, 107, 20);
		contentPane.add(pass);
		
		super.setTitle("Tela de Login");
	}
}
