package projekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;

public class Config extends JFrame implements ActionListener {

	private int rounds, numOfPlayers;
	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton rbtn1,rbtn2,rbtn3,rbtn4;
	private JLabel lblOutputRound ,lblRounds;

	public Config() {
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int width=180;
		int height= 180;
		
		
		
		JLabel lblRounds = new JLabel("Rounds");
		lblRounds.setForeground(Color.WHITE);
		lblRounds.setBounds(30, 20, 60, 20);
		contentPane.add(lblRounds);
		
		textField = new JTextField();
		textField.setBounds(100, 20, 50, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblInvalidAnswer = new JLabel("Invalid answer");
		lblInvalidAnswer.setForeground(Color.RED);
		lblInvalidAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblInvalidAnswer.setBounds(60, 40, 70, 10);
		contentPane.add(lblInvalidAnswer);
		
		JLabel lblNumberOfPlayers = new JLabel("Number of Players");
		lblNumberOfPlayers.setForeground(Color.WHITE);
		lblNumberOfPlayers.setBounds(30, 60, 120, 15);
		contentPane.add(lblNumberOfPlayers);
		
		JRadioButton radioButton_2 = new JRadioButton("2");
		radioButton_2.setForeground(Color.WHITE);
		radioButton_2.setBounds(30, 85, 40, 20);
		radioButton_2.setSelected(true);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		radioButton_3.setForeground(Color.WHITE);
		radioButton_3.setBounds(70, 85, 40, 20);
		contentPane.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("4");
		radioButton_4.setForeground(Color.WHITE);
		radioButton_4.setBounds(110, 85, 40, 20);
		contentPane.add(radioButton_4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(30, 110, 120, 30);
		contentPane.add(btnSubmit);
		
		ButtonGroup bG = new ButtonGroup();
	    bG.add(radioButton_2);
	    bG.add(radioButton_3);
	    bG.add(radioButton_4);
	    
	     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		rounds = 0;
		numOfPlayers = 0;


		lblOutputRound.setText("");
		try {
			rounds = (int) Double.parseDouble(tfRounds.getText());
		} catch (Exception error) {
			lblOutputRound.setText("You can play between 1 and 18 Rounds");

		}
		if (rounds <= 100 && rounds >= 1 && numOfPlayers <= 6 && numOfPlayers >= 2) {
			this.setVisible(false);
			PlayerConfig pc = new PlayerConfig();
			pc.startConfig(numOfPlayers, rounds);
		} else {
			if (rounds > 100 || rounds < 1) {
				lblOutputRound.setText("You can play between 1 and 100 Rounds");
			} 
			if (numOfPlayers > 6 || numOfPlayers < 2) {
			}
		}

		tfRounds.setText("");
	}
}
