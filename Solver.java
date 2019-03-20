//Colin Gallaway and Andrew Chough
// Borrowed Socket Code from:
// https://www.geeksforgeeks.org/socket-programming-in-java/
import java.net.*; 
import java.io.*; 

public class Solver 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private ObjectOutputStream out	 = null; 

	// constructor to put ip address and port 
	public Solver(String address, int port) 
	{ 
		// establish a connection 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			// sends output to the socket 
			out = new ObjectOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		String target = "1ABBC33775DF223A1ABBC33775DF223A1ABBC33775DF223A1ABBC33775DF223A";
		
		try
		{ 
			Block b = new Block(target);
			Message msg = new Message(b);
			String hash = b.getHashValue();
			System.out.println("Block's Hash: " + hash);
			out.writeObject(msg);
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// close the connection 
		try
		{ 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Solver solver = new Solver("127.0.0.1", 5000); 
	} 
} 
