package project4;

import java.util.ArrayList;

/**
 * MemberReport outputs the report of a member's transactions to file. This is done with a selected member
 * and the list of transaction record
 * 
 * @version 2.0
 * 
 * @author Richard Rice
 */

public class MemberReport {

	/**
	 * Method that prints a member report
	 * for the given member
	 * @param member member to be printed
	 * @param transactions ArrayList of transaction records
	 */
	public static void printMemberReport(Member member, ArrayList<TransactionRecord> transactions) {
		
		//Print all member details
		System.out.println("||~~~~~Printing member~~~~~||");
		member.printMemberDetails();
		
		//Print Transaction Details
		System.out.println("||----Transactions----||");
		String memberNum = member.getNumber();
		
		//Throws exception if there are no transactions
		if (transactions.size() < 0) {
			throw new NumberFormatException("There are no transactions found");
		}
		
		//Find and print each transaction involving member
		for(int i = 0;  i < transactions.size(); i++) {
			if ((memberNum.equals(transactions.get(i).getMember().getNumber()))) {
				transactions.get(i).printTransactionRecordMember();
			}
		}	
		//Adds space between report and the terminal menu
		System.out.println("\n");
	}
}