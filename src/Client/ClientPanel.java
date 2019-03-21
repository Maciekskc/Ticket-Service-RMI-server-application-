package Client;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Window.Frame;

public class ClientPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Frame frame = new Frame("Terminal",64*4,128);
	public JLabel cmbTypesLabel;
	public JButton takeButton;
	public JComboBox<String> cmbTypes;
	
	private String[] options = {"Normalny","Priorytet"};
	
	
	public ClientPanel(Client action) {
		this.setLayout(null);
		this.setBounds(0, 0, frame.width, frame.height);
		
		JLabel cmbTypesLabel = new JLabel("Type:");
		cmbTypesLabel.setBounds(30, 0, 40, 20);
		this.add(cmbTypesLabel);
		
		cmbTypes = new JComboBox<String>(options);
		cmbTypes.setBounds(30, 21, 140, 22);
		cmbTypes.addActionListener(action);
		this.add(cmbTypes);
		
		
		takeButton = new JButton("Take");
		takeButton.setBounds(frame.width/2 - 40, 60, Frame.BTN_WIDTH, Frame.BTN_HEIGHT);
		this.add(takeButton);
		takeButton.addActionListener(action);
		
		frame.add(this);
	}
	
	
}
