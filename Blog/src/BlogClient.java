import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class BlogClient {

	public static final String IP ="127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		
		/*User user = new User(1, "A", "a@cse.ust.hk");
		
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
		blog.setPosts(allposts);*/
		
		try {	          
			Socket socket = new Socket(IP, PORT);
			socket.setSoTimeout(0);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			while(true){
				
				System.out.print("Enter something:");
				String cin = new Scanner(System.in).nextLine();
				writer.println(cin);
				if (cin.equals("quit"))
					break;
				else{
					String line;
					while(true){
						if(socket.getInputStream().available() > 0 && (line = reader.readLine()) != null){
							System.out.println(line);
							break;
						}
					}
				}
				//writer.close();
			}
			reader.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
