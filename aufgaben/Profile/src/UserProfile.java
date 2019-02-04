
import javax.swing.*;
import java.awt.event.*;

public class UserProfile extends JFrame implements ActionListener {

	private JLabel textName, textColor, textSport, outputName, outputColor, outputSport;
	private JTextField fieldName, fieldColor, fieldSport;
	private JButton buttonChange;
	private Profile userProfile = new Profile();

	public void createProfile() {
		setLayout(null);

		textName = new JLabel("Name:");
		textName.setBounds(10, 20, 100, 40);

		fieldName = new JTextField();
		fieldName.setBounds(110, 20, 150, 40);

		textColor = new JLabel("Color:");
		textColor.setBounds(10, 80, 100, 40);

		fieldColor = new JTextField();
		fieldColor.setBounds(110, 80, 150, 40);

		textSport = new JLabel("Sport:");
		textSport.setBounds(10, 140, 100, 40);

		fieldSport = new JTextField();
		fieldSport.setBounds(110, 140, 150, 40);

		outputName = new JLabel();
		outputName.setBounds(260, 20, 200, 40);

		outputName = new JLabel();
		outputName.setBounds(260, 80, 200, 40);

		outputName = new JLabel();
		outputName.setBounds(260, 140, 200, 40);

		buttonChange = new JButton("Update Profile");
		buttonChange.setBounds(10, 200, 260, 40);
		buttonChange.addActionListener(this);

		add(textName);
		add(fieldName);
		add(outputName);
		add(textColor);
		add(fieldColor);
		add(outputColor);
		add(textSport);
		add(fieldSport);
		add(outputSport);
		add(buttonChange);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setTitle("Profile");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		userProfile.setName(textName.getText());
		userProfile.setColor(textColor.getText());
		userProfile.setSport(textSport.getText());

		outputName.setText(userProfile.getName());
		outputColor.setText(userProfile.getColor());
		outputSport.setText(userProfile.getSport());
	}

}
