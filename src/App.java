import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Central.ICentralImpl;
import Data.Info;

public class App {
	
	public Info data= new Info();
	
	public App() throws RemoteException {
		ICentralImpl register = new ICentralImpl(data);
		//IMonitorImpl monitor = new IMonitorImpl(data);
		
		Registry reg = LocateRegistry.createRegistry(5099);
		reg.rebind("register",register);
		//reg.rebind("monitor",monitor);
	}
	
	public static void main(String[] args) throws RemoteException {	
	new App();		
	}
}
