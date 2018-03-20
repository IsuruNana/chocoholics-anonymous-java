package project4;

/**
* TransactionRecords creates a record
* of each transaction that a provider
* provides to a specified member, which
* contains the current date, date of service,
* provider, member, service, and any additional comments.
* 
* @author Hunter Kimbrell
* @version 1.0
*/

public class TransactionRecord {
    private DateTime currentDateTime;
    private DateTime serviceDate;
    private Provider provider;
    private Member member;
    private Service service;
    private String comments;
    
    /**
     * Default constructor.
     */
    public TransactionRecord() {
    	provider = new Provider();
    	member = new Member();
    	currentDateTime = new DateTime();
    	serviceDate = new DateTime();
    	service = new Service();
    }
    
    /**
     * Constructor that initializes the corresponding
     * fields in a TransactionRecord object.
     * @param today today's date and time
     * @param serviceTime service date and time
     * @param p specified provider
     * @param m specified member
     * @param s specified service
     * @param c additional comments 
     */
    public TransactionRecord(DateTime today, DateTime serviceTime, Provider p, Member m, Service s, String c) {
    	currentDateTime = today;
    	serviceDate = serviceTime;
    	provider = p;
    	member = m;
    	service = s;
    	comments = c;
    }
    
    /**
     * Method that returns the currentDateTime.
     * @return current date and time
     */
    public DateTime getCurrentDate() {
    	return currentDateTime;
    }
    
    /**
     * Method that returns the serviceDate.
     * @return service date and time
     */
    public DateTime getServiceDate() {
        return serviceDate;
    }
    
    /**
     * Method that returns any additional comments.
     * @return additional comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * Method that returns member.
     * @return specified member
     */
    public Member getMember() {
    	return member;
    }
    
    /**
     * Method that returns provider.
     * @return specified provider
     */
    public Provider getProvider() {
    	return provider;
    }
    
    /**
     * Method that returns service.
     * @return specified service
     */
    public Service getService() {
    	return service;
    }
    
    /**
     * Method that sets the currentDateTime.
     */
    public void setCurrentDateTime() {
    	currentDateTime.setToCurrentDateTime();
    }
    
    /**
     * Method that sets the serviceDate.
     * @param newServDate service date
     */
    public void setServiceDate(DateTime newServDate) {
        serviceDate = newServDate;
    }
    
    /**
     * Method that sets the member.
     * @param m specified member
     */
    public void setMember(Member m) {
    	member = m;
    }
    
    /**
     * Method that sets the provider.
     * @param p specified provider
     */
    public void setProvider(Provider p) {
    	provider = p;
    }
    
    /**
     * Method that sets the service
     * @param s specified service
     */
    public void setService(Service s) {
    	service = s;
    }
    
    /**
     * Method that returns the transactionFee.
     * @return specified transaction fee
     */
    public double getTransactionFee() {
    	return service.getServiceFee();
    }
    
    /**
     * Method that sets any additional comments.
     * @param comms additional comments
     */
    public void setComments(String comms) {
    	comments = comms;
    }
    
    /**
     * Method that prints the member transaction record.
     */
    public void printTransactionRecordMember() {
    	System.out.print("Received (" + service.getServiceName() + ") ");
		System.out.print("from (" + provider.getName() + ") ");
		System.out.print("on (");
		serviceDate.printDate();
		System.out.println(")");
    }
    
    /**
     * Method that prints the provider transaction record.
     */
    public void printTransactionRecordProvider() {
    	System.out.print("Provider (" + provider.getName() + ") ");
		System.out.print("provided service (" + service.getServiceNumber() + ") ");
		System.out.print("to (" + member.getName() + " : ");
		System.out.print(member.getNumber() + ") ");
		System.out.print("for ($" + service.getServiceFee() + ") on (");
		serviceDate.printDate();
		System.out.print("), and was submitted (");
		currentDateTime.printDateTime();
		System.out.println(")");
    }
}