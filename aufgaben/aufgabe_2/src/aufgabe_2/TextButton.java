package aufgabe_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextButton extends JFrame implements ActionListener {

	private JButton commandButton = new JButton("Text");
	private JTextField field = new JTextField();
	private JLabel outputLabel = new JLabel();

	public void showDialog() {
		setLayout(null);

		outputLabel.setBounds(10, 60, 250, 15);
		field.setBounds(10,40,250,15);
		commandButton.setBounds(10, 80, 250, 20);
		add(outputLabel);
		add(field);
		add(commandButton);
		commandButton.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 1200);
		setTitle("title");
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String text = field.getText();
		outputLabel.setText(" " + text);
	}

}
