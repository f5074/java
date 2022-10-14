package practice.awt.table;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AwtTable {

	public static void main(String[] args) {

		JFrame frame = new JFrame("참가자 명단");
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setLocation(500, 400);

		Container contentPane = frame.getContentPane();

		String colNames[] = { "이름", "나이", "성별" };
		// Data가 없는 Default Table을 만든다. column는 있기 때문에 아래와 같이 생성.
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		// spring table 생성
		JTable table = new JTable(model);
		// scrollpanel을 추가
		JScrollPane scrollpane = new JScrollPane(table);
		// table을 frame에 추가
		contentPane.add(scrollpane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		JTextField tfName = new JTextField(6);
		JTextField tfAge = new JTextField(3);
		JTextField tfSex = new JTextField(2);

		JButton btAdd = new JButton("Add");
		JButton btDel = new JButton("Del");

		// 이벤트를 처리할 class 객체를 생성한다.
		AddButton adaction = new AddButton(table, tfName, tfAge, tfSex);
		DeleteButton rmaction = new DeleteButton(table);
		// 이벤트 처리 객체를 연결한다.
		btAdd.addActionListener(adaction);
		btDel.addActionListener(rmaction);

		panel.add(new JLabel(colNames[0]));
		panel.add(tfName);
		panel.add(new JLabel(colNames[1]));
		panel.add(tfAge);
		panel.add(new JLabel(colNames[2]));
		panel.add(tfSex);

		panel.add(btAdd);
		panel.add(btDel);

		// table을 frame에 추가
		contentPane.add(panel, BorderLayout.SOUTH);

		// 프로그램 종료
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame이 화면에 딱 맞도록 처리
		frame.pack();
		// 화면에 표시
		frame.setVisible(true);
	}

} 