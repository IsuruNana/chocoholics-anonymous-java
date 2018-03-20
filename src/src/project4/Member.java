package project4;

import java.util.*;

/**
 * 
 * The Manager class implements the abstract base class User.
 * It contains the setters and getters for its various fields,
 * including the member's name, address, state, city, zipcode,
 * status, and number, all of which are strings. It also implements 3
 * constructors, based on which arguments are passed, a print
 * method, and methods to add, remove, and get transaction records.
 * 
 * @author Alan Manning
 * @version 1.0
 */

public class Member extends User {
	private String status; //Required for verification
	private ArrayList<TransactionRecord> servicesReceived;	// Record of transaction services received
	
	/**
	 * Default constructor instantiates an ArrayList servicesReceived
	 * of services received.
	 */
	public Member() {
		servicesReceived = new ArrayList<TransactionRecord>();
	}
	
	/**
	 * Constructor that passes member with name only.
	 * @param n member name
	 */
	public Member(String n) {
		super(n);
		servicesReceived = new ArrayList<TransactionRecord>();	// Allocate space for TransactionRecord ArrayList
	}
	
	/**
	 * Constructor calls parent class constructor.
	 * @param n member name
	 * @param a member address 
	 * @param c member city
	 * @param s member state
	 * @param z member zipcode
	 * @param i member number
	 */
    public Member(String n, String a, String c, String s, String z, String i ) {
        super(n, a, c, s, z, i);
        status = "valid";
        servicesReceived = new ArrayList<TransactionRecord>();	// Allocate space for TransactionRecord ArrayList
    }
    
    /**
     * Sets member status ('valid' or 'invalid')
     * based on String parameter.
     * @param newStatus member status
     */
    public void setStatus(String newStatus) {
    	status = newStatus;
    }
    
    /**
     * Returns the status of member ('valid' or 'invalid').
     * @return status of member
     */
    public String getStatus() {
    	return status;
    }
    
    /**
     * Adds transaction record to list of services received by member.
     * @param t transaction record for service
     */
    public void addTransactionRecord(TransactionRecord t) {
    	servicesReceived.add(t);
    }
    
    /**
     * Removes transaction record from list of services
     * received by member based on index.
     * @param i index of transaction record in ArrayList of records
     */
    public void removeTransactionRecord(int i) {
    	servicesReceived.remove(i);
    }
    
    /**
     * Returns transaction record based on
     * index of record in ArrayList of transaction records.
     * @param index index of transaction record in ArrayList
     * @return transaction record at given index
     */
    public TransactionRecord getMemberTransactionRecord(int index) {
    	return servicesReceived.get(index); 
    }
    
    /**
     * Returns size of transaction record.
     * @return size of transaction record 
     */
    public int getMemberTransactionSize() {
    	return servicesReceived.size(); 
    }
    
    /**
     * Prints fields corresponding to given member.
     */
    public void printMemberDetails() {
    	System.out.println("Member Name: " + getName());
		System.out.println("Member Number: " + getNumber());
		System.out.println("Street Address: " + getAddress());
		System.out.println("City: " + getCity());
		System.out.println("State: " + getState());
		System.out.println("ZIP Code: " + getZipcode());
    }
}
