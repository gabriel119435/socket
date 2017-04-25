import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		Socket cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente "
							+ cliente.getInetAddress().getHostAddress() 
							+ ".");

		Scanner entrada = new Scanner(cliente.getInputStream());
		System.out.println("before while");
		while (entrada.hasNextLine()) {
			System.out.println(entrada.nextLine());
		}

		entrada.close();
		cliente.close();
		servidor.close();
		System.out.println("closed everything");
	}
}