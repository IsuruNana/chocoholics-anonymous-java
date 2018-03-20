package project4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BillChocAn serves as a framework that
 * a provider can utilize to BillChocAn.
 * 
 * @version 1.0
 * 
 * @author Isuru Nanayakkara
 */


public class BillChocAn{
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;
	private ArrayList<Service> providerDirectory;
	private ArrayList<TransactionRecord> transactionList;
	
	
	/**
	 * Constructor that is passed the following parameters.
	 * @param memberRecords an ArrayList of members, including their details
	 * @param providerRecords an ArrayList of providers, including their details
	 * @param providerDirectory the Provider Directory, which serves as an
	 * alphabetical listing of healthcare services, along with their service codes
	 * and fees
	 * @param transactionList a record of the relevant details for each healthcare
	 * service provided to a member
	 */
	public BillChocAn(MemberRecords memberRecords, 
					  ProviderRecords providerRecords, 
					  ArrayList<Service> providerDirectory,
					  ArrayList<TransactionRecord> transactionList) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
		this.providerDirectory = providerDirectory;
		this.transactionList = transactionList;
	}
	
	/**
	 * Method that presents the provider with the option to
	 * provide a healthcare service, Bill ChocAn, Display the Provider Directory,
	 * or Exit. 
	 * @param scanner used for user input
	 */
	public void billChocAnTerminal(Scanner scanner) {
		// Provider log-in
		Provider activeProvider;
		String response;
		boolean askQuestions = true;
		activeProvider = providerLogin(scanner);
		
		if(activeProvider != null) {
			
			while(askQuestions){
				response = questionPrompt(scanner);
				
				switch(response) {
				
					case "P" : 
						//Provide Service
						requestServiceCase(scanner, activeProvider);
						break;
					case "B" :
						//Bill ChocAn	
						billMemberCase(scanner, activeProvider);
						break;
					case "D" :
						//Display Provider Directory
						activeProvider.displayProviderDirectory(providerDirectory);
						break;
					case "E":
						//Log out
						askQuestions = false;
						break;
					default :
						System.out.println("Invalid response. Please try again.");
						break;
				}
			}
		}
	}
	
	/**
	 * Method that reads lines for the prompt
	 * with the option to provide a healthcare service, bill ChocAn, 
	 * display the provider directory, or exit, and returns
	 * a string.
	 * @param questions used for user input
	 * @return String 
	 */
	
	public String questionPrompt(Scanner questions) {
		System.out.println("Which service do you require?");
		System.out.println("Provide service: P");
		System.out.println("Bill ChocAn: B");
		System.out.println("Display Provider Directory: D");
		System.out.println("Exit: E");
		String answer = "nothing";
		
		answer = questions.nextLine();
		
		return answer;
	}
	
	/**
	 * Method that prompts the user for a user ID.
	 * @param reader used for user input
	 * @param type 9-digit PIN input
	 * @return String the member/provider number
	 */
	public String promptNumber(Scanner reader, String type) { //Make sure to enter a 9-digit number
		String userID;
		System.out.println("Enter " + type + " number: ");
		
		userID  = reader.nextLine(); 
		
		while (userID.length() != 9) {
			System.out.println("Invalid " + type + " Number.\nEnter another number: ");
			userID = reader.nextLine();
		}
		
		return userID;
	}
	
	/**
	 * Method that allows the provider to manually enter
	 * the date.
	 * @param reader used for user input
	 * @return date entered by provider
	 */
	
	public DateTime promptDate(Scanner reader) { 
		int month;
		int day;
		int year;
		DateTime dt = new DateTime();
		
		System.out.println("Enter month (MM):");
		month = reader.nextInt();
		dt.setMonth(month);
		
		System.out.println("Enter day (DD):");
		day = reader.nextInt();
		dt.setDayOfMonth(day);
		
		System.out.println("Enter year (YYYY):");
		year = reader.nextInt();
		dt.setYear(year);
		
		reader.nextLine();
		
		return dt;
	}
	
	/**
	 * Method that allows a provider to login to the terminal.
	 * @param reader used for user input
	 * @return provider with the given login credentials
	 */
	
	public  Provider providerLogin(Scanner reader) {
		String providerNum;
		int providerIndex = -1;
	
		while(providerIndex == -1) {
			providerNum = promptNumber(reader, "Provider");
			providerIndex = providerRecords.getRecordIndex(providerNum); //Check if provider exists
			
			if(providerIndex == -1) {
				System.out.println("Error provider not found. Please Try again.");
			}
		}
		
		return providerRecords.getProvider(providerIndex);
	}
	
	/**
	 * Method that emulates swiping a member's card
	 * to verify that they are an active member.
	 * @param reader used for user input
	 * @return member with given credentials
	 */
	
	public Member memberLogin(Scanner reader) {
		String memberNum;
		int memberIndex = -1;
	
		while(memberIndex == -1) {
			memberNum = promptNumber(reader, "Member");
			memberIndex = memberRecords.getRecordIndex(memberNum); //Check if member exists
			
			if(memberIndex == -1) {
				System.out.println("Error member not found. Please Try again.");
			}
		}
		
		return memberRecords.getMember(memberIndex);
	}
	
	/**
	 * Method that prompts the user for a given service code
	 * and returns the index of the service in the service records.
	 * @param scanner used for user input
	 * @param provider currently active provider
	 * @return index of service in the service records
	 */
	
	public int promptService(Scanner scanner, Provider provider) {

			String serviceCode;
			int serviceIndex = -1;
			String yesNo = "N";
			
			while(!yesNo.equals("Y")) { //Only accept Y
				System.out.println("Type in service code.(E for exit):");
				serviceCode = scanner.nextLine();
				
				if (serviceCode.equals("E")) {
					return -1;
				}
				
				else {
					serviceIndex = provider.lookUpServiceCodeIndex(serviceCode, providerDirectory);
					if(serviceIndex == -1) {
						System.out.println("Error Service not found. Try again.(E for exit)");
					}
					else {
						System.out.println("Is this the service you wanted?");
						//Print service name
						System.out.println(providerDirectory.get(serviceIndex).getServiceName());
						System.out.println("Yes/No (Y/N)?: ");
						yesNo = scanner.nextLine();
					}
				}
			}
		
			return serviceIndex;
	}
	
	/**
	 * Method that verifies that the requested service
	 * is correct and exists in the system.
	 * @param scanner used for user input
	 * @param provider currently active provider
	 * @param providerDirectory provider directory
	 * @return index of service in provider directory
	 */
	
	public int validateService(Scanner scanner,
									  Provider provider, 
									  ArrayList<Service> providerDirectory) {

		String requestedService;
		int serviceIndex = -1;
		
		while(serviceIndex == -1) {
			System.out.println("Enter Healthcare Service (E for exit):");
			requestedService = scanner.nextLine();
			
			if (requestedService.equals("E")) {
					return -1;
			}
			
			else {
				serviceIndex = provider.accessProviderDirectory(requestedService, providerDirectory);
				if(serviceIndex == -1) {
					System.out.println("Error Service not found. Try again.(E for exit)");
				}
			}
		}

		return serviceIndex;
	}
	
	/**
	 * Method that requests that a 
	 * certain service by provided, and that the records
	 * for said service be initialized with the correct information.
	 * @param scanner used for user input
	 * @param activeProvider currently active provider
	 */
	
	public void requestServiceCase(Scanner scanner, Provider activeProvider) {
		int serviceNum;
		Member activeMember = memberLogin(scanner);
		
		if(activeMember.getStatus().equals("valid")) {
			System.out.println("Validated");
			serviceNum = validateService(scanner, activeProvider, providerDirectory);
			
			if(serviceNum != -1) {
				// Two messages for invalid member/error
				TransactionRecord transaction = new TransactionRecord();
				DateTime dTime = new DateTime();
				dTime.setToCurrentDateTime();
				transaction.setMember(activeMember);
				transaction.setProvider(activeProvider);
				transaction.setServiceDate(dTime);
				transaction.setService(providerDirectory.get(serviceNum));
				activeMember.addTransactionRecord(transaction);
				//activeMember.printAllRecords();		
			}
		}
		
		else {
			System.out.println("Member suspended");
		}
	}
	
	/**
	 * Method that Bills ChocAn, based on a given service.
	 * @param scanner used for user input
	 * @param activeProvider currently active provider
	 */
	
	public void billMemberCase(Scanner scanner, Provider activeProvider) {
		Member activeMember = memberLogin(scanner);
		
		TransactionRecord currentTransaction;
		String recordedService;
		String validatedService;
		String comments;
		int size = activeMember.getMemberTransactionSize();
		int index;
		
		
		//Member login
		if(activeMember.getStatus().equals("valid")) { //Validate member
			System.out.println("Validated");
			if(size == 0) {
				 System.out.println("No services were billed.");
				 return;
			}
			
			for(int i = 0; i < size; i++) { //For each service in member.
				//BILL STUFF
				
				//Get Transaction Record
				currentTransaction = activeMember.getMemberTransactionRecord(i);
				//Manual type of Date
				currentTransaction.setServiceDate(promptDate(scanner));
				currentTransaction.setCurrentDateTime();
				
				recordedService = currentTransaction.getService().getServiceName();
				
				//Prompt service
				index = promptService(scanner, activeProvider);
				validatedService = providerDirectory.get(index).getServiceName();
			    
			    if (recordedService.equals(validatedService)) {
			    	System.out.println("Requested service has been verified");
			    	//Do bills
			    	transactionList.add(currentTransaction);

			    	System.out.println("Billing complete");
			    }
				
				//Enter comments
			    System.out.println("Enter any additional comments:");
			    
			    comments = scanner.nextLine();
			    
			    currentTransaction.setComments(comments);
				
				System.out.println(currentTransaction.getService().getServiceFee());
				//At the end remove the service because it has been billed
				if (i == size - 1) {
					activeMember.removeTransactionRecord(i);
				}
			}
		}
	}
}
