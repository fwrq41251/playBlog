package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ModelsTest {
	
	@Before
	public void setUp(){

	}

	@Test
	public void createAndRetrieveUser() {
		new User("Bob", "secret","bob@gmail.com").save();
		User bob = User.find.where().eq("email", "bob@gmail.com").findUnique();
		assertNotNull(bob);
		assertEquals("Bob", bob.userName);
	}
}
