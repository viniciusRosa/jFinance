package controller;

import model.Password;
import model.User;
import repository.RepositoryPassword;
import repository.RepositoryUser;

public class ControllerNewUser {
	RepositoryUser repUser = new RepositoryUser();
	RepositoryPassword repPassword = new RepositoryPassword();
	
	public void createUser(String firstName, String lastName, String email, String password){
		User user = new User(firstName, lastName, email);
		repUser.InsertUser(user);
		User u = repUser.getUser(email);
		createPass(u, password);
	}
	
	private void createPass(User user, String pass){
		Password password = new Password(pass, user.getIdUser());
		repPassword.InsertPassword(password);
		System.out.println(password.getIdUser());
		
	}
	
	public  String validateUser(String email, String remail, String pass, String repass){
		String messageError = "";
		if(!email.matches("[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+")){
			messageError += "Email invalido\n";
		}if(!email.equals(remail)){
			messageError += "Email não conferem\n";
		}if(repUser.validateEmail(email) == false){
			messageError += "Email já cadastrado\n";
		}if(!pass.equals(repass)){
			messageError += "Senhas não conferem\n";
		}
		
		if(messageError.isEmpty()){
			return messageError;
		}else{
			return messageError;
		}
	}
	
	public boolean validateEmail(String email){
		return repUser.validateEmail(email);
	}
}