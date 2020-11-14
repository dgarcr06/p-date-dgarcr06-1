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
	
	public boolean dayRight() {
		return (this.day > 0 && this.day <= this.daysOfMonth(this.month));
	}
	
	public int daysOfMonth() {
		return this.daysOfMonth(this.month);
	}
	
	private int daysOfMonth(int month) {
		int days = 0;
		
		switch(this.month) {
			case 2:
				days = 28;
				break;
			case 4:
			case 6: 
			case 9: 
			case 11:
				days = 30;
				break;
			default:
				days = 31;	
		}
		
		return days;
	}
	
	public String getSeasonName(){
		String month = null;
		
		switch (this.month){
			case 1: 
			case 2: 
			case 3: 
				month = "Winter";
				break;
			case 4: 
			case 5: 
			case 6:
				month = "Spring";
				break;
			case 7: 
			case 8:  
			case 9:
				month = "Summer";
				break;
			default:
				month = "Autumn";
				break;
		}
		
		return month;
	}
	
	public String monthsUntilEnd() throws DateException {
		StringBuffer monthsUntilEnd = new StringBuffer();
		Date aux = new Date(this.day, this.month, this.year);
		
		for(int i = this.month; i <= 12; i++) {
			aux.setMonth(i);
			monthsUntilEnd.append(aux.month + " ");
		}
		
		return monthsUntilEnd.toString();
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	public String datesUntilMonthEnd() throws DateException {
		StringBuffer dates = new StringBuffer();
		Date aux = new Date(this.day, this.month, this.year);
		
		for(int i = this.day + 1; i <= this.daysOfMonth(); i++) {
			aux.setDay(i);
			dates.append(aux.toString() + " ");
		}
		
		return dates.toString();
	}
	
	public String monthsWithSameDays() throws DateException {
		StringBuffer monthNames = new StringBuffer();
		Date aux = new Date(this.day, this.month, this.year);
		
		for (int i = 1; i <= 12; i++) {
			aux.setMonth(i);
			if (aux.daysOfMonth() == this.daysOfMonth()) {
				monthNames.append(aux.getMonthName() + " ");
			}
		}
		
		return monthNames.toString();
	}
	
	public int daysSinceStart() throws DateException {
		int days = 0;
		Date aux = new Date(1,1,this.year);
		
		for (int i = 1; i < this.month; i++) {
			days += aux.daysOfMonth();
			aux.setMonth(i + 1);
		}
		
		return days;
	}
	
	public int randomEqualsDate() throws DateException {
		int contador = 0;
		int randomMonth = (int)(Math.random() * 12 + 1);
		int randomDay = (int)(Math.random() * this.daysOfMonth(randomMonth) + 1);
		int year = this.year;
		
		do {
			randomDay = (int)(Math.floor(Math.random()*32+1));
			randomMonth = (int)(Math.floor(Math.random()*13+1));
			contador++;
		}while(!this.isSame(new Date(randomDay, randomMonth, year)));
		
		return contador;
	
		/*while(!this.isSame(new Date(randomDay, randomMonth, year))) {
			randomDay = (int)(Math.floor(Math.random()*32+1));
			randomMonth = (int)(Math.floor(Math.random()*13+1));
			contador++;
		}
		return contador;*/
	}
	
	public String dayOfWeek(int primerDia) throws DateException{
		int dayNumber;
		
		dayNumber = (daysSinceStart() % 7 + primerDia ) % 7;
		
		return nameOfDay(dayNumber);
	}
	
	private String nameOfDay(int day) {
		String name;
	
		switch (day) {
			case 1: 
				name = "Monday";
				break;
			case 2: 
				name = "Tuesday";
				break;
			case 3: 
				name = "Wednesday";
				break;
			case 4: 
				name = "Thursday";
				break;
			case 5: 
				name = "Friday";
				break;
			case 6: 
				name = "Saturday";
				break;
			default:
				name = "Sunday";
		}
		
		return name;
	}
}