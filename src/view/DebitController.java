package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.ControllerCredit;
import controller.ControllerDebit;
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
import model.Debit;




public class DebitController implements Initializable{
	ControllerDebit controllerDebit = new ControllerDebit();
	Facade f = Facade.getInstance();
	
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtDescription;
	@FXML
	private TextField txtMaturity;
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
	private TableView<Debit> tableDebit;
	@FXML
	private TableColumn<Debit, String> columnName;
	@FXML
	private TableColumn<Debit, String> columnDescription;
	@FXML
	private TableColumn<Debit, String> columnMaturity;
	@FXML
	private TableColumn<Debit, Double> columnValue;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnName.setCellValueFactory(new PropertyValueFactory<Debit, String>("name"));
		columnDescription.setCellValueFactory(new PropertyValueFactory<Debit, String>("description"));
		columnMaturity.setCellValueFactory(new PropertyValueFactory<Debit, String>("maturity"));
		columnValue.setCellValueFactory(new PropertyValueFactory<Debit, Double>("value"));
		//labelTotal.setText(f.setTotalDebitFacade());
		labelTotal.setText(controllerDebit.setTotal());
		
		loadTable(); 
	}
	
	
	@FXML
	public void buttonEvent(ActionEvent event){
		try{
			if(event.getSource() == btnConfirm){
				System.out.println(event.getSource() + " Debit->confirm");
				//f.insertDebitFacade(txtName.getText(), txtDescription.getText(), txtMaturity.getText(), txtValue.getText());
				controllerDebit.insertDebit(txtName.getText(), txtDescription.getText(), txtMaturity.getText(), txtValue.getText());
				txtName.setText("");
				txtDescription.setText("");
				txtMaturity.setText("");
				txtValue.setText("");
				labelTotal.setText(controllerDebit.setTotal());
				loadTable();
			}else if(event.getSource() == btnClear){
				txtName.setText("");
				txtDescription.setText("");
				txtMaturity.setText("");
				txtValue.setText("");
			}else if(event.getSource() == btnDelete){
				int selectedIndex = tableDebit.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					Debit cr = tableDebit.getItems().remove(selectedIndex);
					System.out.println(cr.getIdDebit());
					//f.deleteItemDebitFacade(cr);
					controllerDebit.deleteItem(cr);
				} 
				labelTotal.setText(controllerDebit.setTotal());
			}else if(event.getSource() == btnEdit){
				int selectedIndex = tableDebit.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					btnUpdate.setVisible(true);
					btnCancel.setVisible(true);
					Debit cr = tableDebit.getItems().get(selectedIndex);
					txtName.setText(cr.getName());
					txtDescription.setText(cr.getDescription()); 
					txtMaturity.setText(cr.getMaturity());
					txtValue.setText(String.valueOf(cr.getValue()));
				} 
				
			}else if(event.getSource() == btnCancel){
				btnUpdate.setVisible(false);
				btnCancel.setVisible(false);
				txtName.setText("");
				txtDescription.setText("");
				txtMaturity.setText("");
				txtValue.setText("");
			}else if(event.getSource() == btnUpdate){
				int selectedIndex = tableDebit.getSelectionModel().getSelectedIndex();
				if (selectedIndex >= 0) {
					Debit cr = tableDebit.getItems().get(selectedIndex);
					//f.updateDebitFacade(cr.getIdDebit(), txtName.getText(), txtDescription.getText(), txtMaturity.getText(), txtValue.getText());
					controllerDebit.updateDebit(cr.getIdDebit(), txtName.getText(), txtDescription.getText(), txtMaturity.getText(), txtValue.getText());
				}
				txtName.setText("");
				txtDescription.setText("");
				txtMaturity.setText("");
				txtValue.setText("");
				labelTotal.setText(controllerDebit.setTotal());
				loadTable();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void loadTable()  {
		//List<Debit> list = f.listAllDebitFacade();
		List<Debit> list = controllerDebit.listAll();
		ObservableList<Debit> obsList = FXCollections.observableArrayList();
		for (Debit listDebit : list) {
			obsList.add(listDebit);
		}
		tableDebit.setItems(obsList);
	}


}
