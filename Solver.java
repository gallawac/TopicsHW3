//Colin Gallaway and Andrew Chough
// Borrowed Socket Code from:
// https://www.geeksforgeeks.org/socket-programming-in-java/
import java.net.*; 
import java.io.*; 

public class Solver 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 

	// constructor to put ip address and port 
	public Solver(String address, int port) 
	{ 
		// establish a connection 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			// takes input from terminal 
			input = new DataInputStream(System.in); 

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
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
			//line = input.readLine();
			String hash = b.getHashValue();
			System.out.println("Block Sent to Verifer: " + hash);
			out.writeUTF(hash);
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// close the connection 
		try
		{ 
			input.close(); 
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
