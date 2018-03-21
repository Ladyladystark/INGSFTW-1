
package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;

public class ServerRmi {
	public static void main(String[] args) throws RemoteException,
	NamingException, AlreadyBoundException  {
		System.out.println("IMPLEMENTATION...");
		ServerInterface MainFrame = new ServerImplRmi();
		System.out.println("BINDING SERVER...");
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("MainFrame", MainFrame);
		System.out.println("Waiting Clients");
		
	}
}
