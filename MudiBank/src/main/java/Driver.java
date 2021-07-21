import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoDB;
import com.bank.dao.EmployeeDao;
import com.bank.dao.EmployeeDaoDB;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.TransferLog;
import com.bank.services.CustomerService;
import com.bank.services.EmployeeService;

public class Driver {
	
	
	private static CustomerDao cDao = new CustomerDaoDB();
	private static EmployeeDao eDao = new EmployeeDaoDB();
	private static CustomerService cServ = new CustomerService(cDao);
	private static EmployeeService eServ = new EmployeeService(eDao);
	final static Logger log = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		Scanner in = new Scanner(System.in);
		
		
		List<TransferLog> tranD;
		Customer c;
		Employee emp;
		String option = "";
		option = menu.appLaunch();
		
		while(!option.equals("5")) {
			
			switch(option) {
			case "1":
				boolean i = false;
				while (i != true) {
				System.out.println("Please enter your username: ");
				String username = in.nextLine();
				System.out.print("Please enter your password: ");
				String password = in.nextLine();
				try {
					c = cServ.signIn(username, password);
					log.info("Login Successful");
					System.out.println("Welcome " + c.getFirstName());
				} catch(Exception e) {
					System.out.println("Username or password was incorect. Goodbye");
				}
				
				String optio = "";

				optio = menu.custPortal();
				
				while(!optio.equals("5")) {
					switch(optio) {
					case "1":
						boolean b = true;
						if(b) {
							
							System.out.println("Please enter your Account ID: ");
							int srcId = in.nextInt();
							
							try {
								emp = eDao.checkBalance(srcId);
								log.info("Customer checked balance");
								System.out.println("Acount " + srcId + " has $ " + emp.getTranAmount() + " present in account.");
								System.out.println("Thank you for your business :)");
							} catch(Exception e) {
								System.out.println("Account ID was invalid. Goodbye");
							} b = false;
						}
						
					case"2":
						boolean d = true;
						if (d) {
							System.out.println("Please enter your Account ID: ");
							int srcId = in.nextInt();
							System.out.println("Please enter your Account ID again: ");
							int destId = in.nextInt();
							System.out.println("Please enter the $ you want to deposit/withdraw. Enter positive value for deposite and negative value for withdrawal. ");
							int tranAmount = in.nextInt();
							try {
								emp = eServ.depositWithdraw(srcId, destId, tranAmount);
								log.info("Customer deposited or withdrawn money");
								System.out.println("Deposit/Withdrawl was successful.");
								System.out.println("You have deposited/withdrawn $" + emp.getTranAmount() + " into/from your account.");
								System.out.println("Thank you for your business :)");

								d = false;
							
							} catch(Exception e) {
								System.out.println("Account ID was invalid. Goodbye");
								
							} return;
						}
						break;
						
					case"3":
						boolean f = true;
						if (f) {
							System.out.println("Please enter your Account ID: ");
							int srcId = in.nextInt();
							System.out.println("Please enter the recipient's Account ID: ");
							int destId = in.nextInt();
							System.out.println("Please enter the $ you want to transfer.  ");
							int tranAmount = in.nextInt();
							try {
								emp = eServ.initTransfer(srcId, destId, tranAmount);
								log.info("Customer transferred money");
								System.out.println("Request for transfer has been submitted for approval");
								System.out.println("Thank you for your business :)");

							} catch(Exception e) {
								System.out.println("Request for transfer failed. Goodbye");
								f =  false;
							} 
						}	break;	
					case "4":
						System.out.println("Press 1 to accept the transfer. Press 2 to reject.");
						int choi = Integer.parseInt(in.nextLine());
						if(choi == 1) { 
							eDao.acceptTransfer();
							System.out.println("You have successfully accepted the transfer!");
							System.out.println("Thank you for your business :)");

						}else {
							eDao.rejectTransfer();
							System.out.println("You have successfully rejected the transfer!");
							System.out.println("Thank you for your business :)");

						}
							} return;
					
						
					} 
				}
				
			case "2":
				boolean j = true;
				if (j) {
				System.out.print("Please enter you first name: ");
				String first = in.nextLine();
				System.out.print("Please enter your last name: ");
				String last = in.nextLine();
				System.out.print("Please enter your username: ");
				String username = in.nextLine();
				System.out.print("Please enter your email: ");
				String email = in.nextLine();
				System.out.print("Please enter a password: ");
				String password = in.nextLine();
				System.out.print("Please enter a starting balance: ");
				int startingBalance = in.nextInt();
				try {
					c = cServ.signUp(first, last, username, email, password, startingBalance);
					log.info("A new user signed up");
					System.out.println("Your account creation request has been sent for approval: " + c.getUsername());
					System.out.println("Thank you for your business :)");

				} catch (Exception e) {
					System.out.println("Sorry, we could not process your request");
					System.out.println("Please try again later");
				}return;
				}
				break;
			case "3":
				boolean k = true;
				if(k) {
					System.out.println("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
						c = cServ.signIn(username, password);
						System.out.println("Welcome " + c.getFirstName());
						
					} catch(Exception e) {
						System.out.println("Username or password was incorect. Goodbye");
					} 
				}
					String opti = "";

					opti = menu.empPortal();
					
					if(!opti.equals("4")) {
						switch(opti) {
						case "1":
							System.out.println("Press 1 to approve a customer account creation. Press 2 to reject.");
							int cho = Integer.parseInt(in.nextLine());
							if(cho == 1) { 
								cDao.acceptTransfer();
								System.out.println("You have successfully approved the customer account creation!");
							}else {
								cDao.rejectTransfer();
								System.out.println("You have successfully rejected the customer account creation!");
							}
							
							return;

							
						
						case "2":
							boolean g = false;
							if(g != true) {
								System.out.println("Please enter the Customer Account ID: ");
								int srcId = in.nextInt();
								
								try {
									emp = eDao.checkBalance(srcId);
									System.out.println("Acount " + srcId + " has $ " + emp.getTranAmount() + " present in account.");
								} catch(Exception e) {
									System.out.println("Account ID was invalid. Goodbye");
								} g = true;
								
								return;
							}	break;
												
						case "3" :
								try {
									tranD = eServ.getAllTransfers();
									System.out.println("Here is the record of all the transactions: " + eDao.getAllTransfers());
								} catch(Exception e) {
									System.out.println("Sorry, you are not authorized to see the transaction records. Goodbye");
								} return;
							}	break;	
							
						}
				}
			}
		
		System.out.println("Goodbye :)");
		in.close();
		
	}
	
}