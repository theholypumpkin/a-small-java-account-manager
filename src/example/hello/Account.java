package example.hello;

import java.io.Serializable;

/**
 * 
 */

/**
 * @author Pascal S. SENSITIVE INFORMATION REDACTED
 * Created on 1 Jun 2019
 */
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2182675848680916386L;
	
	public String surname = null;
	public String firstName = null;
	public String userName = null;
	public int accountID = 0;
	public float balance = 0;
	
	/**
	 * 
	 */
	@SuppressWarnings( "unused" )
	private Account(){}
	
	
	public Account(String surname, String firstName, String userName, int accountID,
			float balance){
		this.surname = surname;
		this.firstName = firstName;
		this.userName = userName;
		this.accountID = accountID;
		this.balance = (float) (Math.round(balance * 100)/100D);//Rounds to 2 decimal places
		System.out.print(this.balance);
	}
}