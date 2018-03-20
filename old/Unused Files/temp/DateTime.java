import java.time.*;

public class DateTime {
	// PREVENT INVALID INPUT
	private int numberDay; // Day of year (1-366)
	private int month; // 1-12
	private int dayOfMonth; // 1-31
	private int dayOfWeek; // 1-7 M-Sun
	private int year;
	private int hour;
	private int minute;
	private int second;
	private LocalDateTime LDT;
	
	DateTime() {
		numberDay = -1;
		month = -1;
		dayOfMonth = -1;
		dayOfWeek = -1;
		year = -1;
		hour = -1;
		minute = -1;
		second = -1;
	}
	
	void setToCurrentDateTime() {
		setNumberDay(LDT.getDayOfYear());
		setMonth(LDT.getMonthValue());
		setDayOfMonth(LDT.getDayOfMonth());
		setDayOfWeek(LDT.getDayOfWeek()); //check to make sure this works as this returns enum, not int. check functions below as well
		setYear(LDT.getYear());
		setHour(LDT.getHour());
		setMinute(LDT.getMinute());
		setSecond(LDT.getSecond());
	}
	
	void setNumberDay(int a) {
		numberDay = a;
	}
	
	void setMonth(int a) {
		month = a;
	}
	
	void setDayOfMonth(int a) {
		dayOfMonth = a;
	}
	
	void setDayOfWeek(int a) {
		dayOfWeek = a;
	}
	
	void setYear(int a) {
		year = a;
	}
	
	void setHour(int a) {
		hour = a;
	}
	
	void setMinute(int a) {
		minute = a;
	}
	
	void setSecond(int a) {
		second = a;
	}
	
	int getNumberDay() {
		return numberDay;
	}
	
	int getMonth() {
		return month;
	}
	
	int getDayOfMonth() {
		return dayOfMonth;
	}
	
	int getDayOfWeek() {
		return dayOfWeek;
	}
	
	int getYear() {
		return year;
	}
	
	int getHour() {
		return hour;
	}
	
	int getMinute() {
		return minute;
	}
	
	int getSecond() {
		return second;
	}
	
	void printDate() {
		if (month == -1 || dayOfMonth == -1 || year == -1) {system.out.println("Invalid date"); return;}
		if (month < 10) system.out.println("0");
		system.out.println(month + "-");
		if (dayOfMonth < 10) system.out.println("0");
		system.out.println(dayOfMonth + "-");
		system.out.println(year);
	}
	
	void printTime() {
		if (hour == -1 || minute == -1 || second == -1) {system.out.println("Invalid time"); return;}
		if (hour < 10) system.out.println("0");
		system.out.println(hour + ":");
		if (minute < 10) system.out.println("0");
		system.out.println(minute + ":");
		if (second < 10) system.out.println("0");
		system.out.println(second);
	}
	
	void printDateTime() {
		if (month == -1 || dayOfMonth == -1 || year == -1 || hour == -1 || minute == -1 || second == -1) {system.out.println("Invalid date/time"); return;}
		printDate();
		system.out.println(" ");
		printTime();
	}
}