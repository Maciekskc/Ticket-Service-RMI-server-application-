package Window;
import javax.swing.JFrame;



public class WindowStyle {
	

	
	public WindowStyle(Frame frame) {

		frame.setTitle(Frame.appTittle);
		frame.setSize(frame.width, frame.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(true);
	}
}