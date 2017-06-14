package controller;

import model.Password;
import model.Session;
import model.User;
import model.UserLogin;
import repository.RepositoryPassword;
import repository.RepositoryUser;

public class ControllerUser {

	RepositoryUser repU = new RepositoryUser();
	
	public boolean confirmLogin(String email, String password){
		User user = repU.getUser(email);
		UserLogin login = repU.getLogin(email);
		if(login == null){
			System.out.println("false");
			return false;
		}else{
			if(login.getPassword().equals(password)){
				System.out.println("true");
				Session session = Session.getInstance();
				session.setUsuario(user);
				return true;
			}else{
				return false;
			}	
		}
	}
}
