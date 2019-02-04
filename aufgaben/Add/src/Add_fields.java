
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_fields extends JFrame implements ActionListener {

	private JButton commandButton = new JButton("Add");
	private JTextField field1 = new JTextField();
	private JTextField field2 = new JTextField();
	private JLabel outputLabel = new JLabel();

	public void showDialog() {
		setLayout(null);

		outputLabel.setBounds(10, 60, 250, 15);
		field1.setBounds(10, 40, 120, 15);
		field2.setBounds(130, 40, 120, 15);
		commandButton.setBounds(10, 80, 250, 20);
		add(outputLabel);
		add(field1);
		add(field2);
		add(commandButton);
		commandButton.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 1200);
		setTitle("title");
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		double num1 = Double.parseDouble(field1.getText());
		double num2 = Double.parseDouble(field2.getText());
		double result = num1 + num2;
		outputLabel.setText("" + result);

	}

}
