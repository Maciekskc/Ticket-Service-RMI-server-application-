package Servant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Central.ICentral;
import Data.Ticket;

public class Servant implements ActionListener {
	public ServantPanel items;
	public ICentral service;
	public Ticket received = null;
	
	public Servant() {
		items = new ServantPanel(this);
		try {
			service = (ICentral)Naming.lookup("rmi://localhost:5099/register");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.err.println("Servant conecting to register failed");
		}
	}
	
	public static void main(String[] args) {
		new Servant();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == items.checkButton) {
			try {
				received = service.toServe();
				System.out.println("RReceived from server ticket nr:" +received.number);
				String fill=""+received.number+"-"+received.type;
				items.txtNumber.setText(fill);
			} catch (RemoteException | NullPointerException e1) {
				System.err.println("Dont received any ticket, RemoteException in \"toServe\" metod.(Ticket list can be empty)");
			}
		}else if(e.getSource() == items.serveButton) {
			if(received!=null) {
				try {
					int x = received.number;
					service.served(x);
					items.txtNumber.setText("");
					System.out.println("Sended to server call to serve ticket nr  " + received.number);
				} catch (RemoteException e1) {
					System.err.println("Dont received any ticket, RemoteException in \"toServe\" metod.");
				}
			}else{
				System.err.println("Dont received any ticket, null pointer");
			}
		}
		
	}

}
