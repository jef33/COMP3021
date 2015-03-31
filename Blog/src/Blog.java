import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


public class Blog implements Serializable{

	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public void setPosts(ArrayList<Post> allposts2) {
		allPosts = allposts2;
	}
	
	public User getUser(){
		return user;
	}
	
	public String toString(){
		return user.getName() + "'s Blog";
	}
	
	public void post(Post p){
		allPosts.add(p);
		System.out.println("You have added a new post to your blog");
	}	
	
	public String list(){
		int i=0;
		StringBuffer output = new StringBuffer("");
		for(Post p:allPosts)
			output.append("Post[" + i++ + "]: " + p.print() + "\n");
		return output.toString();
	}
	
	public void delete(int index){
		try{
			allPosts.remove(index);
		}catch(Exception e){
			System.out.println("Invalid post index number");
		}
	}
	
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		for(Post p:allPosts){
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH)+1;
			if(month != postMonth || !p.contains(someone))
				continue;
			System.out.print(p.print());			
		}
	}
	
	public void save(String path)/* throws IOException*/{
		try{
			FileOutputStream f = new FileOutputStream(path);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(this);
			o.close();
			f.close();
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load(String path)/* throws IOException, ClassNotFoundException*/{
		FileInputStream f;
		try {
			f = new FileInputStream(path);
			ObjectInputStream o = new ObjectInputStream(f);
			Blog b = (Blog) o.readObject();
			this.user = b.user;
			this.allPosts = b.allPosts;
			o.close();
			f.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}
	}
	
	public boolean equals(Object o){
		if(o instanceof Blog){
			Blog other = (Blog) o;
			if(user.equals(other.user) && allPosts.equals(other.allPosts))
				return true;
		}
		return false;
	}
	
	public int hashCode(){
		return user.hashCode() + allPosts.hashCode();
	}
}
