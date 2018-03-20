import 200project.DateTime //make this work so can use DateTime

public class Timer {
	
	private DateTime theDateTime = new DateTime();
	
	boolean checkFridayMidnight(){
		theDateTime.setToCurrentDateTime();
		if ((theDateTime.getDayOfWeek() == 6) && (theDateTime.getHour() == 0)) {
			initiateWeeklyMaintenance();
			return true;
		}
		else return false;
	}
	
	void initiateWeeklyMaintenance() { //This needs to make calls to functions within 5 other classes
		clearOldTransactionRecords();
		initiateEFT();
		initiateMemberReport();
		initiateProviderReport();
		initiateSummaryReport();
	}
	
	void clearOldTransactionRecords() {
		
	}
	
	void initiateEFT() {
		
	}
	
	void initiateMemberReport() {
		
	}
	
	void initiateProviderReport() {
		
	}
	
	void initiateSummaryReport() {
		
	}
	
}