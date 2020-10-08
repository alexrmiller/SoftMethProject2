 /**
	 * @author Maudiel Romero, Alex Miller
	 *
	 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class TransactionManager {

	Scanner TransactionManager = new Scanner(System.in);
	// .useDelimiter("\n");
	AccountDatabase database = new AccountDatabase();
	DecimalFormat doubleBalance = new DecimalFormat("#.##");

	// THESE MIGHT NOT BE ALLOWED
	//	String line =TransactionManager.nextLine();
	//	String[] input = line.split(" ");
	//	String command = input[0]; 
	//	char firstChar = input[0].charAt(0);
	//	char SecondChar = input[0].charAt(1);
	// boolean bool = input[5];
	// boolean dog = true;

	/**
	 * 
	 * @param profile
	 * @return
	 */
	public void run() {
		String line = TransactionManager.nextLine();
		String[] input = line.split("\\s+");
		switchstatement(input);

	}

	/**
	 * 
	 * @param abc
	 * @param arr
	 */
	public void switchstatement(String[] arr) {
		if (arr[0].length() == 2) {
			char First = arr[0].charAt(0);
			char Second = arr[0].charAt(1);
			switch (First) {
			case 'C':
				if (Second == 'C' || Second == 'S' || Second == 'M') {
					close(arr);
				} else {
					System.out.println("Command '" + arr[0] + "' not supported!");
					run();
				}
				break;
			case 'O':
				if (Second == 'C' || Second == 'S' || Second == 'M') {
					open(arr);
				} else {
					System.out.println("Command '" + arr[0] + "' not supported!");
					run();
				}
				break;
			case 'D':
				if (Second == 'C' || Second == 'S' || Second == 'M') {
					deposit(Second, arr);
				} else {
					System.out.println("Command '" + arr[0] + "' not supported!");
					run();
				}
				break;
			case 'W':
				if (Second == 'C' || Second == 'S' || Second == 'M') {
					withdraw(Second, arr);
				} else {
					System.out.println("Command '" + arr[0] + "' not supported!");
					run();
				}
				break;
			case 'P':
				if (Second == 'A') {
					database.printAccounts();
					run();
				} else if (Second == 'D') {
					database.printByDateOpen();
					run();
				} else if (Second == 'N') {
					database.printByLastName();
					run();
				} else {
					System.out.println("Command '" + arr[0] + "' not supported!");
					run();
				}
				break;
			default:
				System.out.println("Command '" + arr[0] + "' not supported!");
				run();
				break;
			}
		} else if (arr[0].length() == 1) {
			char First = arr[0].charAt(0);
			switch (First) {
			case 'Q':
				System.out.print(" \n Transaction processing completed.");
				break;
			default:
				System.out.println("Command '" + arr[0] + "' not supported!");
				run();
				break;
			}
		} else {
			System.out.println("Command '" + arr[0] + "' not supported!");
			run();
		}
	}

	/**
	 * 
	 * @param arr
	 * @param s
	 */
	public void close(String[] arr) {
		if (arr.length != 3) {
			System.out.println("invalid input.");
			run();
		}
		char type = arr[0].charAt(1);
		String FirstName = arr[1];
		String LastName = arr[2];

		Profile prof = new Profile(FirstName, LastName);

		if (type == 'C') {
			Checking check = new Checking(prof);
			if (database.remove(check) == true) {
				System.out.println("Account closed and removed from the database.");
			} else {
				System.out.println("Account does not exist.");
			}
		} else if (type == 'S') {
			Savings save = new Savings(prof);
			if (database.remove(save) == true) {
				System.out.println("Account closed and removed from the database.");
			} else {
				System.out.println("Account does not exist.");
			}
		} else if (type == 'M') {
			MoneyMarket money = new MoneyMarket(prof);
			if (database.remove(money) == true) {
				System.out.println("Account closed and removed from the database.");
			} else {
				System.out.println("Account does not exist.");
			}
		}
		run();
	}

	/**
	 * 
	 * @param arr
	 * @param s
	 */
	public void open(String[] arr) {
		// make sure it's valid input
		if (arr.length != 5 && arr.length !=6) {
			System.out.println("invalid input.");
			run();
		}
		PosNum(arr);

		char type = arr[0].charAt(1);
		String FirstName = arr[1];
		String LastName = arr[2];
		double 	Balance = Double.parseDouble(arr[3]);
		String[] Date = arr[4].split("/", 3);
		boolean bool=false;
		if(arr.length==6) {
		bool = Boolean.parseBoolean(arr[5].toLowerCase());
		}

		Date date = new Date(Integer.parseInt(Date[0]), Integer.parseInt(Date[1]), Integer.parseInt(Date[2]));
		if (date.isValid() != true) {
			System.out.print("'" + arr[4] + "' is not a valid date!");
			run();
		}

		Profile prof = new Profile(FirstName, LastName);

		if (type == 'C') {
			Checking check = new Checking(prof, Balance, date, bool);
			if (database.add(check) == true) {
				System.out.println("Account opened and added to the database.");
			} else {
				System.out.println("Account is already in the database.");
			}
		} else if (type == 'S') {
			Savings save = new Savings(prof, Balance, date, bool);
			if (database.add(save) == true) {
				System.out.println("Account opened and added to the database.");
			} else {
				System.out.println("Account is already in the database.");
			}
		} else if (type == 'M') {
			MoneyMarket money = new MoneyMarket(prof, Balance, date, 0);
			if (database.add(money) == true) {
				System.out.println("Account opened and added to the database.");
			} else {
				System.out.println("Account is already in the database.");
			}
		}
		run();
	}

	/**
	 * 
	 * @param arr
	 */
	public void deposit(char type, String[] arr) {
		if (arr.length == 4) {
			PosNum(arr);
			boolean test = false;
			Profile name = new Profile(arr[1], arr[2]);
			if (type == 'C') {
				Checking check = new Checking(name);
				test = database.deposit(check, Double.parseDouble(arr[3]));
			} else if (type == 'M') {
				MoneyMarket money = new MoneyMarket(name);
				test = database.deposit(money, Double.parseDouble(arr[3]));
			} else if (type == 'S') {
				Savings save = new Savings(name);
				test = database.deposit(save, Double.parseDouble(arr[3]));
			}
			// account doesn't exist
			if (test == false) {
				System.out.println("Account does not exist.");
			}
			// success
			else {
				System.out.println(arr[3] + " deposited to account.");
			}
			run();
		} else {
			System.out.println("Invalid Input.");
			run();
		}
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public void withdraw(char type, String[] arr) {
		if (arr.length == 4) {
			PosNum(arr);
			int test = 0;
			Profile name = new Profile(arr[1], arr[2]);
			if (type == 'C') {
				Checking check = new Checking(name);
				test = database.withdraw(check, Double.parseDouble(arr[3]));
			} else if (type == 'M') {
				MoneyMarket money = new MoneyMarket(name);
				test = database.withdraw(money, Double.parseDouble(arr[3]));
			} else if (type == 'S') {
				Savings save = new Savings(name);
				test = database.withdraw(save, Double.parseDouble(arr[3]));
			}
			// account doesn't exist
			if (test == -1) {
				System.out.println("Account does not exist.");
			}
			// insufficient funds
			else if (test == 1) {
				System.out.println("Insufficient funds.");
			}
			// success
			else {
				System.out.println(arr[3] + " withdrawn from account.");
			}
			run();
		} else {
			System.out.println("Invalid Input.");
			run();
		}
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public void PosNum(String[] arr) {
		try {
			Double num = Double.parseDouble(arr[3]);
			if (num > 0) {
				return;
			}
		} catch (NumberFormatException ex) {
			System.out.println("Input data type mismatch.");
			run();
		}
		return;
	}
	
}