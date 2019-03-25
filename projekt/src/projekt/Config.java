package projekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class Config extends JFrame implements ActionListener {

	private int rounds, numOfPlayers;
	private JPanel contentPane;
	private JTextField TfRounds;
	private JTextField TfPlayers;
	private JLabel LabelOutputPlayers, LabelOutputRounds;

	public Config() {
		setTitle("Config");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 175);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LabelRounds = new JLabel("Rounds");
		LabelRounds.setBounds(40, 23, 59, 16);
		contentPane.add(LabelRounds);
		LabelRounds.setForeground(Color.WHITE);

		TfRounds = new JTextField();
		TfRounds.setBounds(245, 18, 62, 26);
		contentPane.add(TfRounds);
		TfRounds.setHorizontalAlignment(SwingConstants.RIGHT);
		TfRounds.setColumns(10);

		JLabel LabelPlayers = new JLabel("Number of Players ");
		LabelPlayers.setBounds(40, 51, 119, 16);
		contentPane.add(LabelPlayers);
		LabelPlayers.setForeground(Color.WHITE);

		TfPlayers = new JTextField();
		TfPlayers.setBounds(245, 49, 61, 20);
		contentPane.add(TfPlayers);
		TfPlayers.setHorizontalAlignment(SwingConstants.RIGHT);
		TfPlayers.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(74, 119, 203, 28);
		contentPane.add(btnSubmit);
		btnSubmit.setBackground(Color.DARK_GRAY);
		btnSubmit.addActionListener(this);

		LabelOutputRounds = new JLabel("");
		LabelOutputRounds.setBounds(50, 79, 246, 16);
		contentPane.add(LabelOutputRounds);
		LabelOutputRounds.setForeground(Color.WHITE);

		LabelOutputPlayers = new JLabel("");
		LabelOutputPlayers.setBounds(64, 101, 228, 16);
		contentPane.add(LabelOutputPlayers);
		LabelOutputPlayers.setBackground(Color.DARK_GRAY);
		LabelOutputPlayers.setForeground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		rounds = 0;
		numOfPlayers = 0;

		LabelOutputPlayers.setText("");
		LabelOutputRounds.setText("");
		try {
			rounds = (int) Double.parseDouble(TfRounds.getText());
		} catch (Exception error) {
			LabelOutputRounds.setText("You can play between 1 and 18 Rounds");

		}
		try {
			numOfPlayers = (int) Double.parseDouble(TfPlayers.getText());
		} catch (Exception error) {
			LabelOutputPlayers.setText("You can only play with 2-6 players");
		}
		if (rounds <= 18 && rounds >= 1 && numOfPlayers <= 6 && numOfPlayers >= 2) {
			PlayerConfig pc = new PlayerConfig();
			pc.startConfig(numOfPlayers, rounds);
		} else {
			if (rounds > 18 || rounds < 1) {
				LabelOutputRounds.setText("You can play between 1 and 18 Rounds");
			} 
			if (numOfPlayers > 6 || numOfPlayers < 2) {
				LabelOutputPlayers.setText("You can only play with 2-6 players");
			}
		}

		TfRounds.setText("");
		TfPlayers.setText("");
	}
}
