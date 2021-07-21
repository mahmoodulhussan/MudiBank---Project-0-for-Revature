

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoDB;
import com.bank.dao.EmployeeDao;
import com.bank.dao.EmployeeDaoDB;
import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.services.CustomerService;
import com.bank.services.EmployeeService;

public class Menu {
	private static CustomerDao cDao = new CustomerDaoDB();
	private static EmployeeDao eDao = new EmployeeDaoDB();
	private static CustomerService cServ = new CustomerService(cDao);
	private static EmployeeService eServ = new EmployeeService(eDao);
	
private Scanner sc = new Scanner(System.in);
	
	public Menu()
	{
		super();
	}
	
	public String appLaunch() {
		String option = "";
		
		System.out.println("Welcome to Mudi Bank :)");
		System.out.println("Please choose from the following options: ");
		System.out.println("\t1. Existing customer"
				+ "\n\t2. New customer"
				+ "\n\t3. Employee"
				+ "\n\t4. Manager"
				+ "\n\t5. Exit Application");
		
		option = sc.nextLine();
		
		return option;
	}
	
	public String custPortal() {
		String option = "";
		
		System.out.println("Please choose from the following options: ");
		System.out.println("\t1. Check Balance."
				+ "\n\t2. Deopist/Withdraw Money"
				+ "\n\t3. Transfer Funds"
				+ "\n\t4. Accept A Money Transfer"
				+ "\n\t5. Return");
		
		option = sc.nextLine();
		
		return option;
	}
	
	public String empPortal() {
		String option = "";
		
		System.out.println("Please choose from the following options: ");
		System.out.println("\t1. Approve/Reject An Account."
				+ "\n\t2. View A Customer's Bank Accont."
				+ "\n\t3. View A Log of All Transactions"
				+ "\n\t4. Exit Application");
		
		option = sc.nextLine();
		
		return option;
	}


	}
