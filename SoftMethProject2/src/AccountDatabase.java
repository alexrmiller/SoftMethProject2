
public class AccountDatabase {

	private Account[] accounts;
	private int size;

	public AccountDatabase() {
		this.accounts = new Account[5];
		this.size = 0;
	}

	private int find(Account account) {
		for (int i = 0; i < size; i++) {
			if (accounts[i].equals(account)) {
				return i;
			}
		}
		return -1;
	}

	// grow the array container
	private void grow() {
		Account[] newAcc = new Account[this.accounts.length + 5];
		for (int i = 0; i < this.accounts.length; i++) {
			newAcc[i] = accounts[i];
		}
		accounts = newAcc;
	}

	// adds the account
	public boolean add(Account account) {
		int location = find(account);
		if (location == -1) {
			// if found then add the account and grow if needed
			if (this.size == accounts.length) {
				grow();
			}
			accounts[size] = account;
			size++;
			return true;
		} else {
			// if not found then return false
			return false;
		}
	}

	// deletes the account if is able to find
	public boolean remove(Account account) {
		int location = find(account);
		if (location != -1) {
			// if found then remove it
			accounts[location] = accounts[this.size - 1];
			accounts[this.size - 1] = null;
			this.size--;
			return true;
		} else {
			// if not found then can't remove
			return false;
		}
	}

	// deposit into the account
	public boolean deposit(Account account, double amount) {
		int i = find(account);
		if (i == -1) {
			return false;
		}else {
			accounts[i].credit(amount);
			return true;
		}
	}

	// return 0: withdraw successful, 1: insufficient funds, -1 account doesn't
	// exist
	public int withdraw(Account account, double amount) {
		int i = find(account);
		if (i == -1) {
			return -1;
		} else if (accounts[i].getBalance() < amount) {
			return 1;
		} else {
			accounts[i].debit(amount);
			return 0;
		}
	}

	public void sortByDateOpen() {
		Account account = null;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (accounts[i].getDateOpen().compareTo(accounts[j].getDateOpen()) == -1) {
					// switch the two
					account = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = account;
				}
			}
		}
		return;
	}

	private void sortByLastName() {
		Account account = null;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (accounts[i].getProfile().getLastName().compareTo(accounts[j].getProfile().getLastName()) == -1) {
					// switch the two
					account = accounts[i];
					accounts[i] = accounts[j];
					accounts[j] = account;
				}
			}
		}
		return;
	}

	public void printByDateOpen() {
		if(size==0) {
			System.out.println("Database is empty");
			return;
		}
		sortByDateOpen();
		System.out.println("--Printing statements by date opened-- \n");
		for (int i = 0; i < size; i++) {
			System.out.println(accounts[i].toString() +"\n");
			System.out.println("-interest: $ " + accounts[i].monthlyInterest());
			System.out.println("-fee: $ " + accounts[i].monthlyFee());
			double newBalance = accounts[i].getBalance()-accounts[i].monthlyFee()+accounts[i].monthlyInterest();
			accounts[i].setBalance(newBalance);
			System.out.println("-new balance: $ " + newBalance + "\n");
		}
		System.out.println("--end of printing--");
		return;
	}

	public void printByLastName() {
		if(size==0) {
			System.out.println("Database is empty");
			return;
		}
		sortByLastName();
		System.out.println("--Printing statements by last name-- \n");
		for (int i = 0; i < size; i++) {
			System.out.println(accounts[i].toString() +"\n");
			System.out.println("-interest: $ " + accounts[i].monthlyInterest());
			System.out.println("-fee: $ " + accounts[i].monthlyFee());
			System.out.println("-new balance: $ " + accounts[i].getBalance());
		}
		System.out.println("--end of printing--");
		return;
	}

	public void printAccounts() {
		if(size==0) {
			System.out.println("Database is empty");
			return;
		}
		System.out.println("--Listing accounts in the database--");		
		for (int i = 0; i < size; i++) {
			System.out.println(accounts[i].toString());
		}
		System.out.println("--end of listing--");
		return;
	}
}
