package project4;

import java.time.*;
import java.util.*;

/**
* DateTime is able to store and return dates and times. 
* These can be manually set or automatically set to the current date and time. T
* The date, time, or both can also be printed out.
* 
* @author Hunter Kimbrell
* @version 1.0
*/

public class DateTime {
	
	private int numberDay; // Day of year (1-366)
	private int month; // 1-12
	private int dayOfMonth; // 1-31
	private int dayOfWeek; // 1-7 M-Sun
	private int year; // 0+
	private int hour; // 0-59
	private int minute; // 0-59
	private int second; // 0-59
	private LocalDateTime LDT;

	/**
	 * Default constructor. Variables initialized to an invalid value (-1).
	 */
	public DateTime() { 
		numberDay = -1;
		month = -1;
		dayOfMonth = -1;
		dayOfWeek = -1;
		year = -1;
		hour = -1;
		minute = -1;
		second = -1;
		LDT = LocalDateTime.now();
	}
	
	/**
	 * Sets all fields to be the current values for the local date and time.
	 */
	public void setToCurrentDateTime() {
		LDT = LocalDateTime.now();
		setNumberDay(LDT.getDayOfYear());
		setMonth(LDT.getMonthValue());
		setDayOfMonth(LDT.getDayOfMonth());
		setDayOfWeek(LDT.getDayOfWeek().ordinal());
		setYear(LDT.getYear());
		setHour(LDT.getHour());
		setMinute(LDT.getMinute());
		setSecond(LDT.getSecond());
	}
	
	/**
	 * Sets numberDay.
	 * @param a day of the year
	 */
	public void setNumberDay(int a) {
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Day of year must be positive.");
		}
		// Checks to ensure the value is 366 or less
		if (a > 366) {
			throw new NumberFormatException("Day of year must be 366 or less.");
		}
		numberDay = a;
	}

	/**
	 * Sets month.
	 * @param a month of the year
	 */
	public void setMonth(int a) {
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Month must be positive.");
		}
		// Checks to ensure the value is 12 or less
		if (a > 12) {
			throw new NumberFormatException("Month must be 12 or less.");
		}
		
		month = a;
	}

	/**
	 * Sets dayOfMonth.
	 * @param a day of the month
	 */
	public void setDayOfMonth(int a) {
		// If the month is 2 (February), accepts the inputed value if it is positive and less than or equal to 28
		if ((getMonth() == 2) && (a > 0) && (a <= 28)) {
			dayOfMonth = a;
		}
		// Else for the given months, accepts the inputed value if it is positive and less than or equal to 30
		else if (((getMonth() == 9) || (getMonth() == 4) || (getMonth() == 6) || (getMonth() == 11)) && (a > 0) && (a <= 30)) {
			dayOfMonth = a;
		}
		// Else accepts the inputed value if it is positive and less than or equal to 31
		else if ((a <= 31) && (a > 0)) {
			dayOfMonth = a;
		}
		// throws an exception otherwise
		else {
			throw new NumberFormatException("Day of month must be positive and less than 28, 30, or 31.");
		}
	}

	/**
	 * Sets dayOfWeek.
	 * @param a day of the week
	 */
	public void setDayOfWeek(int a) {
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Day of week must be positive.");
		}
		// Checks to ensure the value is 7 or less
		if (a > 7) {
			throw new NumberFormatException("Day of week must be 7 or less.");
		}
		
		dayOfWeek = a;
	}

	/**
	 * Sets year.
	 * @param a year
	 */
	public void setYear(int a) {
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentYear = gcalendar.get(Calendar.YEAR);
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Year must be positive.");
		}
		// Checks to ensure the value is not greater than the current year
		if (a > currentYear) {
			throw new NumberFormatException("Incorrect year");
		}
		
		year = a;
	}

	/**
	 * Sets hour.
	 * @param a hour of the day
	 */
	public void setHour(int a) {
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Hour must be positive.");
		}
		// Checks to ensure the value is less than 60
		if (a >= 60) {
			throw new NumberFormatException("Hour must be less than 60.");
		}
		
		hour = a;
	}

	/**
	 * Sets minute.
	 * @param a minute of the given hour
	 */
	public void setMinute(int a) {
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Minute must be positive.");
		}
		// Checks to ensure the value is less than 60
		if (a >= 60) {
			throw new NumberFormatException("Minute must be less than 60.");
		}
		
		minute = a;
	}

	/**
	 * Sets second.
	 * @param a second for current minute and hour
	 */
	public void setSecond(int a) {
		// Checks to ensure the value is positive
		if (a < 0) {
			throw new NumberFormatException("Second must be positive.");
		}
		// Checks to ensure the value is less than 60
		if (a >= 60) {
			throw new NumberFormatException("Second must be less than 60.");
		}
		
		second = a;
	}

	/**
	 * Gets numberDay.
	 * @return day of the year
	 */
	public int getNumberDay() {
		return numberDay;
	}

	/**
	 * Get month.
	 * @return month of the year
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets dayOfMonth.
	 * @return day of the month
	 */
	public int getDayOfMonth() {
		return dayOfMonth;
	}

	/**
	 * Gets dayOfWeek
	 * @return day of the week
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * Gets year.
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Gets hour.
	 * @return hour of the day
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Gets minute.
	 * @return minute of the given hour
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * Gets second.
	 * @return second for current minute and hour
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * Prints the date in the format MM-DD-YYYY.
	 */
	public void printDate() {
		// Checks to ensure the values are valid
		if (month < 1 || month > 12 || dayOfMonth < 1 || dayOfMonth > 31 || year < 1) {
			System.out.println("Invalid date");
			return;
		}
		// Ensures the output is in the format MM
		if (month < 10) {
			System.out.print("0");
		}
		System.out.print(getMonth() + "-");
		// Ensures the output is in the format DD
		if (dayOfMonth < 10) { 
			System.out.print("0");
		}
		System.out.print(getDayOfMonth() + "-");
		System.out.print(getYear());
	}

	/**
	 * Prints the time in the format HH:MM:SS.
	 */
	public void printTime() {
		// Checks to ensure the values are valid
		if (hour < 0 || hour > 24 || minute < 0 || minute > 59 ||  second < 0 || second > 59) {
			System.out.println("Invalid time"); 
			return;
		}
		// Ensures the output is in the format HH
		if (hour < 10) { 
			System.out.print("0");
		}
		System.out.print(getHour() + ":");
		// Ensures the output is in the format MM
		if (minute < 10) {
			System.out.print("0");
		}
		System.out.print(getMinute() + ":");
		// Ensures the output is in the format SS
		if (second < 10) {
			System.out.print("0");
		}
		System.out.print(getSecond());
	}

	/**
	 * Prints the date and the time in the format MM-DD-YYYY HH:MM:SS.
	 */
	public void printDateTime() {
		printDate();
		System.out.print(" ");
		printTime();
	}
}