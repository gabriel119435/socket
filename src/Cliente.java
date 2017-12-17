
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("the client has connected with server!");

		Scanner keyboard = new Scanner(System.in);
		PrintStream output = new PrintStream(cliente.getOutputStream());

		while (keyboard.hasNextLine()) {
			output.println(keyboard.nextLine());
		}
		keyboard.close();
		output.close();
		cliente.close();
	}
}