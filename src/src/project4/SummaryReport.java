package project4;

import java.util.*;

/**
* SummaryReport accepts an ArrayList of type TransactionRecord,
* sorts the array, and then traverses the array, making 
* necessary output for the SummaryReport.
*
* @author Hunter Kimbrell
* @version 1.0
*/

public class SummaryReport {
	
	private ArrayList<TransactionRecord> transactionArray;// = new ArrayList<TransactionRecord>();
	private int individualConsultationCounter;
	private double individualFee;
	private int totalProviderCounter;
	private int totalConsultationCounter;
	private double overallFee;
	
	/**
	 * Comparator that compares two transaction records.
	 */
	public static Comparator<TransactionRecord> proNum = new Comparator<TransactionRecord>() {
		public int compare(TransactionRecord t1, TransactionRecord t2) {
			String num1 = t1.getProvider().getNumber().toUpperCase();
			String num2 = t2.getProvider().getNumber().toUpperCase();
			return num1.compareTo(num2);
		}
	};
	
	/**
	 * Constructor that takes transaction record array.
	 * @param array ArrayList of transaction records
	 */
	public SummaryReport(ArrayList<TransactionRecord> array) {
		this.transactionArray = array;
	}
	
	/**
	 * Method that sorts a given ArrayList of providers
	 * by number, then traveses this ArrayList and prints
	 * the details of each transaction. 
	 */
	public void initiateSummaryReport() {
		sortArrayByProviderNumber();
		System.out.println("\n||~~~~~Summary Report~~~~~||");
		traverseArray();
	}
	
	/**
	 * Method that sorts a list of providers by provider number.
	 */
	public void sortArrayByProviderNumber() {
		//Collections sort is stable, so the list will be ordered by Provider Number then Date
		Collections.sort(transactionArray, EFT.proNum); 
	}
	
	/**
	 * Method that traverses a given ArrayList of providers
	 * and prints the details of each transaction.
	 */
	public void traverseArray() {
		individualConsultationCounter = 0;
		totalConsultationCounter = 0;
		totalProviderCounter = 1;
		individualFee = 0;
		overallFee = 0;
		String tempNum = transactionArray.get(0).getProvider().getNumber();
		String tempName = transactionArray.get(0).getProvider().getName();
		writeProvider(tempName, tempNum);
		int a = 0;
		while (a < transactionArray.size()) {
			overallFee = overallFee + transactionArray.get(a).getService().getServiceFee();
			totalConsultationCounter = totalConsultationCounter + 1;
			tempNum = transactionArray.get(a).getProvider().getNumber();
			tempName = transactionArray.get(a).getProvider().getName();
			if (a > 0) {
				if (tempNum != (transactionArray.get(a-1).getProvider().getNumber()) && (a > 0)) {
					writeAmountDue();
					writeConsultations();
					writeProvider(tempName, tempNum);
					totalProviderCounter = totalProviderCounter + 1;
					individualFee = transactionArray.get(a).getService().getServiceFee();
					individualConsultationCounter = 1;
				}
				else {
					individualFee = individualFee + transactionArray.get(a).getService().getServiceFee();
					individualConsultationCounter = individualConsultationCounter + 1;
				}
			}
			else {
				individualFee = individualFee + transactionArray.get(a).getService().getServiceFee();
				individualConsultationCounter = individualConsultationCounter + 1;
			}
			a = a + 1;
		}
		writeAmountDue();
		writeConsultations();
		System.out.println("\nTotals for the week:");
		System.out.println("\tTotal number of providers who provided services: " + totalProviderCounter);
		System.out.println("\tTotal number of consultations: " + totalConsultationCounter);
		System.out.print("\tOverall fee: $");
		System.out.printf("%.2f\n", overallFee);
	}
	
	/**
	 * Method that prints the names of providers and their IDs.
	 * @param a provider name
	 * @param b provider number
	 */
	public void writeProvider(String a, String b) {		
		System.out.println("" + a + "(" + b + "):");		
	}
	
	/**
	 * Method that prints the fee due for each week.
	 */
	public void writeAmountDue() {		
		System.out.print("\tFee for week is $");
		System.out.printf("%.2f\n", individualFee);		
	}
	
	/**
	 * Method that displays total number of consultations
	 * for a specified provider.
	 */
	public void writeConsultations() {		
		System.out.println("\tNumber of consultations is " + individualConsultationCounter);		
	}	
}