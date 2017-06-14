package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import model.Password;
import model.User;
import util.DBUtil;

public class RepositoryPassword {
	
	PreparedStatement stmt;
	
	public Password getPassword(User user){
		Password password = null;
		try {
			String query = "SELECT * "
							+ "FROM tb_password "
							+ "WHERE pa_iduser=" + user.getIdUser() + ";";
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int pa_id = rs.getInt("pa_id");
				String pa_password = rs.getString("pa_password");
				int pa_iduser = rs.getInt("pa_iduser");
				password = new Password(pa_id, pa_password, pa_iduser);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}
	
	public void InsertPassword(Password password){
		
		try {
			String query =  "INSERT INTO tb_password(pa_password, pa_iduser) VALUES (?, ?);";
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(query);
			stmt.setString(1, password.getPassword());
			stmt.setInt(2, password.getIdUser());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		
		}


}
