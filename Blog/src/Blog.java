import java.util.ArrayList;


public class Blog {

	private User user;
	private ArrayList<Post> allPosts;
	
	public Blog(User user){
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void post(Post p){
		allPosts.add(p);
		System.out.println("You have added a new post to your blog");
	}
	
	public void list(){
		int i=0;
		for(Post p:allPosts)
			System.out.println("Post[" + i++ + "]: " + p.print());
	}
	
	public void delete(int index){
		try{
			allPosts.remove(index);
		}catch(Exception e){
			System.out.println("Invalid post index number");
		}
	}
	
	public String toString(){
		return user.getName() + "'s Blog";
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
