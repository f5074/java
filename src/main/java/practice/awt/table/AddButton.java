package practice.awt.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddButton implements ActionListener {

	JTable table;
	JTextField tfName;
	JTextField tfAge;
	JTextField tfSex;

	// 생성자에게 table과 기타 정보를 넘겨준다.
	public AddButton(JTable table, JTextField tfName, JTextField tfAge, JTextField tfSex) {
		this.table = table;
		this.tfName = tfName;
		this.tfAge = tfAge;
		this.tfSex = tfSex;
	}

	public void actionPerformed(ActionEvent e) {
		String str[] = new String[3];
		str[0] = tfName.getText();
		str[1] = tfAge.getText();
		str[2] = tfSex.getText();

		// 생성자로부터 받은 table 객체의 타입을 변경한다.
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// table에 object를 추가한다.
		model.addRow(str);
	}
}