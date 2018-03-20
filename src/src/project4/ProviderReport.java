package project4;

import java.util.ArrayList;

/**
 * ProviderReport outputs the report of a provider's transactions to file. This is done with a selected provider
 * and the list of transaction records.
 * 
 * @version 2.0
 * 
 * @author Richard Rice
 */

public class ProviderReport {
	/**
	 * Method that prints the providerReport.
	 * @param provider provider specified
	 * @param transactions ArrayList of transactions for each service
	 */
	public static void printProviderReport(Provider provider, ArrayList<TransactionRecord> transactions) {
		//Print all provider details
		System.out.println("||~~~~~Printing provider~~~~~||");
		provider.printProviderDetails();
		
		int consultationCounter = 0;
		double totalFee = 0.0;

		//Calculates the amount due to provider
		String providerNum = provider.getNumber();
		for(int i = 0;  i < transactions.size(); i++) {
			if ((providerNum.equals(transactions.get(i).getProvider().getNumber()))) {
				transactions.get(i).printTransactionRecordProvider();
				totalFee += transactions.get(i).getTransactionFee();
				consultationCounter++;
			}
		}	
		
		//prints the rest of the details for the member report
		System.out.println("Summary:");
		System.out.println("Total number of consulations with members: " + consultationCounter);
		System.out.println("Total fee for week: $" + totalFee);
	}
}