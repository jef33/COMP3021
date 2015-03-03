import java.util.Date;
import java.util.Scanner;


public class TestObject {

	public final static String post = "post";
	public final static String del = "delete";
	public final static String end = "exit";
	public final static String list = "list";
	
	//public User currUser;
	public static Blog currBlog;
	
	public static void main(String[] args){
		/*User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Date date = new Date();
		String content = "This is my fisrt post";
		FriendsPost postFromFriend = new FriendsPost(date, content, user);
		System.out.println(postFromFriend);
		
		System.out.println(postFromFriend.contains("first"));
		System.out.println(postFromFriend.contains("HKUST"));*/
		
		User defaultUser = new User(0, "default", "admin@default.com");
		//currUser = defaultUser;
		Blog b = new Blog(defaultUser);
		currBlog = b;
		while(true){
			System.out.print("Enter the prompt: ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			int space = input.indexOf(" ");
			String[] inputParts = new String[2];
			if(space > 0){
				inputParts[0] = input.substring(0, space);
				inputParts[1] = input.substring(space+1, input.length());
			}else{
				inputParts[0] = input;
				inputParts[1] = null;
			}
			handleCommand(inputParts[0], inputParts[1]);
		}
	}
	
	public static void handleCommand(String cm, String para){
		if(cm.equals(post)){
			Date date = new Date();
			Post p = new Post(date, para);
			currBlog.post(p);
		}else if(cm.equals(del)){
			currBlog.delete(Integer.parseInt(para));
		}else if(cm.equals(list)){
			currBlog.list();
		}else if(cm.equals(end)){
			System.exit(0);
		}
	}
	
}
