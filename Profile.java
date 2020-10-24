/**
 * Profile Class used to create Accounts
 * 
* @author Maudiel Romero, Alex Miller
*
*/
public class Profile {
	private String fname;
	private String lname;
	
	/**
	 * Constructor for Profile
	 * 
	 * @param f refers to users first name 
	 * @param l refers to user last name
	 */
	public Profile(String f, String l) {
		this.fname=f;
		this.lname=l;
	}

	/**
	 * Overrides Profile class to return first and last name together as one instance 
	 * @return fname + ' ' + lname refers to string output of func. Profile
	 */
	@Override
	public String toString() {
		return this.fname +" "+this.lname;
	}
	/**
	 * checks if names in account is equal to new input names
	 * @param profile refers to users first and last name
	 * @return true if first and last name are the same, false refers to names not matching
	 */
	public boolean equals(Profile profile) {
		return (this.fname.equals(profile.fname) && this.lname.equals(profile.lname));
	}
	
	/**
	 * getter method to retrieve Profile's last name
	 * 
	 * @return this.lname refers to users last name
	 */
	public String getLastName() {
		return this.lname;
	}

}