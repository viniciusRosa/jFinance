package repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Credit;
import util.DBUtil;

public class RepositoryCredit {

	PreparedStatement stmt;
	
	public void insert(Credit credit){
		try{
			
			String insert = "INSERT INTO tb_credit(cr_name, cr_description, cr_available, " +
					"cr_value, cr_iduser) VALUES(?, ?, ?, ?, ?)";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setString(1, credit.getName());
			stmt.setString(2, credit.getDescription());
			stmt.setString(3, credit.getAvailable());
			stmt.setDouble(4, credit.getValue());
			stmt.setInt(5, credit.getIduser());
			System.out.println(stmt.toString());
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public ArrayList<Credit> selectAll(int id){
		Credit result = null;
		ArrayList<Credit> crList = new ArrayList<>();
		try{
			String insert = "SELECT * FROM tb_credit WHERE cr_iduser = ?";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idCredit = rs.getInt("cr_idcredit");
				String name = rs.getString("cr_name");
				String description = rs.getString("cr_description");
				String available = rs.getString("cr_available");
				double value = rs.getDouble("cr_value");
				result = new Credit(idCredit, name, description, available, value);
				crList.add(result);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}
		return crList;
	}
	
	public ArrayList<Credit> selectForDate(int id, String date){
		Credit result = null;
		ArrayList<Credit> crList = new ArrayList<>();
		try{
			String insert = "SELECT * FROM tb_credit WHERE cr_iduser = ? AND cr_available LIKE  ?";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setInt(1, id);
			stmt.setString(2, date);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idCredit = rs.getInt("cr_idcredit");
				String name = rs.getString("cr_name");
				String description = rs.getString("cr_description");
				String available = rs.getString("cr_available");
				double value = rs.getDouble("cr_value");
				result = new Credit(idCredit, name, description, available, value);
				crList.add(result);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}
		return crList;
	}
	
	public Credit selectCredit(int id){
		Credit result = null;
		try{
			String insert = "SELECT * FROM tb_credit WHERE cr_idcredit = ?";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idCredit = rs.getInt("cr_idcredit");
				String name = rs.getString("cr_name");
				String description = rs.getString("cr_description");
				String available = rs.getString("cr_available");
				double value = rs.getDouble("cr_value");
				result = new Credit(idCredit, name, description, available, value);
				
			}
		}catch(SQLException e){
				e.printStackTrace();
		}
		return result;
	}
	
	
	public void update(Credit credit){
		try{
			String update = "UPDATE tb_credit SET cr_name = ?, cr_description = ?, cr_available = ?, cr_value = ? WHERE cr_idcredit = ?";
			
			stmt = (PreparedStatement)DBUtil.getConnetion().prepareStatement(update);
			stmt.setString(1, credit.getName());
			stmt.setString(2, credit.getDescription());
			stmt.setString(3, credit.getAvailable());
			stmt.setDouble(4, credit.getValue());
			stmt.setDouble(5, credit.getIdCredit());
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void deletecredit(Credit credit){
		try{
			String update = "DELETE FROM tb_credit WHERE cr_idcredit = ?;";
			
			stmt = (PreparedStatement)DBUtil.getConnetion().prepareStatement(update);
			stmt.setInt(1, credit.getIdCredit());
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	
}
