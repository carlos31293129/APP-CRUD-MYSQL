import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	

	
	
	conexion db=new conexion();
	Connection cin = (Connection) db.getConnection();
	String idcurso,curso;
	PreparedStatement ps;
	
	public App() {
		
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(0, 0, 804, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("App  Crud Mysql");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel.setBounds(242, 36, 294, 44);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(365, 156, 253, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(365, 234, 253, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID Cursos");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(114, 150, 160, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Curso");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_2.setBounds(63, 228, 235, 34);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\52686\\Desktop\\java\\CrudMysql\\imagenes\\guardar-el-archivo.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				idcurso=textField.getText();
				curso= textField_1.getText();
				
				
				String buscar="select * from software.curso where idcursos=?";
				
				try {
					 ps=cin.prepareCall(buscar);
					 	System.out.println("buscando");
					 	ps.setString(1, idcurso);
					 
				
					ResultSet registro=ps.executeQuery();
					
		 			
		 		if(registro.next()) {
		 			textField.setText(registro.getString("idcursos"));
		 			textField_1.setText(registro.getString("curso"));
		 			
		 			JOptionPane.showMessageDialog(null, "Registro Encontrado","bien", JOptionPane.QUESTION_MESSAGE, null);
		 		}else {
		 				
		 			String insertar="INSERT INTO `software`.`curso` (`idcursos`, `curso`) VALUES (?,?)";
				
				try {
		 			
					 ps=cin.prepareCall(insertar);
					 	System.out.println("insertando");
					 	ps.setString(1, idcurso);
					 	ps.setString(2, curso);
				
					int registro1=ps.executeUpdate();
		 		if(registro1>0) {
		 			JOptionPane.showMessageDialog(null, "Registro Guardado","bien", JOptionPane.QUESTION_MESSAGE, null);
		 			textField.setText("");
			 		textField_1.setText("");
		 		}else {
		 				JOptionPane.showMessageDialog(null, "Error al guardar registro","error", JOptionPane.ERROR_MESSAGE);	
		 		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		 			
		 			
		 		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
					
					
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(63, 406, 147, 85);
		panel.add(btnNewButton);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\52686\\Desktop\\java\\CrudMysql\\imagenes\\buscar.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			idcurso=textField.getText();
			
			String buscar="select * from software.curso where idcursos=?";
			
			try {
				 ps=cin.prepareCall(buscar);
				 	System.out.println("buscando");
				 	ps.setString(1, idcurso);
				 
			
				ResultSet registro=ps.executeQuery();
				
	 			
	 		if(registro.next()) {
	 			textField.setText(registro.getString("idcursos"));
	 			textField_1.setText(registro.getString("curso"));
	 			
	 			JOptionPane.showMessageDialog(null, "Registro Encontrado","bien", JOptionPane.QUESTION_MESSAGE, null);
	 		}else {
	 				JOptionPane.showMessageDialog(null, "Error al buscar registro","error", JOptionPane.ERROR_MESSAGE);	
	 		}
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(235, 418, 147, 73);
		panel.add(btnNewButton_1);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		
		
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\52686\\Desktop\\java\\CrudMysql\\imagenes\\eliminar.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eliminar="DELETE FROM `software`.`curso` WHERE (`idcursos` = ?);";
				
				
				
				try {
					 ps=cin.prepareCall(eliminar);
					 	System.out.println("insertando");
					 	ps.setString(1, idcurso);
					int registro=ps.executeUpdate();
					
		 			
		 		if(registro>0) {
		 			
		 			
		 			JOptionPane.showMessageDialog(null, "Registro Eliminado","bien", JOptionPane.QUESTION_MESSAGE, null);
		 			textField.setText("");
			 		textField_1.setText("");
		 			
		 		}else {
		 				JOptionPane.showMessageDialog(null, "Error al eliminar registro","error", JOptionPane.ERROR_MESSAGE);	
		 		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		


				
			}
		});
		btnNewButton_2.setBounds(395, 406, 171, 85);
		panel.add(btnNewButton_2);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		
		
		
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\52686\\Desktop\\java\\CrudMysql\\imagenes\\actualizar-flecha.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idcurso=textField.getText();
				curso=textField_1.getText();
				
				String actualizar ="UPDATE `software`.`curso` SET `idcursos` = ?, `curso` = ? WHERE (`idcursos` = ?);";
				
				try {
					 ps=cin.prepareCall(actualizar);
					 	System.out.println("actualizando");
					 	ps.setString(1, idcurso);
					 	ps.setString(2, curso);
					 	ps.setString(3, idcurso);
					int registro=ps.executeUpdate();
					
		 			
		 		if(registro>0) {
		 			
		 			
		 			JOptionPane.showMessageDialog(null, "Registro Modificado","bien", JOptionPane.QUESTION_MESSAGE, null);
		 			textField.setText("");
			 		textField_1.setText("");
		 		}else {
		 				JOptionPane.showMessageDialog(null, "Error al modificar registro","error", JOptionPane.ERROR_MESSAGE);	
		 		}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		
				
				
				
			}
		});
		btnNewButton_3.setBounds(576, 406, 160, 85);
		panel.add(btnNewButton_3);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\52686\\Desktop\\wallpaper\\java.jpg"));
		lblNewLabel_3.setBounds(0, 0, 804, 617);
		panel.add(lblNewLabel_3);
	
	
	}
}
