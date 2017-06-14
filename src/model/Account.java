package model;

import java.util.ArrayList;

public class Account {

	private int idAccount;
	private int idUser;
	private ArrayList<Credit> credits;
	private ArrayList<Debit> debits;
	
	public Account(){
		
	}

	public Account(int idAccount, int idUser, ArrayList<Credit> credits, ArrayList<Debit> debits) {
		super();
		this.idAccount = idAccount;
		this.idUser = idUser;
		this.credits = credits;
		this.debits = debits;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public ArrayList<Credit> getCredits() {
		return credits;
	}

	public void setCredits(ArrayList<Credit> credits) {
		this.credits = credits;
	}

	public ArrayList<Debit> getDebits() {
		return debits;
	}

	public void setDebits(ArrayList<Debit> debits) {
		this.debits = debits;
	}
	
	
}
