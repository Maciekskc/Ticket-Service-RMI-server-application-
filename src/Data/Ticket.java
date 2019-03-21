package Data;

import java.io.Serializable;

public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int number;
	public String type;
	public char state;
	
	public Ticket(int number,String type) {
		this.number = number;
		this.type = type;
		this.state = 'i';
	}
}
