import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	conexion db=new conexion();
	Connection cin = (Connection) db.getConnection();
	PreparedStatement ps;
	String usuario,password;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 608, 428);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 134, 140, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 194, 140, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(50, 11, 515, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("INTRODUSCA SU CONTRASE\u00D1A Y PASSWORD");
		lblNewLabel_3.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(148, 51, 340, 29);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(213, 120, 229, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 182, 229, 41);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usuario=textField.getText();
				password=textField_1.getText();
				
				
		
				String buscar="select * from software.curso where idcursos=? and curso=?";
				
				try {
					 ps=cin.prepareCall(buscar);
					 	System.out.println("buscando");
					 	ps.setString(1, usuario);
					 	ps.setString(2, password);
				
					ResultSet registro=ps.executeQuery();
					
		 			
		 		if(registro.next()) {
		 		
		 			
		 			JOptionPane.showMessageDialog(null, "Usuario y Password correcto","bien", JOptionPane.QUESTION_MESSAGE, null);
		 			App frame1 = new App();
					frame1.setVisible(true);
					
					frame.setVisible(false);
					
		 		}else {
		 				JOptionPane.showMessageDialog(null, "Usuario y Password icorrecto","error", JOptionPane.ERROR_MESSAGE);	
		 		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		btnNewButton.setBounds(224, 311, 173, 41);
		panel.add(btnNewButton);
	}
}
