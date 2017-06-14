package controller;

import java.util.ArrayList;

import model.Credit;
import model.Debit;
import model.Session;
import model.User;
import repository.RepositoryDebit;

public class ControllerDebit {
	Session session = Session.getInstance();
	User user = session.getUser();
	RepositoryDebit repDebit = new RepositoryDebit();
	Debit debit = null;
	
	
	public void insertDebit(String name, String description, String maturity, String value){
		double valueDouble = Double.parseDouble(value);
		
		repDebit.insert(new Debit(name, description, maturity, valueDouble, user.getIdUser()));
	}
	
	public ArrayList<Debit> listAll(){
		ArrayList<Debit> list = new ArrayList<>();
		list = repDebit.selectAll(user.getIdUser());
		return list;
	}
	
	public ArrayList<Debit> listForDate(String date){
		ArrayList<Debit> list = new ArrayList<>();
		list = repDebit.selectForDate(user.getIdUser(), date);
		return list;
	}
	
	public void deleteItem(Debit debit){
		repDebit.deleteDebit(debit);
	}
	
	public void updateDebit(int id, String name, String description, String maturity, String value){
		double valueDouble = Double.parseDouble(value);
		
		repDebit.update(new Debit(id, name, description, maturity, valueDouble));
	}
	
	public String setTotal(){
		String total = null;
		double some = 0;
		ArrayList<Debit> list = new ArrayList<>();
		list = repDebit.selectAll(user.getIdUser());
		for (Debit listDebit : list) {
			some += listDebit.getValue();
		}
		
		return total.valueOf(some);
	}

}
