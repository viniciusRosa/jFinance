package controller;

import java.util.ArrayList;

import model.Credit;
import model.Session;
import model.User;
import repository.RepositoryCredit;

public class ControllerCredit {
	Session session = Session.getInstance();
	User user = session.getUser();
	RepositoryCredit repCredit = new RepositoryCredit();
	

	public void insertCredit(String name, String description, String available, String value){
		double valueDouble = Double.parseDouble(value);
		Credit credit = new Credit(name, description, available, valueDouble, user.getIdUser());
		repCredit.insert(credit);
	}
	
	public ArrayList<Credit> listAll(){
		ArrayList<Credit> list = new ArrayList<>();
		list = repCredit.selectAll(user.getIdUser());
		return list;
	}
	
	public ArrayList<Credit> listForDate(String date){
		ArrayList<Credit> list = new ArrayList<>();
		list = repCredit.selectForDate(user.getIdUser(), date);
		return list;
	}
	
	public void deleteItem(Credit credit){
		repCredit.deletecredit(credit);
	}
	
	public void updateCredit(int id, String name, String description, String available, String value){
		double valueDouble = Double.parseDouble(value);
		
		repCredit.update(new Credit(id, name, description, available, valueDouble));
	}
	
	public String setTotal(){
		String total = null;
		double some = 0;
		ArrayList<Credit> list = new ArrayList<>();
		list = listAll();
		for (Credit listCred : list) {
			some += listCred.getValue();
		}
		
		return total.valueOf(some);
	}
}
