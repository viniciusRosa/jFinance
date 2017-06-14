package model;
import java.util.Date;

public class Credit {
	
	private int idCredit;
	private String name;
	private String description;
	private String available;
	private double value;
	private int iduser;
	
	public Credit(){
		
	}

	public Credit(String name, String description, String available, double value, int iduser) {
		super();
		this.name = name;
		this.description = description;
		this.available = available;
		this.value = value;
		this.iduser = iduser;
	}
	
	public Credit(int idCredit, String name, String description, String available, double value) {
		super();
		this.idCredit = idCredit;
		this.name = name;
		this.description = description;
		this.available = available;
		this.value = value;
	}

	public int getIdCredit() {
		return idCredit;
	}

	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	

}
