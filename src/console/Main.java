package console;

import java.util.ArrayList;

import controller.ControllerCredit;
import controller.ControllerNewUser;
import model.Credit;
import repository.RepositoryCredit;
import repository.RepositoryUser;

public class Main {
//alterei
	public static void main(String[] args){
		ControllerNewUser nu = new ControllerNewUser();
		
	//System.out.println(nu.validateUser("vinicius.rosa0@gmail.com", "vinicius.rosa00@gmail.com", "1234", "1234"));
	//ControllerCredit contr = new ControllerCredit();
	ArrayList<Credit> list = new ArrayList<>();
	RepositoryCredit rep = new RepositoryCredit();
	list = rep.selectForDate(16, "13/12/2016");
	
	System.out.println(list.get(0).getAvailable());
	}
	
	
}