package practice.example;
import java.awt.*;
import java.awt.event.*;

class Exam_01_sub extends Frame implements ActionListener {

	private TextField tf = new TextField();
	private Button bt[] = new Button[16];
	private String str[] = new String[] { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "=", "%",
			"/" };

	private BorderLayout bl = new BorderLayout();
	private Panel p = new Panel();
	private GridLayout gl = new GridLayout(4, 4, 5, 5);

	private String result = "";
	private String yunres = "";
	private char yun = '\0';
	private int res = 0;

	public void init() {
		this.setLayout(bl);
		tf.setEditable(false);
		tf.setFont(new Font("", Font.BOLD, 40));
		this.add("North", tf);
		this.add("Center", p);
		p.setLayout(gl);
		for (int i = 0; i < 16; ++i) {
			bt[i] = new Button(str[i]);
			p.add(bt[i]);
		}
	}

	public void start() {
		for (int i = 0; i < 16; ++i) {
			bt[i].addActionListener(this);
		}
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(wa);
	}

	Exam_01_sub(String title) {
		super(title);
		this.init();
		this.start();
		super.setSize(300, 200);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - super.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - super.getHeight() / 2);
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}

//	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt[3]) {
			yun = '+';
			yunButton();
			return;
		} else if (e.getSource() == bt[7]) {
			yun = '-';
			yunButton();
			return;
		} else if (e.getSource() == bt[11]) {
			yun = '*';
			yunButton();
			return;
		} else if (e.getSource() == bt[13]) {
			calculation();
		} else if (e.getSource() == bt[14]) {
			yun = '%';
			yunButton();
			return;
		} else if (e.getSource() == bt[15]) {
			yun = '/';
			yunButton();
			return;
		} else {
			for (int i = 0; i < 16; ++i) {
				if (e.getSource() == bt[i]) {
					if (res == -1) {
						res = 0;
						result = "";
					}
					result += str[i];
				}
			}
		}
		tf.setText(result);
	}

	public void yunButton() {
		if (yunres == "") {
			yunres = result;
			result = "";
		}
	}

	public void calculation() {
		switch (yun) {
		case '+':
			res = Integer.parseInt(yunres) + Integer.parseInt(result);
			break;
		case '-':
			res = Integer.parseInt(yunres) - Integer.parseInt(result);
			break;
		case '*':
			res = Integer.parseInt(yunres) * Integer.parseInt(result);
			break;
		case '/':
			res = Integer.parseInt(yunres) / Integer.parseInt(result);
			break;
		case '%':
			res = Integer.parseInt(yunres) % Integer.parseInt(result);
			break;
		}
		result = String.valueOf(res);
		yunres = "";
		res = -1;// 결과를 본후 다음에 새로운 숫자를 입력한다면 기존의 값은 지워져야 하므로
	}
}

public class Exam_01 {
	public static void main(String[] args) {
		Exam_01_sub ex = new Exam_01_sub("계산기예제");
	}
}
