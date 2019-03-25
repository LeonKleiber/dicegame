package projekt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class GameMainGui extends JFrame implements ActionListener {

	private JPanel contentPane, panel;
	private JTable table;

	private JButton btnDice, btnCancel;
	private ScoreManager sm = new ScoreManager();
	private int dice = 0;
	private Color background;
	private Color foreground;
	private DefaultTableModel dtm;
	private Icon one = new ImageIcon("Images/one.png", "1");
	private Icon two = new ImageIcon("Images/two.png", "2");
	private Icon three = new ImageIcon("Images/three.png", "3");
	private Icon four = new ImageIcon("Images/four.png", "4");
	private Icon five = new ImageIcon("Images/five.png", "5");
	private Icon six = new ImageIcon("Images/six.png", "6");

	public GameMainGui(String[] playerNames, Color background, Color foreground, int i, int rounds) {
		this.background = background;
		this.foreground = foreground;
		int windowWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width
				/ playerNames.length;
		int windowHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		dtm = new DefaultTableModel();

		this.dtm.addColumn("Dice 1");
		this.dtm.addColumn("Dice 2");
		this.dtm.addColumn("Dice 3");
		this.dtm.addColumn("Dice 4");
		this.dtm.addColumn("Dice 5");
		this.dtm.addColumn("Dice 6");
		this.dtm.addColumn("Score");

		int rows = rounds;
		for (int iRow = 0; iRow < rows; iRow++) {
			String[] data = { "", "", "", "", "", "", "" };
			this.dtm.addRow(data);
		}
		setTitle(playerNames[i]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(windowWidth * i, 0, windowWidth, windowHeight);

		contentPane = new JPanel();
		contentPane.setBackground(this.background);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		table.setBorder(new LineBorder(this.foreground));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setForeground(this.foreground);
		table.setBackground(this.background);
		table.setModel(dtm);

		contentPane.add(table);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(this.background);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		btnCancel = new JButton("Save Points");
		panel.add(btnCancel, BorderLayout.EAST);
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnCancel.setBackground(this.background);
		btnCancel.addActionListener(this);

		btnDice = new JButton("dice");
		panel.add(btnDice, BorderLayout.WEST);
		btnDice.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnDice.setBackground(this.background);
		btnDice.addActionListener(this);

	}

	public void startRound() {
		sm.startRound();

	}

	public void endRound() {
sm.endRound();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCancel) {
			sm.setTryes(0);
			endRound();
		} else if (e.getSource() == btnDice) {
			if (sm.getTryes() <= 0) {
				dice = sm.dice();
				switch (dice) {
				case 1:
					dtm.setValueAt(one, 0, sm.getPosition());
					break;
				case 2:
					dtm.setValueAt(two, 0, sm.getPosition());
					break;
				case 3:
					dtm.setValueAt(three, 0, sm.getPosition());
					break;
				case 4:
					dtm.setValueAt(four, 0, sm.getPosition());
					break;
				case 5:
					dtm.setValueAt(five, 0, sm.getPosition());
					break;
				case 6:
					dtm.setValueAt(six, 0, sm.getPosition());
					break;
				}

				dice = 0;
			}

		}

	}
}
