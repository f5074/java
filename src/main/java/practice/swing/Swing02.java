package practice.swing;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.Action;

public class Swing02 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing02 window = new Swing02();
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
	public Swing02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 787, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumber = new JLabel("number");
		lblNumber.setBounds(33, 52, 57, 15);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblGrade = new JLabel("grade");
		lblGrade.setBounds(33, 88, 57, 15);
		frame.getContentPane().add(lblGrade);
		
		JLabel lblSubject = new JLabel("subject");
		lblSubject.setBounds(33, 135, 57, 15);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblProfessor = new JLabel("professor");
		lblProfessor.setBounds(33, 177, 57, 15);
		frame.getContentPane().add(lblProfessor);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setBounds(33, 231, 57, 15);
		frame.getContentPane().add(lblYear);
		
		JLabel lblSemester = new JLabel("semester");
		lblSemester.setBounds(33, 274, 57, 15);
		frame.getContentPane().add(lblSemester);
		
		JLabel lblCount = new JLabel("count");
		lblCount.setBounds(33, 320, 57, 15);
		frame.getContentPane().add(lblCount);
		
		textField = new JTextField();
		textField.setBounds(102, 49, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 85, 116, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 132, 116, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 174, 116, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(102, 228, 116, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(102, 271, 116, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(102, 317, 116, 21);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSave = new JButton("Select");
		btnSave.setAction(action);
		btnSave.setBounds(238, 10, 97, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnRefresh = new JButton("Insert");
		btnRefresh.setAction(action_1);
		btnRefresh.setBounds(348, 10, 97, 23);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setAction(action_2);
		btnNewButton.setBounds(457, 10, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setAction(action_3);
		btnNewButton_1.setBounds(571, 10, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Select");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Select");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Insert");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Insert");
			
			// 텍스트 입력값 저장
			String t1 = textField.getText();
			String t2 = textField_1.getText();
			String t3 = textField_2.getText();
			String t4 = textField_3.getText();
			String t5 = textField_4.getText();
			String t6 = textField_5.getText();
			String t7 = textField_6.getText();
			
			try {
				// DB연결
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=UTF-8&serverTimezone=UTC", "root", "1234");
				Statement st = con.createStatement();
				int i = st.executeUpdate("insert into problemm(no,grade,subject,professor,year) values('"+ t1 + "','" + t2 + "','" + t3 + "','" + t4 + "','" + t5 + "')");
				
				JOptionPane.showMessageDialog(null, "Data is inserted successfully");
			} catch (Exception ex) {
				System.out.println(ex);
			}

			
			
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Update");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Update");
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Delete");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("Delete");
		}
	}
}
