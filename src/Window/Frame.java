package Window;
import javax.swing.JFrame;


public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static String appTittle = "RMI App";

	public int width  = 192;
	public int height = 128;
	
	public static final int BTN_WIDTH = 70;
	public static final int BTN_HEIGHT = 25;
	
	private WindowStyle items;
	

	
	public Frame() {
		items = new WindowStyle(this);
	}
	
	public Frame(String tittle,int width,int height) {
		Frame.appTittle = tittle;
		this.width  = width;
		this.height = height;
		items = new WindowStyle(this);
	}
	
	public static void main(String[] args) {
		new Frame();
	}
}
