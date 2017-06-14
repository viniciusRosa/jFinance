package model;

public class Password {
	private int id;
	private String password;
	private  int idUser;
	
	public Password(){
		
	}
	
	public Password(String password, int idUser) {
		super();
		this.password = password;
		this.idUser = idUser;
	}

	public Password(int id, String password, int idUser) {
		super();
		this.id = id;
		this.password = password;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
}
