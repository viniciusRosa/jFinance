package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Password;
import model.User;
import model.UserLogin;
import util.DBUtil;

public class RepositoryUser {
	
	PreparedStatement stmt;
	
	public UserLogin getLogin(String email){
		UserLogin login = null;
		
		try {
			String query =  "SELECT us_firstname, us_email, pa_password "
					+ "from tb_user join tb_password "
					+ "where us_email='"+ email +"' and pa_iduser=us_iduser;"; //and pa_password='"+ senha +"'and pa_iduser=us_iduser;";
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String firstName = rs.getString("us_firstname");
				String emailUser = rs.getString("us_email");
				String password = rs.getString("pa_password");
				login = new UserLogin(firstName, emailUser, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	
	/*
	 * Query retorna um usuario apartir do email
	 */

	public User getUser(String email){
		
		User user = null;
		try {
			String query =  "SELECT * "
					+ "FROM tb_user "
					+ "WHERE tb_user.us_email = '" + email + "';";
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int us_iduser = rs.getInt("us_iduser");
				String us_firstname = rs.getString("us_firstname");
				String us_lastname = rs.getString("us_lastname");
				String us_email = rs.getString("us_email");
				user = new User(us_iduser, us_firstname, us_lastname, us_email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public void InsertUser(User user){
		
		try {
			String query =  "INSERT INTO tb_user(us_firstname, us_lastname, us_email) "
							+ "VALUES(?, ?, ?);";
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(query);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		
		}
	
	public boolean validateEmail(String email){
		int value = 0;
		try {
			String query =  "SELECT count(us_email) FROM jfinance.tb_user WHERE us_email LIKE '" + email + "';";
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				value = rs.getInt("count(us_email)");
				//System.out.println(value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		if(value == 1){
			return false;
		}else{
			return true;
		}
		
		}


}
