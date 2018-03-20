package project4;

import java.util.*;

/**
 * Main method that runs the provider/operator/manager terminal.
 * @author alan, isuru, robert, hunter, and richard
 *
 */

public class Terminal {
	/**
	 * Main method that takes in a String.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		//--------------Variable declarations--------------------//
		boolean mainLoop = true;
	    Scanner scanner = new Scanner(System.in); 
		String response;
		
		// Provided ProviderRecords and MemberRecords
		ProviderRecords providerRecords = new ProviderRecords();
		MemberRecords memberRecords = new MemberRecords();
		ArrayList<Service> providerDirectory = new ArrayList<Service>();
		ArrayList<TransactionRecord> transactionArray = new ArrayList<TransactionRecord>();
		
		
		// Initialize major terminals
		Operator operator = new Operator(memberRecords, providerRecords);
		Manager manager = new Manager(memberRecords, providerRecords);
		BillChocAn billChocAn = new BillChocAn(memberRecords, providerRecords, providerDirectory, transactionArray);
		
		// Initialize data
		initVariables(providerRecords, memberRecords, providerDirectory);
	
		Collections.sort(providerDirectory, Service.SerNameComparator);
		//-------------------------------------------------------//
		
		//BACKGROUND TASK TO PRINT DETAILS AT MIDNIGHT
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new WeeklyMaintenance(providerRecords, memberRecords, transactionArray), 0, 1);
		
		//Master login
		while(mainLoop) {
			response = masterPrompt(scanner);
			
			switch(response) {
				case "O" :
					operator.OperatorTerminal(scanner);
					break;	
				case "P" :
					billChocAn.billChocAnTerminal(scanner);
					break;
				case "M" :
					manager.managerTerminal(scanner, transactionArray);
					break;
				default: 
					System.out.println("Invalid response. Enter O, P, or M.");
			}
		}
				
		/*----------------------------------------------------------------------------*/
		
		/*----------------------------------Hunter------------------------------------*/
		
		/*----------------------------------------------------------------------------*/
	}	
	
	/**
	 * Static method that continually runs to prompt the user
	 * if they are an operator, provider, or manager.
	 * @param questions used for user input
	 * @return string used for selection
	 */
	public static String masterPrompt(Scanner questions) {
		System.out.println("Are you an Operator, Provider or Manager?");
		System.out.println("Operator: O");
		System.out.println("Provider: P");
		System.out.println("Manager: M");
		String answer = "nothing";
		
		answer = questions.nextLine();
		
		return answer;
	}
	
	/**
	 * Static method that initializes
	 * member/provider records and the
	 * provider directory in order to test the program. 
	 * @param providerRecords ArrayList of provider records
	 * @param memberRecords ArrayList of member records
	 * @param providerDirectory provider directory of services
	 */
	public static void initVariables(ProviderRecords providerRecords, 
									MemberRecords memberRecords, 
									ArrayList<Service> providerDirectory) {
		// Add ArrayList<Service> providerDirectory for array list of services
		
				// Initializing providers and adding to ProviderRecords
				Provider providerBob = new Provider("Bob", "1625 Hargrove Rd. East", "Tuscaloosa", "Alabama", "35405", "000000000");
				Provider providerJim = new Provider("Jim", "1234 PB&J Lane", "Tuscaloosa", "Alabama", "35406", "000000001");
				Provider providerAlex = new Provider("Alex", "The Shire", "Tuscaloosa", "Alabama", "35404", "000000002");
				providerRecords.addProvider(providerBob);
				providerRecords.addProvider(providerJim);
				providerRecords.addProvider(providerAlex);
				
				// Initializing members and adding to MemberRecords
				Member memberAlice = new Member("Alice", "Wonderland", "Tuscaloosa", "Alabama", "35403", "000000000");
				Member memberClark = new Member("Clark", "Krypton", "Tuscaloosa", "Alabama", "35406", "000000001");
				Member memberSanta = new Member("Santa", "The North Pole", "Tuscaloosa", "Alabama", "35404", "000000002");
				memberRecords.addMember(memberAlice);
				memberRecords.addMember(memberClark);
				memberRecords.addMember(memberSanta);
				
				// Initializing services and adding to ProviderDirectory
				Service dietitianSession = new Service("Dietitian Session", "598470", 200.00);
				Service aerobicsExercise = new Service("Aerobics Exercise Session", "883948", 69.00);
				Service insulinTreatments = new Service("Insulin Treatments", "314592", 75.00);
				Service shockTherapy = new Service("Electroconvulsive Therapy Session", "000000", 100.00);
				
				// Allocate memory for providerDirectory
				// Add existing services to providerDirectory
				providerDirectory.add(dietitianSession);
				providerDirectory.add(aerobicsExercise);
				providerDirectory.add(insulinTreatments);
				providerDirectory.add(shockTherapy);
	}
	
}