import java.util.ArrayList;
import java.util.Date;


public class Post {

	private Date date;
	private String content;
	private ArrayList<String> comment;
	
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
		System.out.println(date);
		System.out.println(content);
	} 
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String toString(){
		return content;
	}
	
	public String print(){
		return date.toLocaleString() + "\n" + content;
	}
	
	public boolean equals(Object o){
		if(o instanceof Post){
			Post p = (Post)o;
			return content.equals(p.content) && date.equals(p.date) && comment.equals(p.comment);
		}
		return false;
	}
	
	public int hashCode(){
		return date.hashCode()+content.hashCode()+comment.hashCode();
	}
	
	public boolean contains(String substring){
		if(substring==null)
			return false;
		return content.contains(substring);
	}
}
