package practice.awt.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteButton implements ActionListener {

	JTable table;

	// 생성자에게 table과 기타 정보를 넘겨준다.
	public DeleteButton(JTable table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row >= 0) {
			// 생성자로부터 받은 table 객체의 타입을 변경한다.
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// table에 object를 삭제한다.
			model.removeRow(row);
		}
	}
}