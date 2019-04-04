


package projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Option extends JFrame implements ActionListener{

	private JPanel contentPane;
	private int rounds;
	private String[] playerNames;
	private Color[] playerBackgrounds,playerForegrounds;
	private JCheckBox checkBox_1,checkBox_2,checkBox_3,checkBox_4,checkBox_5,checkBox_6;

	

	public Option(int rounds, String[] playerNames, Color[] playerBackgrounds, Color[] playerForegrounds) {
		
		this.rounds=rounds;
		this.playerNames=playerNames;
		this.playerBackgrounds=playerBackgrounds;
		this.playerForegrounds=playerForegrounds;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 150);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Wich Numbers are evil");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(69, 13, 140, 16);
		contentPane.add(lblTitle);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(78, 76, 117, 29);
		contentPane.add(btnSubmit);
		
		checkBox_1 = new JCheckBox("1");
		checkBox_1.setSelected(true);
		checkBox_1.setForeground(Color.WHITE);
		checkBox_1.setBounds(24, 41, 40, 23);
		contentPane.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("2");
		checkBox_2.setForeground(Color.WHITE);
		checkBox_2.setBounds(68, 41, 40, 23);
		contentPane.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("3");
		checkBox_3.setSelected(true);
		checkBox_3.setForeground(Color.WHITE);
		checkBox_3.setBounds(110, 41, 40, 23);
		contentPane.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("4");
		checkBox_4.setForeground(Color.WHITE);
		checkBox_4.setBounds(146, 41, 40, 23);
		contentPane.add(checkBox_4);
		
		checkBox_5 = new JCheckBox("5");
		checkBox_5.setSelected(true);
		checkBox_5.setForeground(Color.WHITE);
		checkBox_5.setBounds(186, 41, 40, 23);
		contentPane.add(checkBox_5);
		
		checkBox_6 = new JCheckBox("6");
		checkBox_6.setForeground(Color.WHITE);
		checkBox_6.setBounds(224, 41, 40, 23);
		contentPane.add(checkBox_6);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean[] isSelected = new boolean[6];
		int i = 0;
		if (checkBox_1.isSelected()) {
			isSelected[0]=true;
			i++;
		} else {
			isSelected[0]=false;
		}
		if (checkBox_2.isSelected()) {
			isSelected[1]=true;
			i++;
		} else {
			isSelected[1]=false;
		}
		if (checkBox_3.isSelected()) {
			isSelected[2]=true;
			i++;
		} else {
			isSelected[2]=false;
		}
		if (checkBox_4.isSelected()) {
			isSelected[3]=true;
			i++;
		} else {
			isSelected[3]=false;
		}
		if (checkBox_5.isSelected()) {
			isSelected[4]=true;
			i++;
		} else {
			isSelected[4]=false;
		}
		if (checkBox_6.isSelected()) {
			isSelected[5]=true;
			i++;
		} else {
			isSelected[5]=false;
		}
		 
		int[] evilNums= new int[i];
		int iEvilNum=0;
		
		for (int j=0; j<isSelected.length;j++) {
			if (isSelected[j]) {
				evilNums[iEvilNum]=j+1;
				iEvilNum++;
			}
		}
		
		PlayerManager pm = new PlayerManager(rounds, playerNames, playerBackgrounds, playerForegrounds,evilNums);
		pm.startGame();
	}
}
