/**
	 * @author Maudiel Romero, Alex Miller
	 *
	 */
public class Profile {
	private String fname;
	private String lname;
	
	/**
	 * 
	 * @param f
	 * @param l 
	 */
	public Profile(String f, String l) {
		this.fname=f;
		this.lname=l;
	}
	//should I make a full name 1 allocation in array? 
	/**
	 * Overrides Profile class to return first and last name together as one instance 
	 * @param 
	 * @return first name + ' ' + lastname refers to string output of func. Profile
	 */
	@Override
	public String toString() {
		return this.fname +" "+this.lname;
	}
	/**
	 * checks if names in account is equal to new input names
	 * @param profile
	 * @return true if first and last name are the same, false refers to names not matching
	 */
	public boolean equals(Profile profile) {
		return (this.fname.equals(profile.fname) && this.lname.equals(profile.lname));
	}
	
	//TO DO make comment
	public String getLastName() {
		return this.lname;
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//Profiler();
//		Profile object = new Profile();
//		Profile object2 = new Profile();
//		object.Profile("Maudiel", "Romero");
//		object2.Profile("Maudiel", "Rom");
//	    System.out.println(object2.equals(object));
//	}

}