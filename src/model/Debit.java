package model;

public class Debit {
	
	private int idDebit;
	private String name;
	private String description;
	private String maturity;
	private double value;
	private int iduser;
	
	public Debit(){
		
	}

	public Debit(String name, String description, String maturity, double value, int iduser) {
		super();
		this.name = name;
		this.description = description;
		this.maturity = maturity;
		this.value = value;
		this.iduser = iduser;
	}

	public Debit(int idDebit, String name, String description, String maturity, double value) {
		super();
		this.idDebit = idDebit;
		this.name = name;
		this.description = description;
		this.maturity = maturity;
		this.value = value;
	}

	public int getIdDebit() {
		return idDebit;
	}

	public void setIdDebit(int idDebit) {
		this.idDebit = idDebit;
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

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
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
