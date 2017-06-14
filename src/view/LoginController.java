package view;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;

import controller.ControllerNewUser;
import controller.ControllerUser;
import facade.Facade;
import facebook4j.Facebook;
import facebook4j.FacebookBase;
import facebook4j.FacebookFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import model.Password;
import repository.RepositoryUser;


public class LoginController {
	
	ControllerUser controllerUsuario = new ControllerUser();
	ControllerNewUser controllerNewUser = new ControllerNewUser();
	Facade f = Facade.getInstance();
	
	@FXML
	private TextField fieldEmail;
	@FXML
	private PasswordField fieldPassword;
	@FXML
	private Button buttonLogin;
	@FXML
	private Button buttonNew;
	@FXML
	private Button facebookLogin;
	@FXML
	private Label labelerror;
	
	
	@SuppressWarnings("deprecation")
	@FXML
	public void actionlogin(ActionEvent event){

		try{
			if(event.getSource() == buttonLogin){
				if(f.confirmloginFacade(fieldEmail.getText(), fieldPassword.getText())){
					
					System.out.println("ok");
					System.out.println(buttonLogin.getText());
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
					
					
					((Node) (event.getSource())).getScene().getWindow().hide();
					Parent root1 = (Parent) fxmlloader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));  
					stage.show();	
							
					}else{
						labelerror.setVisible(true);
						
					}
				
					System.out.println(fieldEmail.getText());
					System.out.println(fieldPassword.getText());
				}else if(event.getSource() == buttonNew){
					System.out.println("work");
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
					
					Parent root1 = (Parent) fxmlloader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));  
					stage.show();
				}else if(event.getSource() == facebookLogin){

				    String domain = "http://www.google.com/";
				    String appId = "196452104148000";
				    String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=public_profile, email";
				    System.setProperty("webdirver.chrome.driver", "chromedriver.exe");
				    
				    WebDriver driver = new ChromeDriver();
				    driver.get(authUrl);
				    String accessToken;
				    while(true){
				      if(!driver.getCurrentUrl().contains("facebook.com")){
				      String url = driver.getCurrentUrl();
				      accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
				      driver.quit();
			             FacebookClient fbClient = new DefaultFacebookClient(accessToken);
			             User user = fbClient.fetchObject("me",User.class, Parameter.with("fields", "first_name,last_name,name,email,picture"));
			            
			             System.out.println(user.getFirstName());
			             System.out.println(user.getLastName());
			             System.out.println(user.getName());
			             System.out.println(user.getEmail());
			             System.out.println(user.getId());
			             System.out.println(user.getPicture());
			             
			             if(controllerNewUser.validateEmail(user.getEmail())){
			            	controllerNewUser.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());
			            	if(f.confirmloginFacade(user.getEmail(), user.getId())){
			            		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
								((Node) (event.getSource())).getScene().getWindow().hide();
								Parent root1 = (Parent) fxmlloader.load();
								Stage stage = new Stage();
								stage.setScene(new Scene(root1));  
								stage.show();
			            	}
			             }else{
			            	 if(f.confirmloginFacade(user.getEmail(), user.getId())){
			            		 FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
			 					((Node) (event.getSource())).getScene().getWindow().hide();
			 					Parent root1 = (Parent) fxmlloader.load();
			 					Stage stage = new Stage();
			 					stage.setScene(new Scene(root1));  
			 					stage.show();
				            	}
			             }
			             
			              
				         }
				     
				     }		
				}
			}catch (Exception e) {
				e.printStackTrace();
			}	
	}
}
