package auftrag_1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PureWindow extends JFrame {
	
	public void showDialog() {
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setTitle("title");
		setVisible(true);
		
		JLabel label = new JLabel("ABCD");
		JTextField textField = new JTextField();
		JButton button = new JButton("button");
		
		label.setBounds(10, 10, 100, 10);
		textField.setBounds(1, 30, 100, 15);
		button.setBounds(1, 50, 100, 15);
		
		add(label);
		add(textField);
		add(button);
	}
	
}
