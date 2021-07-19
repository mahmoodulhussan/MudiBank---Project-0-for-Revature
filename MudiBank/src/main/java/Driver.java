import java.util.List;
import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoDB;
import com.bank.dao.EmployeeDao;
import com.bank.dao.EmployeeDaoDB;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.TranDisplay;
import com.bank.services.CustomerService;
import com.bank.services.EmployeeService;

public class Driver {
	
	
	private static CustomerDao cDao = new CustomerDaoDB();
	private static EmployeeDao eDao = new EmployeeDaoDB();
	private static CustomerService cServ = new CustomerService(cDao);
	private static EmployeeService eServ = new EmployeeService(eDao);
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		Scanner in = new Scanner(System.in);
		
		//This will be used to control our loop
//		boolean done = false;
//		
		Customer c;
		Employee emp;
		String option = "";
		option = menu.appLaunch();
		
		while(!option.equals("4")) {
			
			switch(option) {
			case "1":
				boolean i = true;
				if(i) {
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
								System.out.println("Acount " + srcId + " has $ " + emp.getTranAmount() + " present in account.");
							} catch(Exception e) {
								System.out.println("Account ID was invalid. Goodbye");
							} b = false;
						}	break;
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
								emp = eServ.initTransfer(srcId, destId, tranAmount);
								System.out.println("Deposit/Withdrawl was successful");
							} catch(Exception e) {
								System.out.println("Account ID was invalid. Goodbye");
								d = false;
							} 
						}	break;
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
								System.out.println("Transfer for transfer has been submitted for approval");
							} catch(Exception e) {
								System.out.println("Request for transfer failed. Goodbye");
								f = false;
							} 
						}	break;	
					}
						
					} 
				}
				
				
//				break;
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
					System.out.println("Your account creation request has been sent for approval: " + c.getUsername());
				} catch (Exception e) {
					System.out.println("Sorry, we could not process your request");
					System.out.println("Please try again later");
				}
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
			
			}
			
			
//			if(c == null) {
//				System.out.println("Press 1 for existing customer Login, Press 2 to Signup");
//				int choice = Integer.parseInt(in.nextLine());
//				if(choice == 1) {
//					System.out.print("Please enter your username: ");
//					String username = in.nextLine();
//					System.out.print("Please enter your password: ");
//					String password = in.nextLine();
//					try {
//						c = cServ.signIn(username, password);
//						System.out.println("Welcome " + c.getFirstName());
//					} catch(Exception e) {
//						System.out.println("Username or password was incorect. Goodbye");
//						done = true;
//					}
//				} else {
//					System.out.print("Please enter you first name: ");
//					String first = in.nextLine();
//					System.out.print("Please enter your last name: ");
//					String last = in.nextLine();
//					System.out.print("Please enter your username: ");
//					String username = in.nextLine();
//					System.out.print("Please enter your email: ");
//					String email = in.nextLine();
//					System.out.print("Please enter a password: ");
//					String password = in.nextLine();
//					try {
//						c = cServ.signUp(first, last, username, email, password);
//						System.out.println("Your account creation request has been sent for approval: " + c.getUsername());
//					} catch (Exception e) {
//						System.out.println("Sorry, we could not process your request");
//						System.out.println("Please try again later");
//						done = true;
//					}
//				}
//			} else {
//				System.out.println("To view posts press 1, to create a post press 2");
//				int choice = Integer.parseInt(in.nextLine());
//				//If the user chooses 1, we will show them the list of posts
//				if(choice == 1) {
//					List<PostDisplay> posts = eServ.getAllPosts();
//					for(PostDisplay post: posts) {
//						System.out.println(post.getUsername() + ":");
//						System.out.println(post.getContent());
//						System.out.println();
//					}
//					System.out.println("Are you finished? Press 1 for yes, press 2 for no");
//					choice = Integer.parseInt(in.nextLine());
//					done = (choice == 1) ? true : false;
//				} else {
//					System.out.println("Please enter the amount you want to deposit/withdraw:");
//					int content = in.nextInt();
//					String a = in.nextLine();
//					eServ.addPost(c.getCustomerId(), c.getCustomerId(), content);
//					System.out.println("Post was received, are you finished? Press 1 for yes, press 2 for no");
//					choice = Integer.parseInt(in.nextLine());
//					done = (choice == 1) ? true : false;
//				}
//			}
		}
		
		System.out.println("Goodbye :)");
		in.close();
		
	}
	
}