package serverSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import database.datalog;
import server.ServerInterface;

public class handler extends Thread implements ServerInterface{
	BufferedReader input;
	OutputStream out;
	Socket client;
	public handler(Socket clientSocket) {
		this.client=clientSocket;
		System.out.println();
	}

	public  void run(){
		String user,password;
		boolean risp;
		try {
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			user = input.readLine();
			password = input.readLine();
			risp = Login(user, password);
			//invio la risposta al client
			if(risp)
				user = "true";
			else 
				user = "false";
			
			out = client.getOutputStream();
			ObjectOutputStream oout = new ObjectOutputStream(out);
			oout.writeObject(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//}
	}// fine run

	@Override
	public boolean Login(String user, String pw) throws Exception {
		datalog d = new datalog();
		
		return d.check(user, pw);
	}

	@Override
	public void SignUp(String usr, String pw) throws Exception {
		// TODO Auto-generated method stub
		
	}




	}// fine classe
