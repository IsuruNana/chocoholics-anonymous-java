/**
 * 
 * The User class is an abstract base class for members and providers.
 * It contains the setters and getters for its various fields,
 * including the user's name, address, state, city, zipcode,
 * status, and number, all of which are strings. It also implements 3
 * constructors, based on which arguments are passed, a print
 * method, and methods to add, remove, and get transaction records.
 * 
 * @author Alan Manning
 * @version 1.0
 */

package project4;

abstract class User {
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String number;
	
	/**
	 * Default constructor.
	 */
	public User() {
	}

	/**
	 * Constructor that is passed only member name.
	 * @param n member name
	 */
	public User(String n) {
		number = n;
	}

	/**
	 * Constructor.
	 * @param n user name
	 * @param a user address
	 * @param c user city
	 * @param s user state
	 * @param z user zipcode
	 * @param i user number
	 */
	public User(String n, String a, String c, String s, String z, String i) {
		name = n;
		address = a;
		city = c;
		state = s;
		zipcode = z;
		
		// Check to determine if user PIN is 9 digits
		if (i.length() != 9) {
    		throw new NumberFormatException("Member PIN must be 9 digits.");
		}
		
		number = i;
	}

	/**
	 * Sets user name.
	 * @param n user name
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * Returns user name.
	 * @return user name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets user address.
	 * @param a user address
	 */
	public void setAddress(String a) {
		address = a;
	}

	/**
	 * Returns user address.
	 * @return user address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets user city.
	 * @param c user city
	 */
	public void setCity(String c) {
		city = c;
	}

	/**
	 * Returns user city.
	 * @return user city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets user state.
	 * @param s user state
	 */
	public void setState(String s) {
		state = s;
	}

	/**
	 * Returns user state.
	 * @return user state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets user zipcode.
	 * @param z user zipcode
	 */
	public void setZipcode(String z) {
		zipcode = z;
	}

	/**
	 * Returns user zipcode.
	 * @return user zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Sets user number.
	 * @param n user number
	 */
	public void setNumber(String n) {
		
		// Check to determine if user number is 9 digits
		if (n.length() != 9) {
    		throw new NumberFormatException("Member PIN must be 9 digits.");
    	}
	
		number = n;
	}

	/**
	 * Returns user number.
	 * @return user number
	 */
	public String getNumber() {
		return number;
	}
}