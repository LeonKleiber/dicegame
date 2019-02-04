
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class Application extends JFrame implements ActionListener {

	private JButton buttonAbheben, buttonEinzahlen, buttonKontostand;
	private JTextField input = new JTextField();
	private JLabel output = new JLabel();
	private Konto konto1;

	public void accountApplication() {
		setLayout(null);

		konto1 = new Konto();

		buttonEinzahlen = new JButton("Einzahlen");
		buttonEinzahlen.setBounds(10, 20, 200, 40);
		add(buttonEinzahlen);
		buttonEinzahlen.addActionListener(this);

		buttonAbheben = new JButton("Abheben");
		buttonAbheben.setBounds(10, 100, 200, 40);
		add(buttonAbheben);
		buttonAbheben.addActionListener(this);

		buttonKontostand = new JButton("Saldo");
		buttonKontostand.setBounds(10, 180, 200, 40);
		add(buttonKontostand);
		buttonKontostand.addActionListener(this);

		input.setBounds(220, 60, 240, 40);
		add(input);
		output.setBounds(220, 180, 220, 40);
		add(output);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setTitle("Konto Manager");
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		double betrag = Double.parseDouble(input.getText());
		

		if (e.getSource() == buttonAbheben) {
			konto1.abheben(betrag);
			input.setText("");

		} else if (e.getSource() == buttonEinzahlen) {
			konto1.einzahlen(betrag);
			input.setText("");
		} else if (e.getSource() == buttonKontostand) {
			double kontostand = konto1.getKontostand();
			output.setText("" + kontostand);
		}

	}

}
