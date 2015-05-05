
import java.io.IOException;
import java.net.ServerSocket;


public class MultiThreadServer {

	public static final int PORT = 3021;
	
	public static void main(String[] args){
		ServerSocket server;
		int serverCount = 0;
		try {
			server = new ServerSocket(PORT);
			while(true){
				
				ThreadHandler thread = new ThreadHandler(server.accept(), serverCount);
				serverCount ++;
				new Thread(thread).start();
				System.out.println("Thread"+serverCount+"Running");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
