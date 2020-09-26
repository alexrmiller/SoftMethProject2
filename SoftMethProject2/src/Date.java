import java.text.DecimalFormat;

public class Date implements Comparable<Date>{
	private int  year;
	private int month;
	private int day;
	
	public Date(int month, int date, int year) {
		this.year=year;
		this.month=month;
		this.day=date;
	}
	
	//return 0,-1,1
	@Override
	public int compareTo(Date date) {
		if(this.year < date.year) {
			return 1;
		}
		else if(this.year>date.year) {
			return -1;
		}
		else {
			//same year go to month
			if(this.month>date.month) {
				return 1;
			}
			else if(this.month<date.month) {
				return -1;
			}else {
				//year and month are the same go to day
				if(this.day>date.day) {
					return 1;
				}else if(this.day<date.day) {
					return -1;
				}
				else {
					//they are the same
					return 0;
				}
			}
		}
	}
	
	//mm/dd/yyyy format
	public String toString() {
		if(this.isValid()==true) {
			DecimalFormat fOther = new DecimalFormat("#0");
			DecimalFormat fYear = new DecimalFormat("####");
			return fOther.format(this.month) + "/" + fOther.format(this.day) + "/" + fYear.format(this.year);	
		}
		return this.month + "/" + this.day + "/" + this.year + "is not a valid Date";
	}
	
	//TO DO
	public boolean isValid() {

	}
	
	public static void main(String[] args) {
		Date d = new Date(2000,12,2);
		System.out.println(d.toString());
	}
}

