package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) throws DateException{
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	
	public void setDay(int day) throws DateException{
		if(day < 1 || day > this.daysOfMonth()){
			throw new DateException("Date error. Day must be between 1 and " + daysOfMonth());
		}else{
			this.day = day;
		}	
	}
	public void setMonth(int month) throws DateException {
		if(month < 1 || month > 12) {
			throw new DateException("Date error. Month must be between 1 and 12");
		}else {
			this.month = month;
		}
	}
	
	public void setYear (int year) {
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean isSameYear(Date today) {
		/*if(this.year == today.getYear()) {
			return true;
		}else {
			return false;
		}*/
		
		return(this.year == today.getYear());
		 
	}
	
	public boolean isSameMonth(Date today) {		
		/*if(this.month == today.getMonth()) {
			return true;
		}else {
			return false;
		}*/
		
		return(this.month == today.getMonth());
	}
	
	public boolean isSameDay(Date today) {
		/*if(this.day == today.getDay()) {
			return true;
		}else {
			return false;
		}*/
		
		return(this.day == today.getDay());
	}
	
	public boolean isSame(Date today) {
		/*if(this.isSameDay(today) && this.isSameMonth(today) && this.isSameYear(today)) {
			return true;
		}else {
			return false;
		}*/
		
		return (this.isSameDay(today) && this.isSameMonth(today) && this.isSameYear(today));
	}
	
	public String getMonthName() {
		String nameMonth = null;

		switch (this.month){
			case 1:
				nameMonth = "January";
				break;
			case 2:
				nameMonth = "February";
				break;
			case 3:
				nameMonth = "March";
				break;
			case 4:
				nameMonth = "April";
				break;
			case 5:
				nameMonth = "May";
				break;
			case 6:
				nameMonth = "June";
				break;
			case 7:
				nameMonth = "July";
				break;
			case 8:
				nameMonth = "August";
				break;
			case 9:
				nameMonth = "September";
				break;
			case 10:
				nameMonth = "October";
				break;
			case 11:
				nameMonth = "November";
				break;
			case 12:
				nameMonth = "December";
				break;
		}
		
		return nameMonth;
	}
}
