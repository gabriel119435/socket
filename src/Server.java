import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("open port 12345!");

		Socket client = server.accept();
		System.out.println("new connection with client " + client.getInetAddress().getHostAddress() + ".");

		Scanner input = new Scanner(client.getInputStream());
		System.out.println("before while");
		while (input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
		input.close();
		client.close();
		server.close();
		System.out.println("closed everything");
	}
}