import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class BlogServer {

	public static final int PORT = 3021;
	
	public static void main(String[] args){
		ServerSocket server;
		try {
			server = new ServerSocket(PORT);
			System.out.println("Putting up server.");
			
			System.out.println("Server is online.");
			Socket socket = server.accept();
			socket.setSoTimeout(3000);
			System.out.println("Client accepted.");
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Client says,");
			String line;
			while(true){
			while(socket.getInputStream().available()>0 && (line = reader.readLine()) != null){
				System.out.println(line);
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
