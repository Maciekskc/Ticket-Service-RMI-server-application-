package Servant;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Window.Frame;

public class ServantPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Frame frame = new Frame("Servant",64*4,128);
	public JLabel txtNumberLabel;
	public JButton serveButton,checkButton;
	public JTextField txtNumber;
	
	
	
	public ServantPanel(Servant action) {
		this.setLayout(null);
		this.setBounds(0, 0, frame.width, frame.height);
		
		txtNumberLabel = new JLabel("Number:");
		txtNumberLabel.setBounds(30, 0, 100, 20);
		this.add(txtNumberLabel);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(30, 21, 140, 22);
		this.add(txtNumber);
		
		serveButton = new JButton("Serve");
		serveButton.setBounds(frame.width/2 - 5-Frame.BTN_WIDTH, 60, Frame.BTN_WIDTH, Frame.BTN_HEIGHT);
		this.add(serveButton);
		serveButton.addActionListener(action);
		
		checkButton = new JButton("Check");
		checkButton.setBounds(frame.width/2 , 60, Frame.BTN_WIDTH, Frame.BTN_HEIGHT);
		this.add(checkButton);
		checkButton.addActionListener(action);
		
		frame.add(this);
	}
}
