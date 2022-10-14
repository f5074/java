package practice.swing;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Swing01 {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing01 window = new Swing01();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("button1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1번 클릭");
			}
		});
		btnNewButton.setBounds(51, 43, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action);
		btnNewButton_1.setBounds(165, 43, 135, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	// 스윙버튼 
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "button2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println("스윙버튼 클릭");
		}
	}
}
