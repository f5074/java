package practice.example;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class MainView {
	public static void main(String[] args) {
		Frame f = new Frame();
		Label label1 = new Label("no: ");
		Label label2 = new Label("grade: ");
		Label label3 = new Label("subject: ");
		Label label4 = new Label("professor: ");
		Label label5 = new Label("year: ");
		final TextField text1 = new TextField(20);
		final TextField text2 = new TextField(20);
		final TextField text3 = new TextField(20);
		final TextField text4 = new TextField(20);
		final TextField text5 = new TextField(20);
		Button b = new Button("Insert");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String v1 = text1.getText();
				String v2 = text2.getText();
				String v3 = text3.getText();
				String v4 = text4.getText();
				String v5 = text5.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?characterEncoding=UTF-8&serverTimezone=UTC", "root", "1234");
					Statement st = con.createStatement();
					int i = st.executeUpdate("insert into problemm(no,grade,subject,professor,year) values('"+ v1 + "','" + v2 + "','" + v3 + "','" + v4 + "','" + v5 + "')");
					JOptionPane.showMessageDialog(null, "Success");
				} catch (Exception exception) {
					System.out.println(exception);
				}
			}
		});
		Panel p = new Panel(new GridLayout(6, 2));
		p.add(label1);
		p.add(text1);
		p.add(label2);
		p.add(text2);
		p.add(label3);
		p.add(text3);
		p.add(label4);
		p.add(text4);
		p.add(label5);
		p.add(text5);
		p.add(b);
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
}

