package client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.mysql.jdbc.SequentialBalanceStrategy;

import database.datalog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.ServerInterface;

public class SignUpController {
	private String remoteObjectName = "MainFrame";
	@FXML
	private TextField user;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField check;
	
	@FXML
	private Label label;
	
	datalog d = null;
	
	public void Sign(ActionEvent ev) throws Exception {
		System.out.println("pota");
		if (d== null) { // così creo tutto solo una volta
			
		d = new datalog();
		
		//mi connetto al server per potermi registrare
		Registry registry = LocateRegistry.getRegistry();
		ServerInterface MainFrame = (ServerInterface) registry.lookup(remoteObjectName);
		}
		if(!user.getText().isEmpty()) {
			
		if(d.Repeat(user.getText()))
			//nome già presente
			label.setText("Nome utente già in uso");
		else {
			if(password.getText().equals(check.getText()) ) {
				if((password.getText().isEmpty())) {
					label.setText("La password non può essere vuota");
				}
				else {
				d.Signup(user.getText(),password.getText());
				((Node) ev.getSource()).getScene().getWindow().hide();
				LoginController C = new LoginController();
				Stage stage = new Stage();
				C.initialize(stage);
				}
				
			}
			else
				//le due password non coincidono
				label.setText("le Password non coincidono");
			
		}
		}
		else
			label.setText("Username non può essere vuoto");
			
	}
	public void Back(ActionEvent ev) throws Exception {
		((Node) ev.getSource()).getScene().getWindow().hide();
		LoginController C = new LoginController();
		Stage stage = new Stage();
		C.initialize(stage);
	}

}
