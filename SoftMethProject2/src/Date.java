/**
 * Our own date class, comparable to Date object
 * @author Maudiel Romero, Alex Miller
 *
 */
import java.text.DecimalFormat;

public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;

	DecimalFormat fOther = new DecimalFormat("#0");
	DecimalFormat fYear = new DecimalFormat("####");

	/**
	 * Date Constructor
	 * 
	 * @param month refers to ## int for month
	 * @param date refers to ## int for the day
	 * @param year refers to #### int for the year
	 */
	public Date(int month, int date, int year) {
		this.year = year;
		this.month = month;
		this.day = date;
	}

	
	/**
	 * compares date based on year, month, day 
	 * @param date refers to the date the user made account
	 * @return 0,-1,1 refers to the date traversing forwards or backwards in account array
	 */
	@Override
	public int compareTo(Date date) {
		if (this.year < date.year) {
			return 1;
		} else if (this.year > date.year) {
			return -1;
		} else {
			// same year go to month
			if (this.month > date.month) {
				return 1;
			} else if (this.month < date.month) {
				return -1;
			} else {
				// year and month are the same go to day
				if (this.day > date.day) {
					return 1;
				} else if (this.day < date.day) {
					return -1;
				} else {
					// they are the same
					return 0;
				}
			}
		}
	}

	/**
	 * returns string in date format
	 * @return date format if date is valid, date format "is not valid" refers to date
	 *         not valid
	 */
	public String toString() {
		if (this.isValid() == true) {
			return fOther.format(this.month) + "/" + fOther.format(this.day) + "/" + fYear.format(this.year);
		}
		return this.month + "/" + this.day + "/" + this.year + " is not a valid Date";
	}

	/**
	 * 
	 * @return false refers to day, month, year is invalid, true refers to if day,
	 *         month, year, is valid
	 */
	public boolean isValid() {

		if (this.day > 31 || this.day < 1) {
			return false;
		} else if (this.month > 12 || this.month < 1) {
			return false;
		} else if (this.year < 1900) {
			return false;
		} else if (this.checkMatche() == false) {
			return false;
		} else if (this.evenMonths() == true && this.day > 30) {
			return false;
		} else if (this.month == 2 && this.day > 28 && this.year % 4 != 0){
			return false;
		} else if (this.day > 29 && this.year % 4 == 0) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * this checks if the matches are formated correct using AJEX
	 * @return true if the day, month, year, mathches mm/dd/yyyy format, false
	 *         refers if mm/dd/yyyy is not a valid format
	 */
	boolean checkMatche() {
		String dateFormat = fOther.format(this.month) + "/" + fOther.format(this.day) + "/" + fYear.format(this.year);
		if (dateFormat.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
			return true;
		} else if (dateFormat.matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) {
			return true;
		} else if (dateFormat.matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) {
			return true;
		} else if (dateFormat.matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 *  if the month ends on the 30th it is even
	 * @return true refers to months that end with 30 days, false refers to the
	 *         remaider months
	 */
	boolean evenMonths() {
		if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
			return true;
		} else {
			return false;
		}
	}

}