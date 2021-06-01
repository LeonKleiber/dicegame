package projekt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigGui frame = new ConfigGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setSelected(true);
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setBounds(30, 85, 40, 20);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setForeground(Color.WHITE);
		radioButton_2.setBounds(70, 85, 40, 20);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setForeground(Color.WHITE);
		radioButton_3.setBounds(110, 85, 40, 20);
		contentPane.add(radioButton_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(30, 110, 120, 30);
		contentPane.add(btnSubmit);
	}
}
