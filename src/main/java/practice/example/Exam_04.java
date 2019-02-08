package practice.example;
import java.awt.*;
import java.awt.event.*;

class Exam_04_sub extends Frame implements ActionListener {
	private Button bt1 = new Button("확대");
	private Button bt2 = new Button("축소");
	private Button bt3 = new Button("원본");
	private Button bt4 = new Button("종료");
	private int width = 100;

	private Panel p = new Panel(); // 명령 Panel

	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\dev\\sun.jpg");
		g.drawImage(img, 20, 40, width, width, this);

	}

	public void init() {
		this.setLayout(new BorderLayout());

		p.setLayout(new GridLayout(4, 1));
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);

		this.add("East", p);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}

	Exam_04_sub(String title) {
		super(title); // 생성자를 통해 타이틀 생성
		super.setSize(400, 300);
		this.init();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2) - super.getWidth() / 2;
		int ypos = (int) (screen.getHeight() / 2) - super.getHeight() / 2;

		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}

//	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt1) {
			if (width >= 300)
				return;
			width += 30;
		} else if (e.getSource() == bt2) {
			if (width <= 30)
				return;
			width -= 30;
		} else if (e.getSource() == bt3) {
			width = 100;
		} else if (e.getSource() == bt4) {
			System.exit(0);
		}

		repaint();
	}

}

public class Exam_04 {

	public static void main(String[] args) {
		Exam_04_sub ex = new Exam_04_sub("awt 실습 타이틀");
	}

}
