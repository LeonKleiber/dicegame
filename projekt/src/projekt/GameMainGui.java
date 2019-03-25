package projekt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class GameMainGui extends JFrame implements ActionListener {

	private JPanel contentPane, panel;
	private JTable table;

	private JButton btnDice, btnCancel;
	private ScoreManager sm = new ScoreManager();
	private int dice = 0;
	private Color background;
	private Color foreground;
	private DefaultTableModel dtm;
	private RoundManager rm;
	private int iRounds;
	private Icon one = new ImageIcon("./Images/one.png", "1");
	private Icon two = new ImageIcon("./Images/two.png", "2");
	private Icon three = new ImageIcon("./Images/three.png", "3");
	private Icon four = new ImageIcon("./Images/four.png", "4");
	private Icon five = new ImageIcon("./Images/five.png", "5");
	private Icon six = new ImageIcon("../Images/six.png", "6");

	public GameMainGui(String[] playerNames, Color background, Color foreground, int i, int rounds, RoundManager rm) {
		this.rm = rm;
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
		this.dtm.addColumn("Score");

		int rows = rounds;
		for (int iRow = 0; iRow < rows; iRow++) {
			String[] data = { "", "", "", "", "", "" };
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
		table.setEnabled(false);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setBorder(new LineBorder(null));
		table.setForeground(this.foreground);
		table.setBackground(this.background);
		table.setModel(dtm);
		table.setDefaultEditor(Object.class, null);
		for (int iRow = 0; iRow < rounds; iRow++) {
			table.setRowHeight(iRow, 50);
		}
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int iCol = 0; iCol < dtm.getColumnCount(); iCol++) {
			table.getColumnModel().getColumn(iCol).setCellRenderer(centerRenderer);
		}

		contentPane.add(table, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(this.background);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		btnCancel = new JButton("Save Points");
		panel.add(btnCancel, BorderLayout.EAST);
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnCancel.setBackground(this.background);

		btnDice = new JButton("dice");
		panel.add(btnDice, BorderLayout.WEST);
		btnDice.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnDice.setBackground(this.background);
		

	}

	public void startRound(int iRounds) {
		this.iRounds = iRounds;
		sm.startRound();
		btnDice.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void endRound() {
		btnDice.removeActionListener(this);
		btnCancel.removeActionListener(this);
		rm.checkRounds();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCancel) {
			sm.setTryes(0);
		} else if (e.getSource() == btnDice) {
			if (sm.getTryes() > 0) {
				dice = sm.dice();
				switch (dice) {
				case 1:
					dtm.setValueAt(one, iRounds, sm.getPosition());
					break;
				case 2:
					dtm.setValueAt(two, iRounds, sm.getPosition());
					break;
				case 3:
					dtm.setValueAt(three, iRounds, sm.getPosition());
					break;
				case 4:
					dtm.setValueAt(four, iRounds, sm.getPosition());
					break;
				case 5:
					dtm.setValueAt(five, iRounds, sm.getPosition());
					break;
				case 6:
					dtm.setValueAt(six, iRounds, sm.getPosition());
					break;
				}
				sm.checkDice();
				dice = 0;
				dtm.setValueAt(sm.getTemporarlyScore() + "/" + sm.getScore(), iRounds, 5);
			} 

		}

		if (sm.getTryes()==0) {
			endRound();
		}
	}
	public int getScore() {
		return sm.getScore();
	}
}
