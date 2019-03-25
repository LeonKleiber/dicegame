package projekt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

public class PlayerConfig extends JFrame implements ActionListener {

	private int rounds;
	private String[] playerNames;
	private Color[] playerBackgrounds;
	private Color[] playerForegrounds;
	private JButton submitButton;
	private JLabel labelsPlayer[];
	private JTextField tfsPlayer[];
	private JPanel contentPane;
	private JRadioButton rbsRose[], rbsGreen[], rbsYellow[], rbsBlue[], rbsBlack[], rbsWhite[];
	private int numOfPlayers;

	public void startConfig(int numOfPlayers, int rounds) {
		this.rounds = rounds;
		this.numOfPlayers = numOfPlayers;
		playerNames = new String[numOfPlayers];
		playerBackgrounds = new Color[numOfPlayers];
		playerForegrounds = new Color[numOfPlayers];
		labelsPlayer = new JLabel[numOfPlayers];
		tfsPlayer = new JTextField[numOfPlayers];
		rbsRose = new JRadioButton[numOfPlayers];
		rbsGreen = new JRadioButton[numOfPlayers];
		rbsYellow = new JRadioButton[numOfPlayers];
		rbsBlue = new JRadioButton[numOfPlayers];
		rbsBlack = new JRadioButton[numOfPlayers];
		rbsWhite = new JRadioButton[numOfPlayers];

		ButtonGroup[] playerGroups = new ButtonGroup[numOfPlayers];

		setLayout(null);

		// Damit man nicht so viel verändern muss falls einem die Positionen nicht
		// gefallen
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);

		int positionLeftX = 20;
		int firstElementsY = 20;
		int widthElements = 170;
		int heightElements = 20;
		int positionPlayersX = positionLeftX + widthElements;
		int positionRoseX = 2 * positionLeftX + 2 * widthElements;
		int widthRose = 70;
		int positionGreenX = positionRoseX + widthRose;
		int widthGreen = 70;
		int positionYellowX = positionGreenX + widthGreen;
		int widthYellow = 80;
		int positionBlueX = positionYellowX + widthYellow;
		int widthBlue = 60;
		int positionBlackX = positionBlueX + widthBlue;
		int widthBlack = 70;
		int positionWhiteX = positionBlackX + widthBlack;
		int widthWhite = 80;
		int widthButton = 2 * widthElements + widthRose + widthGreen + widthYellow + widthBlue + widthBlack
				+ widthWhite;
		int i;

		for (i = 0; i < numOfPlayers; i++) {
			ButtonGroup playerGroupsI = new ButtonGroup();

			labelsPlayer[i] = new JLabel("Name Player " + (i + 1));
			labelsPlayer[i].setBounds(positionLeftX, i * firstElementsY + heightElements, widthElements,
					heightElements);
			labelsPlayer[i].setForeground(Color.WHITE);
			contentPane.add(labelsPlayer[i]);
			tfsPlayer[i] = new JTextField();
			tfsPlayer[i].setBounds(positionPlayersX, i * firstElementsY + heightElements, widthElements,
					heightElements);
			contentPane.add(tfsPlayer[i]);

			rbsRose[i] = new JRadioButton("Rose");
			rbsRose[i].setBounds(positionRoseX, i * firstElementsY + heightElements, widthRose, heightElements);
			contentPane.add(rbsRose[i]);
			rbsRose[i].setForeground(Color.PINK);
			playerGroupsI.add(rbsRose[i]);
			rbsRose[i].addActionListener(this);

			rbsGreen[i] = new JRadioButton("Green");
			rbsGreen[i].setBounds(positionGreenX, i * firstElementsY + heightElements, widthGreen, heightElements);
			contentPane.add(rbsGreen[i]);
			rbsGreen[i].setForeground(Color.GREEN);
			playerGroupsI.add(rbsGreen[i]);
			rbsGreen[i].addActionListener(this);

			rbsYellow[i] = new JRadioButton("Yellow");
			rbsYellow[i].setBounds(positionYellowX, i * firstElementsY + heightElements, widthYellow, heightElements);
			contentPane.add(rbsYellow[i]);
			rbsYellow[i].setForeground(Color.YELLOW);
			playerGroupsI.add(rbsYellow[i]);
			rbsYellow[i].addActionListener(this);

			rbsBlue[i] = new JRadioButton("Blue");
			rbsBlue[i].setBounds(positionBlueX, i * firstElementsY + heightElements, widthBlue, heightElements);
			contentPane.add(rbsBlue[i]);
			rbsBlue[i].setForeground(Color.BLUE);
			playerGroupsI.add(rbsBlue[i]);
			rbsBlue[i].addActionListener(this);

			rbsBlack[i] = new JRadioButton("Black");
			rbsBlack[i].setBounds(positionBlackX, i * firstElementsY + heightElements, widthBlack, heightElements);
			contentPane.add(rbsBlack[i]);
			rbsBlack[i].setForeground(Color.BLACK);
			playerGroupsI.add(rbsBlack[i]);
			rbsBlack[i].addActionListener(this);

			rbsWhite[i] = new JRadioButton("White");
			rbsWhite[i].setBounds(positionWhiteX, i * firstElementsY + heightElements, widthWhite, heightElements);
			contentPane.add(rbsWhite[i]);
			rbsWhite[i].setForeground(Color.WHITE);
			playerGroupsI.add(rbsWhite[i]);
			rbsWhite[i].addActionListener(this);

		}

		int height = i * (firstElementsY) + 10 + 5 * firstElementsY;
		int width = widthButton + 2 * positionLeftX;

		submitButton = new JButton("Submit");
		submitButton.setBounds(positionLeftX, i * 20 + 40, widthButton, heightElements);
		submitButton.addActionListener(this);
		contentPane.add(submitButton);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(width, height);
		this.setTitle("Dice Game: Config");
		// im Internet nachgeschaut
		// Zentriet das Fenster
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			for (int i = 0; i < labelsPlayer.length; i++) {
				playerNames[i] = tfsPlayer[i].getText();
			}
			PlayerManager pm = new PlayerManager(rounds, playerNames, playerBackgrounds, playerForegrounds);
			pm.startGame();
		}
		for (int iPlayer = 0; iPlayer < numOfPlayers; iPlayer++) {

			if (e.getSource() == rbsRose[iPlayer]) {
				playerBackgrounds[iPlayer] = Color.PINK;
				playerForegrounds[iPlayer] = Color.WHITE;

			} else if (e.getSource() == rbsGreen[iPlayer]) {
				playerBackgrounds[iPlayer] = Color.GREEN;
				playerForegrounds[iPlayer] = Color.BLACK;

			} else if (e.getSource() == rbsYellow[iPlayer]) {
				playerBackgrounds[iPlayer] = Color.YELLOW;
				playerForegrounds[iPlayer] = Color.BLACK;

			} else if (e.getSource() == rbsBlue[iPlayer]) {
				playerBackgrounds[iPlayer] = Color.BLUE;
				playerForegrounds[iPlayer] = Color.WHITE;

			} else if (e.getSource() == rbsWhite[iPlayer]) {
				playerBackgrounds[iPlayer] = Color.WHITE;
				playerForegrounds[iPlayer] = Color.BLACK;

			} else if (e.getSource() == rbsBlack[iPlayer]) {
				playerBackgrounds[iPlayer] = Color.DARK_GRAY;
				playerForegrounds[iPlayer] = Color.WHITE;

			}

		}
	}

}
