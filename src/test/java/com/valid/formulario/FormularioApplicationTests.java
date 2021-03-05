package com.valid.formulario;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.valid.formulario.entity.User;
import com.valid.formulario.repository.UserRepository;
import com.valid.formulario.service.UserService;

@SpringBootTest
class FormularioApplicationTests {
	
	@Mock
	private UserRepository ur;
	
	@InjectMocks
	private UserService us;
	
	@Test
	public void createUser() {
		
		User u = Mockito.mock(User.class);
		
		Mockito.when(u.getId()).thenReturn((int) 1);
		
		assertEquals(1, u.getId());
	}
	
	@Test
	public void getAllUsers() {
		
		User u = new User();
		User u2 = new User();
		User u3 = new User();
		
		u.setFirstName("Ander");
		u.setLastName("Herrera");
		
		u2.setFirstName("Juan");
		u2.setLastName("Mata");
		
		u3.setFirstName("Jhon");
		u3.setLastName("117");
		
		Mockito.when(us.getAllUsers()).thenReturn(asList(u,u2,u3));
		
		List<User> users = us.getAllUsers();
		
		assertEquals(u2, users.get(1));
		
		assertEquals(u3, users.get(2));
		
		assertEquals(u, users.get(0));
		
		
	}

	@Test
	public void getAUser() {
		
		User u = Mockito.mock(User.class);
		
		Mockito.when(u.getId()).thenReturn(1);
		Mockito.when(u.getFirstName()).thenReturn("Moises");
		Mockito.when(u.getLastName()).thenReturn("Rojas");
		
		UserService us1 = Mockito.mock(UserService.class);
		
		Mockito.doReturn(u).when(us1).getAUser("1");
		
		assertEquals("Moises", u.getFirstName());
		
	}

}
