import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.utils.ConnectionUtil;

public class TestDriver {
	
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		//This will be used to control our loop
		boolean done = false;
ArrayList<Customer> cList = new ArrayList<>();
ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	Account account = new Account();
		
		Connection con = conUtil.getConnection(); 
		
		String sql = "create table if not exists demo(\r\n"
				+ "	id int primary key generated always as identity,\r\n"
				+ "	first_name varchar(30) not null,\r\n"
				+ "	last_name varchar(30) not null,\r\n"
				+ "	email varchar(50) not null unique,\r\n"
				+ "	username varchar(64) not null unique,\r\n"
				+ "	password varchar(50) not null,\r\n"
				+ "	starting_balance int not null,\r\n"
				+ "    constraint balance_nonnegative check (starting_balance >= 0)\r\n"
				+ ");";
				
				try {
					Statement s = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}
	
}