package practice.awt.table02;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by with2J on 2017-07-21.
 */
public class TableEx2 extends JFrame implements TableModelListener {

    public static void main(String[] args)
    {
        new TableEx2();
    }

    //FIELDS
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnType = { "번호", "이름", "나이", "성별"};
    private Object[][] data = {
            {"1", "김철수", "20", "남성"},
            {"2", "김옥자", "43", "여성"},
            {"3", "이순신", "100", "남성"},
            {"4", "유관순", "18", "여성"},
            {"5", "이 도", "54", "남성"}
    };

    //CONSTRUCTOR
    TableEx2()
    {
        super("JTable Test!"); //setTitle() 도 가능
        setSize(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        table = new JTable(data, columnType);
        scrollPane = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);

        table.getModel().addTableModelListener(this); // 테이블에 소속된 하나의 모델이 셀들을 관리하므로 항상 getModel() 을 호출해야함
        table.setAutoCreateRowSorter(true); //자동 행 정렬기능

        //성별 컬럼에 지정된 선택지만 추가할 수 있도록 설정한다.
        TableColumn genderColumn = table.getColumn("성별");
        JComboBox gender = new JComboBox();
        gender.addItem("여성");
        gender.addItem("남성");
        genderColumn.setCellEditor(new DefaultCellEditor(gender));

        add(scrollPane);
        setVisible(true);
    }

//    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();

        if (column == 2) { // 컬럼번호가 2이면 "나이" 컬럼이다. 컬럼인덱스는 0부터 시작한다.
            TableModel model = (TableModel) e.getSource();
            String colName = model.getColumnName(column); //해당 인덱스의 컬럼이름을 받아온다.
            String str = (String) model.getValueAt(row, column); // data는 object 타입이므로 형변환해야 한다.
            if (Integer.parseInt(str) > 100) { //입력한 나이값이 100이 넘을 경우, 경고창을 띄운다.
                JOptionPane.showMessageDialog(this, "나이 범위를 초과하였습니다. 100 미만으로 입력해주세요.", "경고",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}