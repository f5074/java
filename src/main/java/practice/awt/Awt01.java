package practice.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Awt01 {
	private static String url;
	private static String id;
	private static String password;

	public static void main(String[] args) {

		// 1. Github에 올릴 경우 자신의 계정정보가 노출되지 않도록 항상 주의
		// 2. 아이디와 비밀번호 파일을 따로 만들어서 관리하기 위해 사용
		try {

			// 프로퍼티 객체 생성
			Properties properties = new Properties();

			// 파일 읽기
			properties.load(new FileInputStream("C:\\DEV\\server.ini"));

			// 프로퍼티 값 읽기
			url = properties.getProperty("url");
			id = properties.getProperty("id");
			password = properties.getProperty("password");

		} catch (Exception exception) {

			System.err.println(exception);
			// 파일이 없을 경우나 예외 발생 시 url, id, password 기본 값
			url = "jdbc:mysql://127.0.0.1:3306/university?characterEncoding=UTF-8&serverTimezone=UTC";
			id = "root";
			password = "1234";
		}

		Frame frame = new Frame();
		Label label1 = new Label("No:");
		Label label2 = new Label("Grade:");
		Label label3 = new Label("Subject:");
		Label label4 = new Label("Professor:");
		Label label5 = new Label("year:");
		Label label6 = new Label("semester:");
		Label label7 = new Label("count:");

		final TextField text1 = new TextField(20);
		final TextField text2 = new TextField(20);
		final TextField text3 = new TextField(20);
		final TextField text4 = new TextField(20);
		final TextField text5 = new TextField(20);
		final TextField text6 = new TextField(20);
		final TextField text7 = new TextField(20);
		Button button = new Button("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connect = DriverManager.getConnection(url, id, password);

					String sql = "INSERT INTO problemm(no,grade,subject,professor,year,semester,count) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pstmt = connect.prepareStatement(sql);

					pstmt.setString(1, text1.getText());
					pstmt.setString(2, text2.getText());
					pstmt.setString(3, text3.getText());
					pstmt.setString(4, text4.getText());
					pstmt.setString(5, text5.getText());
					pstmt.setString(6, text6.getText());
					pstmt.setString(7, text7.getText());

					int result = pstmt.executeUpdate();
					
					if (result == 1) {
						System.out.println("성공");
						JOptionPane.showMessageDialog(null, "성공");
					} else {
						System.out.println("실패");
						JOptionPane.showMessageDialog(null, "실패");
					}

				} catch (Exception exception) {
					System.err.println(exception);
				}
			}
		});
		Panel panel = new Panel(new GridLayout(8, 2));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(label4);
		panel.add(text4);
		panel.add(label5);
		panel.add(text5);
		panel.add(label6);
		panel.add(text6);
		panel.add(label7);
		panel.add(text7);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
}
