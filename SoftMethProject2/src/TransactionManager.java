/**
	 /**
	 * @author Maudiel Romero, Alex Miller
	 *
	 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class TransactionManager {
	
	
	Scanner TransactionManager = new Scanner(System.in);
			//.useDelimiter("\n");
	AccountDatabase database = new AccountDatabase();
	
	
	//THESE MIGHT NOT BE ALLOWED 
//	String line =TransactionManager.nextLine();
//	String[] input = line.split(" ");
//	String command = input[0]; 
//	char firstChar = input[0].charAt(0);
//	char SecondChar = input[0].charAt(1);
	//boolean bool = input[5];
	//boolean dog = true;
	
	/**
	 * 
	 * @param profile
	 * @return
	 */
	public void run() {
		String line =TransactionManager.nextLine();
		String[] input = line.split(" ");
		switchstatement(input);
		
		
	}
	/**
	 * 
	 * @param abc
	 * @param arr
	 */
public void switchstatement(String[]arr){
	if(arr[0].length()==2) {
		char First = arr[0].charAt(0);
		char Second = arr[0].charAt(1);
	switch(First){
		case 'C':
				if(Second=='C' || Second=='S' || Second=='M') {
					close(arr);
				}else {
					System.out.println("Command '"+ arr[0] +"' not supported!");
					run();
				}
			break; 
		case 'O':
			if(Second=='C' || Second=='S' || Second=='M') {
				open(arr);
			}else {
				System.out.println("Command '"+ arr[0] +"' not supported!");
				run();
			}
			break;
		case 'D':
			if(Second=='C' || Second=='S' || Second=='M') {
				deposit(Second,arr);
			}else {
				System.out.println("Command '"+ arr[0] +"' not supported!");
				run();
			}
			break;
		case 'W':
			if(Second=='C' || Second=='S' || Second=='M') {
				withdraw(Second,arr);
			}else {
				System.out.println("Command '"+ arr[0] +"' not supported!");
				run();
			}
			break;
		case 'P':
			if(Second=='A') {
				database.printAccounts();
			}
			else if(Second=='D') {
				database.printByDateOpen();
			}
			else if(Second=='N') {
				database.printByLastName();
			}
			else {
				System.out.println("Command '"+ arr[0] +"' not supported!");
				run();
			}
			break;
		default: 
			System.out.println("Command '"+ arr[0] +"' not supported!");
			run();
			break;
	}
	}
	else if (arr[0].length()==1) {
		char First = arr[0].charAt(0);
		switch(First) {
		case 'Q':
			System.out.print(" \n Transaction processing completed."); 
			break;
		default: 
			System.out.println("Command '"+ arr[0] +"' not supported!");
			run();
			break;
		}
	}
	else {
		System.out.println("Command '"+ arr[0] +"' not supported!");
		run();
	}
	}

/**
 * 
 * @param arr
 * @param s 
 */
public void close(String []arr) {
	if(arr.length==4) {
	char type = arr[0].charAt(1);
	String FirstName = arr[1];
	String LastName = arr[2];
    Profile prof = new Profile(FirstName,LastName);
    Checking check = new Checking(prof);
    Savings save = new Savings(prof);
    MoneyMarket money = new MoneyMarket(prof);
    
    if(type == 'C' ) {
   	System.out.print(database.remove(check));
	 }else if(type == 'S' ) {
		System.out.print(database.remove(save));
	} else if (type == 'M' ) {
		System.out.print(database.remove(money));
		}run();
	}
}
/**
 * 
 * @param arr
 * @param s
 */
public void open(String [] arr) {	// should be string[] arr , boolean t/f
	if (arr.length != 6) {
		System.out.println("invalid input");
		 run();
		 } 
	datesyntaxcheck(arr);
	 PosNum(arr);
	 boolcheck(arr);
	 
	 char type = arr[0].charAt(1);
	 String booltype = arr[5];
	 boolean bool =Boolean.valueOf(booltype.toLowerCase());
	 String FirstName = arr[1];
	 String LastName = arr[2];
	 String Bal = arr[3];
	 String date1 = arr[4];
	 String [] date2 = date1.split("/",3);
	 int a = Integer.parseInt(date2[0]);
     int b = Integer.parseInt(date2[1]); 
     int c = Integer.parseInt(date2[2]);
     
     Date date = new Date(a,b,c);
     double Balance = Double.parseDouble(Bal);
     Profile prof = new Profile(FirstName,LastName);
     Checking check = new Checking(prof,Balance,date,bool);
     Savings save = new Savings(prof,Balance,date,bool);
     MoneyMarket money = new MoneyMarket(prof,Balance,date,0);
     if(type == 'C' ) {
    	if(database.add(check)==true){
    		System.out.println("Account opened and added to the database");
    	}
    	else {
    		System.out.println("Account already exists");
    	}
	 }else if(type == 'S' ) {
		 if(database.add(save)==true){
	    		System.out.println("Account opened and added to the database");
	    	}
	    	else {
	    		System.out.println("Account already exists");
	    	}
	} else if (type == 'M' ) {
		if(database.add(money)==true){
    		System.out.println("Account opened and added to the database");
    	}
    	else {
    		System.out.println("Account already exists");
    	}
		}
     run();
}
/**
 * 
 * @param arr
 */
public void deposit(char type, String[] arr) {
	if (arr.length == 4) {run();}
	 PosNum(arr);
	 
	System.out.print("this is deposit");
}
/**
 * 
 * @param arr
 * @return
 */
public void withdraw(char type, String[] arr) { 
	if (arr.length == 4) {
		Account acc = null;
		PosNum(arr);
		Profile name = new Profile(arr[1],arr[2]);
	if(type=='C') {
		acc = new Checking(name);
	}
	else if(type=='M') {
		acc = new MoneyMarket(name);
	}else if(type=='S') {
		acc = new Savings(name);
	}
	 int test = database.withdraw(acc, Double.parseDouble(arr[3]));
	 //account doesn't exist
	 if(test==-1) {
		 System.out.println("Account does not exist.");
	 }
	 //insufficient funds
	 else if(test==1) {
		 System.out.println("Insufficient funds.");
	 }
	 //success
	 else {
		 System.out.println(arr[3] + "Withdrawn from account.");
	 }
	 run();
	}
	else {
		System.out.println("Invalid Input.");
		run();
	}
}
/**
 * 
 * @param arr
 * @return 
 */
public boolean datesyntaxcheck(String[] arr) {

	String date1 = arr[4];
	String [] date2 = date1.split("/",3);
	 try {  
         int a = Integer.parseInt(date2[0]);
         int b = Integer.parseInt(date2[1]); 
         int c = Integer.parseInt(date2[2]); 
         Date date = new Date(a,b,c);
         if( date.isValid()==true) {
        	 return true;
         }else 
        	 System.out.print("'"+arr[4]+ " ' is not a valid date!");
         	 run();
	 }catch(NumberFormatException ex){  
		return false;
	 } 
	 return false;
}
/**
 * 
 * @param arr
 * @return
 */
public void PosNum(String[] arr) {
	try{
	   int num = Integer.parseInt(arr[3]);
	   if(num > 0) {return;}
	}catch (NumberFormatException ex) {
		run();
	}
	return;
}
/**
 * 
 * @param arr
 * @return 
 */
public void boolcheck(String[] arr) {
	
	String booltype = arr[5];
	boolean boola = Boolean.valueOf(booltype.toLowerCase());
	String check= Boolean.toString(boola);
	
	if(check.equals(booltype.toLowerCase())!=true) { 
		run();		 
	}
	return;
}

}