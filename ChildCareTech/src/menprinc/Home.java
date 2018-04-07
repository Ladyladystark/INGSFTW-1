package menprinc;

import client.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home {
	public void anag(ActionEvent ev) throws Exception {
		((Node) ev.getSource()).getScene().getWindow().hide();
		Parent root = FXMLLoader.load(getClass().getResource("/anagrafica/Anag.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

		
	}
	
	public void logout(ActionEvent ev) throws Exception {
		((Node) ev.getSource()).getScene().getWindow().hide();
		LoginController C = new LoginController();
		Stage stage = new Stage();
		C.initialize(stage);
		
	}
	public void gite(ActionEvent ev) throws Exception {
		((Node) ev.getSource()).getScene().getWindow().hide();
		Parent root = FXMLLoader.load(getClass().getResource("/gita/Gita.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
	}
	public void mensa(ActionEvent ev) throws Exception {
		((Node) ev.getSource()).getScene().getWindow().hide();
		Parent root = FXMLLoader.load(getClass().getResource("/mensa/Mensa.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
	}
	
}
