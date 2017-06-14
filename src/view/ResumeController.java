package view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.ControllerCredit;
import controller.ControllerDebit;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Credit;
import model.Debit;
import repository.RepositoryCredit;

public class ResumeController implements Initializable{
	ControllerCredit controllerCredit = new ControllerCredit();
	ControllerDebit controllerDebit = new ControllerDebit();
	/*
	 * TABELA CREDITO
	 */
	@FXML
	private Button btnCredit;
	@FXML
	private TextField txtCredit;
	@FXML
	private TableView<Credit> tableCredit;
	@FXML
	private TableColumn<Credit, String> creditName;
	@FXML
	private TableColumn<Credit, String> creditAvailable;
	@FXML
	private TableColumn<Credit, String> creditValue;
	
	@FXML
	private Label txtSaldoCredit;
	
	/*
	 * TABELA DEBITO
	 */
	@FXML
	private Button btnDebit;
	@FXML
	private TextField txtDebit;
	@FXML
	private TableView<Debit> tableDebit;
	@FXML
	private TableColumn<Debit, String> debitName;
	@FXML
	private TableColumn<Debit, String> debitMaturity;
	@FXML
	private TableColumn<Debit, String> debitValue;
	
	@FXML
	private Label txtSaldoDebit;
	
	@FXML
	private Label txtTotal;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		creditName.setCellValueFactory(new PropertyValueFactory<Credit, String>("name"));
		creditAvailable.setCellValueFactory(new PropertyValueFactory<Credit, String>("available"));
		creditValue.setCellValueFactory(new PropertyValueFactory<Credit, String>("value"));
		//loadTableCredit();
		
		debitName.setCellValueFactory(new PropertyValueFactory<Debit, String>("name"));
		debitMaturity.setCellValueFactory(new PropertyValueFactory<Debit, String>("maturity"));
		debitValue.setCellValueFactory(new PropertyValueFactory<Debit, String>("value"));
		//loadTableDebit();
		
		txtSaldoCredit.setText(controllerCredit.setTotal());
		txtSaldoCredit.setTextFill(Color.GREEN);
		
		txtSaldoDebit.setText(controllerDebit.setTotal());
		txtSaldoDebit.setTextFill(Color.RED);
		
		txtTotal.setText(valueAvailable(controllerCredit.setTotal(), controllerDebit.setTotal()));
		
	}
	
	
	
	@FXML 
	public void actionButton(ActionEvent event) {
		if(event.getSource() == btnCredit){
			System.out.println(txtCredit.getText());
			List<Credit> list = controllerCredit.listForDate(txtCredit.getText());
			ObservableList<Credit> obsList = FXCollections.observableArrayList();
			for (Credit listCre : list) {
				System.out.println(listCre.toString());
				System.out.println(listCre.getDescription());
				obsList.add(listCre);
			}
			tableCredit.setItems(obsList);
		}else if(event.getSource() == btnDebit){
			List<Debit> list = controllerDebit.listForDate(txtDebit.getText());
			ObservableList<Debit> obsList = FXCollections.observableArrayList();
			for (Debit listDeb : list) {
				obsList.add(listDeb);
			}
			tableDebit.setItems(obsList);
		}

		}
	
	public String valueAvailable(String credit, String debit){
		double total = Double.parseDouble(credit) - Double.parseDouble(debit);
		return String.format("%.2f", total);
	}
	
	
}
