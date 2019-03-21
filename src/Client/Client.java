package Client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Central.ICentral;
import Data.Ticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client implements ActionListener {
	public static Ticket var = null;
	public ClientPanel items;
	
	public static ICentral  service;
	
	public Client() {
		items = new ClientPanel(this);
		try {
			service = (ICentral)Naming.lookup("rmi://localhost:5099/register");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.err.print(e.getMessage());
		}
	}
	
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		new Client();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == items.takeButton) {
			Ticket var = null;
			try {
				if(items.cmbTypes.getSelectedItem().equals("Normalny")) {
					var = new Ticket(service.getNumber(),"Normalny");
				}else {
					var = new Ticket(service.getNumber(),"Priorytetowy");
				}
				System.out.println("[SERVER]" + service.getTicket(var));
			} catch (RemoteException e1) {
				System.err.print("remote metod ticketSend(Ticket) returned error\n"+e1.getMessage());
			}
		}
		
	}

}
