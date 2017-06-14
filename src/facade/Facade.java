package facade;

import java.util.List;

import controller.ControllerCredit;
import controller.ControllerDebit;
import controller.ControllerNewUser;
import controller.ControllerUser;
import model.Credit;
import model.Debit;
import repository.RepositoryCredit;


public class Facade {
	
	private static Facade f;
	private final ControllerCredit controllerCredit;
	private final ControllerDebit controllerDebit;
	private final ControllerNewUser controllerNewUser;
	private final ControllerUser controllerUser;
	
	 private Facade(){
		controllerCredit = new ControllerCredit();
		this.controllerDebit = new ControllerDebit();
		this.controllerNewUser = new ControllerNewUser();
		this.controllerUser = new ControllerUser();
	}
	
	
	
	public static Facade getInstance() {
		if(f == null) {
			f = new Facade();
		}
		return f;
	}
	
	/*
	 * METHODS CREDIT
	 */
	public void insertCreditFacade(String name, String description, String available, String value){
		this.controllerCredit.insertCredit( name,  description,  available,  value);
	}
	
	public void deleteItemCreditFacade(Credit credit){
		this.controllerCredit.deleteItem(credit);
	}
	
	public void updateCreditFacade(int id, String name, String description, String available, String value){
		this.controllerCredit.updateCredit(id, name, description, available, value);
	}
	
	public List<Credit> listAllCreditFacade(){
		return this.controllerCredit.listAll();
	}
	
	public String setTotalCreditFacade(){
		return this.controllerCredit.setTotal();
	}
	
	
	/*
	 * METHODS DEBIT
	 */
	public void insertDebitFacade(String name, String description, String maturity, String value){
		this.controllerDebit.insertDebit(name, description, maturity, value);
	}
	
	public void deleteItemDebitFacade(Debit debit){
		this.controllerDebit.deleteItem(debit);
	}
	
	public void updateDebitFacade(int id, String name, String description, String maturity, String value){
		this.controllerDebit.updateDebit(id, name, description, maturity, value);
	}
	
	public String setTotalDebitFacade(){
		return this.controllerDebit.setTotal();
	}
	
	public List<Debit> listAllDebitFacade(){
		return this.controllerDebit.listAll();
	}
	
	
	/*
	 * METHODS NEWUSER
	 */
	public void createUserFacade(String name, String lastname, String email, String password){
		this.controllerNewUser.createUser(name, lastname, email, password);
	}
	
	public boolean confirmloginFacade(String email, String password){
		return this.controllerUser.confirmLogin(email, password);
	}
	
	public String validateUserFacade(String email, String remail, String pass, String repass){
		return this.controllerNewUser.validateUser(email, remail, pass, repass);
	}
}
