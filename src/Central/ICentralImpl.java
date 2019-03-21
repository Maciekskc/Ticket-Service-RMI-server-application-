package Central;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.Info;
import Data.Ticket;
import Monitor.IMonitor;

public class ICentralImpl extends UnicastRemoteObject implements ICentral{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int licznik = 1;
	public ArrayList<IMonitor> monitors = new ArrayList<IMonitor>();//<------------------------------
	
	public Info list;
	
	
	
	public ICentralImpl(Info list) throws RemoteException {
		super();
		this.list = list;
	}

	@Override
	public int getNumber() throws RemoteException {
		return licznik;
	}

	@Override
	public String getTicket(Ticket var) throws RemoteException {
		String response = "Server received ticket number:";
		response += var.number;
		list.tickets.add(var);
		licznik++;
		//registermine();
		for(IMonitor monitor : monitors) {//<-----------
			Info info = list;
			monitor.update(info.tickets,info.servedTickets);
		}
		return response;
	}

/*	public void registermine() throws RemoteException {
		IMonitor service;
		try {
			service = (IMonitor)Naming.lookup("rmi://localhost:5099/monitor");
			service.updateWaiting();
		} catch (MalformedURLException | NotBoundException e) {
			System.err.println("Exception in conecting to monitor implementation");
			
		}
	}*/
	
	public Boolean register(IMonitor m) throws RemoteException {//<--------------------------------
		if(m != null) {
			monitors.add(m);
			System.out.println("New monitor has been added to list of monitors");
			//uda³o siê zarejestrowaæ monitor
			int licznik =0 ;
			for(IMonitor monitor : monitors) {
				
				Info info = list;
				System.out.println("lista elementu" +licznik+ " zaktualizowana");
				monitor.update(info.tickets,info.servedTickets);
				licznik ++;
			}
			return true;
		}
		else {
			//nie mo¿na zarejestrowaæ monitora, nie otrzymano ¿adnego interfacu
			return false;
		}
	}
	
	public Ticket toServe() throws RemoteException {
		if(list.tickets.size() == 0) {//Jak niema biletów to nie zwracaj ¿adnego
			return null;
		}
		
		for(Ticket x: list.tickets) {//przeszukaj tablice w poszukiwqaniu priorytetowego i zwróæ pierwszy napotkany
			if(x.type.equals("Priorytetowy")) return x;
		}
		
		return list.tickets.get(0);//jak tablica nie jest pusta i nie ma priorytetowych to poprostu zwróæ pierwszy
	}

	@Override
	public void served(int x) throws RemoteException {
		System.out.println("Received call to serve ticket");
		for(int i = 0 ; i < list.tickets.size();i++) {
			if(list.tickets.get(i).number == x) {
				System.out.println("i found ticket to serve:"+list.tickets.get(i).number);
				list.tickets.get(i).state='s';
				list.servedTickets.add(list.tickets.get(i));
				System.out.println("ticket has benn added to served list ticket with changed state 's'");
				list.tickets.remove(i);
				for(IMonitor monitor : monitors) {
					Info info = list;
					monitor.update(info.tickets,info.servedTickets);
				}
				System.out.println("Called IMonitor interface to reload items on monitors");
			}else{
				System.out.println("Ticket nr:"+x+" has alredy been served or do not exist");
			}
		}
		
	}

}
