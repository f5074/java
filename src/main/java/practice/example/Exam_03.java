package practice.example;
import java.awt.*;
import java.awt.event.*;

class Exam_03_sub extends Frame {

	public void paint(Graphics g) {
		// 색깔 기본색은 검정
		g.drawLine(50, 50, 100, 100); // 기본 선
		g.setColor(Color.BLUE); // 이 이후부터 그리는 것 파랑색
		g.drawRect(50, 50, 100, 100); // 사각형 그리기
		g.setColor(Color.RED); // 이 이후부터 색깔 빨강
		g.fillRect(200, 50, 100, 100); // 안에 색채운 사각형
		g.drawOval(50, 50, 100, 100); // 원 그리기
		g.setColor(Color.BLACK);
		int x[] = new int[] { 170, 230, 140 };
		int y[] = new int[] { 170, 210, 200 };
		g.fillPolygon(x, y, 3); // 다각형 그리기
		g.setColor(Color.GREEN);
		g.setFont(new Font("", Font.BOLD, 15));
		g.drawString("안녕하세요!", 50, 200);

		Image img = Toolkit.getDefaultToolkit().getImage("C:\\dev\\sun.jpg");// 상대경로
		g.drawImage(img, 230, 180, 80, 80, this); // 현재위치에 출력 (this)
	}

	Exam_03_sub(String title) {

		super(title); // 생성자를 통해 타이틀 생성
		super.setSize(400, 300);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2) - super.getWidth() / 2;
		int ypos = (int) (screen.getHeight() / 2) - super.getHeight() / 2;

		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}

}

public class Exam_03 {

	public static void main(String[] args) {
		Exam_03_sub ex = new Exam_03_sub("awt 실습 타이틀");
	}

}
