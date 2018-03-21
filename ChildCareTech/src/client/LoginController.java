package client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.json.simple.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import server.ServerInterface;


public class LoginController implements EventHandler<ActionEvent> {
	Socket clsock = null;


	static Socket socket;
	static BufferedReader read;
	static PrintWriter output;

	@FXML
	private Label label; // label login

	@FXML 
	private TextField nome;

	@FXML 
	private TextField passs;

	@FXML
	private ChoiceBox<String> selec;



	JSONObject txt;



	private String remoteObjectName = "MainFrame";


	@SuppressWarnings("unchecked")
	public void initialize(Stage primaryStage) throws Exception{
		BorderPane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Login");
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		ObservableList<String> C = FXCollections.observableArrayList("RMI","Socket");
		selec = (ChoiceBox<String>) root.lookup("#selec");
		selec.setItems(C);
		selec.setValue("RMI");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public void Login(ActionEvent ev) throws Exception {
		//caso rmi
		if(selec.getValue().equals("RMI")) {
			Registry registry = LocateRegistry.getRegistry();
			ServerInterface MainFrame = (ServerInterface) registry.lookup(remoteObjectName);
			if(MainFrame.Login(nome.getText(),passs.getText())) {
				label.setText("Benvenuto "+ nome.getText());
				//se il login ha avuto successo nascono il login
				((Node) ev.getSource()).getScene().getWindow().hide();
				//apro la home
				Parent root = FXMLLoader.load(getClass().getResource("/menprinc/Home.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();

			}
			else
				label.setText("Login Error!!!");
		}	
		//caso Socket
		else {	

			final InetAddress URL = InetAddress.getLocalHost();
			final  int PORT = 3333;
			clsock = new Socket(URL,PORT);

			//mando i dati al server

			if(loginSocket(clsock)) {
				//se il login ha avuto successo nascono il login
				((Node) ev.getSource()).getScene().getWindow().hide();
				//apro la home
				Parent root = FXMLLoader.load(getClass().getResource("/menprinc/Home.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			}
			else	
				clsock.close();
		} // fine else

	}

	private boolean loginSocket(Socket client) throws Exception {
		output = new PrintWriter(new OutputStreamWriter(clsock.getOutputStream()));



		//mando il nome al server
		output.println(nome.getText());




		//mando la password al server
		output.println(passs.getText());
		output.flush();

		//creo un oggetto per leggere la risposta del server 

		InputStream inp = clsock.getInputStream();
		ObjectInputStream ooin = new ObjectInputStream(inp);
		String Risposta = (String) ooin.readObject();

		if(Risposta.equals("true"))
			return true;

		return false;
	}

	@Override
	public void handle(ActionEvent ev) {


	}
	public void SignUp(ActionEvent ev) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		((Node) ev.getSource()).getScene().getWindow().hide();
		stage.show();

	}
}
