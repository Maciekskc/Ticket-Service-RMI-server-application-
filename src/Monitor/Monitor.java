package Monitor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Central.ICentral;
import Data.Info;
import Data.Ticket;

public class Monitor implements IMonitor {
	public static MonitorPanel items;
	public static Info info = new Info();
	
	public Monitor() {
		items = new MonitorPanel();
		/*	try {
			service = (IMonitor)Naming.lookup("rmi://localhost:5099/monitor");
			service.updateWaiting();
		}catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.err.print(e.getMessage());
		}*/
		try {
			IMonitor stub1 = (IMonitor) UnicastRemoteObject.exportObject(this, 0);
			ICentral stub2 = (ICentral)Naming.lookup("rmi://localhost:5099/register");
			Boolean condition = stub2.register(stub1);
			if(!condition) {
				System.err.println("Cantral app returned Registry Error, monitor couldnt be inicjalized");
				System.exit(0);
			}
		} catch (NotBoundException | RemoteException | MalformedURLException e) {
			System.err.println("Connection Error, monitor couldnt be inicialized");
			System.exit(0);
		}  

	}
	
	public static void main(String[] args) {
		new Monitor();
		do {
		}while(true);
	}
	
	public static void monitorUpdate() {
		//for na usuwanie tabeli 1
		try {
			for(int i = items.tableModel.getRowCount() -1; i >= 0; i--) {
				items.tableModel.removeRow(i);
			}
			//for na dodawanie
			for(int i = 0  ; i <info.tickets.size(); i++) {
				items.tableModel.addRow(new Object[] {info.tickets.get(i).number,info.tickets.get(i).type});
			}
			
			//for na usuwanie tabeli 2
			for(int i = items.tableModel1.getRowCount() -1; i >= 0; i--) {
				items.tableModel1.removeRow(i);
			}
			//for na dodawanie
			for(int i = 0  ; i <info.servedTickets.size(); i++) {
				items.tableModel1.addRow(new Object[] {info.servedTickets.get(i).number,info.servedTickets.get(i).type});
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
		System.out.println("lista zaktualizowana");
	}

	@Override
	public void update(ArrayList<Ticket> l,ArrayList<Ticket> s) throws RemoteException {
		info.tickets = l;
		info.servedTickets = s;
		monitorUpdate();
		
	}
}
