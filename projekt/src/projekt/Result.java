package projekt;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Result extends JFrame{
	
	private int max;
	private String winner;

	public Result(int[] scores, String[] playerNames){
		max = Arrays.stream(scores).max().getAsInt();
		for ( int i =0;i<scores.length;i++) {
			if(scores[i]==max) {
				winner=playerNames[i];
			}
		}
	
	}
	public void createResultWindow(){
			this.setLayout(null);
			
			JLabel lblAndTheWinnerIs = new JLabel("And the Winner is:");
			lblAndTheWinnerIs.setVerticalAlignment((int) CENTER_ALIGNMENT);
			JLabel lblWinner = new JLabel(winner + " :  "+max);
			
			
			lblAndTheWinnerIs.setBounds(30, 20, 150, 20);
			lblWinner.setBounds(30, 50, 150, 20);
			
			add(lblAndTheWinnerIs);
			add(lblWinner);
			
			this.setSize(160,100);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setTitle("Result");
			this.setVisible(true);
			
		}
}
