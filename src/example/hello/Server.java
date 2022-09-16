package example.hello;
        
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
        
public class Server extends RemoteObject implements AccM, Remote{

	/**This is a serialVersionUID used for seriazable objects like this*/
	
	private static final long serialVersionUID = 4505600244318232778L;
	private static ArrayList<Account> AccountManager = null;
	/**Default Constructor*/
	
	public Server() {}
	
	/**Demo method
	 * @deprecated
	 * @return String "Hello World!"*/
	
    public String sayHello() {
        return "Hello, world!";
    }
    
    /*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
    
    
    /**Creates a new Account
     * @version 3.0
     * @param acc an account object
     * @param AccountManager The Account Array List
     * @return The updated array list
     * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
    
    @Override
    public void createAccount( Account acc ) throws RemoteException {
    	
    	AccountManager.add( acc );
    	
    	System.err.println("DEBUG: Account Created size is: " + AccountManager.size());
	}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**Deletes an account out of the Account Manager
	 * @return the Account Manager without the element scheduled to be removed
	 * @param accountID the Account ID
	 * @param AccountManager the Account Manager
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	@Override
	public void deleteAccount( int accountID) throws RemoteException {
		
		for (Account iter: AccountManager) {
			if (iter.accountID == accountID) {
				AccountManager.remove( iter );
				break;
			}
			System.err.println("DEBUG: Account Created size is: " + AccountManager.size());
		}
	}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**I return the Account Manager
	 * @return The Account Manager
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	@Override
	public ArrayList <Account> getAllAccounts() throws RemoteException {
		return AccountManager;
	}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**@param accountID the Account ID
	 * @param Account Manager the Account Manager
	 * @return The searched account
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	@Override
	public Account getAccount( int accountID) throws RemoteException {
		for (Account iter : AccountManager )
			if (iter.accountID == accountID ) {
				return iter;
			}
		return null;
	}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**@param userName the user Name
	 * @param AccountManager the account Manager
	 * @return Account List of all accounts of a User 
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	@Override
	public ArrayList <Account> getAllAccounts( String userName) throws RemoteException {
		ArrayList <Account> returnList = new ArrayList <Account>(); 
		for (Account iter: AccountManager)
			if (iter.userName.equals( userName )) {
				returnList.add( iter );
			}
		return returnList;
	}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**@return The Account Manager newly created
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general
	 *  class of exceptions produced by failed or interrupted I/O operations.
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException. 
	 * @throws NumberFormatException 
	 */
	
	static public ArrayList <Account> initializeAccountManager() throws NumberFormatException, RemoteException, IOException {

		AccountManager = new ArrayList<Account>();

		File csv = new File("AccountManager.txt");
		
		if(csv.exists() && csv.isFile()) {
			
			Scanner csvReader = null;
			csvReader = new Scanner(csv);
			
			while (csvReader.hasNext()) {
				String row = csvReader.nextLine(); 
			    String[] data = row.split(";");
			    if (data.length == 5) {
			    	//Constructs a new A Object with parameters from string.
			    	Account add = new Account(data[0], data[1], data[2],
			    		Integer.valueOf( data[3] ), Float.parseFloat( data[4] ));
			    		//Adds object to A Manager
			    		AccountManager.add( add );
			    		//Resets Data String
			    		data = null;
			    		row = "";
			    }
			    else {
			    	throw new IOException("File courputed");
			    }	    
			}
			csvReader.close();
		}
		return AccountManager;
	}

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**@throws IOException Signals that an I/O exception of some sort has occurred. This class is the general
	 *  class of exceptions produced by failed or interrupted I/O operations.*/
	
	@Override
	public void CloseAccountManager() throws IOException {
		//TODO finish me
		String [] toArray = new String[AccountManager.size()];
		for (int cnt = 0; cnt < AccountManager.size(); cnt++ ) {
			
			toArray[cnt] = AccountManager.get( cnt ).surname + ";" 
				+ AccountManager.get( cnt ).firstName + ";"
				+ AccountManager.get( cnt ).userName + ";"
				+ AccountManager.get( cnt ).accountID + ";"
				+ AccountManager.get( cnt ).balance + "\n";
		}
		String finalString = Arrays.toString( toArray );
		finalString = finalString.replaceAll( "[\\[|\\]|\\,]", "" );
		finalString = finalString.replaceAll( " ", "" );
		File file = new File("AccountManager.txt");
		if (file.exists()) {
			file.delete();
		}
		
		FileWriter fw = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.newLine();
		bw.append(finalString);
		bw.close();
		fw.close();
		
		AccountManager  = null;
		
		System.exit( 0 );
		
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/  
    
	
	/**{@link #initializeAccountManager()}
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general
	 *  class of exceptions produced by failed or interrupted I/O operations.
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.
	 * @throws NumberFormatException */
	
	@Override
	public void init () throws NumberFormatException, RemoteException, IOException{
		initializeAccountManager();
    	
    }
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/ 
	
	
	/**@param userName the Users Name to calculate the overall balance from
	 * @param manager the Account Manager
	 * @return the overall balance of the user
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	@Override
	public float getAllMoneyByUser(String userName) throws RemoteException { 
		float sum = 0;
		for (Account iter: AccountManager)
			if (iter.userName.equals( userName )) {
				sum += iter.balance;
			}
		sum = (float) (Math.round(sum * 100)/100D);//Rounds to 2 decimal places
		return sum;
		
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/ 
	
	
	/**This is the servers main class it shows debug information and creates the RMI Server
	 * @param args NOT USED*/
	
	public static void main(String args[]) {
        
        try {
        	LocateRegistry.createRegistry(1099);
            Server obj = new Server();
            AccM stub = (AccM) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("//localhost/Hello", stub);

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}