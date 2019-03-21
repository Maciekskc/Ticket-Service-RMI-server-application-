package Monitor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.Ticket;

public interface IMonitor extends Remote {
	public void update(ArrayList<Ticket> l,ArrayList<Ticket> s) throws RemoteException;
}
