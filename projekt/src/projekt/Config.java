package projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Config extends JFrame implements ActionListener {

	private int rounds = 0;
	private String[] playerNames = new String[2];
	private JButton submitButton;
	private JTextField tfPlayer1, tfPlayer2, tfRounds;
	private JLabel labelPlayer1, labelPlayer2, labelRounds, labelOutput;

	public void startConfig() {

		setLayout(null);

		// Damit man nicht so viel verändern muss falls einem die Positionen nicht
		// gefallen
		int positionLeftX = 20;
		int firstElementsY = 20;
		int widthLabel = 170;
		int heightElements = 20;
		int positionPlayersX = positionLeftX + widthLabel;
		int widthPlayers = widthLabel;
		int widthRounds = widthPlayers / 4;
		int widthButton = widthLabel + widthPlayers;
		int positionRoundsX = positionPlayersX + widthPlayers - widthRounds;
		int secondElementsY = (int) (firstElementsY + 1.5 * heightElements);
		int thirdElementsY = (int) (secondElementsY + 1.5 * heightElements);
		int buttonY = thirdElementsY + 2 * heightElements;
		int outputY = (int) (buttonY + 1.5 * heightElements);
		int height = outputY + 3 * firstElementsY;
		int width = widthButton + 2 * positionLeftX;

		labelRounds = new JLabel("Rounds:");
		labelRounds.setBounds(positionLeftX, firstElementsY, widthLabel, heightElements);

		tfRounds = new JTextField();
		tfRounds.setBounds(positionRoundsX, firstElementsY, widthRounds, heightElements);
		// Hab ich im Internet Nachgschaut da ich nicht wusste wie das machen könnte
		// Alles in dem TexetField ist Rechtsbündig
		tfRounds.setHorizontalAlignment(SwingConstants.RIGHT);

		labelPlayer1 = new JLabel("Name Player 1:");
		labelPlayer1.setBounds(positionLeftX, secondElementsY, widthLabel, heightElements);

		tfPlayer1 = new JTextField();
		tfPlayer1.setBounds(positionPlayersX, secondElementsY, widthPlayers, heightElements);

		labelPlayer2 = new JLabel("Name Player 2:");
		labelPlayer2.setBounds(positionLeftX, thirdElementsY, widthLabel, heightElements);

		tfPlayer2 = new JTextField();
		tfPlayer2.setBounds(positionPlayersX, thirdElementsY, widthPlayers, heightElements);

		submitButton = new JButton("Submit");
		submitButton.setBounds(positionLeftX, buttonY, widthButton, heightElements);
		submitButton.addActionListener(this);

		labelOutput = new JLabel();
		labelOutput.setBounds(positionLeftX, outputY, widthButton, heightElements);

		this.add(labelRounds);
		this.add(tfRounds);
		this.add(labelPlayer1);
		this.add(tfPlayer1);
		this.add(labelPlayer2);
		this.add(tfPlayer2);
		this.add(submitButton);
		this.add(labelOutput);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(width, height);
		this.setTitle("Dice Game: Config");
		// Zentriet das Fenster
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			rounds = (int) Double.parseDouble(tfRounds.getText());
			if (rounds <= 20 && rounds > 0) {
				playerNames[0] = tfPlayer1.getText();
				playerNames[1] = tfPlayer2.getText();
				for (int i = 0; i < playerNames.length; i++) {
					GameGui gg = new GameGui(rounds, playerNames, i);
				}

			} else {
				throw new Exception();
			}
		} catch (Exception error) {
			labelOutput.setText("You have to give a number between 1 and 10 Rounds");
			tfRounds.setText("");
		}

	}

}
