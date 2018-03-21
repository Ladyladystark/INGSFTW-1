package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import database.datalog;

public class ServerImplRmi extends UnicastRemoteObject implements ServerInterface {
	
 	protected ServerImplRmi() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	public boolean Login(String user,String pw) throws Exception {
		datalog d = new datalog();
		return d.check(user, pw);
	}
	public void SignUp(String usr,String pw) throws Exception {
		datalog d = new datalog();
		if(!d.Repeat(usr))
			d.Signup(usr, pw);
		else
			System.out.println("Utente già esistente");
	}
	
}
