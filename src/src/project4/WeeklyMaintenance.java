package project4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;

/**
 * WeeklyMaintenance performs weekly
 * maintenance by printing a number of various
 * reports upon a timer reaching Friday
 * at midnight. This extends class TimerTask.
 * 
 * @version 1.0
 * 
 * @author Isuru Nanayakkara
 */

public class WeeklyMaintenance extends TimerTask {
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;
	private ArrayList<TransactionRecord> transactionArray;
	private Date curr;
	private boolean printOnce = true;
	
	/**
	 * Constructor that takes providerRecords,
	 * memberRecords, and transaction.
	 * @param providerRecords ArrayList of provider records 
	 * @param memberRecords ArrayList of member records
	 * @param transactionArray ArrayList of transaction records
	 */
	public WeeklyMaintenance(ProviderRecords providerRecords, MemberRecords memberRecords, ArrayList<TransactionRecord> transactionArray) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
		this.transactionArray = transactionArray;
	}
	
	/**
	 * Method that prints the details of the
	 * members on record.
	 */
	public void printMR() {
		int memberCounter = 0;
		while (memberCounter < memberRecords.getSize()) {
			MemberReport.printMemberReport(memberRecords.getMember(memberCounter), transactionArray);
			System.out.println("");
			++memberCounter;
		}
	}
	
	/**
	 * Method that prints the details of the
	 * providers on record.
	 */
	public void printPR() {
		int providerCounter = 0;
		while (providerCounter < providerRecords.getSize()) {
			ProviderReport.printProviderReport(providerRecords.getProvider(providerCounter), transactionArray);
			System.out.println("");
			++providerCounter;
		}
	}
	
	/**
	 * Method that overrides the run method
	 * to implement timer functionality mentioned above.
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub
		curr = new Date();
		
		if(curr.getDay() == 6 && 
			curr.getHours() == 0 &&
			curr.getMinutes() == 0 &&
			curr.getSeconds() == 0 && printOnce){
				
			    //Generate reports
				printMR();
				printPR();
				
				if (transactionArray.size() > 0) {
					SummaryReport summaryReport = new SummaryReport(transactionArray);
					EFT testEFT = new EFT(transactionArray);
					summaryReport.initiateSummaryReport();
				}
				
				printOnce = false;
			}
		else if(curr.getSeconds() != 0 && !printOnce) {
			printOnce = true;
		}
	}

}
