package practice.example;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;


public class ExTest03 {
	Button[] btn = new Button[4];
	TextField text1 = new TextField(20);
	ButtonAction action = new ButtonAction();
	Frame f = new Frame();
	Label[] label = new Label[7];
	TextField[] textField = new TextField[7];
	Panel[] panel = new Panel[7];
	Panel northPanel = new Panel();
	Panel westPanel = new Panel();
	
	public ExTest03() {

		String[] buttonName = new String[] { "Select", "Insert", "Update", "Delete" };
		northPanel.setLayout(new GridLayout(1, 4));
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(buttonName[i]);
			btn[i].addActionListener(action);
			northPanel.add(btn[i]);
		}

		String[] labelName = new String[] { "no", "grade", "subject", "professor", "year", "semester", "count" };
		westPanel.setLayout(new GridLayout(7, 1));
		for (int i = 0; i < label.length; i++) {
			panel[i] = new Panel();
			label[i] = new Label(labelName[i]);
			textField[i] = new TextField(20);
			panel[i].add(label[i]);
			panel[i].add(textField[i]);
			westPanel.add(panel[i]);
		}

		f.setSize(1000, 500);
		f.setTitle("AWT Å×½ºÆ®");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2) - f.getWidth() / 2;
		int ypos = (int) (screen.getHeight() / 2) - f.getHeight() / 2;
		f.setLocation(xpos, ypos);

		f.setLayout(new BorderLayout());
		f.add("North", northPanel);
		f.add("West", westPanel);
//		
		f.setVisible(true);

//		f.pack();
	}

	class ButtonAction extends Exception implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Select")) {
				try {
					System.out.println("Select");
//					System.out.println(text1.getText());
					JOptionPane.showMessageDialog(null, "Select");

				} catch (Exception exception) {
					System.err.println(exception.getMessage());

				}
			} else if (e.getActionCommand().equals("Delete")) {
				try {
					System.out.println("Delete");
					JOptionPane.showMessageDialog(null, "Delete");
				} catch (Exception exception) {
					System.err.println(exception.getMessage());
				}

			}
		}
	}

	public static void main(String[] args) {
		ExTest03 ex = new ExTest03();
	}

}
