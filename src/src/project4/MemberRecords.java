package project4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * The MemberRecords class implements the class which contains the member records.
 * It contains the setters, getters, for the field member, which is of type member,
 * it also includes getters for the fields size and recordIndex, which is are ints.
 * It also implements a constructor method as well as
 * methods to get validMember as well as compare two members.
 * 
 * @author Robert Bartnett
 * @version 1.0
 */

public class MemberRecords {
	private ArrayList<Member> memberDetails;
	
	/**
	 * Constructor that initializes memberDetails.
	 */
	public MemberRecords(){
		memberDetails = new ArrayList<Member>();
	}

	/**
	 * Method that adds member to the ArrayList of members.
	 * @param member member added
	 */
	public void addMember(Member member){
		memberDetails.add(member);
	}

	/**
	 * Returns member at current index in ArrayList of members.
	 * @param memberIndex index for the member
	 * @return member at current index
	 */
	public Member getMember(int memberIndex) {
		if((memberIndex < 0) || (memberIndex >= memberDetails.size())){
			return null;	
		}
		
		return memberDetails.get(memberIndex);
	}
	
	/**
	 * Returns member at current index based on member number in ArrayList of members.
	 * @param memberNum member number
	 * @return member with given member number
	 */
	public Member getMember(String memberNum){
		int i = getRecordIndex(memberNum);
		if(i != -1) {
			return memberDetails.get(i);
		}
		else {
			return null;
		}	
	}

	/**
	 * Method that removes the member from ArrayList of member records
	 * @param member member to remove
	 */
	public void removeMember(Member member) {
		memberDetails.remove(member);
	}

	/**
	 * Method that removes the member
	 * at the given index in the ArrayList of member records.
	 * @param i index of member to be removed
	 */
	public void removeMember(int i) {
		memberDetails.remove(i);
	}

	/**
	 * Returns size of ArrayList of member records.
	 * @return size of the ArrayList for members
	 */
	public int getSize() {
		return memberDetails.size();
	}
	
	/**
	 * Method that searches using the member number
	 * and returns the index of the member.
	 * @param number member number
	 * @return index of member in ArrayList of member records
	 */
	public int getRecordIndex(String number) {
		Member m1 = new Member(number);
		Member m2 = new Member();
		
		int size = memberDetails.size();
		
		for (int i = 0; i < size; ++i) {
			m2 = memberDetails.get(i);
			
			if (compare(m1, m2)) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Method that returns the specified member
	 * or "E" if there is not a valid member.
	 * @param scanner used for user input
	 * @return specified member
	 */
	public Member getValidMember(Scanner scanner) {
		String memberID;
		Member member = null;
		
		while(member == null) {
			System.out.println("Enter member ID:");
			memberID = scanner.nextLine();
			if(memberID == "E") {
				break;
			}
			member = getMember(memberID);
			if(member == null) {
				System.out.println("Error try again or press E to exit");
			}
		}
		
		return member;
	}
	 
	/**
	 * Method that compares member numbers.
	 * @param m1 first member
	 * @param m2 second member
	 * @return boolean used to determine if member numbers are equal
	 */
	public boolean compare(Member m1, Member m2) {
		return m1.getNumber().equals(m2.getNumber());
	}
}
