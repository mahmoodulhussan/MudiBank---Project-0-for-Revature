package userTests;
/*

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.anyString;

import com.example.dao.FileIO;
import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.User;
import com.example.services.UserService;

public class UserServiceTest {

//	private User testUser1 = new User("Test", "User", "testPass");
//	private User testUser2 = new User("Test", "User", "password");
//	private UserService uServ = new UserService("test.txt");
//	private FileIO<User> io = new FileIO<User>("test.txt");
	@InjectMocks
	public UserService uServ;
	
//	@Before
//	public void clearTestFile() {
//		if(Files.exists(Paths.get("test.txt"))) {
//			System.out.println("Clearing the test file");
//			try {
//				Files.delete(Paths.get("test.txt"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	@Mock
	public UserDao uDao;
	
//	@Test
//	public void testEmptyUserList() {
//		List<User> userList = uServ.getAllUsers();
//		assertEquals("The list should have no users", 0, userList.size());
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
//	public void testCreatNewUser() {
//		User rick = uServ.signUp("Rick", "Sanchez", "ilovemorty");
//		List<User> userList = uServ.getAllUsers();
	public void testValidLogin() {
		User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(0, "test", "user", "testuser", "test@mail.com", "testpass");
		
//		assertNotNull(rick);
//		assertEquals(rick.getUsername(), userList.get(0).getUsername());
//		assertEquals(1, userList.size());
		when(uDao.getUserByUsername(anyString())).thenReturn(u1);
		
		User loggedIn = uServ.signIn("testuser", "testpass");
		
		assertEquals(u1.getId(), loggedIn.getId());
	}
	
//	@Test
//	public void testCreateMultipleUsers() {
//		User morty = uServ.signUp("Morty", "Smith", "ihaterick");
//		User rick = uServ.signUp("Rick", "Sanchez", "ilovemorty");
	@Test(expected = UserDoesNotExistException.class)
	public void testInvalidUsername() {
		User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(0, "test", "user", "testuser", "test@mail.com", "testpass");
		
//		List<User> userList = uServ.getAllUsers();
		when(uDao.getUserByUsername(anyString())).thenReturn(not);
		
//		assertNotNull(morty);
//		assertNotNull(rick);
//		assertEquals(2, userList.size());
		User loggedIn = uServ.signIn("testuser", "testpass");
	}
	
//	@Test(expected=UserDoesNotExistException.class)
//	public void testUserDoesNotExist() {
//		User rick = uServ.login("Rick", "ilovemorty");
	@Test(expected = InvalidCredentialsException.class)
	public void testInvalidPassword() {
		User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(1, "test", "user", "testuser", "test@mail.com", "wrongpass");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(not);
		
		uServ.signIn("testuser", "testpass");
	}
	
}

*/