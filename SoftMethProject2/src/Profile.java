
public class Profile {
	private String fname;
	private String lname;
	
	public void Profile(String f, String l) {
		this.fname=f;
		this.lname=l;
	}
	
	@Override
	public String toString() {
		return this.fname + this.lname;
	}
	
	public boolean equals(Profile profile) {
		return (this.fname.equals(profile.fname) && this.lname.equals(profile.lname));
	}
}
