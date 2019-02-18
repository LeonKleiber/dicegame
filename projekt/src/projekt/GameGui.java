package projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameGui extends JFrame implements ActionListener {

	private String player;
	private ScoreManager sm = new ScoreManager();
	private int i_player;

	public GameGui(int rounds, String[] playerNames, int i) {
		player = playerNames[i];
		i_player = i;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
