package model;

public class Session {

	public static Session instance = null;
	private User user;
	
	
	private Session(){
    }
	
	private Session(User user){
		super();
		this.user = user;
	}
	
    public void setUsuario(User user){
       this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public static Session getInstance(){
          if(instance == null){
                instance = new Session();
          }
         return instance;
    }
}
