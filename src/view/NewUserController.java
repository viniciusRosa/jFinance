package view;









import controller.ControllerNewUser;
import facade.Facade;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Password;

public class NewUserController {
	
	Facade f = Facade.getInstance();
	
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtConfirmEmail;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private PasswordField txtConfirmPassword;
	@FXML
	private Label labelerrorMessage;
	@FXML
	private Button btnConfirm;
	@FXML
	private Button btnCancel;
	
	
	@FXML
	private Stage dialogStage;
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	public void actionConfirm(ActionEvent event){
		String message = f.validateUserFacade(txtEmail.getText(), txtConfirmEmail.getText(), txtPassword.getText(), txtConfirmPassword.getText());
		//System.out.println(message);
		//System.out.println(txtEmail.getText()+ txtConfirmEmail.getText()+ txtPassword.getText()+ txtConfirmPassword.getText());
		if(message == ""){
			f.createUserFacade(txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), txtPassword.getText());
			labelerrorMessage.setText("Sucesso");
			labelerrorMessage.setTextFill(Color.GREEN);
			labelerrorMessage.setVisible(true);
		}else{
			labelerrorMessage.setText(message);
			labelerrorMessage.setVisible(true);
				
			}
	}
	
	@FXML
	public void actionCancel(ActionEvent event){
		System.out.println("New User -> btnCancel");
		((Node) (event.getSource())).getScene().getWindow().hide();
		
	}
	
	

}
