package aufgabe_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class moreButtons extends JFrame implements ActionListener {

	private JButton ButtonA = new JButton("A");
	private JButton ButtonB = new JButton("B");
	private JButton ButtonC = new JButton("C");
	private JLabel outputLabel = new JLabel();

	public void showDialog() {
		setLayout(null);
		ButtonA.setBounds(10, 10, 250, 20);
		ButtonB.setBounds(10, 40, 250, 20);
		ButtonC.setBounds(10, 70, 250, 20);
		outputLabel.setBounds(10, 100, 250, 15);
		
		add(outputLabel);
		add(ButtonA);
		add(ButtonB);
		add(ButtonC);
		ButtonA.addActionListener(this);
		ButtonB.addActionListener(this);
		ButtonC.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 1200);
		setTitle("title");
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String text="";
		if(e.getSource()==ButtonA) {
			text="A";
		}else if(e.getSource()==ButtonB) {
			text="B";
		}else if(e.getSource()==ButtonC) {
			text="C";
		}
		outputLabel.setText(""+text);
	}

}