package project4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
* EFT accepts an ArrayList of type TransactionRecord,
* sorts the array, and then traverses the array, 
* making necessary output for the EFT.
*
* @author Hunter Kimbrell
* @version 1.0
*/

public class EFT {
	private ArrayList<TransactionRecord> transactionArray = new ArrayList<TransactionRecord>();
	private double tempMoney;
	
	/**
	 * Comparator that compares two Strings.
	 */
	public static Comparator<TransactionRecord> proNum = new Comparator<TransactionRecord>() {
		public int compare(TransactionRecord t1, TransactionRecord t2) {
			String num1 = t1.getProvider().getNumber();
			String num2 = t2.getProvider().getNumber();			
			return num1.compareTo(num2);
		}
	};

	/**
	 * Constructor.
	 * @param array array of transaction records
	 */
	public EFT(ArrayList<TransactionRecord> array) {
		tempMoney = 0;
		int a = 0;
		while (a < array.size()) {
			transactionArray.add(a,array.get(a));
			a++;
		}
	}

	/**
	 * Method that sorts an array, then traverses
	 * the array and prints it out.
	 */
	public void initiateEFT() {
		sortArrayByProviderNumber();
		System.out.println("\n||~~~~~EFT~~~~~||");
		traverseArray();
	}
	
	/**
	 * Method that sorts the transactionArray alphabetically.
	 */
	public void sortArrayByProviderNumber() {
		Collections.sort(transactionArray, EFT.proNum);
	}

	/**
	 * Method that traverses the transactionArray and prints the
	 * EFT information.
	 */
	public void traverseArray() {
		String tempNum = transactionArray.get(0).getProvider().getNumber();
		String tempName = transactionArray.get(0).getProvider().getName();
		writeProvider(tempName, tempNum);
		int a = 0;
		
		while (a < transactionArray.size()) {
			tempNum = transactionArray.get(a).getProvider().getNumber();
			tempName = transactionArray.get(a).getProvider().getName();
			if (a > 0) {
				if ((tempNum != (transactionArray.get(a-1).getProvider().getNumber())) && (a > 0)) {
					writeAmountDue(tempMoney);
					writeProvider(tempName, tempNum);
					tempMoney = transactionArray.get(a).getService().getServiceFee();
				}
				else {
					tempMoney = tempMoney + transactionArray.get(a).getService().getServiceFee();
				}
			}
			else tempMoney = tempMoney + transactionArray.get(a).getService().getServiceFee();
			a = a + 1;
		}
		writeAmountDue(tempMoney);
	}

	/**
	 * Method that prints out the provider's information
	 * in the format given below.
	 * @param a provider name
	 * @param b provider number
	 */
	public void writeProvider(String a, String b) {
		System.out.print("" + a + "(" + b + ")");
	}

	/**
	 * Method that prints fee in given format.
	 * @param a service fee
	 */
	public void writeAmountDue(double a) {
		System.out.print(" - $");
		System.out.printf("%.2f\n", a);
	}
}