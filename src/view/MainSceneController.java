package view;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import model.Session;
import model.User;

public class MainSceneController implements Initializable{
	Session session = Session.getInstance();
	User user = session.getUser();
	@FXML
	private MenuItem btnResume;
	@FXML
	private MenuItem btnCredit;
	@FXML
	private MenuItem btnDebit;
	@FXML
	private MenuItem btnSair;
	@FXML
	private AnchorPane resumePane;
	@FXML
	private MenuItem btnCancel;
	@FXML
	private Menu menuName;
	@FXML
	private Label labelNameUser;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		menuName.setText(user.getFirstName());
		System.out.println("->" + user.getFirstName());
		System.out.println("eu");
		labelNameUser.setText(user.getFirstName() + " "+ user.getLastName());
	}
	
	@FXML
	public void actionButton(ActionEvent event){
		FXMLLoader fxloader;
		try{
			if(event.getSource() == btnResume){
				System.out.println("cliquei");
				fxloader = new FXMLLoader(getClass().getResource("Resume.fxml"));
				resumePane.getChildren().clear();
				resumePane.getChildren().add(fxloader.load());
			}
			else if(event.getSource() == btnCredit){
				System.out.println("cliquei");
				fxloader = new FXMLLoader(getClass().getResource("Credit.fxml"));
				resumePane.getChildren().clear();
				resumePane.getChildren().add(fxloader.load());
			}else if(event.getSource() == btnDebit){
				System.out.println("cliquei Debit");
				fxloader = new FXMLLoader(getClass().getResource("Debit.fxml"));
				resumePane.getChildren().clear();
				resumePane.getChildren().add(fxloader.load());
			}else if(event.getSource() == btnSair){
				System.exit(0);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
