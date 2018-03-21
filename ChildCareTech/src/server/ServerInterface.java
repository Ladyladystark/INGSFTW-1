package server;

import java.rmi.Remote;

public interface ServerInterface extends Remote {
	boolean Login(String user,String pw) throws Exception;
	void SignUp(String usr,String pw) throws Exception;
}
