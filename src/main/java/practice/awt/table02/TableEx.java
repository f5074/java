package practice.awt.table02;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTable;

public class TableEx {

	public static void main(String[] args) {
		
		Frame f = new Frame();
		String[] columnType = { "번호", "이름", "나이", "성별"};

		Object[][] data = {

		       {"1", "김철수", "20", "남성"},

		       {"2", "김옥자", "43", "여성"},

		       {"3", "이순신", "100", "남성"},

		       {"4", "유관순", "18", "여성"},

		       {"5", "이 도", "54", "남성"}

		};

		JTable table = new JTable(data, columnType);
		
		// 종료 이벤트
		f.addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
		});
		
		f.add(table);
		f.setVisible(true);
		f.pack();
	}

}
