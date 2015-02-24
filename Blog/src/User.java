import java.util.Date;


public class User {

	private int id;
	private String name;
	private String email;
	
	public User(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
		System.out.println("User [userId=" + id + ", userName=" + name + ", userEmail=" + email + "]");
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	public boolean equals(Object o){
		if(o instanceof User){
			User u = (User)o;
			return id==u.id && name.equals(u.name) && email.equals(u.email);
		}
		return false;
	}
	
	public int hashCode(){
		return name.hashCode()+email.hashCode()+id;
	}
}
