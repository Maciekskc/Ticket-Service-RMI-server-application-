package Central;
import java.rmi.Remote;
import java.rmi.RemoteException;

import Data.Ticket;
import Monitor.IMonitor;

public interface ICentral extends Remote {
	public int getNumber() throws RemoteException;//do tworzenia biletu
	public String getTicket(Ticket var) throws RemoteException;//wysy³anie biletu do servera
	public Ticket toServe()throws RemoteException;//pobierania biletu z kolejki
	public void served(int x)throws RemoteException;//obs³uga biletu(na podstawie wys³ania indeksu do servera)
	Boolean register(IMonitor m) throws RemoteException;
}
