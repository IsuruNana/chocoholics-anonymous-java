package project4;

import java.util.*;

/**
 * 
 * The Service class implements the service provided to a member.
 * It contains 2 constructors that initializes its
 * serviceName, serviceNumber, and serviceFee fields to the appropriate
 * strings and/or doubles it is passed. It also has a 
 * comparator to compare any 2 service names, along with
 * setters and getters for the aforementioned fields.
 * 
 * @author Alan Manning
 * @version 1.0
 */

public class Service {
	private String serviceName;
	private String serviceNumber;
	private double serviceFee;
	
	/**
	 * Comparator method added for alphabetical sorting.
	 */
	public static Comparator<Service> SerNameComparator = new Comparator<Service>() {
		public int compare(Service s1, Service s2) {
			String Service1 = s1.getServiceName().toUpperCase();
			String Service2 = s2.getServiceName().toUpperCase();
			
			// Sorts in ascending order
			return Service1.compareTo(Service2);
		}
	};
	
	/**
	 * Default Constructor.
	 */
	public Service() {
	}

	/**
	 * Constructor.
	 * @param service service name
	 * @param code service code
	 * @param fee service fee
	 */
	public Service(String service, String code, double fee) {
		serviceName = service;
		serviceNumber = code;
		serviceFee = fee;
	}
	
	/**
	 * Sets service name.
	 * @param name service name
	 */
	public void setServiceName(String name) {
		serviceName = name;
	}
	
	/**
	 * Returns the service name.
	 * @return service name
	 */
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * Sets service number.
	 * @param number service number
	 */
	public void setServiceNumber(String number) {
		serviceNumber = number;
	}
	
	/**
	 * Returns service number.
	 * @return service number
	 */
	public String getServiceNumber() {
		return serviceNumber;
	}
	
	/**
	 * Sets service fee.
	 * @param fee service fee
	 */
	public void setServiceFee(double fee) {
		if (fee < 0) {
			throw new NumberFormatException("Fee must be positive");
		}
		serviceFee = fee;
	}
	
	/**
	 * Returns service fee.
	 * @return service fee
	 */
	public double getServiceFee() {
		return serviceFee;
	}
	
	/**
	 * Prints information for given service.
	 * @param s service to be printed
	 */
	public void printService(Service s) {
		System.out.println("Service: " + getServiceName() + "; Service Code: " + getServiceNumber() + "; Fee = $" + getServiceFee());
	}
}
