//Colin Gallaway and Andrew Chough
// Borrowed Socket Code from:
// https://www.geeksforgeeks.org/socket-programming-in-java/
import java.net.*; 
import java.io.*; 
import java.math.BigInteger;

public class Verifier 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private ObjectInputStream in	 = null;	

	// constructor with port 
	public Verifier(int port) 
	{ 
		// starts server and waits for a connection 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted"); 

			// takes input from the client socket 
			in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			Message message;
			String target = "1ABBC33775DF223A1ABBC33775DF223A1ABBC33775DF223A1ABBC33775DF223A";
			BigInteger targ = new BigInteger(target, 16);

			// reads hash from Solver and verifies whether is is valid
			try
			{
				String msg = "No";
				try
				{ 
					message = (Message) in.readObject();
					String hash = message.getBlockHash();
					System.out.println("Recieved hash of block: " + hash); 
					if((new BigInteger(hash, 16)).compareTo(targ) == -1){
						msg = "Yes";
					}
					System.out.println(msg);
				} 
				catch(ClassNotFoundException e){}
			}
		 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 

			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Verifier verifier = new Verifier(5000); 
	} 
} 
