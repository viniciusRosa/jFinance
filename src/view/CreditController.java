package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.ControllerCredit;
import facade.Facade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Credit;
import repository.RepositoryCredit;



public class CreditController implements Initializable{
	private Facade f = Facade.getInstance();
	ControllerCredit controllerCredit = new ControllerCredit();
	
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtDescription;
	@FXML
	private TextField txtAvailable;
	@FXML
	private TextField txtValue;
	@FXML
	private Button btnClear;
	@FXML
	private Button btnConfirm;
	
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnCancel;
	@FXML
	private Label labelTotal;
	@FXML
	private TableView<Credit> tableCredit;
	@FXML
	private TableColumn<Credit, String> columnName;
	@FXML
	private TableColumn<Credit, String> columnDescription;
	@FXML
	private TableColumn<Credit, String> columnAvailable;
	@FXML
	private TableColumn<Credit, Double> columnValue;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnName.setCellValueFactory(new PropertyValueFactory<Credit, String>("name"));
		columnDescription.setCellValueFactory(new PropertyValueFactory<Credit, String>("description"));
		columnAvailable.setCellValueFactory(new PropertyValueFactory<Credit, String>("available"));
		columnValue.setCellValueFactory(new PropertyValueFactory<Credit, Double>("value"));
		labelTotal.setText(controllerCredit.setTotal());
		loadTable(); 
	}
	
	
	@FXML
	public void buttonEvent(ActionEvent event){
		try{
			if(event.getSource() == btnConfirm){
				System.out.println(event.getSource() + " credit->confirm");
				controllerCredit.insertCredit(txtName.getText(), txtDescription.getText(), txtAvailable.getText(), txtValue.getText());
				//f.insertCreditFacade(txtName.getText(), txtDescription.getText(), txtAvailable.getText(), txtValue.getText());
				txtName.setText("");
				txtDescription.setText("");
				txtAvailable.setText("");
				txtValue.setText("");
				labelTotal.setText(controllerCredit.setTotal());
				loadTable();
			}else if(event.getSource() == btnClear){
				txtName.setText("");
				txtDescription.setText("");
				txtAvailable.setText("");
				txtValue.setText("");
			}else if(event.getSource() == btnDelete){
				int selectedIndex = tableCredit.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					Credit cr = tableCredit.getItems().remove(selectedIndex);
					System.out.println(cr.getIdCredit());
					//f.deleteItemCreditFacade(cr);
					controllerCredit.deleteItem(cr);
				} 
				labelTotal.setText(controllerCredit.setTotal());
			}else if(event.getSource() == btnEdit){
				int selectedIndex = tableCredit.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					btnUpdate.setVisible(true);
					btnCancel.setVisible(true);
					Credit cr = tableCredit.getItems().get(selectedIndex);
					txtName.setText(cr.getName());
					txtDescription.setText(cr.getDescription()); 
					txtAvailable.setText(cr.getAvailable());
					txtValue.setText(String.valueOf(cr.getValue()));
				} 	
			}else if(event.getSource() == btnCancel){
				btnUpdate.setVisible(false);
				btnCancel.setVisible(false);
				txtName.setText("");
				txtDescription.setText("");
				txtAvailable.setText("");
				txtValue.setText("");
			}else if(event.getSource() == btnUpdate){
				int selectedIndex = tableCredit.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					Credit cr = tableCredit.getItems().get(selectedIndex);
					controllerCredit.updateCredit(cr.getIdCredit(), txtName.getText(), txtDescription.getText(), txtAvailable.getText(), txtValue.getText());
					//f.updateCreditFacade(cr.getIdCredit(), txtName.getText(), txtDescription.getText(), txtAvailable.getText(), txtValue.getText());
				}
				txtName.setText("");
				txtDescription.setText("");
				txtAvailable.setText("");
				txtValue.setText("");
				labelTotal.setText(controllerCredit.setTotal());
				loadTable();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void loadTable()  {
		List<Credit> list = controllerCredit.listAll();
		ObservableList<Credit> obsList = FXCollections.observableArrayList();
		for (Credit listCred : list) {
			obsList.add(listCred);
		}
		tableCredit.setItems(obsList);
	}

}
