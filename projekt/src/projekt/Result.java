package projekt;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Result extends JFrame implements ActionListener{
	
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
			
			JLabel lblAndTheWinnerIs = new JLabel("And the Winner is");
			JLabel lblWinner = new JLabel("  " + winner + " :  "+max);
			JButton btnRestart =new JButton("Restart");
			
			lblAndTheWinnerIs.setBounds(30, 20, 150, 20);
			lblWinner.setBounds(35, 50, 150, 20);
			btnRestart.setBounds(30, 80, 125, 20);
			
			add(lblAndTheWinnerIs);
			add(lblWinner);
			add(btnRestart);
			
			btnRestart.addActionListener(this);
			
			this.setSize(200,150);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setTitle("Result");
			this.setVisible(true);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		EventQueue.invokeLater(new Runnable() {	
			public void run() {
				try {
					Config frame = new Config();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
