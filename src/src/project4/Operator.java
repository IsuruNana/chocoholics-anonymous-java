package project4;

import java.util.*;

/**
 * Operator creates a framework that
 * an operator can use to add/remove
 * and update members/providers.
 * 
 * @version 1.0
 * 
 * @author Isuru Nanayakkara
 */

public class Operator {
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;

	/**
	 * Constructor.
	 * @param memberRecords ArrayList of member records
	 * @param providerRecords ArrayList of provider records
	 */
	public Operator(MemberRecords memberRecords, ProviderRecords providerRecords) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
	}
	
	/**
	 * Inserts a member into the ArrayList of member records.
	 * @param member member to be inserted
	 */
	public void insertMember(Member member) {
		memberRecords.addMember(member);
	}

	/**
	 * Method that prompts operator to create and
	 * insert new member.
	 * @param scanner used for user input
	 */
	public void insertMemberPrompt(Scanner scanner) {
		Member member  = new Member();
		System.out.println("Enter member name :");
		member.setName(scanner.nextLine());
		System.out.println("Enter member address :");
		member.setAddress(scanner.nextLine());
		System.out.println("Enter member city :");
		member.setCity(scanner.nextLine());
		System.out.println("Enter member state :");
		member.setState(scanner.nextLine());
		System.out.println("Enter member zipcode :");
		member.setZipcode(scanner.nextLine());
		System.out.println("Enter member number :");
		member.setNumber(scanner.nextLine());
		memberRecords.addMember(member);
	}

	/**
	 * Method that deletes member from the ArrayList of member records.
	 * @param member member to be deleted
	 */
	public void removeMember(Member member) {
		memberRecords.removeMember(member);
	}
	
	/**
	 * Prompts operator to delete member from memeber records.
	 * @param scanner used for user input
	 */
	public void removeMemberPrompt(Scanner scanner) {
		String memberID;
		Member member = null;
		
		//KEEP LOOPING UNTIL VALID MEMBER IS FOUND TO DELETE
		while(member == null) {
			System.out.println("Enter member to remove.");
			memberID = scanner.nextLine();
			if(memberID == "E") {
				break;
			}
			member = memberRecords.getMember(memberID);
			//MEMBER EXISTS
			if(member == null) {
				System.out.println("Error try again or press E to exit");
			}
		}
		//REMOVE THAT MEMBER
		memberRecords.removeMember(member);
	}
	
	//PROMPT OPERATOR TO UPDATE ONLY CERTAIN ASPECTS OF MEMBER
	public void updateMemberPrompt(Scanner scanner) {
		String data;
		//MEMBER EXISTS
		Member member = memberRecords.getValidMember(scanner);
		boolean go = true;
		while(go) {
			System.out.println("Select data to update:");
			System.out.println("Name: N");
			System.out.println("Address: A");
			System.out.println("City: C");
			System.out.println("State: S");
			System.out.println("Zipcode: Z");
			System.out.println("Member Number: M");
			System.out.println("Exit: E");
			
			data = scanner.nextLine();
			//INDIVIDUAL UPDATES. SETS MEMBER FIELDS BASED ON EACH REQUIREMENT
			switch(data) {
				case "N" :
					System.out.println("Enter new name:");
					member.setName(scanner.nextLine());
					break;	
				case "A" :
					System.out.println("Enter new address:");
					member.setAddress(scanner.nextLine());
					break;	
				case "C" :
					System.out.println("Enter new city:");
					member.setCity(scanner.nextLine());
					break;
				case "S" :
					System.out.println("Enter new state:");
					member.setState(scanner.nextLine());
					break;
				case "Z" :
					System.out.println("Enter new zipcode:");
					member.setZipcode(scanner.nextLine());
					break;
				case "M" :
					System.out.println("Enter new memberID:");
					member.setNumber(scanner.nextLine());
					break;
				case "E" :
					go = false; //DONE EDITING. EXIT
					break;
			}
		}	
	}
	
	/**
	 * Method to insert provider into the ArrayList of providers
	 * @param provider provider to be inserted
	 */
	public void insertProvider(Provider provider) {
		providerRecords.addProvider(provider);
	}
	
	/**
	 * Method to prompt operator to create and insert
	 * new provider into ArrayList of providers.
	 * @param scanner Used for user input
	 */
	public void insertProviderPrompt(Scanner scanner) {
		Provider provider  = new Provider();
		System.out.println("Enter provider name :");
		provider.setName(scanner.nextLine());
		System.out.println("Enter provider address :");
		provider.setAddress(scanner.nextLine());
		System.out.println("Enter provider city :");
		provider.setCity(scanner.nextLine());
		System.out.println("Enter provider state :");
		provider.setState(scanner.nextLine());
		System.out.println("Enter provider zipcode :");
		provider.setZipcode(scanner.nextLine());
		System.out.println("Enter provider number :");
		provider.setNumber(scanner.nextLine());
		providerRecords.addProvider(provider);
	}
	
	/**
	 * Method to remove provider from the ArrayList of providers.
	 * @param provider provider to be removed
	 */
	public void removeProvider(Provider provider) {
		providerRecords.removeProvider(provider);
	}
	
	/**
	 * Method to prompt operator to remove provider
	 * from ArrayList of providers.
	 * @param scanner used for user input
	 */
	public void removeProviderPrompt(Scanner scanner) {
		String providerID;
		Provider provider = null;
		
		//KEEP LOOPING UNTIL VALID PROVIDER IS FOUND TO DELETE
		while(provider == null) {
			System.out.println("Enter provider to remove.");
			providerID = scanner.nextLine();
			if(providerID == "E") {
				break;
			}
			provider = providerRecords.getProvider(providerID);
			if(provider == null) {
				System.out.println("Error try again or press E to exit");
			}
		}
		providerRecords.removeProvider(provider);
	}
	
	/**
	 * Method to prompt operator to update only
	 * certain aspects of provider.
	 * @param scanner used for user input
	 */
	public void updateProviderPrompt(Scanner scanner) {
		String data;
		Provider provider = providerRecords.getValidProvider(scanner);
		boolean go = true;
		while(go) {
			System.out.println("Select data to update:");
			System.out.println("Name: N");
			System.out.println("Address: A");
			System.out.println("City: C");
			System.out.println("State: S");
			System.out.println("Zipcode: Z");
			System.out.println("Member Number: M");
			System.out.println("Exit: E");
			
			data = scanner.nextLine();
			switch(data) {
				case "N" :
					System.out.println("Enter new name:");
					provider.setName(scanner.nextLine());
					break;	
				case "A" :
					System.out.println("Enter new address:");
					provider.setAddress(scanner.nextLine());
					break;	
				case "C" :
					System.out.println("Enter new city:");
					provider.setCity(scanner.nextLine());
					break;
				case "S" :
					System.out.println("Enter new state:");
					provider.setState(scanner.nextLine());
					break;
				case "Z" :
					System.out.println("Enter new zipcode:");
					provider.setZipcode(scanner.nextLine());
					break;
				case "M" :
					System.out.println("Enter new memberID:");
					provider.setNumber(scanner.nextLine());
					break;
				case "E" :
					go = false;
					break;
			}
		}	
	}
	
	/**
	 * Method to search for a given member
	 * from an ArrayList of members by number and return this number.
	 * @param memberNum member number
	 * @return member number returned as a String
	 */
	public Member memberSearch(String memberNum) {
			Member member =  memberRecords.getMember(memberNum);
			if(member != null) {
				if(member.getStatus() == "valid") {
					return member;
				}
				else {
					System.out.println("Member suspended!");
				}
			}
			return null;
		}
	
	/**
	 * Method to search for a given provider
	 * from an ArrayList of providers by number and return the provider.
	 * @param providerNum provider number
	 * @return provider number returned as a String
	 */
	public Provider providerSearch(String providerNum) {
		return providerRecords.getProvider(providerNum);
	}
	
	/**
	 * Method used to emulate the main flow of
	 * the operator logic.
	 * @param scanner used for user input
	 */
	public void OperatorTerminal(Scanner scanner) {
		String action;
		boolean edit = true;

		//PROMPT OPTIONS
		while(edit) {
			System.out.println("||---Select Update Option---||");
			System.out.println("Member Add : MA");
			System.out.println("Member Delete : MD");
			System.out.println("Member Update : MU");
			System.out.println("Provider Add : PA");
			System.out.println("Provider Delete : PD");
			System.out.println("Provider Update : PU");
			System.out.println("Exit : E");
			action = scanner.nextLine();
			
			//EXECUTE STATEMENTS BASED ON RESPONSE
			switch(action) {
				case "MA":
					insertMemberPrompt(scanner);
					break;
				case "MD":
					removeMemberPrompt(scanner);
					break;
				case "MU":
					updateMemberPrompt(scanner);
					break;
				case "PA":
					insertProviderPrompt(scanner);
					break;
				case "PD":
					removeProviderPrompt(scanner);
					break;
				case "PU":
					updateProviderPrompt(scanner);
					break;
				case "E":
					edit = false;
					break;
			}
		}	
	}
}





