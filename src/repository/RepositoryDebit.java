package repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Credit;
import model.Debit;
import util.DBUtil;

public class RepositoryDebit {

	PreparedStatement stmt;
	
	public void insert(Debit debit){
		try{
			
			String insert = "INSERT INTO tb_debit(de_name, de_description, de_maturity, " +
					"de_value, de_iduser) VALUES(?, ?, ?, ?, ?)";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setString(1, debit.getName());
			stmt.setString(2, debit.getDescription());
			stmt.setString(3, debit.getMaturity());
			stmt.setDouble(4, debit.getValue());
			stmt.setInt(5, debit.getIduser());
			System.out.println(stmt.toString());
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public ArrayList<Debit> selectAll(int id){
		Debit result = null;
		ArrayList<Debit> crList = new ArrayList<>();
		try{
			String insert = "SELECT * FROM tb_debit WHERE de_iduser = ?";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idDebit = rs.getInt("de_iddebit");
				String name = rs.getString("de_name");
				String description = rs.getString("de_description");
				String available = rs.getString("de_maturity");
				double value = rs.getDouble("de_value");
				result = new Debit(idDebit, name, description, available, value);
				crList.add(result);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}
		return crList;
	}
	
	public ArrayList<Debit> selectForDate(int id, String date){
		Debit result = null;
		ArrayList<Debit> crList = new ArrayList<>();
		try{
			String insert = "SELECT * FROM tb_debit WHERE de_iduser = ? AND de_maturity LIKE ?";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setInt(1, id);
			stmt.setString(2, date);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idDebit = rs.getInt("de_iddebit");
				String name = rs.getString("de_name");
				String description = rs.getString("de_description");
				String available = rs.getString("de_maturity");
				double value = rs.getDouble("de_value");
				result = new Debit(idDebit, name, description, available, value);
				crList.add(result);
			}
		}catch(SQLException e){
				e.printStackTrace();
		}
		return crList;
	}
	
	public Debit selectDebit(int id){
		Debit result = null;
		try{
			String insert = "SELECT * FROM tb_debit WHERE de_iddebit = ?";
			
			stmt = (PreparedStatement) DBUtil.getConnetion().prepareStatement(insert);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idDebit = rs.getInt("de_iddebit");
				String name = rs.getString("de_name");
				String description = rs.getString("de_description");
				String available = rs.getString("de_maturity");
				double value = rs.getDouble("de_value");
				result = new Debit(idDebit, name, description, available, value);
				
			}
		}catch(SQLException e){
				e.printStackTrace();
		}
		return result;
	}
	
	
	public void update(Debit debit){
		try{
			String update = "UPDATE tb_debit SET de_name = ?, de_description = ?, de_maturity = ?, de_value = ? WHERE de_iddebit = ?";
			
			stmt = (PreparedStatement)DBUtil.getConnetion().prepareStatement(update);
			stmt.setString(1, debit.getName());
			stmt.setString(2, debit.getDescription());
			stmt.setString(3, debit.getMaturity());
			stmt.setDouble(4, debit.getValue());
			stmt.setDouble(5, debit.getIdDebit());
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void deleteDebit(Debit debit){
		try{
			String update = "DELETE FROM tb_debit WHERE de_iddebit = ?;";
			
			stmt = (PreparedStatement)DBUtil.getConnetion().prepareStatement(update);
			stmt.setInt(1, debit.getIdDebit());
			stmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	
}
