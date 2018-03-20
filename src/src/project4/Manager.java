package project4;

import java.util.*;

/**
 * 
 * The Manager class implements the manager.
 * It contains a constructor that initializes its
 * providerRecords and memberRecords fields to the appropriate
 * records it is passed. It also has two methods for printing
 * the corresponding provider and member reports, as well as a
 * terminal method that allows the manager to print these reports
 * and a summary report, while generating a EFT file.
 * 
 * @author Alan Manning
 * @version 1.0
 */

public class Manager {
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;
	
	/**
	 * Constructor.
	 * @param memberRecords ArrayList of members
	 * @param providerRecords ArrayList of providers
	 */
	public Manager(MemberRecords memberRecords, ProviderRecords providerRecords) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
	}

	/**
	 * Prints the member report, based on the passed ArrayList passed.
	 * @param transactionArray ArrayList of transaction records
	 */
	public void printMemberReport(ArrayList<TransactionRecord> transactionArray) {
		int memberCounter = 0;
		
		// Prints each transaction from the ArrayList
		while (memberCounter < memberRecords.getSize()) {
			MemberReport.printMemberReport(memberRecords.getMember(memberCounter), transactionArray);
			System.out.println("");
			++memberCounter;
		}
	}
	
	/**
	 * Prints the provider report, based on the passed ArrayList passed.
	 * @param transactionArray ArrayList of transaction records
	 */
	public void printProviderReport(ArrayList<TransactionRecord> transactionArray) {
		int providerCounter = 0;
		
		// Prints each transaction from the ArrayList
		while (providerCounter < providerRecords.getSize()) {
			ProviderReport.printProviderReport(providerRecords.getProvider(providerCounter), transactionArray);
			System.out.println("");
			++providerCounter;
		}
	}

	/**
	 * Presents manager with the options to print the
	 * member, provider, and summary reports.
	 * @param scanner used for user input
	 * @param transactionArray ArrayList of transaction records
	 */
	public void managerTerminal(Scanner scanner, ArrayList<TransactionRecord> transactionArray) {
		String action;
		boolean edit = true;
		
		while(edit) {
			
			// Presents options to manager
			System.out.println("||---Select Print Option---||");
			System.out.println("Print Member Report : MR");
			System.out.println("Print Provider Report : PR");
			System.out.println("Print Provider Report : EFT");
			System.out.println("Print Summary Report : SR");
			System.out.println("Exit : E");
			action = scanner.nextLine();
			
			// Options for manager to print
			switch(action) {
			
				// Member report
				case "MR":
					printMemberReport(transactionArray);
					break;
				//Provider report
				case "PR":
					printProviderReport(transactionArray);
					break;
				// Generates EFT file, if size > 0
				case "EFT":
					if (transactionArray.size() > 0) {
						
						// Instantiates EFT file
						EFT testEFT = new EFT(transactionArray);
						testEFT.initiateEFT();
						System.out.println("");
					}
					break;

				// Summary report
				case "SR":
					if (transactionArray.size() > 0) {
						
						// Instantiates summary report
						SummaryReport summaryReport = new SummaryReport(transactionArray);
						summaryReport.initiateSummaryReport();
					}
					break;
					
				// exit
				case "E":
					edit = false;;
					break;
				
				// Invalid response
				default:
					System.out.println("Invalid reponse. Enter 'PM' or 'PR.'");
			}
		}	
	}
}





