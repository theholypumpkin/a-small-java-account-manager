package example.hello;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface AccM extends Remote, Serializable {

	String sayHello() throws RemoteException;
	
/* ==================================================================== */

	
	/**Creates a new Account
     * @version 3.0
     * @param acc an account object
     * @param AccountManager The Account Array List
     * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	public void createAccount(Account acc) throws RemoteException, MalformedURLException;
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**Deletes an account out of the Account Manager
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
	
	public void deleteAccount(int accountID) throws RemoteException;
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**I'm kinda useless method
	 * @param The Account Manager
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	public ArrayList<Account> getAllAccounts() throws RemoteException;
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/
	
	
	/**@param accountID the Account ID
	 * @param Account Manager the Account Manager
	 * @throws RemoteException A RemoteException is the common superclass for a number of communication-
	 * related exceptions that may occur during the execution of a remote method call. Each method of a 
	 * remote interface, an interface that extends java.rmi.Remote, must list RemoteException in its 
	 * throws clause. 
	 * As of release 1.4, this exception has been retro fitted to conform to the general purpose exception-
	 * chaining mechanism. The "wrapped remote exception" that may be provided at construction time and 
	 * accessed via the public detail field is now known as the cause, and may be accessed via the 
	 * Throwable.getCause() method, as well as the aforementioned "legacy field." Invoking the method 
	 * Throwable.initCause(Throwable) on an instance of RemoteException always throws IllegalStateException.*/
	
	public Account getAccount(int accountID) throws RemoteException;
	
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
	
	public ArrayList<Account> getAllAccounts(String userName) throws RemoteException;
	
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
	
	static public void initializeAccountManager() throws RemoteException, FileNotFoundException, IOException, Exception {
	}
	
	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/

	
	/**@param Account Manager the Account Manager to be saved to disk
	 * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general
	 *  class of exceptions produced by failed or interrupted I/O operations.*/

	public void CloseAccountManager() throws RemoteException, IOException;

	/*-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -*/

	
	/**@return {@link #initializeAccountManager()}
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
	
	public void init() throws RemoteException, Exception;

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
	
	public float getAllMoneyByUser(String userName) throws RemoteException;
}
