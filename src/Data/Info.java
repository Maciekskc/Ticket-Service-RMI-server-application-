package Data;
import java.io.Serializable;
import java.util.ArrayList;

public class Info implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	public static ArrayList<Ticket> servedTickets = new ArrayList<Ticket>();
}
