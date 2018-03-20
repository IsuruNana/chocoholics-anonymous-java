package project4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The ProviderRecords class implements the class that contains the member records
 * It contains the setters, getters, for the field provider, which is of type provider,
 * it also includes getters for the fields size and recordIndex, which is are ints.
 * It also implements a constructor method as well as
 * methods to get validProvider, print the data of all the providers as well as compare two providers.
 * 
 * @author Robert Bartnett
 * @version 1.0
 */

public class ProviderRecords {
	
	private ArrayList<Provider> providerDetails;
	
	/**
	 * Default constructor initializes ArrayList of providers.
	 */
	public ProviderRecords(){
		providerDetails = new ArrayList<Provider>();
	}
	
	/**
	 * Method to add provider to ArrayList of providers.
	 * @param provider provider to be added
	 */
	public void addProvider(Provider provider){
		providerDetails.add(provider);
	}
	
	/**
	 * Method that uses the index to access a provider from
	 * an ArrayList of providers and then return the provider
	 * @param providerIndex index of specified provider in ArrayList of provider
	 * @return provider at specified index
	 */
	public Provider getProvider(int providerIndex){
		if((providerIndex < 0) || (providerIndex >= providerDetails.size())){
			return null;	
		}
		
		return providerDetails.get(providerIndex);
	}
	
	/**
	 * Method that uses the provider number to access a provider from
	 * an ArrayList of providers and then return the provider.
	 * @param providerNumber number of specified provider  
	 * @return provider with specified number
	 */
	public Provider getProvider(String providerNumber){
		int i = getRecordIndex(providerNumber);
		if(i == -1){
			return null;	
		}
		
		return providerDetails.get(i);
	}
	
	/**
	 * Method to remove the provider from the ArrayList of providers.
	 * @param provider provider to be removed
	 */
	public void removeProvider(Provider provider) {
		providerDetails.remove(provider);
	}
	
	/**
	 * Method to remove the provider from an ArrayList
	 * of providers using index given.
	 * @param i index of provider to be removed
	 */
	public void removeProvider(int i) {
		providerDetails.remove(i);
	}
	
	/**
	 * Method to return the size of the ArrayList of providers.
	 * @return size of the ArrayList of providers
	 */
	public int getSize() {
		return providerDetails.size();
	}
	
	/**
	 * Method to search for a provider based on their provider 
	 * number and return the index of that provider
	 * @param number provider number
	 * @return index of specified provider in provider records
	 */
	public int getRecordIndex(String number) {
		
		Provider p1 = new Provider(number);
		Provider p2 = new Provider();
		
		int size = providerDetails.size();
		
		for (int i = 0; i < size; ++i) {
			p2 = providerDetails.get(i);
			
			if (compare(p1, p2)) { 
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Method that prompts the user for a valid provider PIN
	 * and returns the provider
	 * @param scanner used for user input
	 * @return provider with specified PIN
	 */
	public Provider getValidProvider(Scanner scanner) {
		String providerID;
		Provider provider = null;
		
		while(provider == null) {
			System.out.println("Enter provider ID.");
			providerID = scanner.nextLine();
			if(providerID == "E") {
				break;
			}
			provider = getProvider(providerID);
			if(provider == null) {
				System.out.println("Error try again or press E to exit");
			}
		}
		
		return provider;
	}
	
	/**
	 * Method used to print the details of a given provider.
	 */
	public void printDetails() {
		int size = providerDetails.size();
		
		System.out.println("Name\t Address\t State\t City\t Zipcode\t Number\t");
		
		System.out.println("");
		System.out.println("");
		
		for (int i = 0; i < size + 1; ++i) {
			Provider p = providerDetails.get(i);
			
        	System.out.println(p.getName() + "\t" + p.getAddress()  + "\t" + p.getState()  + "\t" + p.getCity()  + "\t" + p.getZipcode()  + "\t" + p.getNumber());
		}
	}
	
	/**
	 * Method that compares provider numbers.
	 * @param p1 first provider
	 * @param p2 second provider
	 * @return boolean used to compare two providers
	 */
	public boolean compare(Provider p1, Provider p2) {
		return p1.getNumber().equals(p2.getNumber());
	}
}
