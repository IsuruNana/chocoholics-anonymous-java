package project4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BackUpFunctionFile {

	/*
	 * public void updateMemberDetails(Member member, HashMap<String, String> data) {
		for (String key : data.keySet()){
			//iterate over key

			//System.out.println(key+" "+dataValue);
			switch(key) {
			case "name": 
				member.setName(data.get(key));
				break;

			case "address": 
				member.setAddress(data.get(key));
				break;

			case "city": 
				member.setCity(data.get(key));
				break;

			case "state": 
				member.setState(data.get(key));
				break;

			case "zipcode": 
				member.setZipcode(data.get(key));
				break;

			case "number": 
				member.setNumber(data.get(key));
				break;
			default :
				break;
			}
		}
	}

	public void updateProviderDetails(Provider provider, HashMap<String, String> data) {
		for (String key : data.keySet()){
			//iterate over key

			//System.out.println(key+" "+dataValue);
			switch(key) {
			case "name": 
				provider.setName(data.get(key));
				break;

			case "address": 
				provider.setAddress(data.get(key));
				break;

			case "city": 
				provider.setCity(data.get(key));
				break;

			case "state": 
				provider.setState(data.get(key));
				break;

			case "zipcode": 
				provider.setZipcode(data.get(key));
				break;

			case "number": 
				provider.setNumber(data.get(key));
				break;
			default :
				break;
			}
		}
	}
	
	
	
	
	//---------------------------------------------------------------//
	
	public static void OperatorEdit(Scanner scanner,
									MemberRecords memberRecords,
									ProviderRecords providerRecords){
	
	System.out.println("Edit Members or Providers?");
	System.out.println("Members: M");
	System.out.println("Providers: P");
	System.out.println("Exit: E\n\n");

	boolean edit = true;
	boolean memberEdit = false;
	boolean updateMember = false;
	boolean providerEdit = false;
	boolean updateProvider = false;
	String toUpdate = "no one";
	String action = "hey";
	String choice;
	String whichUpdate;
	String member;
	String provider;
	String updateValue;
	
	HashMap<String, String> dataMap = new HashMap<String, String>();
	
	//.put("name", "Hunter");
	action = scanner.next();
	
	while (edit) {
		
		switch(action) {
		
			case "M" : {
				memberEdit = true;
				while (memberEdit) {
					System.out.println("Add, remove, or update members?");
					System.out.println("Add: A");
					System.out.println("Remove: R");
					System.out.println("Update: U");
					System.out.println("Exit: E\n\n");
					memberEdit = true;
					choice = scanner.next();
					switch(choice) {
				
						case "A" : {
							System.out.println("Enter new member data:");
						}
			
						case "R" : {
							System.out.println("Enter member to delete:");
						}
			
						case "U" : {
							member = "-1";
							while (memberRecords.getMember(member) == null) {
								System.out.println("Select a member to update:");
								member = scanner.next();
								if(memberRecords.getMember(member) == null) {
									System.out.println("Invalid member, try again.");
								}
							}
							
							System.out.println("Select data to update:");
							System.out.println("Name: N");
							System.out.println("Address: A");
							System.out.println("City: C");
							System.out.println("State: S");
							System.out.println("Zipcode: Z");
							System.out.println("Member Number: M");
							System.out.println("Exit: E");
							updateMember = true;
							whichUpdate = scanner.next();
							while (updateMember) {
								switch(whichUpdate) {
								
									case "N" : {
										System.out.println("Enter new name:");
									}
								
									case "A" : {
										System.out.println("Enter new address:");
									}
								
									case "C" : {
										System.out.println("Enter new city:");
									}
								
									case "S" : {
										System.out.println("Enter new state:");
									}
								
									case "Z" : {
										System.out.println("Enter new address:");
									}
								
									case "M" : {
										System.out.println("Enter new member number:");
									}
								
									case "E" : {
										System.out.println("Exiting...");
										updateMember = false;
									}
						
								
								}
							}
						}
						
						case "E" : {
							System.out.println("Exiting...");
							memberEdit = false;
						}
			
					}
				}
			}
			
			case "P" : {
				providerEdit = true;
				while (providerEdit) {
					System.out.println("Add, remove, or update providers?");
					System.out.println("Add: A");
					System.out.println("Remove: R");
					System.out.println("Update: U");
					System.out.println("Exit: E\n\n");
					memberEdit = true;
					choice = scanner.next();
					switch(choice) {
				
						case "A" : {
							System.out.println("Enter new provider data:");
						}
			
						case "R" : {
							System.out.println("Enter provider to delete:");
						}
			
						case "U" : {
							provider = "-1";
							while (providerRecords.getProvider(provider) == null) {
								System.out.println("Select a provider to update:");
								provider = scanner.next();
								if(providerRecords.getProvider(provider) == null) {
									System.out.println("Invalid provider, try again.");
								}
							}
							
							System.out.println("Select data to update:");
							System.out.println("Name: N");
							System.out.println("Address: A");
							System.out.println("City: C");
							System.out.println("State: S");
							System.out.println("Zipcode: Z");
							System.out.println("Provider Number: M");
							System.out.println("Exit: E");
							updateMember = true;
							whichUpdate = scanner.next();
							while (updateProvider) {
								switch(whichUpdate) {
								
									case "N" : {
										System.out.println("Enter new name:");
										dataMap.put("name", scanner.next());
									}
								
									case "A" : {
										System.out.println("Enter new address:");
										dataMap.put("address", scanner.next());
									}
								
									case "C" : {
										System.out.println("Enter new city:");
										dataMap.put("city", scanner.next());
									}
								
									case "S" : {
										System.out.println("Enter new state:");
										dataMap.put("state", scanner.next());
									}
								
									case "Z" : {
										System.out.println("Enter new zipcode:");
										dataMap.put("zipcode", scanner.next());
									}
								
									case "M" : {
										System.out.println("Enter new provider number:");
										dataMap.put("number", scanner.next());
									}
								
									case "E" : {
										System.out.println("Exiting...");
										updateProvider = false;
									}
						
								
								}
							}
							
							if(dataMap.size() > 0) {
								operator.updateProviderDetails(provider, dataMap);
								dataMap.clear();
							}
						}
						
						case "E" :{
							System.out.println("Exiting...");
							providerEdit = false;
						}
			
					}
				}
			}
		
			case "E" :{
				System.out.println("Exiting...");
				edit = false;
			}
		}
	}
	}
	
	
	
	
	
BILL CHOC AN

package project4;

public class BillChocAn {
    private int serviceCode;
    private DateTime serviceDate;
    private DateTime transactionTime;
    private Member theMember;
    private double fee;
    private TransactionRecord theRecord;
    private int[] validCodes;
    
    public BillChocAn() {
        //DEFAULT CONSTRUCTOR
    	validCodes = new int[1000000];
    }
    
    public void setServiceCode(int servCode) {
        serviceCode = servCode;
    }
    
    public boolean checkValidCode(int correctCode) {
        if(serviceCode == correctCode) {
        	return true;
        }
        else {
        	return false;
        }
    }
    
    // Inserted boolean variable to remove return type error
    public boolean verifyServiceName() {
    	boolean correct = false;
    
    	return correct;
    }
    
    public void inputComments(String comments) {
        theRecord.setComments(comments);
    }
    
    public void inputCurrentDateTime(DateTime dateTime) {
        serviceDate = dateTime;
    }
    
    public void inputMemberName(String n) {
    	theMember.setName(n);
    }
    
    public void inputMemberPIN(String pin) {
        theMember.setNumber(pin);
    }
    
    public double lookupFee() {
        return fee;
    }
    
    public void printFee() {
        System.out.println(fee);
    }
    
    public TransactionRecord getRecord() {
        return theRecord;
    }
    
    public void generateTransactionRecord() {
    	
    }
}	
	
	//-------------OLD TERMINAL------------------//
	 * 
	 * public static String masterPrompt(Scanner questions) {
		System.out.println("Are you an Operator, Provider or Manager?");
		System.out.println("Operator: O");
		System.out.println("Provider: P");
		System.out.println("Manager: M");
		System.out.println("Exit: E");
		String answer = "nothing";
		
		answer = questions.nextLine();
		
		return answer;
	}
	
	public static String questionPrompt(Scanner questions) {
		System.out.println("Which service do you require?");
		System.out.println("Request service: R");
		System.out.println("Bill Member: B");
		System.out.println("Exit: E");
		String answer = "nothing";
		
		answer = questions.nextLine();
		
		return answer;
	}
	
	public static String promptNumber(Scanner reader, String type) { //Make sure to enter a 9-digit number
		String userID;
		System.out.println("Enter " + type + " number: ");
		
		userID  = reader.nextLine(); 
		
		while (userID.length() != 9) {
			System.out.println("Invalid " + type + " Number.\nEnter another number: ");
			userID = reader.nextLine();
		}
		
		return userID;
	}
	
	public static DateTime promptDate(Scanner reader) { 
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
		
		System.out.println("Enter month (YYYY):");
		year = reader.nextInt();
		dt.setYear(year);
		
		reader.nextLine();
		
		return dt;
	}
	
	public static Provider providerLogin(Scanner reader, ProviderRecords records) {
		String providerNum;
		int providerIndex = -1;
	
		while(providerIndex == -1) {
			providerNum = promptNumber(reader, "Provider");
			providerIndex = records.getRecordIndex(providerNum); //Check if provider exists
			
			if(providerIndex == -1) {
				System.out.println("Error provider not found. Please Try again.");
			}
		}
		
		return records.get(providerIndex);
	}
	
	public static Member memberLogin(Scanner reader, MemberRecords records) {
		String memberNum;
		int memberIndex = -1;
	
		while(memberIndex == -1) {
			memberNum = promptNumber(reader, "Member");
			memberIndex = records.getRecordIndex(memberNum); //Check if member exists
			
			if(memberIndex == -1) {
				System.out.println("Error member not found. Please Try again.");
			}
		}
		
		return records.getMember(memberIndex);
	}
	
	public static int promptService(Scanner scanner, 
									Provider provider,
									ArrayList<Service> providerDirectory) {

			String serviceCode;
			// FIXME Shouldn't use conditional check below to check for serviceIndex = -1. Automatically triggers
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
	
	public static int validateService(Scanner scanner,
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
	
	public static void requestServiceCase(Scanner scanner,
										 Provider activeProvider,
										 MemberRecords memberRecords,
										 ArrayList<Service> providerDirectory) {
		int serviceNum;
		Member activeMember = memberLogin(scanner, memberRecords);
		
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
	
	public static void billMemberCase(Scanner scanner,
										 Provider activeProvider,
										 MemberRecords memberRecords,
										 ArrayList<Service> providerDirectory) {
		
		Member activeMember = memberLogin(scanner, memberRecords);
		String comments;
		
		//Member login
		if(activeMember.getStatus().equals("valid")) { //Validate member
			System.out.println("Validated");
			
			int size = activeMember.getMemberTransactionSize();
			if(size == 0) {
				 System.out.println("No services were billed.");
				 return;
			}
			TransactionRecord current;
			String serviceName;
			for(int i = 0; i < size; i++) { //For each service in member.
				//BILL STUFF
				
				//Get Transaction Record
				current = activeMember.getMemberTransactionRecord(i);
				//Manual type of Date
				current.setServiceDate(promptDate(scanner));
				current.setCurrentDateTime();
				
				serviceName = current.getService().getServiceName();
				
				//Prompt service
				// FIXME Correct later-return type
			    promptService(scanner, activeProvider, providerDirectory);
				
				//Enter comments
			    
			    System.out.println("Enter any additional comments:");
			    
			    comments = scanner.nextLine();
			    
			    current.setComments(comments);
				
				System.out.println(current.getService().getServiceFee());
				//At the end remove the service because it has been billed
				activeMember.removeTransactionRecord(i);
			}
		}
	}
	
	//Transaction tests
	
	/*		TransactionRecord t1 = new TransactionRecord();
		TransactionRecord t2 = new TransactionRecord();
		TransactionRecord t3 = new TransactionRecord();
		TransactionRecord t4 = new TransactionRecord();
		TransactionRecord t5 = new TransactionRecord();
		TransactionRecord t6 = new TransactionRecord();
		t1.setMember(memberAlice);
		t2.setMember(memberClark);
		t3.setMember(memberSanta);
		t4.setMember(memberAlice);
		t5.setMember(memberClark);
		t6.setMember(memberSanta);
		t1.setProvider(providerAlex);
		t2.setProvider(providerBob);
		t3.setProvider(providerJim);
		t4.setProvider(providerAlex);
		t5.setProvider(providerBob);
		t6.setProvider(providerJim);
		DateTime testDateTime = new DateTime();
		testDateTime.setToCurrentDateTime();
		t1.setCurrentDateTime();
		t2.setCurrentDateTime();
		t3.setCurrentDateTime();
		t4.setCurrentDateTime();
		t5.setCurrentDateTime();
		t6.setCurrentDateTime();
		t1.setServiceDate(testDateTime);
		t2.setServiceDate(testDateTime);
		t3.setServiceDate(testDateTime);
		t4.setServiceDate(testDateTime);
		t5.setServiceDate(testDateTime);
		t6.setServiceDate(testDateTime);
		t1.setService(dietitianSession);
		t2.setService(aerobicsExercise);
		t3.setService(insulinTreatments);
		t4.setService(dietitianSession);
		t5.setService(aerobicsExercise);
		t6.setService(insulinTreatments);
		transactionArray.add(t1);
		transactionArray.add(t2);
		transactionArray.add(t3);
		transactionArray.add(t4);
		transactionArray.add(t5);
		transactionArray.add(t6);*/
//		int i = 0;
//		while (i < 3) {System.out.println("" + transactionArray.get(i).getProvider().getName()); i = i + 1;}
/*		EFT testEFT = new EFT(transactionArray);
		testEFT.initiateEFT();
		System.out.println("\n");
		SummaryReport summaryReport = new SummaryReport(transactionArray);
		summaryReport.initiateSummaryReport();
		int memberCounter = 0;
		while (memberCounter < memberRecords.getSize()) {
			MemberReport.printMemberReport(memberRecords.getMember(memberCounter), transactionArray);
			System.out.println("");
			memberCounter = memberCounter + 1;
		}
		int providerCounter = 0;
		while (providerCounter < providerRecords.getSize()) {
			ProviderReport.printProviderReport(providerRecords.get(providerCounter), transactionArray);
			System.out.println("");
			providerCounter = providerCounter + 1;
		}*/
		
		// Sorts providerDirectory alphabetically
	
	/*public static void printMemberReport(Member toPrint, ArrayList<TransactionRecord> transactions) {
	System.out.println("Member Name: " + toPrint.getName());
	System.out.println("Member Number: " + toPrint.getNumber());
	System.out.println("Street Address: " + toPrint.getAddress());
	System.out.println("City: " + toPrint.getCity());
	System.out.println("State: " + toPrint.getState());
	System.out.println("ZIP Code: " + toPrint.getZipcode());
	System.out.println("\nTransactions: \n");

	String memberNum = toPrint.getNumber();
	int a = 0;

	while (a < transactions.size()) {
		if ((memberNum == transactions.get(a).getMember().getNumber())) {
			System.out.print("Received (" + transactions.get(a).getService().getServiceName() + ") ");
			System.out.print("from (" + transactions.get(a).getProvider().getName() + ") ");
			System.out.print("on (");
			transactions.get(a).getServiceDate().printDate();
			System.out.println(")");
		}	
		a = a + 1;
	}
}*/
	
	// Hunter's stuff
	//Hunters section
			/*boolean completedMaintenance = false;
			while (true) { //FIXME make condition make sense
				if ((Timer.checkFridayMidnight()) && (completedTask == false)) {
					EFT theEFT = new EFT(transactionArray);
					theEFT.initiateEFT();
					int memberCounter = 0;
					while (memberCounter < memberRecords.getSize()) {
						MemberReport.printMemberReport(memberRecords.get(memberCounter), transactionArray);
						System.out.println("");
						memberCounter = memberCounter + 1;
					}
					int providerCounter = 0;
					while (providerCounter < providerRecords.getSize()) {
						ProviderReport.printProviderReport(providerRecords.get(providerCounter), transactionArray);
						System.out.println("");
						providerCounter = providerCounter + 1;
					}
					SummaryReport summaryReport = new SummaryReport(transactionArray);
					summaryReport.initiateSummaryReport();
					transactionRecords.clear(); //Clear the arraylist
					completedMaintenance = true;
				}
				if (Timer.checkMonday()) {
					completedMaintenance = false;
				}
			}
			
			System.out.println("Which report would you like to be generated?\nMember - M\tProvider - P\tEFT - E\tSummary - S");
			response = scanner.next();
			switch(response) {
				case "M" :
					int memberCounter = 0;
					while (memberCounter < memberRecords.getSize()) {
						MemberReport.printMemberReport(memberRecords.get(memberCounter), transactionArray);
						System.out.println("");
						memberReport = memberReport + 1;
					}
					break;
				case "P" :
					int providerCounter = 0;
					while (providerCounter < providerRecords.getSize()) {
						ProviderReport.printProviderReport(providerRecords.get(providerCounter), transactionArray);
						System.out.println("");
						providerCounter = providerCounter + 1;
					}
					break;
				case "E" :
					EFT theEFT = new EFT(transactionArray);
					theEFT.initiateEFT();
					break;
				case "S" :
					SummaryReport summaryReport = new SummaryReport(transactionArray);
					summaryReport.initiateSummaryReport();
					break;
				default :
					System.out.println("Invalid input. Please try again.");
					break;
			}*/
	
	
}
