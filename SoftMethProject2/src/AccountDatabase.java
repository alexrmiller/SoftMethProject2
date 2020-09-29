
public class AccountDatabase {

	private Account[] accounts;
	private int size;
	
	public AccountDatabase() {
		this.accounts = new Account[5];
		this.size=0;
	}
	
	private int find(Account account) {
		for(int i=0;i<size;i++) {
			if(accounts[i].equals(account)) {
				return i;
			}
		}
		return -1;
	}
	//grow the array container
	private void grow() {
		Account[] newAcc = new Account[this.accounts.length+5];
		for (int i=0;i < this.accounts.length; i++) {
			newAcc[i]=accounts[i];
		}
		accounts=newAcc;
	}
	//adds the account
	public boolean add(Account account) {
		int location = find(account);
		if(location!=-1) {
		//if found then add the account and grow if needed
		if(this.size==accounts.length) {
			grow();
		}
		accounts[size]=account;
		size++;
		return true;
		}
		else {
			//if not found then return false
			return false;
		}
	}
	
	//deletes the account if is able to find
	public boolean remove(Account account) {
		int location = find(account);
		if(location!=-1) {
			//if found then remove it
			accounts[location]=accounts[this.size-1];
			accounts[this.size-1]=null;
			this.size--;
			return true;
		}
		else {
			//if not found then can't remove
			return false;
		}
	}
	//deposit into the account
	public boolean deposit(Account account, double amount) {
		if(find(account)==-1) {
			return false;
		}
		else {
			account.credit(amount);
			return true;
		}
	}
	
	//return 0: withdraw successful, 1: insufficient funds, -1 account doesn't exist
	public int withdraw(Account account, double amount) {
		if(find(account)==-1) {
			return -1;
		}
		else if(account.getBalance()<amount) {
			return 1;
		}
		else {
			account.debit(amount);
			return 0;
		}
	}
	
	public void sortByDateOpen() {
		Account account = null;
		for(int i=0;i<accounts.length;i++) {
			for (int j=i;j<accounts.length;j++) {
				if(accounts[i].getDateOpen().compareTo(accounts[j].getDateOpen())==-1) {
					//switch the two
					account=accounts[i];
					accounts[i]=accounts[j];
					accounts[j]=account;
				}
			}
		}
	}
	
	private void sortByLastName() {
		Account account = null;
		for(int i=0;i<accounts.length;i++) {
			for (int j=i;j<accounts.length;j++) {
				if(accounts[i].getProfile().getLastName().compareTo(accounts[j].getProfile().getLastName())==-1) {
					//switch the two
					account=accounts[i];
					accounts[i]=accounts[j];
					accounts[j]=account;
				}
			}
		}
	}
	
	private void printByDateOpen() {
		sortByDateOpen();
		printAccounts();
	}
	
	private void printByLastName() {
		sortByLastName();
		printAccounts();
	}
	
	private void printAccounts() {
		for(int i=0; i<accounts.length;i++) {
			System.out.println(accounts[i]);
		}
	}
}
