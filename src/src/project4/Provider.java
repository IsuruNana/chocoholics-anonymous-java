package project4;

import java.util.ArrayList;

/**
 * 
 * The Provider class implements the abstract base class User.
 * It contains the setters and getters for its various fields,
 * including the member's name, address, state, city, zipcode,
 * status, and number, all of which are strings. It also implements 3
 * constructors, based on which arguments are passed, a print
 * method, and methods to access the Provider Directory and find
 * the index of healthcare service codes.
 * 
 * @author Alan Manning
 * @version 1.0
 */

public class Provider extends User {
	
	/**
	 * Default constructor instantiates an ArrayList servicesReceived
	 * of services received.
	 */
	public Provider() {
	}

	/**
	 * Constructor that passes member with name only.
	 * @param n provider name
	 */
	public Provider(String n) {
		super(n);
	}

	/**
	 * Constructor calls parent class constructor.
	 * @param n provider name
	 * @param a provider address
	 * @param c provider city
	 * @param s provider state
	 * @param z provider zipcode
	 * @param i provider number
	 */
	public Provider(String n, String a, String c, String s, String z, String i) {
		super(n, a, c, s, z, i);
	}

	/**
	 * Method to access Provider Directory.
	 * @param serviceName name of service specified
	 * @param providerDirectory provider directory of services
	 * @return index of the Provider Directory
	 */
	public int accessProviderDirectory(String serviceName, ArrayList<Service> providerDirectory) {
		int size = providerDirectory.size();

		for (int i = 0; i < size; ++i) {
			Service s = providerDirectory.get(i);	// Gets service at index i

			// Check to match name of service
			if (s.getServiceName().equals(serviceName)) {
				return i;
			}
		}

		return -1;
	}
	
	/**
	 * Method to display Provider Directory.
	 * @param providerDirectory provider directory of services
	 */
	public void displayProviderDirectory(ArrayList<Service> providerDirectory) {
		int size = providerDirectory.size();
		
		for (int i = 0; i < size; ++i) {
			Service s = providerDirectory.get(i);
			
			s.printService(s);
		}
	}
	
	/**
	 * Method that returns the index of the service in
	 * the provider directory.
	 * @param serviceCode service code for a given service
	 * @param providerDirectory provider directory of services
	 * @return index of the service in the provider directory
	 */
	public int lookUpServiceCodeIndex(String serviceCode, ArrayList<Service> providerDirectory) {
		int size = providerDirectory.size();

		for (int i = 0; i < size; ++i) {
			Service s = providerDirectory.get(i);	// Gets service at index i

			// Check to match number of service with service code
			if (s.getServiceNumber().equals(serviceCode)) {
				return i;
			}
		}

		return -1;
	}
	
	/**
     * Prints fields corresponding to given provider.
     */
	public void printProviderDetails() {
		if (getName() == null) {
			throw new NumberFormatException("This Provider is incomplete");
		}
		else if (getNumber() == null) {
			throw new NumberFormatException("This Provider is incomplete");
		}
		else if (getAddress() == null) {
			throw new NumberFormatException("This Provider is incomplete");
		}
		else if (getCity() == null) {
			throw new NumberFormatException("This Provider is incomplete");
		}
		else if (getState() == null) {
			throw new NumberFormatException("This Provider is incomplete");
		}
		else if (getZipcode() == null) {
			throw new NumberFormatException("This Provider is incomplete");
		}
		else {
			System.out.println("Provider Name: " + getName());
			System.out.println("Provider Number: " + getNumber());
			System.out.println("Street Address: " + getAddress());
			System.out.println("City: " + getCity());
			System.out.println("State: " + getState());
			System.out.println("ZIP Code: " + getZipcode());
		}
    }
}
