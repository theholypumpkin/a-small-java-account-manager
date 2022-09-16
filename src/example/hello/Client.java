package example.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;
import java.util.ArrayList;

public class Client extends RemoteObject {

    /** This is a serialVersionUID used for seriazable objects like this*/
	
	private static final long serialVersionUID = -9082168972786651024L;

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**Default Constructor
	 * @throws RemoteException*/
	
	private Client() throws RemoteException{}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	

	/**This method reads the user input than removes all trailing and leading spaces, \n and \r character
	 * than it splits it at every # into separate strings
	 * @throws IOException Signals that an I/O exception of some sort has occurred. 
	 * This class is the general class of exceptions produced by failed or interrupted I/O operations.
	 * @return A splitter String Array with the command and parameters*/
	
	public String[] read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String input = reader.readLine();
	    
	    input.trim();
	    input = input.replaceAll("\n", "");
	    input = input.replaceAll("\r", "");
	    input = input.replaceAll("'", "");
	    
	    return input.split("#");
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**Outputs the Array Lists content
	 * @param output the ArrayList to Output*/
	
	public void out(ArrayList<Account> output) {
		System.out.println(output.size() + " Accounts reteived");
		for (int cnt  = 0 ; cnt < output.size() ; cnt ++) {
			System.out.println(cnt+1 +":\t"
				+ output.get( cnt ).firstName + " " + output.get( cnt ).surname 
				+ " " + output.get( cnt ).userName + " " + output.get( cnt ).accountID 
				+ " " + output.get( cnt ).balance);
		}
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	/**Prints Text*/
	
	public void print() {
		System.out.println("Use # (The hashtag symbole) to seperate each argument\n"
				+ "For Example:\n"
				+ "createAccount#Jane#Doe#JD1#1#0 \t--Spaces are allowed but will be removed\n\n\n"
				+ "Possible commands:\n\n"
				+ "createAccount\t\t\tparameters: First Name # Surname # User Name # Account ID # Balance\n"
				+ "Short Form: 'CRT'\n"
				+ "deleteAccount\t\t\tparameters: Account ID\n"
				+ "Short Form: 'DEL'\n"
				+ "getAllAccounts\t\t\tno parameter\n"
				+ "Short Form: 'GAA'\n"
				+ "getAccount\t\t\tparameters: Account ID\n"
				+ "Short Form: 'GAC'\n"
				+ "getAllAccountByUser\t\tparameters: User Name\n"
				+ "Short Form 'GAU'\n"
				+ "initializeAccountManager\tno parameters\n"
				+ "Short Form: 'INI'\n"
				+ "CloseAccountManager\t\tno Parameters\n"
				+ "Short Form: 'CLS'\n"
				+ "getAllMoneyByUser\t\tparameters: User Name\n"
				+ "Short Form: 'GAM'\n");
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**Parses the command and parameters and calls the RMI functions
	 * @param stub the RMI stub
	 * @return null or the Account Manager
	 * @throws NumberFormatException Thrown to indicate that the application has attempted to convert a 
	 * string to one of the numeric types, but that the string does not have the appropriate format.
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.

	 * @throws IOException Signals that an I/O exception of some sort has occurred. Thi sclass is the general
	 *  class of exceptions produced by failed or interrupted I/O operations.
	 * @throws Exception Any other type of exception program wants that */
	
	public ArrayList<Account> parse(AccM stub) throws NumberFormatException, RemoteException, IOException, Exception {
		
		String data[] = read(); 
	    
		if ((data[0].equals("createAccount")|| data[0].equals("CRT")) && data.length == 6) {
	    	
			Account acc = new Account(data[1].trim(),data[2].trim(),data[3].trim(),Integer.parseInt(data[4].trim()),Float.parseFloat(data[5].trim()));
			
			stub.createAccount(acc);
			
			System.out.println("DONE");
	    }
	   
	    else if ((data[0].equals("deleteAccount") || data[0].equals("DEL")) && data.length == 2) {
	    	
	    	stub.deleteAccount(Integer.parseInt(data[1].trim()));
	    	
	    	System.out.println("DONE");
	    }
	    
	    else if ((data[0].equals("getAllAccounts") || data[0].equals("GAA")) && data.length == 1) {
	    	
	    	return stub.getAllAccounts();
	    }
	    
	    else if ((data[0].equals("getAccount") || data[0].equals("GAC")) && data.length == 2) {
	    	
	    	ArrayList <Account> tmp = new ArrayList<Account>();
	    	
	    	tmp.add(stub.getAccount(Integer.parseInt(data[1].trim())));
	    	
	    	return tmp;
	    }
	    else if ((data[0].equals("getAllAccountByUser")|| data[0].equals("GAU")) && data.length == 2) {
	    	
	    	return stub.getAllAccounts(data[1].trim());
	    }

	    else if ((data[0].equals("initializeAccountManager")|| data[0].equals("INI")) && data.length == 1) {
	    	
	    	stub.init();
	    	System.out.println("initialization Succsessful");
	    }

	    else if ((data[0].equals("CloseAccountManager")|| data[0].equals("CLS")) && data.length == 1) {
	    	
	    	stub.CloseAccountManager();
	    }
		
	    else if ((data[0].equals("getAllMoneyByUser")|| data[0].equals("GAM")) && data.length == 2) {
	    	
	    	float sum = stub.getAllMoneyByUser(data[1].trim());
	    	System.out.println(data[1].trim() + " has the sum of " + sum + " Coins");
	    }
	    else{
	    	System.err.println("No Valid input");
	    }
		return null;  
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**This is the main method it looks up the stub and calls all other methods
	 * @param args not in use
	 * */
	
    public static void main(String[] args) {
        try {
        	Registry registry = LocateRegistry.getRegistry(1099);
            
            AccM stub = (AccM) registry.lookup("//localhost/Hello");
            
            //String response = stub.sayHello();
            Client c = new Client();
            
			ArrayList <Account> returnValues = null;
			c.print();
            do {
            	returnValues = c.parse(stub);
            	
            	if (returnValues != null) {
            		c.out( returnValues );
            	}
            }while(true);
            
        } catch (NumberFormatException| IOException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}