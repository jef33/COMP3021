import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class BlogClient {

	public static final String IP ="127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		User user = new User(1, "A", "a@cse.ust.hk");
		
		ArrayList<Post> allposts = new ArrayList<Post>();
		// Month starts with 0, not 1
		Calendar cal1 = new GregorianCalendar(2015, 02, 1); // March 1, 2015
		allposts.add(new Post(cal1.getTime(), "No sunshine these days"));

		Calendar cal4 = new GregorianCalendar(2014, 11, 25); // Dec. 25, 2014
		allposts.add(new Post(cal4.getTime(), "Merry Xmas @Amy!"));

		Calendar cal3 = new GregorianCalendar(2015, 01, 2); // Feb 2, 2015
		allposts.add(new Post(cal3.getTime(),
				"New semester starts. Fighting!!!"));

		Calendar cal2 = new GregorianCalendar(2015, 01, 18); // Feb 18, 2015
		allposts.add(new Post(cal2.getTime(),
				"Thanks @Amy for your beautiful gift"));
		
		Blog blog=new Blog(user);
		blog.setPosts(allposts);
		try {	          
			Socket socket = new Socket(IP, PORT);
			socket.setSoTimeout(3000);
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			writer.write(blog.list());
			writer.close();
			socket.close();
			//System.out.println(blog.list());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
